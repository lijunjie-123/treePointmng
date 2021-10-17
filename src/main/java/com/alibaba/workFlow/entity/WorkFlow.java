package com.alibaba.workFlow.entity;

import java.util.List;

/**
 * Created by wangxy on 21/10/16.
 */
public class WorkFlow {

    private Long id;

    private Long parentId;

    private String categoryName;

    private String displayOrder;

    private String createSinglePage;

    public List<WorkFlow> getChildren() {
        return children;
    }

    public void setChildren(List<WorkFlow> children) {
        this.children = children;
    }

    private List<WorkFlow> children;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getCreateSinglePage() {
        return createSinglePage;
    }

    public void setCreateSinglePage(String createSinglePage) {
        this.createSinglePage = createSinglePage;
    }
}
