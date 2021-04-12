 <%@ include file="../init.jsp"%>

<liferay-ui:error key="serviceErrorDetails">
    <liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' 
    key="error.todo-list-service-error" />
</liferay-ui:error>
<liferay-ui:error key="ProgressOutOfScope" message="todoItem-progressOutOfScope" />
<liferay-ui:error key="TodoDueDateNotSet" message="todoItem-todoDueDateNotSet" />
<liferay-ui:error key="TitleEmpty" message="todoItem-titleEmpty" />
<liferay-ui:error key="TitleTooShort" message="todoItem-titleTooShort" />

 <%-- Generate add / edit action URL and set title. --%>
 <c:choose>
     <c:when test="${not empty todoItem}">
         <portlet:actionURL var="todoItemActionURL" name="<%=MVCCommandNames.EDIT_TODOITEM %>">
             <portlet:param name="redirect" value="${param.redirect}" />
         </portlet:actionURL>

         <c:set var="editTitle" value="edit-todoItem"/>
     </c:when>
     <c:otherwise>
         <portlet:actionURL var="todoItemActionURL" name="<%=MVCCommandNames.ADD_TODOITEM %>">
             <portlet:param name="redirect" value="${param.redirect}" />
         </portlet:actionURL>

         <c:set var="editTitle" value="add-todoItem"/>
     </c:otherwise>
 </c:choose>

 <div class="container-fluid-1280 edit-todoItem">

     <h1><liferay-ui:message key="${editTitle}" /></h1>

     <aui:model-context bean="${todoItem}" model="${todoItemClass}" />

     <aui:form action="${todoItemActionURL}" name="fm">

         <aui:input name="todoItemId" field="todoItemId" type="hidden" />

         <aui:fieldset-group markupView="lexicon">

             <aui:fieldset>
                 <%-- Title field. --%>
                 <aui:input name="title">
	                 <aui:validator errorMessage="error.assignment-title-format" name="custom">
					     function(val, fieldNode, ruleValue) {
					         var wordExpression = 
					             new RegExp("^[^\\[\\]\\^$<>]*$");
					
					         return wordExpression.test(val);
					     }
					 </aui:validator>
                 </aui:input>

                 <%-- Description field. --%>
                 <aui:input name="description">
                     <aui:validator name="required" />
                 </aui:input>

                 <%-- Due date field. --%>
                 <aui:input name="dueDate" label="dueDate">
                     <aui:validator name="required" />
                 </aui:input>
                 
                 <aui:input name="doneFlag">
                 </aui:input>
                 
                 <aui:input name="memo">
                 </aui:input>
                 <aui:input name="progress">
                     <aui:validator name="number" />
                     <aui:validator name="range" errorMessage="input-progress-error">[0,1]</aui:validator>
                 </aui:input>
                 
                 
             </aui:fieldset>
         </aui:fieldset-group>

         <%--Buttons. --%>
         <aui:button-row>
             <aui:button cssClass="btn btn-primary" type="submit" />
             <aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
         </aui:button-row>
     </aui:form>
 </div>