package controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author:xianglei
 * Date: 2019-02-25 11:02
 * Description:
 */
public abstract class BaseController {

    @InitBinder
    //此方法用于日期的转换，若页面日期格式转换错误，将报400错误
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //这种情况下java会把你输入的日期进行计算，比如55个月那么就是4年以后，这时候年份就会变成03年了,如果是false直接异常
        //"1999-55-1";
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
