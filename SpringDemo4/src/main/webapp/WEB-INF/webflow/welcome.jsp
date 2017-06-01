<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

  <head><title>Spring Pizza</title></head>

  <body>
  	<h2>Welcome to Spring Pizza!!!</h2>
	
		<form:form>
      		<input type="hidden" name="_flowExecutionKey" >
			<input type="text" name="phoneNumber">
			<input type="submit" name="_eventId_phoneEntered1">
			<input type="submit" name="_eventId_phoneEntered2">
		</form:form>
	</body>
</html>