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

package com.liferay.todolist.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.todolist.model.TodoItem;
import com.liferay.todolist.service.base.TodoItemServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the todo item remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.todolist.service.TodoItemService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=todolist",
		"json.web.service.context.path=TodoItem"
	},
	service = AopService.class
)
public class TodoItemServiceImpl extends TodoItemServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.todolist.service.TodoItemServiceUtil</code> to access the todo item remote service.
	 */
	public TodoItem addTodoItem(long groupId,
			String title,
			Map<Locale, String> descriptionMap,
			Date dueDate,
			ServiceContext serviceContext) throws PortalException {

		return todoItemLocalService.addTodoItem(groupId, title, descriptionMap, dueDate, serviceContext);
	}

	public TodoItem deleteTodoItem(long todoItemId) throws PortalException {

		TodoItem todoItem = todoItemLocalService.getTodoItem(todoItemId);

		return todoItemLocalService.deleteTodoItem(todoItem);
	}

	public TodoItem getTodoItem(long todoItemId) throws PortalException {

		TodoItem todoItem = todoItemLocalService.getTodoItem(todoItemId);

		return todoItem;
	}

	public List<TodoItem> getTodoItemsByGroupId(long groupId) {

		return todoItemPersistence.findByGroupId(groupId);
	}

	public List<TodoItem> getTodoItemsByKeywords(long groupId,
			String keywords,
			int start,
			int end,
			OrderByComparator<TodoItem> orderByComparator) {

		return todoItemLocalService.getTodoItemsByKeywords(groupId, keywords, start, end, orderByComparator);
	}

	public long getTodoItemsCountByKeywords(long groupId,
			String keywords) {

		return todoItemLocalService.getTodoItemsCountByKeywords(groupId, keywords);
	}

	public TodoItem updateTodoItem(long todoItemId,
			String title,
			Map<Locale, String> descriptionMap,
			Date dueDate,
			String memo,
			Double progress,
			Boolean doneFlag,
			ServiceContext serviceContext) throws PortalException {

		return todoItemLocalService.updateTodoItem(todoItemId, title, descriptionMap, dueDate, memo, progress,
				doneFlag, serviceContext);
	}
}