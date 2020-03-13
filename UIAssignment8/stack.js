class Stack{
    constructor(){
        this.item = [];
    }
    add(value){
        this.item.push(value);
    }
    delete(){
        if(this.item.length == 0){
            alert("Underflow");
            return;
        }
        this.item.pop();
    }
    show(){
        var temporary = 0;
        var str=""
        while(temporary<this.item.length){
            str += this.item[temporary]+"<code>--></code>";
            temporary++;
        }
        console.log("s: "+ str)
        document.getElementById("list").innerHTML = str+"&#x25BC";
    }
}

let stack = new Stack();

function addnode(){
    console.log("grv")
    stack.add(document.getElementById("Enterelement").value);
    stack.show();
    
}

function deletenode(){
    stack.delete();
    stack.show();
}