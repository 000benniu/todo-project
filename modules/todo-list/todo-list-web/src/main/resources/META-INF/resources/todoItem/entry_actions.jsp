<%@ include file="/init.jsp"%>

<c:set var="todoItem" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

<liferay-ui:icon-menu markupView="lexicon">

	<%-- View action. --%>
	<c:if test="${todoItemPermission.contains(permissionChecker, todoItem.todoItemId, 'VIEW' )}">
		<portlet:renderURL var="viewTodoItemURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.VIEW_TODOITEM%>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="todoItemId" value="${todoItem.todoItemId}" />
		</portlet:renderURL>
		<liferay-ui:icon message="view" url="${viewTodoItemURL}" />
	</c:if>

	<%-- Edit action. --%>
	<c:if test="${todoItemPermission.contains(permissionChecker, todoItem.todoItemId, 'UPDATE' )}">
		<portlet:renderURL var="editTodoItemURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.EDIT_TODOITEM%>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="todoItemId" value="${todoItem.todoItemId}" />
		</portlet:renderURL>
		<liferay-ui:icon message="edit" url="${editTodoItemURL}" />
	</c:if>

	<%-- Delete action. --%>
	<c:if test="${todoItemPermission.contains(permissionChecker, todoItem.todoItemId, 'DELETE' )}">
		<portlet:actionURL name="<%=MVCCommandNames.DELETE_TODOITEM%>"
			var="deleteTodoItemURL">
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="todoItemId" value="${todoItem.todoItemId}" />
		</portlet:actionURL>
		<liferay-ui:icon-delete url="${deleteTodoItemURL}" />
	</c:if>

</liferay-ui:icon-menu>