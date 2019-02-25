package dao.impl;

import dao.TestDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//为了包扫描的时候这个Dao被扫描到
@Repository
public class TestDaoImpl implements TestDao {

    //注入sqlSessionFactory,会在加载spring的xml配置文件中的sqlSessionFactory会话配置工厂
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession = null;

    private SqlSession getSqlSession() {
        if(sqlSession == null)
            sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
    @Override
    public List<User> findUserByName(User user) {
        List<User> uList = getSqlSession().selectList("test.findUserByName", "%" + user.getName() + "%");
        return uList;
    }
}
