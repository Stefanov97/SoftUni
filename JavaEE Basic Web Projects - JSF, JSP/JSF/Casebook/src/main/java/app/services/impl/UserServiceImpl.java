package app.services.impl;

import app.domain.entities.Gender;
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
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public void register(UserServiceModel user) throws IllegalAccessException {

        if (isUsernameAvailable(user.getUsername())) {
            User mappedUser = this.mapper.map(user, User.class);
            mappedUser.setGender(Gender.valueOf(user.getGender().toUpperCase()));
            this.userRepository.save(mappedUser);

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
    public List<UserServiceModel> getAll() {
        return this.userRepository.findAll().stream().map(u -> this.mapper.map(u, UserServiceModel.class)).collect(Collectors.toList());
    }

    @Override
    public UserServiceModel getByUsername(String username) {
        return this.mapper.map(this.userRepository.findByUsername(username),UserServiceModel.class);
    }

    @Override
    public void addFriend(String username, String friendName) {
        User user = this.userRepository.findByUsername(username);
        User friend = this.userRepository.findByUsername(friendName);
        user.addFriend(friend);
        friend.addFriend(user);
        this.userRepository.update(user);
        this.userRepository.update(friend);
    }

    @Override
    public void removeFriend(String username, String friendName) {
        User user = this.userRepository.findByUsername(username);
        User friend = this.userRepository.findByUsername(friendName);
        user.removeFriend(friend);
        friend.removeFriend(user);
        this.userRepository.update(user);
        this.userRepository.update(friend);
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
