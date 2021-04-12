package com.liferay.todolist.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.todolist.model.TodoItem;
import com.liferay.todolist.service.TodoItemService;
import com.liferay.todolist.web.constants.MVCCommandNames;
import com.liferay.todolist.web.constants.TodoListWebPortletKeys;

import java.text.DateFormat;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TodoListWebPortletKeys.TODOLISTWEB,
		"mvc.command.name=" + MVCCommandNames.VIEW_TODOITEM 
	},
	service = MVCRenderCommand.class
)
public class ViewSingleTodoItemMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long todoItemId = ParamUtil.getLong(renderRequest, "todoItemId", 0);

		try {

			// Call the service to get the todoItem.
			TodoItem todoItem = _todoItemService.getTodoItem(todoItemId);

			DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("EEEEE, MMMMM dd, yyyy",
					renderRequest.getLocale());

			// Set attributes to the request.
			renderRequest.setAttribute("todoItem", todoItem);
			renderRequest.setAttribute("dueDate", dateFormat.format(todoItem.getDueDate()));
			renderRequest.setAttribute("createDate", dateFormat.format(todoItem.getCreateDate()));

			// Set back icon visible.
			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
			String redirect = renderRequest.getParameter("redirect");

			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(redirect);

			return "/todoItem/view_todoItem.jsp";

		} catch (PortalException pe) {
			throw new PortletException(pe);
		}
	}

	@Reference
	private TodoItemService _todoItemService;

	@Reference
	private Portal _portal;

	@Reference
	private UserLocalService _userLocalService;
}
