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

package com.liferay.todolist.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for TodoItem. This utility wraps
 * <code>com.liferay.todolist.service.impl.TodoItemServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemService
 * @generated
 */
public class TodoItemServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.todolist.service.impl.TodoItemServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.todolist.model.TodoItem addTodoItem(
			long groupId, String title,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Date dueDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTodoItem(
			groupId, title, descriptionMap, dueDate, serviceContext);
	}

	public static com.liferay.todolist.model.TodoItem deleteTodoItem(
			long todoItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTodoItem(todoItemId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.todolist.model.TodoItem getTodoItem(
			long todoItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTodoItem(todoItemId);
	}

	public static java.util.List<com.liferay.todolist.model.TodoItem>
		getTodoItemsByGroupId(long groupId) {

		return getService().getTodoItemsByGroupId(groupId);
	}

	public static java.util.List<com.liferay.todolist.model.TodoItem>
		getTodoItemsByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.todolist.model.TodoItem> orderByComparator) {

		return getService().getTodoItemsByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	public static long getTodoItemsCountByKeywords(
		long groupId, String keywords) {

		return getService().getTodoItemsCountByKeywords(groupId, keywords);
	}

	public static com.liferay.todolist.model.TodoItem updateTodoItem(
			long todoItemId, String title,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Date dueDate, String memo, Double progress,
			Boolean doneFlag,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTodoItem(
			todoItemId, title, descriptionMap, dueDate, memo, progress,
			doneFlag, serviceContext);
	}

	public static TodoItemService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TodoItemService, TodoItemService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TodoItemService.class);

		ServiceTracker<TodoItemService, TodoItemService> serviceTracker =
			new ServiceTracker<TodoItemService, TodoItemService>(
				bundle.getBundleContext(), TodoItemService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}