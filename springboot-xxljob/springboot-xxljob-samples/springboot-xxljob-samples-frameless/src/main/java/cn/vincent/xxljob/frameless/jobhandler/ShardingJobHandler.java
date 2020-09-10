package cn.vincent.xxljob.frameless.jobhandler;

import cn.vincent.xxljob.core.biz.model.ReturnT;
import cn.vincent.xxljob.core.context.XxlJobContext;
import cn.vincent.xxljob.core.handler.IJobHandler;
import cn.vincent.xxljob.core.log.XxlJobLogger;

/**
 * 分片广播任务
 *
 * @author xuxueli 2017-07-25 20:56:50
 */
public class ShardingJobHandler extends IJobHandler {

	@Override
	public ReturnT<String> execute(String param) throws Exception {

		// 分片参数
		int shardIndex = XxlJobContext.getXxlJobContext().getShardIndex();
		int shardTotal = XxlJobContext.getXxlJobContext().getShardTotal();

		XxlJobLogger.log("分片参数：当前分片序号 = {}, 总分片数 = {}", shardIndex, shardTotal);

		// 业务逻辑
		for (int i = 0; i < shardTotal; i++) {
			if (i == shardIndex) {
				XxlJobLogger.log("第 {} 片, 命中分片开始处理", i);
			} else {
				XxlJobLogger.log("第 {} 片, 忽略", i);
			}
		}

		return SUCCESS;
	}
	
}
