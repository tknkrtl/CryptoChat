<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.outer {
  display: table;
  position: absolute;
  height: 100%;
  width: 100%;
}

.middle {
  display: table-cell;
  vertical-align: middle;
  
}

.inner {
  margin-left: auto;
  margin-right: auto;
  height: 800px;
  width: 400px;
  border-style: dotted;
  
}
</style>
</head>
<body>
<div class="outer">
  <div class="middle" >
    <div class="inner">
      <h1>The Content</h1>
      <p>Once upon a midnight dreary...</p>
    </div>
  </div>
</div>


</body>
</html>