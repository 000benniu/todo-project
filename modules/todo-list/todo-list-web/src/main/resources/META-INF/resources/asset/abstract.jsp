<%@ include file="../init.jsp"%>

<p>
    <h2>---in abstract.jsp---</h2>
	<%
		AssetRenderer<?> assetRenderer = (AssetRenderer<?>) request.getAttribute(WebKeys.ASSET_RENDERER);
	%>

	<%=HtmlUtil.escape(assetRenderer.getSummary(renderRequest, renderResponse))%>
</p>
