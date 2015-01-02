function logout()
{
	window.location.href="/imdb/user/logout";

	}
function postcomment(creatorName, movieId)
{
	var x = document.getElementById('commentbox').value.trim();
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
	  
	
	
	
  x = document.forms["createnewpage"]["moviename"].value.trim();
  if(x==null || x=="")
	  
	  {
	     alert("Movie name is mandatory");
	     return false;
	  };
  if(x.len>45)
	  {
	    alert("Moviename size should be less than 100");
	  };
	  
  x = document.forms["createnewpage"]["director"].value.trim();
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
		
	if(x.len>20)
		  {
		    alert("Director name size should be less than 100");
		  };
		

  x = document.forms["createnewpage"]["cast"].value.trim();
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
		
	  if(x.len>45)
		  {
		    alert("Cast name size should be less than 45");
		  };
		

  x = document.forms["createnewpage"]["creator"].value.trim();
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
	if(x.len>20)
		{
		    alert("Creator name size should be less than 20");
		 };
		
		
	x = document.forms["createnewpage"]["description"].value.trim();
		if(x==null || x=="")
			  
		 {
			  alert("Description is mandatory");
			  return false;
		 };	  
		 if(x.len>100)
		  {
		    alert("Description size should be less than 100");
		  };
		
		
		
		return true;


}
 function upload()
 {
	 var photo = document.getElementById("photo");
	    var file = photo.files[0];
	    
	    if (!file.fileName.match(/\.(jpg|jpeg|png|gif)$/)) 
	    	{
	        alert('not an image');
	        return false;
	    	};
	    	
	      var reader = new FileReader();
        
         reader.onload = function (e) {
        	 document.getElementById("pic").value = e.target.result;
			    window.alert("file uploaded");
                         };
         
         reader.readAsDataURL(file);

 return false;
 };
 
 
 
 
 
 
 
 
 
 
 
 
 