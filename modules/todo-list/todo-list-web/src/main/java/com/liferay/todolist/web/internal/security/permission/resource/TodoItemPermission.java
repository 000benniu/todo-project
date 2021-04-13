package com.liferay.todolist.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.todolist.model.TodoItem;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author liferay
 */
@Component(
    immediate = true, 
    service = TodoItemPermission.class
)

public class TodoItemPermission {

    public static boolean contains(
            PermissionChecker permissionChecker, TodoItem todoItem,
            String actionId)
        throws PortalException {

        return _todoItemModelResourcePermission.contains(
            permissionChecker, todoItem, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long todoItemId, String actionId)
        throws PortalException {

        return _todoItemModelResourcePermission.contains(
            permissionChecker, todoItemId, actionId);
    }

    @Reference(
        target = "(model.class.name=com.liferay.todolist.model.TodoItem)",
        unbind = "-"
    )
    protected void setEntryModelPermission(
        ModelResourcePermission<TodoItem> modelResourcePermission) {

        _todoItemModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<TodoItem>
    _todoItemModelResourcePermission;

}
