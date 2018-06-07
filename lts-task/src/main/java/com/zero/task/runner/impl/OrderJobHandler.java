package com.zero.task.runner.impl;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.zero.common.constant.HandlerTaskType;
import com.zero.task.runner.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author jianqing.li
 * @date 2018/6/7
 */
@Component
public class OrderJobHandler implements JobHandler {

    private static Logger logger = LoggerFactory.getLogger(OrderJobHandler.class);

    @Override
    public Result handler(JobContext jobContext) {
        logger.info("订单通知任务开始处理");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            return new Result(Action.EXECUTE_FAILED, "执行失败了，好忧伤");
        }
        logger.info("订单通知任务处理完成");
        return new Result(Action.EXECUTE_SUCCESS, "执行成功了，哈哈");
    }

    @Override
    public String jobHandlerType() {
        return HandlerTaskType.ORDER.getJobType();
    }
}
