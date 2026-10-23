package service;

import dao.UserDAO;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAO dao = new UserDAO();

    public User loginById(int id) throws SQLException {
        return dao.findById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return dao.getAllUsers();
    }
}