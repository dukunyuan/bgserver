package com.paperx.bgbackup.service.user;

import com.paperx.bgbackup.model.user.User;

public interface UserService {
    User findByUsername(User user);
    User findUserById(String userId);
}
