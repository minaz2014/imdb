
function validateform()
{
	var x = document.forms["login"]["emailid"].value;
	if (x==null || x=="")
	{
		alert("Email-id is mandatory");
		return false;

	};

	var emailpattern = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(!emailpattern.test(x))
	{
		alert("Email-id is incorrect");
		return false;
	}

	var y = document.forms["login"]["password"].value;
	if (y==null || y=="")
	{
		alert("password is mandatory");
		return false;

	};

	var xmlhttp;
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			if(xmlhttp.responseText==null || xmlhttp.responseText==""){
				window.location.href="/imdb/homepage";
			} else {
				alert(xmlhttp.responseText);

			}
				
		}
	};

	xmlhttp.open("POST","/imdb/user/login",false);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("emailid="+x+"&password="+y);



}