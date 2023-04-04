// function Validate() {
//        var password = document.getElementById("password").value;
//        var confirmPassword = document.getElementById("ConfirmPassword").value;
//        if (password != confirmPassword) {
//            alert("Passwords do not match.");
//            return false;
//        }
//        return true;
//    }


document.querySelector('.button').onclick= function(){

var password= document.querySelector('.password').value, 
confirmPassword= document.querySelector('. confirmPassword').value;

if(password == "")
{ alert("Field cannot be empty.");

}

else if(password != confirmPassword)
{ alert("Password didn't match try again.");
 return false

}

else if(password == confirmPassword)
{ alert("Password matched")

} return 

}