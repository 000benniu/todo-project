package com.liferay.todolist.web.portlet.action;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.todolist.exception.TodoItemValidationException;
import com.liferay.todolist.model.TodoItem;
import com.liferay.todolist.service.TodoItemService;
import com.liferay.todolist.web.constants.MVCCommandNames;
import com.liferay.todolist.web.constants.TodoListWebPortletKeys;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	     immediate = true,
	     property = {
	         "javax.portlet.name=" + TodoListWebPortletKeys.TODOLISTWEB_PORTLETNAME,
	         "mvc.command.name=" + MVCCommandNames.EDIT_TODOITEM
	     },
	     service = MVCActionCommand.class
	 )
public class EditTodoItemMVCActionCommand extends BaseMVCActionCommand {
	@Override
    protected void doProcessAction(
        ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {

        ServiceContext serviceContext =
            ServiceContextFactory.getInstance(TodoItem.class.getName(), actionRequest);

        // Get parameters from the request.
        long todoItemId = ParamUtil.getLong(actionRequest, "todoItemId");
        String title = ParamUtil.getString(actionRequest, "title");

        Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(actionRequest, "description");

        String memo = ParamUtil.getString(actionRequest, "memo");
        Boolean doneFlag = ParamUtil.getBoolean(actionRequest, "doneFlag");
        Double progress = ParamUtil.getDouble(actionRequest, "progress");
        

        Date dueDate = ParamUtil.getDate(
            actionRequest, "dueDate",
            DateFormatFactoryUtil.getDate(actionRequest.getLocale()));

        try {

            // Call the service to update the assignment
			_todoItemService.updateTodoItem(todoItemId, title, descriptionMap, dueDate, memo, progress, doneFlag,
					serviceContext);
			
			SessionMessages.add(actionRequest, "todoItemUpdated");

            sendRedirect(actionRequest, actionResponse);
        }
        catch (TodoItemValidationException ave) {

            ave.getErrors().forEach(x -> SessionErrors.add(actionRequest, x));

            actionResponse.setRenderParameter(
                "mvcRenderCommandName", MVCCommandNames.EDIT_TODOITEM);            

        }
        catch (PortalException pe) {

        	SessionErrors.add(actionRequest, "serviceErrorDetails", pe);

            actionResponse.setRenderParameter(
                "mvcRenderCommandName", MVCCommandNames.EDIT_TODOITEM);            
        }
    }

    @Reference
    protected TodoItemService _todoItemService;
}
