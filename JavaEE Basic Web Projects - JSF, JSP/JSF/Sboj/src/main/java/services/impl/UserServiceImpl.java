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
