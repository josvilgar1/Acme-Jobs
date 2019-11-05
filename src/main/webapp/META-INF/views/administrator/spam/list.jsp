
<%--
- list.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form-double code="administrator.spam.list.label.threshold" path="threshold" readonly="true" />

<acme:form-panel code="administrator.spam.list.label.word"/>
<acme:menu-separator/>
<jstl:forEach var="word" items="${words}">
	<acme:message code="${word}"/>
	<acme:menu-separator/>
</jstl:forEach>
