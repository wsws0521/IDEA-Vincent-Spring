package cn.spring.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("msg", "欢迎来到freemarker");
        return "index";
    }
}
