package com.liferay.todolist.resetbuild.client.resource.v1_0;

import com.liferay.todolist.resetbuild.client.dto.v1_0.TodoItem;
import com.liferay.todolist.resetbuild.client.dto.v1_0.TodoItemRequest;
import com.liferay.todolist.resetbuild.client.http.HttpInvoker;
import com.liferay.todolist.resetbuild.client.pagination.Page;
import com.liferay.todolist.resetbuild.client.problem.Problem;
import com.liferay.todolist.resetbuild.client.serdes.v1_0.TodoItemSerDes;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author ben
 * @generated
 */
@Generated("")
public interface TodoItemResource {

	public static Builder builder() {
		return new Builder();
	}

	public Page<TodoItem> getTodolistPage() throws Exception;

	public HttpInvoker.HttpResponse getTodolistPageHttpResponse()
		throws Exception;

	public Page<TodoItem> patchTodolistMarkItemDoneTodoItemPage(Long todoItemId)
		throws Exception;

	public HttpInvoker.HttpResponse
			patchTodolistMarkItemDoneTodoItemPageHttpResponse(Long todoItemId)
		throws Exception;

	public Page<TodoItem> getTodolistMarkItemUndoTodoItemPage(Long todoItemId)
		throws Exception;

	public HttpInvoker.HttpResponse
			getTodolistMarkItemUndoTodoItemPageHttpResponse(Long todoItemId)
		throws Exception;

	public TodoItem postTodolistAddTodoItemPage(TodoItemRequest todoItemRequest)
		throws Exception;

	public HttpInvoker.HttpResponse postTodolistAddTodoItemPageHttpResponse(
			TodoItemRequest todoItemRequest)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public TodoItemResource build() {
			return new TodoItemResourceImpl(this);
		}

		public Builder endpoint(String host, int port, String scheme) {
			_host = host;
			_port = port;
			_scheme = scheme;

			return this;
		}

		public Builder header(String key, String value) {
			_headers.put(key, value);

			return this;
		}

		public Builder locale(Locale locale) {
			_locale = locale;

			return this;
		}

		public Builder parameter(String key, String value) {
			_parameters.put(key, value);

			return this;
		}

		private Builder() {
		}

		private Map<String, String> _headers = new LinkedHashMap<>();
		private String _host = "localhost";
		private Locale _locale;
		private String _login = "";
		private String _password = "";
		private Map<String, String> _parameters = new LinkedHashMap<>();
		private int _port = 8080;
		private String _scheme = "http";

	}

	public static class TodoItemResourceImpl implements TodoItemResource {

		public Page<TodoItem> getTodolistPage() throws Exception {
			HttpInvoker.HttpResponse httpResponse =
				getTodolistPageHttpResponse();

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return Page.of(content, TodoItemSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse getTodolistPageHttpResponse()
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/todo-list-restbuild/v1.0/todolist/gettodolist");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<TodoItem> patchTodolistMarkItemDoneTodoItemPage(
				Long todoItemId)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				patchTodolistMarkItemDoneTodoItemPageHttpResponse(todoItemId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return Page.of(content, TodoItemSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse
				patchTodolistMarkItemDoneTodoItemPageHttpResponse(
					Long todoItemId)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(todoItemId.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.PATCH);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/todo-list-restbuild/v1.0/todolist/markItemDone/{todoItemId}");

			httpInvoker.path("todoItemId", todoItemId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<TodoItem> getTodolistMarkItemUndoTodoItemPage(
				Long todoItemId)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getTodolistMarkItemUndoTodoItemPageHttpResponse(todoItemId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return Page.of(content, TodoItemSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse
				getTodolistMarkItemUndoTodoItemPageHttpResponse(Long todoItemId)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(todoItemId.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.PATCH);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/todo-list-restbuild/v1.0/todolist/markItemUndo/{todoItemId}");

			httpInvoker.path("todoItemId", todoItemId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public TodoItem postTodolistAddTodoItemPage(
				TodoItemRequest todoItemRequest)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				postTodolistAddTodoItemPageHttpResponse(todoItemRequest);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return TodoItemSerDes.toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse postTodolistAddTodoItemPageHttpResponse(
				TodoItemRequest todoItemRequest)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(todoItemRequest.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/todo-list-restbuild/v1.0/todolist/addTodoItem");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private TodoItemResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			TodoItemResource.class.getName());

		private Builder _builder;

	}

}