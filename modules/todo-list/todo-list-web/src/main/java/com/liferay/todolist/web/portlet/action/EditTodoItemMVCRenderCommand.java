package com.liferay.todolist.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.todolist.exception.NoSuchTodoItemException;
import com.liferay.todolist.model.TodoItem;
import com.liferay.todolist.service.TodoItemService;
import com.liferay.todolist.web.constants.MVCCommandNames;
import com.liferay.todolist.web.constants.TodoListWebPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = { "javax.portlet.name=" + TodoListWebPortletKeys.TODOLISTWEB, "mvc.command.name="
				+ MVCCommandNames.EDIT_TODOITEM },
		service = MVCRenderCommand.class)
public class EditTodoItemMVCRenderCommand implements MVCRenderCommand {
	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException {

		TodoItem todoItem = null;
		long todoItemId = ParamUtil.getLong(renderRequest, "todoItemId", 0);

		if (todoItemId > 0) {
			try {
				// Call the service to get the todoItem for editing.
				todoItem = _todoItemService.getTodoItem(todoItemId);
			} catch (NoSuchTodoItemException nsae) {
				nsae.printStackTrace();
			} catch (PortalException pe) {
				pe.printStackTrace();
			}
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// Set back icon visible.
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		portletDisplay.setShowBackIcon(true);

		String redirect = renderRequest.getParameter("redirect");

		portletDisplay.setURLBack(redirect);

		// Set todoItem to the request attributes.

		renderRequest.setAttribute("todoItem", todoItem);
		renderRequest.setAttribute("todoItemClass", TodoItem.class);

		return "/todoItem/edit_todoItem.jsp";
	}

	@Reference
	private TodoItemService _todoItemService;

}
