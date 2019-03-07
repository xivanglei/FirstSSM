package dao.impl;

import dao.UserDao;
import entity.User;
import org.springframework.stereotype.Repository;

/**
 * Author:xianglei
 * Date: 2019-02-25 13:52
 * Description:用户数据
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        setNs("mapper.UserMapper");
    }
}
