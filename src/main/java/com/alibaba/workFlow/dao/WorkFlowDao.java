package com.alibaba.workFlow.dao;


import com.alibaba.workFlow.entity.WorkFlow;

import java.util.List;

/**
 * Created by wangxy on 21/10/16.
 */
public interface WorkFlowDao {

    List<WorkFlow> findAll(Long id);

    List<WorkFlow> queryWorkFlowList();
}
