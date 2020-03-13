function removeRepeating(){
    var string = document.getElementById("Enterstring").value;
    var i=0;
    while(i<string.length-1){
        if(string.charAt(i) == string.charAt(i+1)){
            string = string.substring(0,i) + string.substring(i+2);
            i=0;
            continue;
         }
         i++;
     }
     document.getElementById("list").innerHTML = string;
}