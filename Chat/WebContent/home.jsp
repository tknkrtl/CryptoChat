<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet href="https://s3-us-west-2.amazonaws.com/colors-css/2.2.0/colors.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
		body {
		    margin: 10;
		    padding: 0;
		    align-items: center;
		    justify-content: center;
		    text-align: center;
		    overflow: hidden;
		    background: #3D9970;
		}
		.leftwrapper{
		position: relative;
		height: 900px;
		width: 300px;
		
		}
		.text{
		border: 2px solid black;
		border-radius: 7px;
		width: 100%;
		height: 100%;
		resize: none;
		}
		.sendmessage{
		
		width: 100%;
		position: relative;
		top: -30%;
		
		text-align: center;
		}
		.btn{
		padding: 2px;
		float: none;
		}
		.h2{
		text-align: center;
		position: relative;
		top: 10%;
		}
		.Center{
			text-align: center;
		    width:250px;
		    height:200px;
		    background:#0088cc;
		    margin: auto;
		    border-radius:5%;
		    display: flex;
		 	 align-items: center;
		  	justify-content: center;
		}
		.middlewrapper{
		
		border: 2px solid black;
		overflow: auto;
		left: 15%;
		position: relative;
		margin-left: 400px;
		height: 900px;
		width: 500px;
		float: left;
		
		}
		.rightwrapper{
		border: 2px solid blue;
		position: relative;
		height: 200px;
		width: 200px;
		float : right;
		
		}
		.decrypt{
		float: right;
		overflow: hidden;
		position: relative;
		padding: 10px;
		height: 30px;
		width: 40px;
		border: 2px solid green;
		
		}
		.a{
		text-align: center;
		border: 2px solid teal;
		height: 150px;
		width: 100%;
		margin: auto;
		}
		.username{
		position: relative;
		color: red;
		}
		.message{
		position: relative;
		color: teal;
		}
		.date{
		position: relative;
		color: orange;
		}
		
	</style>
	
	
	 <script type="text/javascript">
	
	setInterval(function (){
    
    var XHR = new XMLHttpRequest();
    XHR.open("GET","ajaxCall",true);
    
    XHR.onreadystatechange = function(){
        
        if(XHR.readyState == 4 ){
            if(XHR.status == 200){
            	
            	var lastmessage = JSON.parse(this.responseText);          
            	
				var html="";
				html += "<div class ='a'> ";
            	html += "<p class='username'>" + lastmessage[0].musername + "</p></br" ;
            	html += "<p class='message'>" + lastmessage[0].mmesage + "</p></br>" ;
            	html += "<p class='date'>" + lastmessage[0].mdate + "</p></br>" ;
            	html += "</div>" ;
            		 
            	document.getElementById("middle").innerHTML+=html;           	
            }
            else
                console.log('problem with request');   
        }   
    }

    XHR.send();
    
},3000);
	
   </script> 
   
</head>
<body>

		<h2>Chat Messages</h2>
	<div class="middlewrapper" id="middle">
	
		<c:forEach items="${allMessageList}" var="allMessageList">
			<div class="a">
			<p class='username'><c:out value="${allMessageList.musername}"></c:out></p>
			<p class='message'><c:out value="${allMessageList.mmesage}"></c:out></p>
			<p class='date'><c:out value="${allMessageList.mdate}"></c:out></p>
    		</div>
    		
    	</c:forEach> 
		
	</div>

	
	
<form action="SendMessage" method ="post">
	<div  class='leftwrapper'>
		
		<div class='sendmessage'>
				<div class='Center' align='center'>
					<textarea rows="5" cols="50" class="text" name="message" required></textarea>
				</div>		
				<p><input type="submit" value="encrypt&send" class="btn"></p>
	    </div>
	</div>
</form>

	<div class="rightwrapper">
	
	</div>




</body>
</html>