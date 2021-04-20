package com.liferay.todolist.resource.v1_0;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.todolist.dto.v1_0.TodoItemModel;

import java.util.Locale;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/todo-list-headless/v1.0
 *
 * @author ben
 * @generated
 */
@Generated("")
@ProviderType
public interface TodoItemModelResource {

	public static Builder builder() {
		return FactoryHolder.factory.create();
	}

	public Page<TodoItemModel> getTodoItemModelsPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception;

	public TodoItemModel postTodoItemModel(TodoItemModel todoItemModel)
		throws Exception;

	public Response postTodoItemModelBatch(String callbackURL, Object object)
		throws Exception;

	public void deleteTodoItemModel(String todoItemId) throws Exception;

	public Response deleteTodoItemModelBatch(
			String todoItemId, String callbackURL, Object object)
		throws Exception;

	public TodoItemModel getTodoItemModel(String todoItemId) throws Exception;

	public TodoItemModel patchTodoItemModel(
			String todoItemId, TodoItemModel todoItemModel)
		throws Exception;

	public default void setContextAcceptLanguage(
		AcceptLanguage contextAcceptLanguage) {
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany);

	public default void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {
	}

	public default void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {
	}

	public default void setContextUriInfo(UriInfo contextUriInfo) {
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser);

	public void setGroupLocalService(GroupLocalService groupLocalService);

	public void setRoleLocalService(RoleLocalService roleLocalService);

	public static class FactoryHolder {

		public static volatile Factory factory;

	}

	@ProviderType
	public interface Builder {

		public TodoItemModelResource build();

		public Builder checkPermissions(boolean checkPermissions);

		public Builder httpServletRequest(
			HttpServletRequest httpServletRequest);

		public Builder preferredLocale(Locale preferredLocale);

		public Builder user(com.liferay.portal.kernel.model.User user);

	}

	@ProviderType
	public interface Factory {

		public Builder create();

	}

}