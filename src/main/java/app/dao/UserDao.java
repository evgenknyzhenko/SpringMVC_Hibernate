package app.dao;

import app.model.User;

public interface UserDao {
    User addUser(User user);

    User getByEmail(User user);

}
