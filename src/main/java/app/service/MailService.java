package app.service;

import app.model.User;

public interface MailService {
    void notify(User user);

}
