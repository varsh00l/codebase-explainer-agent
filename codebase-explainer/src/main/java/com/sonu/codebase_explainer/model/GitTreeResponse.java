package com.sonu.codebase_explainer.model;

import java.util.List;


public class GitTreeResponse {
    private List<GitTreeItem> tree;

    public List<GitTreeItem> getTree() {
        return tree;
    }

    public void setTree(List<GitTreeItem> tree) {
        this.tree = tree;
    }

}
