package cn.vincent.springbootnetty.server;

import cn.vincent.springbootnetty.client.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String callRpc(String param) {
        System.out.println(param);
        return param;
    }
}