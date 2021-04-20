package com.liferay.todolist.internal.resource.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.liferay.todolist.dto.v1_0.Creator;
import com.liferay.todolist.dto.v1_0.TodoItemModel;
import com.liferay.todolist.internal.util.CreatorUtil;
import com.liferay.todolist.model.TodoItem;
import com.liferay.todolist.resource.v1_0.TodoItemModelResource;
import com.liferay.todolist.service.TodoItemService;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.v3.oas.annotations.Parameter;

/**
 * @author ben
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/todo-item-model.properties",
	scope = ServiceScope.PROTOTYPE, service = TodoItemModelResource.class
)
public class TodoItemModelResourceImpl extends BaseTodoItemModelResourceImpl {
	
	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/todo-list-headless/v1.0/todoItems'  -u 'test@liferay.com:test'
	 */
	@Override
//	@GET
//	@Operation(
//		description = "Retrieves the list of todoItems. Results can be paginated, filtered, searched, and sorted."
//	)
//	@Parameters(
//		value = {
//			@Parameter(in = ParameterIn.QUERY, name = "search"),
//			@Parameter(in = ParameterIn.QUERY, name = "filter"),
//			@Parameter(in = ParameterIn.QUERY, name = "page"),
//			@Parameter(in = ParameterIn.QUERY, name = "pageSize"),
//			@Parameter(in = ParameterIn.QUERY, name = "sort")
//		}
//	)
//	@Path("/todoItems")
//	@Produces({"application/json", "application/xml"})
//	@Tags(value = {@Tag(name = "TodoItemModel")})
	public Page<TodoItemModel> getTodoItemModelsPage(
			@Parameter(hidden = true) @QueryParam("search") String search,
			@Context Filter filter, @Context Pagination pagination,
			@Context Sort[] sorts)
		throws Exception {
		try {
			Page<Object> result1 = SearchUtil.search(
					null,
					booleanQuery -> {
						// does nothing, we just need the UnsafeConsumer<BooleanQuery, Exception> method
					},
					filter, TodoItem.class, search, pagination, 
					queryConfig -> queryConfig.setSelectedFieldNames(
							Field.ENTRY_CLASS_PK),
					searchContext -> searchContext.setCompanyId(
							contextCompany.getCompanyId()),
					sorts, 
					null);
			System.out.print("Got result1");
			
			return SearchUtil.search(
					booleanQuery -> {
						// does nothing, we just need the UnsafeConsumer<BooleanQuery, Exception> method
					},
					filter, TodoItem.class, search, pagination,
					queryConfig -> queryConfig.setSelectedFieldNames(
							Field.ENTRY_CLASS_PK),
					searchContext -> searchContext.setCompanyId(
							contextCompany.getCompanyId()),
					document -> _toTodoItemModel(
							_todoItemService.getTodoItem(
									GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))),
					sorts);
		} catch (Exception e) {
			_log.error("Error listing vitamins: " + e.getMessage(), e);

			throw e;
		}
	}
	
	protected TodoItemModel _toTodoItemModel(TodoItem todoItem) throws Exception {
		return new TodoItemModel() {{
			group = Long.toString(todoItem.getGroupId());
			description = todoItem.getDescription();
			todoItemId = Long.toString(todoItem.getTodoItemId());
			creator = CreatorUtil.toCreator(_portal, _userLocalService.getUser(todoItem.getUserId()));
			title = todoItem.getTitle();
			progress = todoItem.getProgress();
			memo = todoItem.getMemo();
			doneFlag = todoItem.getDoneFlag();
			dueDate = todoItem.getDueDate();
		}};
	}
	
	@Reference
	private Portal _portal;

	@Reference
	private UserLocalService _userLocalService;

	@Reference
	private TodoItemService _todoItemService;

	private static final Logger _log = LoggerFactory.getLogger(TodoItemModelResourceImpl.class);
}