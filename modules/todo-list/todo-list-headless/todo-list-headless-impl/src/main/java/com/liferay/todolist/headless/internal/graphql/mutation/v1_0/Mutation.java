package com.liferay.todolist.headless.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.todolist.headless.dto.v1_0.TodoItemModel;
import com.liferay.todolist.headless.resource.v1_0.TodoItemModelResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author ben
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setTodoItemModelResourceComponentServiceObjects(
		ComponentServiceObjects<TodoItemModelResource>
			todoItemModelResourceComponentServiceObjects) {

		_todoItemModelResourceComponentServiceObjects =
			todoItemModelResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Create a new todoItem/mineral.")
	public TodoItemModel createTodoItemModel(
			@GraphQLName("todoItemModel") TodoItemModel todoItemModel)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoItemModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemModelResource -> todoItemModelResource.postTodoItemModel(
				todoItemModel));
	}

	@GraphQLField
	public Response createTodoItemModelBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoItemModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemModelResource ->
				todoItemModelResource.postTodoItemModelBatch(
					callbackURL, object));
	}

	@GraphQLField(
		description = "Deletes the todoItem and returns a 204 if the operation succeeds."
	)
	public boolean deleteTodoItemModel(
			@GraphQLName("todoItemId") String todoItemId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_todoItemModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemModelResource -> todoItemModelResource.deleteTodoItemModel(
				todoItemId));

		return true;
	}

	@GraphQLField
	public Response deleteTodoItemModelBatch(
			@GraphQLName("todoItemId") String todoItemId,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoItemModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemModelResource ->
				todoItemModelResource.deleteTodoItemModelBatch(
					todoItemId, callbackURL, object));
	}

	@GraphQLField(
		description = "Replaces the todoItem with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	public TodoItemModel patchTodoItemModel(
			@GraphQLName("todoItemId") String todoItemId,
			@GraphQLName("todoItemModel") TodoItemModel todoItemModel)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoItemModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemModelResource -> todoItemModelResource.patchTodoItemModel(
				todoItemId, todoItemModel));
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
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}