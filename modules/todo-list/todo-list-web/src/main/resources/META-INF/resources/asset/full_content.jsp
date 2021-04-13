<%@ include file="../init.jsp"%>

<%
    AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);

    String viewEntryURL = assetRenderer.getURLView(liferayPortletResponse, WindowState.MAXIMIZED);

    TodoItem todoItem = (TodoItem)request.getAttribute("todoItem");                    
%>

<aui:a cssClass="title-link" href="<%= viewEntryURL %>">
    <h3 class="title"><%= HtmlUtil.escape(todoItem.getTitle()) %></h3>
</aui:a>

<div class="autofit-col autofit-col-expand">
    <%= HtmlUtil.escape(todoItem.getDescription(locale)) %>
</div>
