package com.stefanov.herobattles.service.services;

import com.stefanov.herobattles.data.models.User;
import com.stefanov.herobattles.data.repositories.UserRepository;
import com.stefanov.herobattles.service.models.UserServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthServiceImpl implements AuthService {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final HashingService hashingService;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, ModelMapper mapper, HashingService hashingService) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.hashingService = hashingService;
    }

    @Override
    public void register(UserServiceModel user) throws IllegalAccessException {

        if (!someFieldIsEmpty(user) && arePasswordsMatching(user.getPassword(), user.getConfirmPassword()) && isEmailValid(user.getEmail()) && isEmailAvailable(user.getEmail()) && isUsernameAvailable(user.getUsername())) {
            user.setPassword(this.hashingService.hash(user.getPassword()));
            //TODO set role and enable everything
            this.userRepository.saveAndFlush(this.mapper.map(user, User.class));

        } else {
            throw new IllegalAccessException();
        }
    }

    @Override
    public UserServiceModel login(UserServiceModel user) throws IllegalAccessException {
        user.setPassword(this.hashingService.hash(user.getPassword()));
        if (!usernameAndPasswordAreValid(user.getUsername(), user.getPassword())) {
            throw new IllegalAccessException();
        }
        return this.mapper.map(this.userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()), UserServiceModel.class);
    }

    private boolean someFieldIsEmpty(UserServiceModel user) {
        return user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getConfirmPassword().isEmpty() || user.getEmail().isEmpty();
    }

    private boolean arePasswordsMatching(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private boolean isEmailValid(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    private boolean isEmailAvailable(String email) {
        User user = this.userRepository.findByEmail(email);
        return user == null;
    }

    private boolean isUsernameAvailable(String username) {
        User user = (this.userRepository.findByUsername(username));
        return user == null;
    }

    private boolean usernameAndPasswordAreValid(String username, String password) {
        User user = this.userRepository.findByUsernameAndPassword(username, password);
        return user != null;
    }
}
