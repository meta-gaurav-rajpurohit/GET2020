package Question1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Node<T> {

    private T data = null;
    private List<Node<T>> children = new ArrayList<>();
    private Node<T> parent = null;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date ;

    public Node(T data) {
        this.data = data;
        this.date = new Date();
    }

    public void addChild(Node<T> child) {
        boolean flag = true;
        for(Node<T> node : this.children){
            if(node.getData().equals(child.getData())){
                flag = false;
                break;
            }
        }
        if(flag){
            child.setParent(this);
            this.children.add(child);
        }else{
            System.out.println("directory already exists");
        }
    }

    public List<Node<T>> getChildrens() {
        return children;
    }
    
    public Node<T> getChild(String data) {
        for(Node<T> node : children){
            if(node.getData().equals(data))
                return node;
        }
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getParent() {
        return parent;
    }

    public String getDate(){
        return dateFormat.format(date);
    }

}
