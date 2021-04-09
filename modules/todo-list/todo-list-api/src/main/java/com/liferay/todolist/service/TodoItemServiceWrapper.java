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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TodoItemService}.
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemService
 * @generated
 */
public class TodoItemServiceWrapper
	implements ServiceWrapper<TodoItemService>, TodoItemService {

	public TodoItemServiceWrapper(TodoItemService todoItemService) {
		_todoItemService = todoItemService;
	}

	@Override
	public com.liferay.todolist.model.TodoItem addTodoItem(
			long groupId, String title,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Date dueDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoItemService.addTodoItem(
			groupId, title, descriptionMap, dueDate, serviceContext);
	}

	@Override
	public com.liferay.todolist.model.TodoItem deleteTodoItem(long todoItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoItemService.deleteTodoItem(todoItemId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _todoItemService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.todolist.model.TodoItem getTodoItem(long todoItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoItemService.getTodoItem(todoItemId);
	}

	@Override
	public java.util.List<com.liferay.todolist.model.TodoItem>
		getTodoItemsByGroupId(long groupId) {

		return _todoItemService.getTodoItemsByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.todolist.model.TodoItem>
		getTodoItemsByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.todolist.model.TodoItem> orderByComparator) {

		return _todoItemService.getTodoItemsByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public long getTodoItemsCountByKeywords(long groupId, String keywords) {
		return _todoItemService.getTodoItemsCountByKeywords(groupId, keywords);
	}

	@Override
	public com.liferay.todolist.model.TodoItem updateTodoItem(
			long todoItemId, String title,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Date dueDate, String memo, Double progress,
			Boolean doneFlag,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoItemService.updateTodoItem(
			todoItemId, title, descriptionMap, dueDate, memo, progress,
			doneFlag, serviceContext);
	}

	@Override
	public TodoItemService getWrappedService() {
		return _todoItemService;
	}

	@Override
	public void setWrappedService(TodoItemService todoItemService) {
		_todoItemService = todoItemService;
	}

	private TodoItemService _todoItemService;

}