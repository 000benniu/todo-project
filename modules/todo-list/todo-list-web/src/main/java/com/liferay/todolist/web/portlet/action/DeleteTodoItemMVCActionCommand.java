package com.liferay.todolist.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.todolist.service.TodoItemService;
import com.liferay.todolist.web.constants.MVCCommandNames;
import com.liferay.todolist.web.constants.TodoListWebPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	     immediate = true,
	     property = {
	         "javax.portlet.name=" + TodoListWebPortletKeys.TODOLISTWEB,
	         "mvc.command.name=" + MVCCommandNames.DELETE_TODOITEM
	     },
	     service = MVCActionCommand.class
	 )
public class DeleteTodoItemMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

        long todoItemId = ParamUtil.getLong(actionRequest, "todoItemDeleted");

        try {

            // Call service to delete the assignment.
        	_todoItemService.deleteTodoItem(todoItemId);
			SessionMessages.add(actionRequest, "todoItemDeleted");

        }
        catch (PortalException pe) {
        	SessionErrors.add(actionRequest, "serviceErrorDetails", pe);
        }
    }

    @Reference
    protected TodoItemService _todoItemService;

}
