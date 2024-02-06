package com.blueyonder.service;

import com.blueyonder.dao.UserDAO;
import com.blueyonder.dao.UserDAOImpl;
import com.blueyonder.exceptions.PasswordMismatchException;
import com.blueyonder.exceptions.UserNotFoundException;
import com.blueyonder.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDAO userDOA = new UserDAOImpl();

    @Override
    public User getUserByName(String userName) throws UserNotFoundException {
        return userDOA.getUserByUserName(userName);
    }

    @Override
    public List<User> getAllUsers() {
        return userDOA.getAllUsers();
    }

    @Override
    public boolean validateUserNameAndPassword(String userName, String password) throws UserNotFoundException, PasswordMismatchException {
        return userDOA.validateUserNameAndPassword(userName,password);
    }
}
