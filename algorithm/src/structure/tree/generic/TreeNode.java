package structure.tree.generic;

import java.util.*;

public class TreeNode <T>
{
    private T data;
    private TreeNode<T> parent;
    private List<TreeNode<T>> children = new ArrayList();

    /**
     * 이 클래스의 사용법을 안내할 목적으로 추가된 main()
     */
    public static void main(String[] args)
    {
        TreeNode<String> root = new TreeNode();
        root.setData("가");

        TreeNode<String> childA = new TreeNode();
        childA.setData("A");
        root.addChild(childA);

        TreeNode<String>childB = new TreeNode();
        childB.setData("B");
        root.addChild(childB);

        TreeNode<String>childC = new TreeNode();
        childC.setData("C");
        root.addChild(childC);

        TreeNode<String> childOne = new TreeNode();
        childOne.setData("ONE");
        childA.addChild(childOne);

        TreeNode<String> childTwo = new TreeNode();
        childTwo.setData("TWO");
        childA.addChild(childTwo);

        printTree(root, 0);
    }
    /**
     *  Use for debugging. prints all TreeNodes from root to leaves
     * @param TreeNode 콘솔화면에 출력할 root TreeNode의 참조
     * @param level 콘솔화면에 출력할 차수, 처음 호출시 반드시 0을 전달하세요
     */
    private static void printTree(TreeNode<String> TreeNode, int level){
        int indent = level++;
        String tabs = "";
        for(int i=0;i<indent;i++) {
            tabs+="\t";
        }
        System.out.println(tabs+TreeNode.getData());
        List<TreeNode<String>> children = TreeNode.getChildren();
        if(children.size()==0) {
            return;
        }
        for(int i=0;i<children.size();i++) {
            TreeNode<String> child = children.get(i);
            printTree(child, level);
        }
    }

    public void addChild(TreeNode<T> child) {
        child.setParent(this);
        getChildren().add(child);
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public TreeNode<T> getParent() {
        return parent;
    }
    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }
    public List<TreeNode<T>> getChildren() {
        return children;
    }
    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }
}
