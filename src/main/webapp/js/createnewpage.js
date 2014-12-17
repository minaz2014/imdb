function logout()
{
	window.location.href="/imdb/user/logout";

	}
function postcomment(creatorName, movieId)
{
	var x = document.getElementById('commentbox').value;
	  if(x==null || x=="")
		  
		  {
		     alert("Please write a comment");
		     return;
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
		var parentdiv = document.getElementById('comments');
		var newCommentHTML = "<div style='margin:5px;'><strong>"+creatorName+": </strong>"+x+"</div>";
		parentdiv.innerHTML += newCommentHTML; 
		document.getElementById('commentbox').value = "";

	}
};

xmlhttp.open("POST","/imdb/comment/add",false);
xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
xmlhttp.send("comments="+x+"&creator="+creatorName+"&movieId="+movieId);
//xmlhttp.send("emailid="+x+"&password="+y);
}



function validateform()
{
	var x = document.forms["createnewpage"]["pic"].value;
	if(x==null || x=="")
		  
	  {
	     alert("Please upload an image");
	     return false;
	  };
	
	
  x = document.forms["createnewpage"]["moviename"].value;
  if(x==null || x=="")
	  
	  {
	     alert("Movie name is mandatory");
	     return false;
	  };
	  
  x = document.forms["createnewpage"]["director"].value;
  if(x==null || x=="")
		  
	  {
		 alert("Director is mandatory");
		 return false;
	  };
	  if((typeof x)!='string')
		{
		  alert("Enter a valid director name");
		  return false;
		};

  x = document.forms["createnewpage"]["cast"].value;
  if(x==null || x=="")
	 	  
	  {
	 	  alert("Cast is mandatory");
	 	  return false;
	  };
	  if((typeof x)!='string')
		{
		  alert("Enter a valid cast name");
		  return false;
		};

  x = document.forms["createnewpage"]["creator"].value;
  if(x==null || x=="")
		  
	 {
		  alert("Creator name is mandatory");
		  return false;
	 };	  
	 if((typeof x)!='string')
		{
		  alert("Enter a your valid name");
		  return false;
		};
		
	x = document.forms["createnewpage"]["description"].value;
		if(x==null || x=="")
			  
		 {
			  alert("Description is mandatory");
			  return false;
		 };	  
		
		
		
		return true;


//
//var xmlhttp;
//if (window.XMLHttpRequest)
//{// code for IE7+, Firefox, Chrome, Opera, Safari
//	xmlhttp=new XMLHttpRequest();
//}
//else
//{// code for IE6, IE5
//	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
//}
//xmlhttp.onreadystatechange=function()
//{
//	if (xmlhttp.readyState==4 && xmlhttp.status==200)
//	{
//		if(xmlhttp.responseText==null || xmlhttp.responseText==""){
//			window.location.href="/imdb/homepage";
//		}
//		alert(xmlhttp.responseText);
//	}
//};
//
//xmlhttp.open("POST","/imdb/movi/add",false);
//xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//xmlhttp.send("moviename="+x+"&director="+x+"&cast="+x+"&creator="+x);
//


}
 function upload()
 {
	 var photo = document.getElementById("photo");
	    var file = photo.files[0];
	
 
	
	      var reader = new FileReader();
        
         reader.onload = function (e) {
        	 document.getElementById("pic").value = e.target.result;
			    window.alert("file uploaded");
                         };
         
         reader.readAsDataURL(file);

 return false;
 };