class Queue{
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
        this.item.shift();
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

let queue = new Queue();

function addnode(){
    console.log("grv")
    queue.add(document.getElementById("Enterelement").value);
    queue.show();
    
}

function deletenode(){
    queue.delete();
    queue.show();
}