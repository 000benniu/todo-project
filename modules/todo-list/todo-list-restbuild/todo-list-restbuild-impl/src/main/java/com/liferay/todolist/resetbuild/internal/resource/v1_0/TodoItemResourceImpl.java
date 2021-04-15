package com.liferay.todolist.resetbuild.internal.resource.v1_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.headless.common.spi.service.context.ServiceContextRequestUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.todolist.resetbuild.dto.v1_0.TodoItem;
import com.liferay.todolist.resetbuild.resource.v1_0.TodoItemResource;
import com.liferay.todolist.service.TodoItemLocalService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tags;

/**
 * @author ben
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/todo-item.properties",
	scope = ServiceScope.PROTOTYPE, service = TodoItemResource.class
)
public class TodoItemResourceImpl extends BaseTodoItemResourceImpl {
	
	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/todo-list-restbuild/v1.0/todolist/gettodolist'  -u 'test@liferay.com:test'
	 */
	@Override
	@GET
	@Path("/todolist/gettodolist")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {})
	public Page<TodoItem> getTodolistPage() throws Exception {
		String result = "";
		
		Company company;
		try {
			company = _companyService.getCompanyById(PortalUtil.getDefaultCompanyId());
			
			List<Group> groups = _groupLocalService.getGroups(company.getCompanyId(), 0, true);
			
			List<TodoItem> todolist = new ArrayList<TodoItem>();
			for(Group group : groups) {
				List<com.liferay.todolist.model.TodoItem> todoItems = _todoItemLocalService.getTodoItemsByGroupId(group.getGroupId());
				for(com.liferay.todolist.model.TodoItem todoItem : todoItems) {

					TodoItem apiTodoItem = new TodoItem();

					apiTodoItem.setTodoItemId(todoItem.getTodoItemId());
					
					apiTodoItem.setCompanyId(todoItem.getCompanyId());
					apiTodoItem.setGroupId(todoItem.getGroupId());
					apiTodoItem.setUserName(todoItem.getUserName());
					apiTodoItem.setCreateDate(todoItem.getCreateDate());
					
					apiTodoItem.setTitle(todoItem.getTitle());
					apiTodoItem.setDescription(todoItem.getDescription(_getDefaultLocale(todoItem.getGroupId())));
					apiTodoItem.setProgress(todoItem.getProgress());
					apiTodoItem.setDoneFlag(todoItem.getDoneFlag());
					apiTodoItem.setDueDate(todoItem.getDueDate());
					apiTodoItem.setMemo(todoItem.getMemo());

					todolist.add(apiTodoItem);
				}
			}

			return Page.of(todolist);
			
		} catch (PortalException e) {
			result += "erors:" + e.getMessage();
			e.printStackTrace();
		} catch (Exception e) {
			result += "E erors:" + e.getMessage();
			e.printStackTrace();
		}
		
		return super.getTodolistPage();
	}
	

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PATCH' 'http://localhost:8080/o/todo-list-restbuild/v1.0/todolist/markItemDone/{todoItemId}'  -u 'test@liferay.com:test'
	 */
	@Override
	@Operation(description = "Mark item as done")
	@PATCH
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "todoItemId")}
	)
	@Path("/todolist/markItemDone/{todoItemId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {})
	public Page<TodoItem> patchTodolistMarkItemDoneTodoItemPage(
			@NotNull @Parameter(hidden = true) @PathParam("todoItemId") Long
				todoItemId)
		throws Exception {
		
		_todoItemLocalService.doneTodoItem(todoItemId, null);

		return Page.of(Collections.emptyList());
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PATCH' 'http://localhost:8080/o/todo-list-restbuild/v1.0/todolist/markItemUndo/{todoItemId}'  -u 'test@liferay.com:test'
	 */
	@Override
	@Operation(description = "Reset item to to-do.")
	@PATCH
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "todoItemId")}
	)
	@Path("/todolist/markItemUndo/{todoItemId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {})
	public Page<TodoItem> getTodolistMarkItemUndoTodoItemPage(
			@NotNull @Parameter(hidden = true) @PathParam("todoItemId") Long
				todoItemId)
		throws Exception {

		_todoItemLocalService.unDoneTodoItem(todoItemId, null);
		return Page.of(Collections.emptyList());
	}
	
	private Locale _getDefaultLocale(long groupId) throws Exception {
		Group group = _groupLocalService.getGroup(groupId);

		String defaultLanguageId = LocalizationUtil.getDefaultLanguageId(
			group.getName());

		if (Validator.isNotNull(defaultLanguageId)) {
			return LocaleUtil.fromLanguageId(defaultLanguageId);
		}

		return LocaleUtil.getSiteDefault();
	}
	
	@Reference
	private CompanyService _companyService;
	@Reference
	private GroupLocalService _groupLocalService;
	@Reference
	private TodoItemLocalService _todoItemLocalService;
}