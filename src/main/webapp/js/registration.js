
function validateform()
{
	var x = document.forms["registration"]["username"].value.trim();
	if (x==null || x=="")
		{
		  alert("Username is mandatory");
          return false;
        
		};
	if((typeof x)!='string')
		{
		  alert("Enter a valid username");
		  return false;
		};
	
	x = document.forms["registration"]["emailid"].value;
	if (x==null || x=="")
	{
	  alert("Email-id is mandatory");
      return false;
    
	};
	
	var emailpattern = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(!emailpattern.test(x)) {
		alert("Email-id is incorrect");
		return false;
		
	}
	
	
	x = document.forms["registration"]["password"].value;

	var pwdpattern =  /^[A-Za-z]\w{7,14}$/;  
	if(!x.match(pwdpattern))   
	{   
		alert('Password should contain 7 to 14 characters, first character must be alphabet.');  
		return false;  
	}  
	
	 var y = document.forms["registration"]["confirmpsw"].value;
	 if (y==null || y=="")
		{
		  alert("Please re-type the password");
	      return false;
	    
		};
		
	if (y!=x)
    {
		alert('Check your password again');
		return false;
    };
		
	return true;
};
