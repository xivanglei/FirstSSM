package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;
import utils.ListUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Author:xianglei
 * Date: 2019-02-25 13:30
 * Description:用户登录
 */
@Controller
public class UserController extends BaseController {

    @Resource
    UserService userService;

    //跳转登录页面
    @RequestMapping("/user/toLogin.action")
    public String toLogin() {
        return "/login.jsp";
    }

    //列表
    @RequestMapping("/user/login.action")
    public String login(User user, Model model, HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        List<User> userList = userService.find(map);
        if(ListUtil.isEmpty(userList)) {
            model.addAttribute("errorMsg", "登录失败!账号或密码错误!");
            return "/login.jsp";
        } else {
            request.getSession().setAttribute("user", userList.get(0));
            return "/home.jsp";
        }
    }

    //跳转至注册页面
    @RequestMapping("/user/registerPage.action")
    public String toRegister() {
        return "/register.jsp";
    }

    //注册
    @RequestMapping("/user/register.action")
    public String register(User user, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //查找账号是否已被注册
        Map<String, String> map = new HashMap<>();
        map.put("username", user.getUsername());
        List<User> userList = userService.find(map);
        if(!ListUtil.isEmpty(userList)) {
            model.addAttribute("errorMsg", "注册失败，用户名已被占用!");
            return "/register.jsp";
        }
        user.setUserId(UUID.randomUUID().toString());
        userService.insert(user);
        model.addAttribute("noticeMsg", "注册成功!请输入账号密码登录");
        return "/login.jsp";
    }
}
