package cn.vincent.springbootnetty.server;

import cn.vincent.springbootnetty.client.UserService;


public class UserServiceImpl implements UserService {

    @Override
    public String callRpc(String param) {
        System.out.println(param);
        return param;
    }
}