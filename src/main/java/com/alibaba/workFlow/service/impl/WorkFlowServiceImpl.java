package com.alibaba.workFlow.service.impl;

import com.alibaba.workFlow.dao.WorkFlowDao;
import com.alibaba.workFlow.entity.WorkFlow;
import com.alibaba.workFlow.service.WorkFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangxy on 21/10/16.
 */
@Service
public class WorkFlowServiceImpl implements WorkFlowService {

    @Resource
    private WorkFlowDao workFlowDao;

    @Override
    public List<WorkFlow> findAll(Long id) {
        return workFlowDao.findAll(id);
    }

    @Override
    public List<WorkFlow> queryWorkFlowList() {
        return workFlowDao.queryWorkFlowList();
    }
}
