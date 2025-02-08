package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDaoImpl userDaoImpl;


    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDaoImpl.createUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> readAllUser() {
        return userDaoImpl.readAllUser();
    }

    @Override
    @Transactional(readOnly = true)
    public User readUserById(Long id) {
        return userDaoImpl.readUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDaoImpl.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDaoImpl.deleteUserById(id);
    }

}
