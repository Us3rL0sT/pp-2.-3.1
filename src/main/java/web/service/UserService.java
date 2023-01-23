package web.service;

import web.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void removeUserById(int id);

    void addUser(User user);

    void updateUser(int id, User user);

    User getUserById(int id);
}
