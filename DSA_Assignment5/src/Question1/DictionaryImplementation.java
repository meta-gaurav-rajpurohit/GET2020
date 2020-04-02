package Question1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;


public class DictionaryImplementation implements Dictionary {

    private Node root;
    Node temp = null;

    public DictionaryImplementation(JSONObject dictionary) {
        this.root = null;
        Set<String> keys = dictionary.keySet();
        for (Object key : keys) {
            int integerKey = Integer.parseInt(String.valueOf(key));
            System.out.println(integerKey);
            System.out.println(String.valueOf(dictionary.get(key)));
            put(integerKey, String.valueOf(dictionary.get(key)));
        }
    }
    
    private String findKey(Node rootNode, int key) {
        if (rootNode == null) {
            return null;
        } 
        if (rootNode.key < key) {
            return findKey(rootNode.rightChild, key);
        } else if (rootNode.key > key) {
            return findKey(rootNode.leftChild, key);
        } else {
            return rootNode.value;
        }
    }
    
    @Override
    public String getValue(int key) throws Exception {
        String value = findKey(root, key);
        if (value == null) {
            throw new Exception("Key not found.");
        }
        return value;
    }

    @Override
    public void put(int key, String value) {
        if (root == null) {
            root = new Node(key, value);
        } else {
            Node parent = root;
            boolean isInserted = false;
            while ((parent != null) && (!isInserted)) {
                if (key > parent.key) {
                    if (parent.rightChild == null) {
                        parent.rightChild = new Node(key, value);
                        isInserted = true;
                    }
                    parent = parent.rightChild;
                } else if (key < parent.key) {
                    if (parent.leftChild == null) {
                        parent.leftChild = new Node(key, value);
                        isInserted = true;
                    }
                    parent = parent.leftChild;
                } else {
                    System.out.println("Duplicate key found.");
                    break;
                }
            }
        }
    }

    private Node findMax(Node rootNode) {
        if (rootNode.rightChild == null) {
            return rootNode;
        }
        return findMax(rootNode.rightChild);
    }

    private Node deleteNode(Node rootNode, int key) {
        
        if (rootNode == null) {
            return null;
        } else if (key < rootNode.key) {
            rootNode.leftChild = deleteNode(rootNode.leftChild, key);
        } else if (key > rootNode.key) {
            rootNode.rightChild = deleteNode(rootNode.rightChild, key);
        } else {
            // element found.
            if ((rootNode.leftChild != null) &&
                (rootNode.rightChild != null)) {
                // node has both children.
                
                temp = findMax(rootNode.leftChild);
                rootNode.key = temp.key;
                rootNode.leftChild = deleteNode(rootNode.leftChild, rootNode.key);
            } else {
                // node has zero or one child.
                
                temp = rootNode;
                System.out.println(temp.key);
                if (rootNode.leftChild == null) {
                    rootNode = rootNode.rightChild;
                    return temp;
                } else if (rootNode.rightChild == null) {
                    rootNode = rootNode.leftChild;
                    return temp;
                }
            }
        }
        return temp;
    }

    @Override
    public String delete(int key) throws Exception {
        Node deletedNode =  deleteNode(root, key);
        if (deletedNode == null) {
            throw new Exception("Element does not exist.");
        }
        return deletedNode.value;
    }
 
    private void inorderTraversal(Node rootNode, Map<Integer, String> keyValuePair) {
        if (rootNode != null) {
            inorderTraversal(rootNode.leftChild, keyValuePair);
            keyValuePair.put(rootNode.key, rootNode.value);
            inorderTraversal(rootNode.rightChild, keyValuePair);
        }
    }

    private void inorderTraversal(Node rootNode, int key1, int key2, Map<Integer, String> keyValuePair) {
        if (rootNode != null) {
            inorderTraversal(rootNode.leftChild, key1, key2, keyValuePair);
            if ((rootNode.key >= key1) && (rootNode.key <= key2)) {
                keyValuePair.put(rootNode.key, rootNode.value);
            }
            inorderTraversal(rootNode.rightChild, key1, key2, keyValuePair);
        }
    }
    
    @Override
    public Map<Integer, String> sort() {
        Map<Integer, String> keyValuePair = new HashMap<Integer, String>();
        inorderTraversal(root, keyValuePair);
        return keyValuePair;
    }

    @Override
    public Map<Integer, String> sort(int key1, int key2) {
        Map<Integer, String> keyValuePair = new HashMap<Integer, String>();
        inorderTraversal(root, key1, key2, keyValuePair);
        return keyValuePair;
    }
}
