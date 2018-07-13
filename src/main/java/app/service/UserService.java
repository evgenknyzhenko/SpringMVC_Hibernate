package app.service;

import app.model.User;

public interface UserService {
    User addUser(User user);
    User getByEmail(User user);
}

