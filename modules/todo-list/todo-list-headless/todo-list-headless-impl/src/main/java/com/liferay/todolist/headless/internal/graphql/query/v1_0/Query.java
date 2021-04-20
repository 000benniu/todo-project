package com.liferay.todolist.headless.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.todolist.headless.dto.v1_0.TodoItemModel;
import com.liferay.todolist.headless.resource.v1_0.TodoItemModelResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author ben
 * @generated
 */
@Generated("")
public class Query {

	public static void setTodoItemModelResourceComponentServiceObjects(
		ComponentServiceObjects<TodoItemModelResource>
			todoItemModelResourceComponentServiceObjects) {

		_todoItemModelResourceComponentServiceObjects =
			todoItemModelResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {todoItemModels(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the list of todoItems. Results can be paginated, filtered, searched, and sorted."
	)
	public TodoItemModelPage todoItemModels(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoItemModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemModelResource -> new TodoItemModelPage(
				todoItemModelResource.getTodoItemModelsPage(
					search,
					_filterBiFunction.apply(
						todoItemModelResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(
						todoItemModelResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {todoItemModel(todoItemId: ___){title, todoItemId, description, group, articleId, doneFlag, progress, dueDate, memo, creator}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the todoItem via its ID.")
	public TodoItemModel todoItemModel(
			@GraphQLName("todoItemId") String todoItemId)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoItemModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemModelResource -> todoItemModelResource.getTodoItemModel(
				todoItemId));
	}

	@GraphQLName("TodoItemModelPage")
	public class TodoItemModelPage {

		public TodoItemModelPage(Page todoItemModelPage) {
			actions = todoItemModelPage.getActions();

			items = todoItemModelPage.getItems();
			lastPage = todoItemModelPage.getLastPage();
			page = todoItemModelPage.getPage();
			pageSize = todoItemModelPage.getPageSize();
			totalCount = todoItemModelPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<TodoItemModel> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(
			TodoItemModelResource todoItemModelResource)
		throws Exception {

		todoItemModelResource.setContextAcceptLanguage(_acceptLanguage);
		todoItemModelResource.setContextCompany(_company);
		todoItemModelResource.setContextHttpServletRequest(_httpServletRequest);
		todoItemModelResource.setContextHttpServletResponse(
			_httpServletResponse);
		todoItemModelResource.setContextUriInfo(_uriInfo);
		todoItemModelResource.setContextUser(_user);
		todoItemModelResource.setGroupLocalService(_groupLocalService);
		todoItemModelResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<TodoItemModelResource>
		_todoItemModelResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}