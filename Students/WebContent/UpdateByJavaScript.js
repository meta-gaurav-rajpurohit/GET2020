
let url = new URL(window.location);
let email = url.searchParams.get("mail");

document.getElementById("EmailID").value = email;
document.getElementById("EmailID").placeholder = email;