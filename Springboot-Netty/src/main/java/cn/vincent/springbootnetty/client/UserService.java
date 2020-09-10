package cn.vincent.springbootnetty.client;

import cn.vincent.springbootnetty.client.nettyClientScan.NettyRpcClient;

/**
 * Created by zhangshukang.
 */

@NettyRpcClient
public interface UserService {
    String callRpc(String param); //5
}
