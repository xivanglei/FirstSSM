package controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

//配置spring和junit整合，这样junit在启动时就会加载spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration(locations = {"classpath:springmvc.xml", "classpath:beans.xml"})
//事务
@Rollback(value = false)
@Transactional(transactionManager = "txManager")
// 解决WebApplicationContext无法注入问题
@WebAppConfiguration
public class TaskControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;//为setup方法里第一种初始化方法自动注入
    @Autowired
    private TestController testController;//注入要测试的Controller

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        //mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();//两种方式都可以初始化mockMvc，推荐用这种，上面的会自动跳转地址status判断方法无效
    }

//    @Test
    public void testList() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/findUser.action")).andExpect(MockMvcResultMatchers.view().name("/test/test.jsp"));
    }

    @Test
    public void getData() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/findUser.action", 2)//url
                .param("name", "张"))//传入参数
                .andDo(MockMvcResultHandlers.print())//打印MvcResult信息
//                .andExpect(MockMvcResultMatchers.content().json("{'taskType':2,'finishTime':'2018-01-15','submitTime':'2018-01-12','taskTime':'2018-01-17'}"))//测试规则，测试返回值是否为指定JSON
                .andExpect(MockMvcResultMatchers.status().isOk())//测试状态码
                .andReturn();//返回MvcResult
    }
}