package com.liferay.todolist.internal.security.permission.resource.definition;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.ModelResourcePermissionDefinition;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import com.liferay.todolist.constants.TodoListConstants;
import com.liferay.todolist.model.TodoItem;
import com.liferay.todolist.service.TodoItemLocalService;

import java.util.function.Consumer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
     immediate = true, 
     service = ModelResourcePermissionDefinition.class
 )
public class TodoItemModelResourcePermissionDefinition implements ModelResourcePermissionDefinition<TodoItem>  {

	@Override
	public TodoItem getModel(long todoItemId) throws PortalException {
		return _todoItemLocalService.getTodoItem(todoItemId);
	}

	@Override
	public Class<TodoItem> getModelClass() {
        return TodoItem.class;
	}

	@Override
	public PortletResourcePermission getPortletResourcePermission() {

        return _portletResourcePermission;
	}

	@Override
	public long getPrimaryKey(TodoItem todoItem) {
        return todoItem.getTodoItemId();
	}

	@Override
	public void registerModelResourcePermissionLogics(ModelResourcePermission<TodoItem> modelResourcePermission,
			Consumer<ModelResourcePermissionLogic<TodoItem>> modelResourcePermissionLogicConsumer) {
        modelResourcePermissionLogicConsumer.accept(
                new StagedModelPermissionLogic<>(
                    _stagingPermission,
                    "com_liferay_todolist_web_portlet_TodoListWebPortlet",
                    TodoItem::getTodoItemId));

            // Only enable if you use (optional) workflow support

            //    modelResourcePermissionLogicConsumer.accept(
            //        new WorkflowedModelPermissionLogic<>(
            //            _workflowPermission, modelResourcePermission,
            //            _groupLocalService, TodoItem::getTodoItemId));
		
	}

    @Reference
    private TodoItemLocalService _todoItemLocalService;

    @Reference
    private GroupLocalService _groupLocalService;

    @Reference(target = "(resource.name=" +  TodoListConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;

    @Reference
    private StagingPermission _stagingPermission;

    @Reference
    private WorkflowPermission _workflowPermission;

}
