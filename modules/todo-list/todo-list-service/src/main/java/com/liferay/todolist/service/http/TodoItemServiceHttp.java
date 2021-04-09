/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.todolist.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.todolist.service.TodoItemServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>TodoItemServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemServiceSoap
 * @generated
 */
public class TodoItemServiceHttp {

	public static com.liferay.todolist.model.TodoItem addTodoItem(
			HttpPrincipal httpPrincipal, long groupId, String title,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Date dueDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TodoItemServiceUtil.class, "addTodoItem",
				_addTodoItemParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, title, descriptionMap, dueDate,
				serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.todolist.model.TodoItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.todolist.model.TodoItem deleteTodoItem(
			HttpPrincipal httpPrincipal, long todoItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TodoItemServiceUtil.class, "deleteTodoItem",
				_deleteTodoItemParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, todoItemId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.todolist.model.TodoItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.todolist.model.TodoItem getTodoItem(
			HttpPrincipal httpPrincipal, long todoItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TodoItemServiceUtil.class, "getTodoItem",
				_getTodoItemParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, todoItemId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.todolist.model.TodoItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.todolist.model.TodoItem>
		getTodoItemsByGroupId(HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				TodoItemServiceUtil.class, "getTodoItemsByGroupId",
				_getTodoItemsByGroupIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.todolist.model.TodoItem>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.todolist.model.TodoItem>
		getTodoItemsByKeywords(
			HttpPrincipal httpPrincipal, long groupId, String keywords,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.todolist.model.TodoItem> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				TodoItemServiceUtil.class, "getTodoItemsByKeywords",
				_getTodoItemsByKeywordsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, keywords, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.todolist.model.TodoItem>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getTodoItemsCountByKeywords(
		HttpPrincipal httpPrincipal, long groupId, String keywords) {

		try {
			MethodKey methodKey = new MethodKey(
				TodoItemServiceUtil.class, "getTodoItemsCountByKeywords",
				_getTodoItemsCountByKeywordsParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.todolist.model.TodoItem updateTodoItem(
			HttpPrincipal httpPrincipal, long todoItemId, String title,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Date dueDate, String memo, Double progress,
			Boolean doneFlag,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TodoItemServiceUtil.class, "updateTodoItem",
				_updateTodoItemParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, todoItemId, title, descriptionMap, dueDate, memo,
				progress, doneFlag, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.todolist.model.TodoItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TodoItemServiceHttp.class);

	private static final Class<?>[] _addTodoItemParameterTypes0 = new Class[] {
		long.class, String.class, java.util.Map.class, java.util.Date.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteTodoItemParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _getTodoItemParameterTypes2 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getTodoItemsByGroupIdParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[] _getTodoItemsByKeywordsParameterTypes4 =
		new Class[] {
			long.class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[]
		_getTodoItemsCountByKeywordsParameterTypes5 = new Class[] {
			long.class, String.class
		};
	private static final Class<?>[] _updateTodoItemParameterTypes6 =
		new Class[] {
			long.class, String.class, java.util.Map.class, java.util.Date.class,
			String.class, Double.class, Boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};

}