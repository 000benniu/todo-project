package com.liferay.todolist.internal.security.permission.resource.definition;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.PortletResourcePermissionDefinition;
import com.liferay.todolist.constants.TodoListConstants;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = PortletResourcePermissionDefinition.class
)
public class TodoItemPortletResourcePermissionDefinition implements PortletResourcePermissionDefinition {

	@Override
	public PortletResourcePermissionLogic[] getPortletResourcePermissionLogics() {
        return new PortletResourcePermissionLogic[] {
                new StagedPortletPermissionLogic(
                    _stagingPermission,
                    "com_liferay_todolist_web_portlet_TodoListWebPortlet")
            };
	}

	@Override
	public String getResourceName() {
		return TodoListConstants.RESOURCE_NAME;
	}

    @Reference
    private StagingPermission _stagingPermission;
}
