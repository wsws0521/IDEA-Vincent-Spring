package cn.vincent.xxlsso.server.service;

import cn.vincent.xxlsso.server.core.model.UserInfo;
import cn.vincent.xxlsso.server.core.result.ReturnT;

public interface UserService {
    public ReturnT<UserInfo> findUser(String username, String password);
}
