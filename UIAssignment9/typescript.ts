class Display{
    empId = 1;
    show(curid : string, nextid : string) : void{
        
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
        if(((<HTMLInputElement>document.getElementById(curid)).value).match(Pattern) == null){
            alert("invalid "+curid);
            return;
        }
        if(temporary == 1){
            if((<HTMLInputElement>document.getElementById("Password")).value != 
            (<HTMLInputElement>document.getElementById("ConfirmPassword")).value){
                alert("Password and ConfirmPassword value are not same");
                return;
            }
        }
        // alertMsg(nextid);
        (<HTMLElement>document.getElementById(nextid)).style.display="inline";
        // alert("grv");
    }
}
class Signup extends Display{
    employeeName: string ="";
    employeeGender: string ="";
    employeeEmail: string ="";
    employeePassword: string ="";
    employeeMatchPassword: string ="";
    employeeContact: string ="";
    employeeOrganization: string ="";
    constructor(){
        super();
        (<HTMLElement>document.getElementById("fieldsetName")).style.display = "inline";
    }
    varify() : void{
        this.employeeName = (<HTMLInputElement>document.getElementById("Name")).value;
        show("Name","EmailID");
        this.employeeEmail = (<HTMLInputElement>document.getElementById("EmailID")).value;
        show("EmailID","Password");
        this.employeePassword =(<HTMLInputElement>document.getElementById("Password")).value;
        show("Password","ConfirmPassword");
        this.employeeMatchPassword = (<HTMLInputElement>document.getElementById("ConfirmPassword")).value;
        show("ConfirmPassword","MobileNumber");
        this.employeeContact = (<HTMLInputElement>document.getElementById("MobileNumber")).value;
        show("MobileNumber","MobileNumber");
        alert(document.getElementsByName("gender"));

        var ele = document.getElementsByName("gender"); 
		var i;
			for(i = 0; i < ele.length; i++) { 
				if(ele[i].checked) 
				this.employeeGender = ele[i].value; 
            }
            alert(this.employeeGender);
        this.employeeOrganization = (<HTMLInputElement>document.getElementById("Organization")).value;
        (<HTMLElement>document.getElementById("containRegistrationForm")).style.display="none";
        swal("1st step done",{
            icon: "success",
        });
        (<HTMLElement>document.getElementById("containVehicleRegistrationForm")).style.display="block";
        (<HTMLElement>document.getElementById("empId")).value = this.empId;
    }

}
class Vehicle extends Signup{
    vehicleName : string ="";
    vehicleModel : string ="";
    vehicleNumber : string ="";
    employeeId : string="";
    Identification : string="";
    vehicleType : string="";
    currency : string="";

    varifyVehicle() : void{
        this.vehicleName = (<HTMLInputElement>document.getElementById("inputVehicleName")).value;
        this.vehicleModel = (<HTMLInputElement>document.getElementById("inputVehicleModel")).value;
        this.vehicleNumber =(<HTMLInputElement>document.getElementById("VehicleNumber")).value;
        this.employeeId = (<HTMLInputElement>document.getElementById("empId")).value;
        this.Identification = (<HTMLInputElement>document.getElementById("Identification")).value;
        this.vehicleType = (<HTMLInputElement>document.getElementById("VehicleName")).value;
        this.currency = (<HTMLInputElement>document.getElementById("VehicleCurrency")).value;

        if((this.vehicleName == null) || (this.vehicleModel == null) || (this.vehicleNumber == null) ||
        (this.Identification == null)){
            alert("Fill all field");
            return;
        }
        let Daily , Monthly , Yearly ;
        let USD = 0.013, YEN = 1.54;
        var vehiclePass = (<HTMLElement>document.getElementById('VehicleName'));
        var vehiclePassType = vehiclePass.options[vehiclePass.selectedIndex].text; 
        var vehiclePrice = (<HTMLElement>document.getElementById('VehicleCurrency'));
        var vehiclePriceType = vehiclePrice.options[vehiclePrice.selectedIndex].text; 
        if(vehiclePassType == 'Cycle'){
            (<HTMLElement>document.getElementById("heading")).innerHTML = "Cycle Pass";
            Daily = 5;
            Monthly = 100;
            Yearly = 500;
        }
        else if(vehiclePassType == 'MotorCycle'){
            (<HTMLElement>document.getElementById("heading")).innerHTML = "MotorCycle Pass";
            Daily = 10;
            Monthly = 200;
            Yearly = 1000;
        }
        else if(vehiclePassType == 'FourWheelers'){
            (<HTMLElement>document.getElementById("heading")).innerHTML = "Four Wheelers Pass";
            Daily = 20;
            Monthly = 500;
            Yearly = 3500;
        }
        if(vehiclePriceType == 'INR'){
            (<HTMLElement>document.getElementById("myButton1")).value = Daily ;
            (<HTMLElement>document.getElementById("myButton2")).value = Monthly ;
            (<HTMLElement>document.getElementById("myButton3")).value = Yearly;
        }
        else if(vehiclePriceType == 'USD'){
            (<HTMLElement>document.getElementById("myButton1")).value = Daily * USD;
            (<HTMLElement>document.getElementById("myButton2")).value = Monthly * USD ;
            (<HTMLElement>document.getElementById("myButton3")).value = Yearly * USD;
        }
        else if(vehiclePriceType == 'YEN'){
            (<HTMLElement>document.getElementById("myButton1")).value = Daily * YEN;
            (<HTMLElement>document.getElementById("myButton2")).value = Monthly * YEN;
            (<HTMLElement>document.getElementById("myButton3")).value = Yearly * YEN;
            
        }
        (<HTMLElement>document.getElementById('containVehicleRegistrationForm')).style.display = 'none';
        swal("2nd step done",{
           icon: "success",
        });
        (<HTMLElement>document.getElementById("pass")).style.display="block";
    }
}

class Price extends Vehicle{
   passType : string = ""; 
   price = 0;
   priceInUSD = 0;
   private IndianToUSD = 0.014;
   private YENToUSD = 0.0093;
   verifyPrice(result){
    this.passType = (<HTMLElement>document.getElementById("heading")).innerHTML;
    this.price = result;
    alert(this.currency);
    if(this.currency == "INR"){
        this.priceInUSD = this.price * this.IndianToUSD;
    }
    else if(this.currency == "YEN"){
        this.priceInUSD = this.price * this.YENToUSD;
    }
        // (<HTMLElement>document.getElementById("idInReceipt")).innerHTML = this.employeeId ;
        // (<HTMLElement>document.getElementById("nameInReceipt")).innerHTML = this.employeeName ;
        // (<HTMLElement>document.getElementById("genderInReceipt")).innerHTML = this.employeeGender ; 
        // (<HTMLElement>document.getElementById("numberInReceipt")).innerHTML =  this.employeeContact;
        // (<HTMLElement>document.getElementById("vehicleTypeInReceipt")).innerHTML = this.passType;
        // (<HTMLElement>document.getElementById("vehicleNameInReceipt")).innerHTML = this.vehicleName ;
        (<HTMLElement>document.getElementById("vehicleNumberInReceipt")).innerHTML = this.vehicleNumber ; 
        (<HTMLElement>document.getElementById("priceInReceipt")).innerHTML = this.price+"" ; 
        (<HTMLElement>document.getElementById('pass')).style.display = 'none';
        swal("3rd step done",{
            icon: "success",
        });
        (<HTMLElement>document.getElementById('receipt')).style.display = 'block';
    }
   }

}
var signup = new Signup();
var vehicle = new Vehicle();
var price = new Price();

function fn(ele : string, curid : string, nextid : string) : void{
    if(event.key  === 'Enter') {    
        signup.show(curid, nextid);  
        return;  
    }
}
function show(curid : string, nextid : string):void{
    signup.show(curid, nextid);
}
function varification():void{
    signup.varify();
}
function showVehicle(id){
    if(event.key === 'Enter') {   
        (<HTMLElement>document.getElementById(id)).style.display="inline"; 
    }
}
function varificationVehicleRegistrationForm(){
    vehicle.varifyVehicle();
}
function result(answer){
    price.verifyPrice(answer);
}