package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.TestService;

import java.util.List;

@Controller
public class TestController {

    //会注入注解了@Service的类,接口名首字母小写
    @Autowired
    private TestService testService;

    @RequestMapping("/user/findUser.action")
    private String findUser(User user, Model model) {
        List<User> userList = testService.findUserByName(user);
        model.addAttribute("userList", userList);
        return "/test/test.jsp";
    }
}
