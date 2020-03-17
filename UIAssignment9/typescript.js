var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Display = /** @class */ (function () {
    function Display() {
        this.empId = 1;
    }
    Display.prototype.show = function (curid, nextid) {
        var Pattern;
        var temporary = 0;
        // alert(curid);
        switch (curid) {
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
                temporary = 1;
                break;
            case "MobileNumber":
                Pattern = /^[0-9]{9,15}$/;
                break;
        }
        // alert(document.getElementById(curid).value);
        if ((document.getElementById(curid).value).match(Pattern) == null) {
            alert("invalid " + curid);
            return;
        }
        if (temporary == 1) {
            if (document.getElementById("Password").value !=
                document.getElementById("ConfirmPassword").value) {
                alert("Password and ConfirmPassword value are not same");
                return;
            }
        }
        // alertMsg(nextid);
        document.getElementById(nextid).style.display = "inline";
        // alert("grv");
    };
    return Display;
}());
var Signup = /** @class */ (function (_super) {
    __extends(Signup, _super);
    function Signup() {
        var _this = _super.call(this) || this;
        _this.employeeName = "";
        _this.employeeGender = "";
        _this.employeeEmail = "";
        _this.employeePassword = "";
        _this.employeeMatchPassword = "";
        _this.employeeContact = "";
        _this.employeeOrganization = "";
        document.getElementById("fieldsetName").style.display = "inline";
        return _this;
    }
    Signup.prototype.varify = function () {
        this.employeeName = document.getElementById("Name").value;
        show("Name", "EmailID");
        this.employeeEmail = document.getElementById("EmailID").value;
        show("EmailID", "Password");
        this.employeePassword = document.getElementById("Password").value;
        show("Password", "ConfirmPassword");
        this.employeeMatchPassword = document.getElementById("ConfirmPassword").value;
        show("ConfirmPassword", "MobileNumber");
        this.employeeContact = document.getElementById("MobileNumber").value;
        show("MobileNumber", "MobileNumber");
        alert(document.getElementsByName("gender"));
        var ele = document.getElementsByName("gender");
        var i;
        for (i = 0; i < ele.length; i++) {
            if (ele[i].checked)
                this.employeeGender = ele[i].value;
        }
        alert(this.employeeGender);
        this.employeeOrganization = document.getElementById("Organization").value;
        document.getElementById("containRegistrationForm").style.display = "none";
        swal("1st step done", {
            icon: "success"
        });
        document.getElementById("containVehicleRegistrationForm").style.display = "block";
        document.getElementById("empId").value = this.empId;
    };
    return Signup;
}(Display));
var Vehicle = /** @class */ (function (_super) {
    __extends(Vehicle, _super);
    function Vehicle() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.vehicleName = "";
        _this.vehicleModel = "";
        _this.vehicleNumber = "";
        _this.employeeId = "";
        _this.Identification = "";
        _this.vehicleType = "";
        _this.currency = "";
        return _this;
    }
    Vehicle.prototype.varifyVehicle = function () {
        this.vehicleName = document.getElementById("inputVehicleName").value;
        this.vehicleModel = document.getElementById("inputVehicleModel").value;
        this.vehicleNumber = document.getElementById("VehicleNumber").value;
        this.employeeId = document.getElementById("empId").value;
        this.Identification = document.getElementById("Identification").value;
        this.vehicleType = document.getElementById("VehicleName").value;
        this.currency = document.getElementById("VehicleCurrency").value;
        if ((this.vehicleName == null) || (this.vehicleModel == null) || (this.vehicleNumber == null) ||
            (this.Identification == null)) {
            alert("Fill all field");
            return;
        }
        var Daily, Monthly, Yearly;
        var USD = 0.013, YEN = 1.54;
        var vehiclePass = document.getElementById('VehicleName');
        var vehiclePassType = vehiclePass.options[vehiclePass.selectedIndex].text;
        var vehiclePrice = document.getElementById('VehicleCurrency');
        var vehiclePriceType = vehiclePrice.options[vehiclePrice.selectedIndex].text;
        if (vehiclePassType == 'Cycle') {
            document.getElementById("heading").innerHTML = "Cycle Pass";
            Daily = 5;
            Monthly = 100;
            Yearly = 500;
        }
        else if (vehiclePassType == 'MotorCycle') {
            document.getElementById("heading").innerHTML = "MotorCycle Pass";
            Daily = 10;
            Monthly = 200;
            Yearly = 1000;
        }
        else if (vehiclePassType == 'FourWheelers') {
            document.getElementById("heading").innerHTML = "Four Wheelers Pass";
            Daily = 20;
            Monthly = 500;
            Yearly = 3500;
        }
        if (vehiclePriceType == 'INR') {
            document.getElementById("myButton1").value = Daily;
            document.getElementById("myButton2").value = Monthly;
            document.getElementById("myButton3").value = Yearly;
        }
        else if (vehiclePriceType == 'USD') {
            document.getElementById("myButton1").value = Daily * USD;
            document.getElementById("myButton2").value = Monthly * USD;
            document.getElementById("myButton3").value = Yearly * USD;
        }
        else if (vehiclePriceType == 'YEN') {
            document.getElementById("myButton1").value = Daily * YEN;
            document.getElementById("myButton2").value = Monthly * YEN;
            document.getElementById("myButton3").value = Yearly * YEN;
        }
        document.getElementById('containVehicleRegistrationForm').style.display = 'none';
        swal("2nd step done", {
            icon: "success"
        });
        document.getElementById("pass").style.display = "block";
    };
    return Vehicle;
}(Signup));
var Price = /** @class */ (function (_super) {
    __extends(Price, _super);
    function Price() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.passType = "";
        _this.price = 0;
        _this.priceInUSD = 0;
        _this.IndianToUSD = 0.014;
        _this.YENToUSD = 0.0093;
        return _this;
    }
    Price.prototype.verifyPrice = function (result) {
        this.passType = document.getElementById("heading").innerHTML;
        this.price = result;
        alert(this.currency);
        if (this.currency == "INR") {
            this.priceInUSD = this.price * this.IndianToUSD;
        }
        else if (this.currency == "YEN") {
            this.priceInUSD = this.price * this.YENToUSD;
        }
        // (<HTMLElement>document.getElementById("idInReceipt")).innerHTML = this.employeeId ;
        // (<HTMLElement>document.getElementById("nameInReceipt")).innerHTML = this.employeeName ;
        // (<HTMLElement>document.getElementById("genderInReceipt")).innerHTML = this.employeeGender ; 
        // (<HTMLElement>document.getElementById("numberInReceipt")).innerHTML =  this.employeeContact;
        // (<HTMLElement>document.getElementById("vehicleTypeInReceipt")).innerHTML = this.passType;
        // (<HTMLElement>document.getElementById("vehicleNameInReceipt")).innerHTML = this.vehicleName ;
        document.getElementById("vehicleNumberInReceipt").innerHTML = this.vehicleNumber;
        document.getElementById("priceInReceipt").innerHTML = this.price + "";
        document.getElementById('pass').style.display = 'none';
        swal("3rd step done", {
            icon: "success"
        });
        document.getElementById('receipt').style.display = 'block';
    };
    return Price;
}(Vehicle));
var signup = new Signup();
var vehicle = new Vehicle();
var price = new Price();
function fn(ele, curid, nextid) {
    // alert(event.key);
    if (event.key === 'Enter') {
        signup.show(curid, nextid);
        return;
    }
}
function show(curid, nextid) {
    signup.show(curid, nextid);
}
function varification() {
    signup.varify();
}
function showVehicle(id) {
    if (event.key === 'Enter') {
        document.getElementById(id).style.display = "inline";
    }
}
function varificationVehicleRegistrationForm() {
    vehicle.varifyVehicle();
}
function result(answer) {
    price.verifyPrice(answer);
}
// /* event listener for enter key */
// window.addEventListener('keypress', function (e) {
//     if (e.keyCode == 13) {
//         signup.show();
//     }
// }, false);
