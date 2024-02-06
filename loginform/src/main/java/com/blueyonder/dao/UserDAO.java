package com.blueyonder.dao;

import com.blueyonder.exceptions.PasswordMismatchException;
import com.blueyonder.exceptions.UserNotFoundException;
import com.blueyonder.model.User;

import java.util.List;

public interface UserDAO {
        public User getUserByUserName(String userName) throws UserNotFoundException;
        public List<User> getAllUsers();

        public boolean validateUserNameAndPassword(String userName, String password) throws UserNotFoundException, PasswordMismatchException;


}
