package com.blueyonder.dao;

import com.blueyonder.exceptions.PasswordMismatchException;
import com.blueyonder.exceptions.UserNotFoundException;
import com.blueyonder.model.User;
import com.blueyonder.util.DBConnectionUtil;
import com.blueyonder.util.QueryMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    @Override
    public User getUserByUserName(String userName) throws UserNotFoundException {
        User user = new User();
        try {
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(QueryMapper.GET_USER_BY_NAME);
            pStmt.setString(1,userName);
            ResultSet rs = pStmt.executeQuery();

            if(rs.next())
            {
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRole(rs.getString(4));

            }
            else {
                throw new UserNotFoundException("User with username --- "+userName+" doesn't exists in database");
            }


        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {

            Connection conn = DBConnectionUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QueryMapper.GET_ALL_USERS);

            while(rs.next())
            {
                User user = new User();
                user.setUserName(rs.getString("userName"));
                userList.add(user);
            }

        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public boolean validateUserNameAndPassword(String userName, String password) throws PasswordMismatchException {
        try {

            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(QueryMapper.VALID_USERNAME_AND_PASSWORD);
            pStmt.setString(1,userName);
            pStmt.setString(2,password);
            ResultSet rs = pStmt.executeQuery();

            if(rs.next())
            {
                return true;
            }
            else {
                throw new PasswordMismatchException();

            }

        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }

    }
}
