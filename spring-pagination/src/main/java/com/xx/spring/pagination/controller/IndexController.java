package com.xx.spring.pagination.controller;

import com.alibaba.fastjson.JSONObject;
import com.xx.spring.pagination.base.Page;
import com.xx.spring.pagination.entity.User;
import com.xx.spring.pagination.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wxiao on 2016.10.14.
 *
 * 控制器
 */

@Controller
public class IndexController {


    @Autowired
    private IUserService userService;


    /**
     * 后台通过subList分页
     * @return
     */
    @RequestMapping("/index")
    public HashMap<String, Object> index() {
        HashMap<String, Object> result = new HashMap<>();
        Page<User> page = userService.list(1, 3);
        result.put("page", page);
        return result;
    }


    /**
     * 前台分页
     */
    @RequestMapping("/index2")
    public HashMap<String, Object> index2() {
        HashMap<String, Object> result = new HashMap<>();
        List<User> userList = userService.list();
        result.put("userList", userList);
        return result;
    }

    /**
     * sql分页
     * @return
     */
    @RequestMapping("/index3")
    public HashMap<String, Object> index3() {
        HashMap<String, Object> result = new HashMap<>();
        Page<User> page = userService.list(1, 3);
        result.put("page", page);
        return result;
    }

    @RequestMapping("/data")
    @ResponseBody
    public String data(int pageNumber, int pageSize) {
        Page<User> userPage = userService.list(pageNumber, pageSize);
        return JSONObject.toJSONString(userPage);
    }

}
