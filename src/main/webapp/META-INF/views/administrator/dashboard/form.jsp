<%--
- form.jsp
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

		
<div>
	<canvas id="canvas"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels:[
						<jstl:out value="${sectorbyCompany.get(0)}"/>,
						<jstl:out value="${sectorbyCompany.get(1)}"/>,
						<jstl:out value="${sectorbyCompany.get(2)}"/>,
						<jstl:out value="${sectorbyCompany.get(3)}"/>
					],
				datasets:[{	
						data:[
							<jstl:out value="${numSectorbyCompany.get(0)}"/>,
							<jstl:out value="${numSectorbyCompany.get(1)}"/>,
							<jstl:out value="${numSectorbyCompany.get(2)}"/>,
							<jstl:out value="${numSectorbyCompany.get(3)}"/>
						]		
						}]
			};
		var options = {
				scales:{ 
					yAxes:[{
							ticks:{
									suggestedMin: 0.0,
									suggestedMax: 4.0
							}
					}]
				},
				legend: {display : true}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		new Chart(context,{
			type : "bar",
			data : data,
			options : options
		});
	});	
</script>

<acme:form readonly="true">
	<acme:form-textbox code="administrator.dashboard.form.lable.countAnnouncement" path="countAnnouncement" />
	<acme:form-textbox code="administrator.dashboard.form.lable.countCompanyRecord" path="countCompanyRecords" />
	<acme:form-textbox code="administrator.dashboard.form.lable.countInvestorRecord" path="countInvestorRecords" />
	<acme:form-textbox code="administrator.dashboard.form.lable.minActiveRequest"
		path="minActiveRequest" />
	<acme:form-textbox code="administrator.dashboard.form.lable.maxActiveRequest"
		path="maxActiveRequest" />
	<acme:form-textbox code="administrator.dashboard.form.lable.avgActiveRequest"
		path="avgActiveRequest" />
	<acme:form-textbox code="administrator.dashboard.form.lable.stDerivationActiveRequest"
		path="stDerivationActiveRequest" />
	<acme:form-textbox code="administrator.dashboard.form.lable.minActiveOffer"
		path="minActiveOffer" />
	<acme:form-textbox code="administrator.dashboard.form.lable.maxActiveOffer"
		path="maxActiveOffer" />
	<acme:form-textbox code="administrator.dashboard.form.lable.avgActiveOffer"
		path="avgActiveOffer" />
	<acme:form-textbox code="administrator.dashboard.form.lable.stDerivationActiveOffer"
		path="stDerivationActiveOffer" />

	<acme:form-return code="administrator.dashboard.form.button.return" />
</acme:form>
