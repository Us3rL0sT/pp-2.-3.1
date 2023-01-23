package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void removeUserById(int id);

    void addUser(User user);

    void updateUser(int id, User user);

    User getUserById(int id);
}
