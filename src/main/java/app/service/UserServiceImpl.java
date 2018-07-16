package app.service;

import app.dao.UserDao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    private MailService mailService;
    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user) {
        user.setToken(getToken());
        mailService.notify(user);

        return user;
    }

    @Override
    public User getByEmail(User user) {
        return userDao.getByEmail(user);
    }

    private String getToken() {
        return UUID.randomUUID().toString();
    }


}
