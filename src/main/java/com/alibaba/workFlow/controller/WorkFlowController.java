package com.alibaba.workFlow.controller;

import com.alibaba.workFlow.entity.WorkFlow;
import com.alibaba.workFlow.service.WorkFlowService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangxy on 21/10/16.
 */
@RestController
@RequestMapping("/workFlow")
public class WorkFlowController {

    @Resource
    private WorkFlowService workFlowServiceImpl;

    @GetMapping("/findAll/{id}")
    public List<WorkFlow> findAll(@PathVariable(name = "id") String id) {

        List<WorkFlow> list = workFlowServiceImpl.findAll(Long.parseLong(id));
        return list;
    }

    @GetMapping("/queryWorkFlow")
    public List<WorkFlow> queryWorkFlowList() {
        List<WorkFlow> Alllist = workFlowServiceImpl.queryWorkFlowList();
        List<WorkFlow> parentList = Alllist.stream().filter(
                workFlow -> workFlow.getParentId() == 0).collect(Collectors.toList());

        //组装树结构
        List<WorkFlow> rootTrees = parentList.stream().map(obj -> assembleTree(obj, Alllist))
                .collect(Collectors.toList());
        return rootTrees;
    }


    public WorkFlow assembleTree(WorkFlow node, List<WorkFlow> Alllist) {
        if (CollectionUtils.isEmpty(Alllist)) {
            return node;
        }

        //获取子节点
        List<WorkFlow> filterList = Alllist.stream().filter(WorkFlow -> WorkFlow.getParentId().longValue() == node.getId().longValue())
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(filterList)) {
            return node;
        }


        //设置当前节点的子节点
        List<WorkFlow> children = new ArrayList<>();
        for (WorkFlow workFlow : filterList) {

            WorkFlow childNode = workFlow;
            //递归调用，创建子树
            children.add(assembleTree(childNode, Alllist));
        }
        //节点排序
        node.setChildren(children);
        return node;
    }

}

