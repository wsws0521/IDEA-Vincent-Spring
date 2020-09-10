package cn.vincent.springbootnetty.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/callRpc")
    public String callRpcTest(){
        //master
        userService.callRpc("callRpc execute......");
        return "ok";
    }

    //33、44、66
}
