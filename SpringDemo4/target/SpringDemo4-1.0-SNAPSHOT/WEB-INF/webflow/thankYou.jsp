<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

  <head><title>Spring Pizza</title></head>

  <body>
	<h2>Thank you for your order!</h2>
	
		<form:form>
      <input type="hidden" name="_flowExecutionKey" 
             value="${flowExecutionKey}"/>
      <input type="submit" name="_eventId_finished1" value="Finished" />
		</form:form>
	</body>
</html>