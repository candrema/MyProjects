/**
 * 
 */

$("#registerButton").click(function(){
    $.post("/createUser",
    {
    	username: $("#usernameRegister").val(),
		email: $("#emailRegister").val(),
		password: $("#passwordRegister").val()
    },	
    	
    function(data, status){
    	$('#testes').html('Account created! Please verify your account in your email.');
    }
    
    );
}); 