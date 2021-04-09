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
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.todolist.service.TodoItemServiceUtil;

import java.rmi.RemoteException;

import java.util.Locale;
import java.util.Map;

/**
 * Provides the SOAP utility for the
 * <code>TodoItemServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.todolist.model.TodoItemSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.todolist.model.TodoItem</code>, that is translated to a
 * <code>com.liferay.todolist.model.TodoItemSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TodoItemServiceSoap {

	public static com.liferay.todolist.model.TodoItemSoap addTodoItem(
			long groupId, String title, String[] descriptionMapLanguageIds,
			String[] descriptionMapValues, java.util.Date dueDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			Map<Locale, String> descriptionMap =
				LocalizationUtil.getLocalizationMap(
					descriptionMapLanguageIds, descriptionMapValues);

			com.liferay.todolist.model.TodoItem returnValue =
				TodoItemServiceUtil.addTodoItem(
					groupId, title, descriptionMap, dueDate, serviceContext);

			return com.liferay.todolist.model.TodoItemSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.todolist.model.TodoItemSoap deleteTodoItem(
			long todoItemId)
		throws RemoteException {

		try {
			com.liferay.todolist.model.TodoItem returnValue =
				TodoItemServiceUtil.deleteTodoItem(todoItemId);

			return com.liferay.todolist.model.TodoItemSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.todolist.model.TodoItemSoap getTodoItem(
			long todoItemId)
		throws RemoteException {

		try {
			com.liferay.todolist.model.TodoItem returnValue =
				TodoItemServiceUtil.getTodoItem(todoItemId);

			return com.liferay.todolist.model.TodoItemSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.todolist.model.TodoItemSoap[]
			getTodoItemsByGroupId(long groupId)
		throws RemoteException {

		try {
			java.util.List<com.liferay.todolist.model.TodoItem> returnValue =
				TodoItemServiceUtil.getTodoItemsByGroupId(groupId);

			return com.liferay.todolist.model.TodoItemSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.todolist.model.TodoItemSoap[]
			getTodoItemsByKeywords(
				long groupId, String keywords, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.todolist.model.TodoItem> orderByComparator)
		throws RemoteException {

		try {
			java.util.List<com.liferay.todolist.model.TodoItem> returnValue =
				TodoItemServiceUtil.getTodoItemsByKeywords(
					groupId, keywords, start, end, orderByComparator);

			return com.liferay.todolist.model.TodoItemSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static long getTodoItemsCountByKeywords(
			long groupId, String keywords)
		throws RemoteException {

		try {
			long returnValue = TodoItemServiceUtil.getTodoItemsCountByKeywords(
				groupId, keywords);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.todolist.model.TodoItemSoap updateTodoItem(
			long todoItemId, String title, String[] descriptionMapLanguageIds,
			String[] descriptionMapValues, java.util.Date dueDate, String memo,
			Double progress, Boolean doneFlag,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			Map<Locale, String> descriptionMap =
				LocalizationUtil.getLocalizationMap(
					descriptionMapLanguageIds, descriptionMapValues);

			com.liferay.todolist.model.TodoItem returnValue =
				TodoItemServiceUtil.updateTodoItem(
					todoItemId, title, descriptionMap, dueDate, memo, progress,
					doneFlag, serviceContext);

			return com.liferay.todolist.model.TodoItemSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TodoItemServiceSoap.class);

}