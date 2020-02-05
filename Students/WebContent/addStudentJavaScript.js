function registration() {

	var firstName = document.getElementById('FirstName').value;
	var firstnamePattern = /^[A-Za-z ]{3,}$/;
	if (!firstnamePattern.test(firstName)) {
		alert("Enter valid First Name");
		return false;
	}
alert("hhhhhhhhhhh");
	var lastName = document.getElementById('LastName').value;
	var lastnamePattern = /^[A-Za-z ]{3,}$/;
	if (!lastnamePattern.test(lastName)) {
		alert("Enter valid Last Name");
		return false;
	}

	var fatherName = document.getElementById('FatherName').value;
	var fathernamePattern = /^[A-Za-z ]{3,}$/;
	if (!fathernamePattern.test(fatherName)) {
		alert("Enter valid Name");
		return false;
	}

	var email = document.getElementById("EmailID").value;
	var emailPattern = /^[A-za-z0-9_.]{3,}@[A-za-z]{3,7}[.]{1}[A-za-z.]{2,6}$/;
	if (!emailPattern.test(email)) {
		alert("Enter valid Email ID");
		return false;
	}
	
	var age = document.getElementById("Age").value;
	var agePattern = /^[0-9]{,3}$/;
	if (!agePattern.test(age) && (age > 0) && (age < 200)) {
		alert("Enter valid Email ID");
		return false;
	}
	return true;
//	var cls = document.getElementById('VehicleName');
//    var clsType = cls.options[cls.selectedIndex].text;
//
//    
//	swal("1st step done", {
//		icon : "success",
//	});
}
