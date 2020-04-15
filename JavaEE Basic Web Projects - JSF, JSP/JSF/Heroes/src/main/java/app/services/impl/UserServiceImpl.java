package app.services.impl;

import app.domain.entities.User;
import app.domain.models.service.UserServiceModel;
import org.modelmapper.ModelMapper;
import app.repositories.UserRepository;
import app.services.UserService;

import javax.inject.Inject;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
    public void register(UserServiceModel user) throws IllegalAccessException {

        if (isEmailValid(user.getEmail()) && isEmailAvailable(user.getEmail()) && isUsernameAvailable(user.getUsername())) {
            this.userRepository.save(this.mapper.map(user, User.class));

        } else {
            throw new IllegalAccessException();
        }
    }

    @Override
    public void loginUser(UserServiceModel user) throws IllegalAccessException {

        if (!usernameAndPasswordAreValid(user.getUsername(), user.getPassword())) {
            throw new IllegalAccessException();
        }
    }

    @Override
    public void save(UserServiceModel user) {
        this.userRepository.save(this.mapper.map(user,User.class));
    }

    @Override
    public UserServiceModel getByUsername(String username) {
        return this.mapper.map(this.userRepository.findByUsername(username),UserServiceModel.class);
    }

    @Override
    public List<UserServiceModel> getAll() {
        return this.userRepository.findAll().stream().map(u-> this.mapper.map(u,UserServiceModel.class)).collect(Collectors.toList());
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
        User user = this.userRepository.findByUsernameAndPassword(username,password);
        return user != null;
    }
}
