package app.service;

import app.dao.UserDao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User getByEmail(User user) {
        return userDao.getByEmail(user);
    }


}
