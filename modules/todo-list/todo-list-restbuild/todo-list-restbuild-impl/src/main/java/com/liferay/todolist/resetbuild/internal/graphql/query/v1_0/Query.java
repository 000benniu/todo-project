package com.liferay.todolist.resetbuild.internal.graphql.query.v1_0;

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
import com.liferay.todolist.resetbuild.dto.v1_0.TodoItem;
import com.liferay.todolist.resetbuild.resource.v1_0.TodoItemResource;

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

	public static void setTodoItemResourceComponentServiceObjects(
		ComponentServiceObjects<TodoItemResource>
			todoItemResourceComponentServiceObjects) {

		_todoItemResourceComponentServiceObjects =
			todoItemResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {todolist{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public TodoItemPage todolist() throws Exception {
		return _applyComponentServiceObjects(
			_todoItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemResource -> new TodoItemPage(
				todoItemResource.getTodolistPage()));
	}

	@GraphQLName("TodoItemPage")
	public class TodoItemPage {

		public TodoItemPage(Page todoItemPage) {
			actions = todoItemPage.getActions();

			items = todoItemPage.getItems();
			lastPage = todoItemPage.getLastPage();
			page = todoItemPage.getPage();
			pageSize = todoItemPage.getPageSize();
			totalCount = todoItemPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<TodoItem> items;

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

	private void _populateResourceContext(TodoItemResource todoItemResource)
		throws Exception {

		todoItemResource.setContextAcceptLanguage(_acceptLanguage);
		todoItemResource.setContextCompany(_company);
		todoItemResource.setContextHttpServletRequest(_httpServletRequest);
		todoItemResource.setContextHttpServletResponse(_httpServletResponse);
		todoItemResource.setContextUriInfo(_uriInfo);
		todoItemResource.setContextUser(_user);
		todoItemResource.setGroupLocalService(_groupLocalService);
		todoItemResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<TodoItemResource>
		_todoItemResourceComponentServiceObjects;

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