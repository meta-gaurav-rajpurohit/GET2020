let empId = 1;
            let Daily , Monthly , Yearly ;
            let USD = 0.013, YEN = 1.54;
            function showVehicle(id){
                if(event.key === 'Enter') {   
                    document.getElementById(id).style.display="inline"; 
                }
            }
            function alertMsg(id){
                var name = document.getElementById("Name").value;
                swal("Hi "+name+"! Can i know your "+id.replace("fieldset",""));
            }
            function show(curid, nextid){
                
                let Pattern;
                let temporary=0;
                // alert(curid);
                switch(curid){
                    case "Name": 
                        Pattern = /(^[A-Za-z ]{2,}$)/;
                        break;
                    case "EmailID": 
                        Pattern = /(^[a-zA-Z0-9]+[_\-\.]?[a-zA-Z0-9]+@[a-zA-Z]+\.[a-zA-Z]+$)/;
                        break;
                    case "Password": 
                        Pattern = /(^[a-zA-Z0-9.,!@#$%^&*~]{8,}$)/;
                        break;
                    case "ConfirmPassword": 
                        Pattern = /(^[a-zA-Z0-9.,!@#$%^&*~]{8,}$)/;
                        temporary=1;
                        break;
                    case "MobileNumber": 
                        Pattern = /^[0-9]{9,15}$/;
                        break;
                }
                // alert(document.getElementById(curid).value);
                if((document.getElementById(curid).value).match(Pattern) == null){
                    alert("invalid "+curid);
                    return;
                }
                if(temporary == 1){
                    if(document.getElementById("Password").value != document.getElementById("ConfirmPassword").value){
                        alert("Password and ConfirmPassword value are not same");
                        return;
                    }
                }
                alertMsg(nextid);
                document.getElementById(nextid).style.display="inline";
                // alert("grv");
            }
            function fn(ele, curid, nextid){
                // alert(event.key);
                if(event.key === 'Enter') {
                    // window.event.keyCode = 9;
                    // alert(ele.value);    
                    show(curid, nextid);  
                    return;  
                }
            }
            function ModifyEnterKeyPressAsTab() {
                if (window.event && window.event.keyCode == 13) {
                    window.event.keyCode = 9;
                }
            }

            function varification(){
                document.getElementById("containRegistrationForm").style.display="none";
                swal("1st step done",{
                    icon: "success",
                });
                document.getElementById("containVehicleRegistrationForm").style.display="block";
                document.getElementById("empId").value = empId;
            }
            function varificationVehicleRegistrationForm(){
                var vehiclePass = document.getElementById('VehicleName');
                var vehiclePassType = vehiclePass.options[vehiclePass.selectedIndex].text; 
                var vehiclePrice = document.getElementById('VehicleCurrency');
                var vehiclePriceType = vehiclePrice.options[vehiclePrice.selectedIndex].text; 
                if(vehiclePassType == 'Cycle'){
                    document.getElementById("heading").innerHTML = "Cycle Pass";
                    Daily = 5;
                    Monthly = 100;
                    Yearly = 500;
                }
                else if(vehiclePassType == 'MotorCycle'){
                    document.getElementById("heading").innerHTML = "MotorCycle Pass";
                    Daily = 10;
                    Monthly = 200;
                    Yearly = 1000;
                }
                else if(vehiclePassType == 'Four Wheelers'){
                    document.getElementById("heading").innerHTML = "Four Wheelers Pass";
                    Daily = 20;
                    Monthly = 500;
                    Yearly = 3500;
                }
                if(vehiclePriceType == 'INR'){
                    document.getElementById("myButton1").value = Daily ;
                    document.getElementById("myButton2").value = Monthly ;
                    document.getElementById("myButton3").value = Yearly;
                }
                else if(vehiclePriceType == 'USD'){
                    document.getElementById("myButton1").value = Daily * USD;
                    document.getElementById("myButton2").value = Monthly * USD ;
                    document.getElementById("myButton3").value = Yearly * USD;
                }
                else if(vehiclePriceType == 'YEN'){
                    document.getElementById("myButton1").value = Daily * YEN;
                    document.getElementById("myButton2").value = Monthly * YEN;
                    document.getElementById("myButton3").value = Yearly * YEN;
                }
                document.getElementById('containVehicleRegistrationForm').style.display = 'none';
                swal("2nd step done",{
                    icon: "success",
                });
                    document.getElementById("pass").style.display="block";
            }
            function result(answer){
            
                document.getElementById("idInReceipt").innerHTML = document.getElementById("empId").value ;
                var name = document.getElementById('Name').value;
                document.getElementById("nameInReceipt").innerHTML = name ;
                var gender;
                if (document.getElementById('r1').checked) {
                    gender = document.getElementById('r1').value;

                }
                if (document.getElementById('r2').checked) {
                    gender = document.getElementById('r2').value;
                }
                if (document.getElementById('r3').checked) {
                    gender = document.getElementById('r3').value;
                }
                document.getElementById("genderInReceipt").innerHTML = gender ; 
                var mobileNumber = document.getElementById('MobileNumber').value ; 
                document.getElementById("numberInReceipt").innerHTML =  mobileNumber;
                var vehiclePass = document.getElementById('VehicleName');
                var vehiclePassType = vehiclePass.options[vehiclePass.selectedIndex].text;
                document.getElementById("vehicleTypeInReceipt").innerHTML = vehiclePassType;
                var vahicleNameReceipt = document.getElementById('inputVehicleName').value ;
                document.getElementById("vehicleNameInReceipt").innerHTML = vahicleNameReceipt ; 
                var vahicleNumber = document.getElementById('VehicleNumber').value;
                document.getElementById("vehicleNumberInReceipt").innerHTML = vahicleNumber ; 
                document.getElementById("priceInReceipt").innerHTML = answer ; 
                
                document.getElementById('pass').style.display = 'none';
                swal("3rd step done",{
                    icon: "success",
                });
                document.getElementById('receipt').style.display = 'block';

                
        }