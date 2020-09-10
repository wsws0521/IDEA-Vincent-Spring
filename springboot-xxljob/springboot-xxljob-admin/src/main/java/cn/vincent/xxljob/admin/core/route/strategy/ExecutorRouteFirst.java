package cn.vincent.xxljob.admin.core.route.strategy;

import cn.vincent.xxljob.admin.core.route.ExecutorRouter;
import cn.vincent.xxljob.core.biz.model.ReturnT;
import cn.vincent.xxljob.core.biz.model.TriggerParam;

import java.util.List;

/**
 * Created by xuxueli on 17/3/10.
 */
public class ExecutorRouteFirst extends ExecutorRouter {

    @Override
    public ReturnT<String> route(TriggerParam triggerParam, List<String> addressList){
        return new ReturnT<String>(addressList.get(0));
    }

}
