
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

<acme:list >
	<acme:list-column code="authenticated.companyrecord.list.label.name" path="name" width="10%"/>
	<acme:list-column code="authenticated.companyrecord.list.label.sector" path="sector" width="10%"/>
	<acme:list-column code="authenticated.companyrecord.list.label.ceo" path="ceo" width="10%"/>
	<acme:list-column code="authenticated.companyrecord.list.label.description" path="description" width="30%"/>		
	<acme:list-column code="authenticated.companyrecord.list.label.web" path="web" width="10%"/>		
	<acme:list-column code="authenticated.companyrecord.list.label.phone" path="phone" width="10%"/>		
	<acme:list-column code="authenticated.companyrecord.list.label.email" path="email" width="10%"/>		
	<acme:list-column code="authenticated.companyrecord.list.label.incorporated" path="incorporated" width="10%"/>
	<acme:list-column code="anonymous.companyrecord.list.label.stars" path="stars" width="10%"/>				
</acme:list>


