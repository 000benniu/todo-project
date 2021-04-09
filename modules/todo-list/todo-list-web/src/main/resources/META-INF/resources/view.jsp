<%@ include file="/init.jsp" %>

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