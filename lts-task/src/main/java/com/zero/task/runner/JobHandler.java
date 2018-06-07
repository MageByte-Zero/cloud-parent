package com.zero.task.runner;

import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;

/**
 * 任务执行接口
 * @author jianqing.li
 * @date 2018/6/7
 */
public interface JobHandler {
    /**
     * 任务处理逻辑
     * @param jobContext
     * @return
     */
    Result handler(JobContext jobContext);

    /**
     * 任务类型
     * @return
     */
    String jobHandlerType();
}
