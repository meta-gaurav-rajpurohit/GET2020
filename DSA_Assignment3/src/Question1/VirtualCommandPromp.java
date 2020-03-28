package Question1;

import java.util.List;

public class VirtualCommandPromp {
    private Node<String> root;
    private Node<String> current;
    static boolean flag = true;

    public VirtualCommandPromp() {
        this.root = new Node<String>("R");
        this.current = this.root;
    }

    public Node<String> getRoot() {
        return root;
    }

    public Node<String> getCurrent() {
        return current;
    }

    public void setCurrent(Node<String> current) {
        if(!(current == null))
            this.current = current;
    }
    
    public <T> boolean checkDirectoryExistsOrNot(String name){
        for(Node<String> node : this.current.getChildrens()){
            if(node.getData().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public <T> void printTree(Node<T> node, String appender) {
        System.out.println(appender + node.getData());
        node.getChildrens().forEach(each ->  printTree(each, appender + appender));
    }

    public <T> boolean find(List<Node<T>> nodes, String data){
        for(Node<T> node : nodes){
            if(node.getData().equals(data)){
                flag = true;
            }
            return find(node.getChildrens(), data);
        }
        return flag;
    }
    
    public <T> void show(Node<T> node){
        System.out.println(String.format("%-20s%-20s",node.getData(),node.getDate()));
        node.getChildrens().forEach(each ->  show(each));
    }
}
