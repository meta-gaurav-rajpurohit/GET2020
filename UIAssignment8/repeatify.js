function repeatify(){
    var string = document.getElementById("EnterString").value;
    var number = document.getElementById("EnterNumber").value;
    var str = "";
    while(number != 0){
        str += string; 
        number--;
    }
    document.getElementById("list").innerHTML = str;
}