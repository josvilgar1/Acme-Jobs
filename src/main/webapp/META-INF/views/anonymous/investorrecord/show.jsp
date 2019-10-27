<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="anonymous.investorrecord.form.label.name" path="name" />
	<acme:form-textarea code="anonymous.investorrecord.form.label.sector" path="sector" />
	<acme:form-textarea code="anonymous.investorrecord.form.label.statment" path="statement" />
	<acme:form-textarea code="anonymous.investorrecord.form.label.stars" path="stars" />
	
  	<acme:form-return code="anonymous.investorrecord.form.button.return"/>
</acme:form>
