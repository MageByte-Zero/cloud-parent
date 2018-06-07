package com.zero.task.dispatcher;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.core.domain.Job;
import com.github.ltsopensource.spring.boot.annotation.JobRunner4TaskTracker;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.github.ltsopensource.tasktracker.runner.JobRunner;
import com.zero.task.runner.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 任务执行分发
 */
@JobRunner4TaskTracker
public class JobRunnerDispatcher implements JobRunner {

    /**
     * 存储所有的handler
     */
    private static final ConcurrentHashMap<String, JobHandler> JOB_HANDLER_MAP = new ConcurrentHashMap<>();
    private static Logger logger = LoggerFactory.getLogger(JobRunnerDispatcher.class);

    @Override
    public Result run(JobContext jobContext) throws Throwable {
        try {
            //根据type选择对应的JobRunner运行
            Job job = jobContext.getJob();
            String taskType = job.getParam("taskType");
            logger.warn("IT_Trade_Tasktracker 正在匹配对应任务.........");
            JobHandler handler = JOB_HANDLER_MAP.get(taskType);
            if (handler == null) {
                return new Result(Action.EXECUTE_FAILED, "找不到执行该任务的处理器");
            }
            logger.warn("IT_Trade_Tasktracker 进入任务中......... TaskType：{}", taskType);
            //委托给真正的实现类处理
            return handler.handler(jobContext);
        } catch (Exception e) {
            logger.info("Run job failed!", e);
            return new Result(Action.EXECUTE_FAILED, e.getMessage());
        }
    }

    @Autowired
    public void setHandlers(List<JobHandler> jobHandlerList) {
        if (CollectionUtils.isEmpty(jobHandlerList)) {
            return;
        }
        jobHandlerList.stream().forEach(item -> JOB_HANDLER_MAP.put(item.jobHandlerType(), item));
    }

}
