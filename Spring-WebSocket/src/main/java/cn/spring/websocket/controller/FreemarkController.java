package cn.spring.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreemarkController {

    @RequestMapping("/test")
    public String index(Model model) {
        return "index";
    }

}
