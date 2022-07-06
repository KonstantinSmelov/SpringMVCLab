package neostudy.service;

import neostudy.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(Long id);
    void saveUser(User user);
    void deleteUser(Long id);
    void updateUser(Long id, User user);
}
