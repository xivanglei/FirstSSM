package db;

import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.TestService;
import utils.ListUtil;

import java.util.List;

//配置spring和junit整合，这样junit在启动时就会加载spring容器
@RunWith(SpringJUnit4ClassRunner.class)//固定写法
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:beans.xml"})//spring与mybatis整合的配置文件
public class UserServiceTest {

    @Autowired
    private TestService testService;//注入需要测试的Service或Mapper，直接调用方法测试即可
    @Test
    public void findUserByName() throws Exception {
        User user = new User();
        user.setName("张");
        List<User> userList = testService.findUserByName(user);
        if(ListUtil.isEmpty(userList)) return;
        for (User u : userList) {
            System.err.println("UserServiceTest.selectByPrimaryKey , 32 : user = " + user.getName());
        }
    }
}
