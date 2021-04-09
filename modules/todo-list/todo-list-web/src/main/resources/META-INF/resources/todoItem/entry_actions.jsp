<%@ include file="/init.jsp"%>

 <c:set var="todoItem" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

 <liferay-ui:icon-menu markupView="lexicon">

     <%-- View action. --%>
     <portlet:renderURL var="viewTodoItemURL">
         <portlet:param name="mvcRenderCommandName"
             value="<%=MVCCommandNames.VIEW_TODOITEM %>" />
         <portlet:param name="redirect" value="${currentURL}" />
         <portlet:param name="todoItemId" value="${todoItem.todoItemId}" />
     </portlet:renderURL>

     <liferay-ui:icon message="view" url="${viewTodoItemURL}" />

     <%-- Edit action. --%>
     <portlet:renderURL var="editTodoItemURL">
         <portlet:param name="mvcRenderCommandName"
             value="<%=MVCCommandNames.EDIT_TODOITEM %>" />
         <portlet:param name="redirect" value="${currentURL}" />
         <portlet:param name="todoItemId" value="${todoItem.todoItemId}" />
     </portlet:renderURL>

     <liferay-ui:icon message="edit" url="${editTodoItemURL}" />    

     <%-- Delete action. --%>
     <portlet:actionURL name="<%=MVCCommandNames.DELETE_TODOITEM %>" var="deleteTodoItemURL">
         <portlet:param name="redirect" value="${currentURL}" />
         <portlet:param name="todoItemId" value="${todoItem.todoItemId}" />
     </portlet:actionURL>

     <liferay-ui:icon-delete url="${deleteTodoItemURL}" />

 </liferay-ui:icon-menu>