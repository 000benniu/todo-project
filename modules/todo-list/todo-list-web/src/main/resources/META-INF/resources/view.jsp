<%@ include file="./init.jsp" %>

<liferay-ui:error key="serviceErrorDetails">
    <liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' key="error.todo-list-service-error" />
</liferay-ui:error>
<liferay-ui:success key="todoItemAdded" message="todoItem-added-successfully" />
<liferay-ui:success key="todoItemUpdated" message="todoItem-updated-successfully" />
<liferay-ui:success key="todoItemDeleted" message="todoItem-deleted-successfully" />


<div class="container-fluid-1280">

    <h1><liferay-ui:message key="todolistweb.caption" /></h1>

    <%-- Clay management toolbar. --%>

    <clay:management-toolbar
        disabled="${todoItemCount eq 0}"
        displayContext="${todoItemsManagementToolbarDisplayContext}"
        itemsTotal="${todoItemCount}"
        searchContainerId="todoItems"
        selectable="false"
    />

    <%-- Search container. --%>

    <liferay-ui:search-container 
        emptyResultsMessage="no-todoItems"
        id="todoItemEntries"
        iteratorURL="${portletURL}" 
        total="${todoItemCount}">

        <liferay-ui:search-container-results results="${todoItems}" />

		<liferay-ui:search-container-row
			className="com.liferay.todolist.model.TodoItem" modelVar="entry">

			<%@ include file="/todoItem/entry_search_columns.jspf"%>
		</liferay-ui:search-container-row>

		<%-- Iterator / Paging --%>
        <liferay-ui:search-iterator 
            displayStyle="${todoItemsManagementToolbarDisplayContext.getDisplayStyle()}"
            markupView="lexicon" 
        />
    </liferay-ui:search-container>
</div>