package cn.neyzoter.module.tree;

public class StateTreeNode {
    private boolean isFirst = true;
    private TreeNode node;
    public StateTreeNode (TreeNode n) {
        this.node = n;
    }
    public void setNotFirst () {
        this.isFirst = false;
    }

    public TreeNode getNode () {
        return this.node;
    }

    public boolean isFirst () {
        return isFirst;
    }
}
