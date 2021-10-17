package com.alibaba.workFlow.service;

import com.alibaba.workFlow.entity.WorkFlow;

import java.util.List;

/**
 * Created by wangxy on 21/10/16.
 */
public interface WorkFlowService {
    List<WorkFlow> findAll(Long id);

    List<WorkFlow> queryWorkFlowList();
}
