package com.liferay.todolist.resetbuild.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.todolist.resetbuild.dto.v1_0.TodoItem;
import com.liferay.todolist.resetbuild.dto.v1_0.TodoItemRequest;
import com.liferay.todolist.resetbuild.resource.v1_0.TodoItemResource;

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
public class Mutation {

	public static void setTodoItemResourceComponentServiceObjects(
		ComponentServiceObjects<TodoItemResource>
			todoItemResourceComponentServiceObjects) {

		_todoItemResourceComponentServiceObjects =
			todoItemResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Mark item as done")
	public java.util.Collection<TodoItem> patchTodolistMarkItemDoneTodoItemPage(
			@GraphQLName("todoItemId") Long todoItemId)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemResource -> {
				Page paginationPage =
					todoItemResource.patchTodolistMarkItemDoneTodoItemPage(
						todoItemId);

				return paginationPage.getItems();
			});
	}

	@GraphQLField(description = "Reset item to to-do.")
	public java.util.Collection<TodoItem> getTodolistMarkItemUndoTodoItemPage(
			@GraphQLName("todoItemId") Long todoItemId)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemResource -> {
				Page paginationPage =
					todoItemResource.getTodolistMarkItemUndoTodoItemPage(
						todoItemId);

				return paginationPage.getItems();
			});
	}

	@GraphQLField(description = "Create a new todoItem.")
	public TodoItem createTodolistAddTodoItemPage(
			@GraphQLName("todoItemRequest") TodoItemRequest todoItemRequest)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemResource -> todoItemResource.postTodolistAddTodoItemPage(
				todoItemRequest));
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

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
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
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}