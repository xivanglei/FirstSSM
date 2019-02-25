package service.impl;

import dao.TestDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TestService;

import java.util.List;

//暴露该Service实现类，以供Controller使用
@Service
public class TestServiceImpl implements TestService {

    //注入testDao,会在需要扫描的包里，找到注解了@Repository的TestDao（参数名符合接口名首字母小写）类
    @Autowired
    private TestDao testDao;

    @Override
    public List<User> findUserByName(User user) {
        return testDao.findUserByName(user);
    }
}
