package neostudy.service.impl;

import lombok.AllArgsConstructor;
import neostudy.dao.UserRepository;
import neostudy.entity.User;
import neostudy.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, User user) {
        User userToUpdate = getUser(id);
        if(userToUpdate != null) {
            userToUpdate.setFullname(user.getFullname());
            userToUpdate.setAddress(user.getAddress());
            userToUpdate.setDateOfBirth(user.getDateOfBirth());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPhone(user.getPhone());
        } else {
            userToUpdate = user;
        }
        saveUser(userToUpdate);

    }


}
