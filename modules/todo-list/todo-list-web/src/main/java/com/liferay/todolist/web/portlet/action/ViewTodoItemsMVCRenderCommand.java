package com.liferay.todolist.web.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.todolist.model.TodoItem;
import com.liferay.todolist.service.TodoItemService;
import com.liferay.todolist.web.constants.MVCCommandNames;
import com.liferay.todolist.web.constants.TodoListWebPortletKeys;
import com.liferay.todolist.web.display.context.TodoItemsManagementToolbarDisplayContext;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true, 
	    property = {
	        "javax.portlet.name=" + TodoListWebPortletKeys.TODOLISTWEB, 
	        "mvc.command.name=/",
	        "mvc.command.name=" + MVCCommandNames.VIEW_TODOITEMS
	    }, 
	    service = MVCRenderCommand.class
)
public class ViewTodoItemsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException {
		
		// Add todoItem list related attributes.
		addTodoItemListAttributes(renderRequest);

		// Add Clay management toolbar related attributes.
		addManagementToolbarAttributes(renderRequest, renderResponse);

		return "/view.jsp";
	}
	
	/**
	 * Adds todoitem list related attributes to the request.
	 * 
	 * @param renderRequest
	 */
	private void addTodoItemListAttributes(RenderRequest renderRequest) {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// Resolve start and end for the search.

		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				SearchContainer.DEFAULT_DELTA);

		int start = ((currentPage > 0)
				? (currentPage - 1)
				: 0) * delta;
		int end = start + delta;

		// Get sorting options.
		// Notice that this doesn't really sort on title because the field is
		// stored in XML. In real world this search would be integrated to the
		// search engine to get localized sort options.

		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "title");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");

		// Create comparator

		OrderByComparator<TodoItem> comparator = OrderByComparatorFactoryUtil.create("TodoItem", orderByCol,
				!("asc").equals(orderByType));

		// Get keywords.
		// Notice that cleaning keywords is not implemented.

		String keywords = ParamUtil.getString(renderRequest, "keywords");

		// Call the service to get the list of todoItems.

		List<TodoItem> todoItems = _todoItemService.getTodoItemsByKeywords(themeDisplay.getScopeGroupId(), keywords,
				start, end, comparator);

		// Set request attributes.

		renderRequest.setAttribute("todoItems", todoItems);
		renderRequest.setAttribute("todoItemCount",
				_todoItemService.getTodoItemsCountByKeywords(themeDisplay.getScopeGroupId(), keywords));

	}
	
	/**
	 * Adds Clay management toolbar context object to the request.
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 */
	private void addManagementToolbarAttributes(RenderRequest renderRequest,
			RenderResponse renderResponse) {

		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);

		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);

		TodoItemsManagementToolbarDisplayContext todoItemsManagementToolbarDisplayContext = 
				new TodoItemsManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));

		renderRequest.setAttribute("todoItemsManagementToolbarDisplayContext",
				todoItemsManagementToolbarDisplayContext);

	}

	@Reference
	protected TodoItemService _todoItemService;

	@Reference
	private Portal _portal;

}
