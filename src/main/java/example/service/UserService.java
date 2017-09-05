package example.service;

import example.dao.UserDao;
import example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void addUser(String name, int age) {
        userDao.addUser(name, age);
    }

    public void deleteUser(int id) {
    	userDao.deleteUserByID(id);
    }

    public void deleteUser(String name) {
    	userDao.deleteUserByName(name);
    }

    public void updateUser(int id, String name) {
    	userDao.updateUserNameByID(id, name);
    }

    public String queryUserName(int id) {
        return userDao.queryNameByID(id);
    }

    public List<User> queryUser(String name) {
        return userDao.queryUserByName(name);
    }
}
