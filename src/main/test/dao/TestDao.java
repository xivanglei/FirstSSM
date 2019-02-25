package dao;

import entity.User;

import java.util.List;

public interface TestDao {
    public List<User> findUserByName(User user);
}
