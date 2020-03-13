class Node{
    constructor(value){
        this.value = value;
        this.next = null;
    }
    add(value){
        if(this.value == null){
            this.value = value;
        } else {
            var currentNode = this ; 
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = new Node(value);
        }
    }
    delete(value){
        var currentNode = this;
        var nextNode = this.next;
        var temporary = 0;
        if(this.value == value && nextNode == null){
            this.value = null;
        }
        else if(this.value == value){
            this.next = nextNode.next;
            return;
        }
        else{
        while(nextNode.next!=null){
            if(nextNode.value == value){
                 currentNode.next = nextNode.next;
                 return;
            }
            nextNode = nextNode.next;
            currentNode = currentNode.next;
        }
        currentNode.next = null;
        
    }
    }
    show(){
        var node = this;
        var str=""
        while(node ){
            str += node.value+"<code>--></code>";
            node=node.next;
        }
        console.log("s: "+ str)
        document.getElementById("list").innerHTML = str+"&#x25BC";
    }
}

let linklist = new Node();

function addnode(){
    linklist.add(document.getElementById("Enterelement").value);
    linklist.show();
    
}

function deletenode(){
    linklist.delete(document.getElementById("Enterelement").value);
    linklist.show();
}