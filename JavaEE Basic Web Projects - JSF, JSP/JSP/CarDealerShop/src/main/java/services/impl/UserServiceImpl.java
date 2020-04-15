package services.impl;

import domain.entities.User;
import domain.models.service.UserServiceModel;
import org.modelmapper.ModelMapper;
import repositories.UserRepository;
import services.UserService;

import javax.inject.Inject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public void registerUser(UserServiceModel user) throws IllegalAccessException {
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty()) {
            throw new IllegalAccessException();
        }
        if (isEmailValid(user.getEmail()) && isEmailAvailable(user.getEmail())  && isUsernameAvailable(user.getUsername())) {
            this.userRepository.registerUser(this.mapper.map(user, User.class));

        } else {
            throw new IllegalAccessException();
        }
    }

    @Override
    public UserServiceModel loginUser(String username, String password) throws IllegalAccessException {
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalAccessException();
        }
        if (!usernameAndPasswordAreValid(username, password)) {
            throw new IllegalAccessException();
        }
       return this.mapper.map(this.userRepository.findUserByUsername(username), UserServiceModel.class);
    }

    private boolean isEmailValid(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    private boolean isEmailAvailable(String email) {
        User user = this.userRepository.findUserByEmail(email);
        return user == null;
    }


    private boolean isUsernameAvailable(String username) {
      User user = (this.userRepository.findUserByUsername(username));
        return user == null;
    }

    private boolean usernameAndPasswordAreValid(String username, String password) {
        User user = this.userRepository.findByUsernameAndPassword(username,password);
        return user != null;
    }
}
