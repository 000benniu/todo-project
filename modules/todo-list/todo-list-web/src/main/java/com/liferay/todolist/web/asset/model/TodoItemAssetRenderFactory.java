package com.liferay.todolist.web.asset.model;

import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactory;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.todolist.constants.TodoListConstants;
import com.liferay.todolist.model.TodoItem;
import com.liferay.todolist.service.TodoItemLocalService;
import com.liferay.todolist.web.constants.MVCCommandNames;
import com.liferay.todolist.web.constants.TodoListWebPortletKeys;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Asset renderer factory component for todoItems.
 *
 * @author liferay
 */
@Component(
    immediate = true,
    property = "javax.portlet.name=" + TodoListWebPortletKeys.TODOLISTWEB_PORTLETNAME,
    service = AssetRendererFactory.class
)
public class TodoItemAssetRenderFactory
    extends BaseAssetRendererFactory<TodoItem> {

    public static final String CLASS_NAME = TodoItem.class.getName();

    public static final String TYPE = "todoItem";

    public TodoItemAssetRenderFactory() {
        setClassName(CLASS_NAME);
        setLinkable(true);
        setPortletId(TodoListWebPortletKeys.TODOLISTWEB_PORTLETNAME);
        setSearchable(true);
    }

    @Override
    public AssetRenderer<TodoItem> getAssetRenderer(long classPK, int type)
        throws PortalException {

    	TodoItem todoItem = _todoItemLocalService.getTodoItem(classPK);

        TodoItemAssetRenderer todoItemAssetRenderer =
            new TodoItemAssetRenderer(
                    todoItem);

        todoItemAssetRenderer.setAssetDisplayPageFriendlyURLProvider( 
            _assetDisplayPageFriendlyURLProvider);
        todoItemAssetRenderer.setAssetRendererType(type);
        todoItemAssetRenderer.setServletContext(_servletContext);

        return todoItemAssetRenderer;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public PortletURL getURLAdd(
        LiferayPortletRequest liferayPortletRequest,
        LiferayPortletResponse liferayPortletResponse, long classTypeId) {

        PortletURL portletURL = _portal.getControlPanelPortletURL(
            liferayPortletRequest, getGroup(liferayPortletRequest),
            TodoListWebPortletKeys.TODOLISTWEB_PORTLETNAME, 0, 0, PortletRequest.RENDER_PHASE);

        portletURL.setParameter("mvcRenderCommandName", MVCCommandNames.EDIT_TODOITEM);

        return portletURL;
    }

    @Override
    public PortletURL getURLView(
        LiferayPortletResponse liferayPortletResponse,
        WindowState windowState) {

        LiferayPortletURL liferayPortletURL =
            liferayPortletResponse.createLiferayPortletURL(
                TodoListWebPortletKeys.TODOLISTWEB_PORTLETNAME, PortletRequest.RENDER_PHASE);

        try {
            liferayPortletURL.setWindowState(windowState);
        }
        catch (WindowStateException wse) {
        }

        return liferayPortletURL;
    }    

    @Override
    public boolean hasAddPermission(
            PermissionChecker permissionChecker, long groupId, long classTypeId)
        throws Exception {

        return _portletResourcePermission.contains(
            permissionChecker, groupId, ActionKeys.ADD_ENTRY);
    }

    @Override
    public boolean hasPermission(
            PermissionChecker permissionChecker, long classPK, String actionId)
        throws Exception {

        return _todoItemModelResourcePermission.contains(
            permissionChecker, classPK, actionId);
    }

    @Reference
    private AssetDisplayPageFriendlyURLProvider
        _assetDisplayPageFriendlyURLProvider;

    @Reference
    private TodoItemLocalService _todoItemLocalService;

    @Reference(
        target = "(model.class.name=com.liferay.todolist.model.TodoItem)"
    )
    private ModelResourcePermission<TodoItem>
        _todoItemModelResourcePermission;

    @Reference
    private Portal _portal;

    @Reference(
        target = "(resource.name=" + TodoListConstants.RESOURCE_NAME + ")"
    )
    private PortletResourcePermission _portletResourcePermission;

    @Reference
    private PortletURLFactory _portletURLFactory;

    @Reference(
        target = "(osgi.web.symbolicname=com.liferay.todolist.web)"
    )
    private ServletContext _servletContext;

}
