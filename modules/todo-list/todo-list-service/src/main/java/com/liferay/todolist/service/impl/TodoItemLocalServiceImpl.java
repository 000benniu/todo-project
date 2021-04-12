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
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.persistence.GroupUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.todolist.model.TodoItem;
import com.liferay.todolist.service.base.TodoItemLocalServiceBaseImpl;
import com.liferay.todolist.validator.TodoItemValidator;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the todo item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.todolist.service.TodoItemLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.todolist.model.TodoItem",
	service = AopService.class
)
public class TodoItemLocalServiceImpl extends TodoItemLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.todolist.service.TodoItemLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.todolist.service.TodoItemLocalServiceUtil</code>.
	 */
	public TodoItem addTodoItem(long groupId, 
			String title,
			Map<Locale, String> descriptionMap, 
			Date dueDate,
			ServiceContext serviceContext) throws PortalException {
		
		_todoItemValidator.validate(title, descriptionMap, dueDate);

		// Get group and user.
		Group group = GroupUtil.fetchByPrimaryKey(groupId);

		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);

		// Generate primary key for the item.
		long todoItemId = counterLocalService.increment(TodoItem.class.getName());

		// Create TodoItem.
		TodoItem todoItem = createTodoItem(todoItemId);

		// Populate fields.
		todoItem.setGroupId(groupId);
		todoItem.setCompanyId(group.getCompanyId());
		todoItem.setUserId(userId);
		todoItem.setUserName(user.getScreenName());
		todoItem.setCreateDate(serviceContext.getCreateDate(new Date()));
		todoItem.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		todoItem.setTitle(title);
		todoItem.setDescriptionMap(descriptionMap);
		todoItem.setDueDate(dueDate);
		
		todoItem.setProgress(0.1); // default 0%dd
		todoItem.setDoneFlag(false); // default false;
		todoItem.setMemo(""); // default ""

		// Persist todoItem to database.
		return super.addTodoItem(todoItem);
	}
	
	public TodoItem updateTodoItem(long todoItemId, 
			String title,
			Map<Locale, String> descriptionMap, 
			Date dueDate,
			String memo,
			Double progress,
			Boolean doneFlag,
			ServiceContext serviceContext) throws PortalException {
		
		_todoItemValidator.validate(title, descriptionMap, dueDate, progress);
		
		TodoItem todoItem = getTodoItem(todoItemId);
		
		todoItem.setModifiedDate(new Date());

		todoItem.setTitle(title);
		todoItem.setDescriptionMap(descriptionMap);
		todoItem.setDueDate(dueDate);

		todoItem.setProgress(progress);
		todoItem.setDoneFlag(doneFlag);
		todoItem.setMemo(memo);
		
		return super.updateTodoItem(todoItem);
	}

	public TodoItem doneTodoItem(long todoItemId,
			ServiceContext serviceContext) throws PortalException {
		
		TodoItem todoItem = getTodoItem(todoItemId);
		
		todoItem.setModifiedDate(new Date());
		todoItem.setDoneFlag(true);
		
		return super.updateTodoItem(todoItem);
	}
	
	public TodoItem unDoneTodoItem(long todoItemId,
			ServiceContext serviceContext) throws PortalException {
		
		TodoItem todoItem = getTodoItem(todoItemId);
		
		todoItem.setModifiedDate(new Date());
		todoItem.setDoneFlag(false);
		
		return super.updateTodoItem(todoItem);
	}
	
	@Override
	public TodoItem addTodoItem(TodoItem todoItem) {
	    throw new UnsupportedOperationException("Not supported.");
	}

	@Override
	public TodoItem updateTodoItem(TodoItem todoItem) {
		throw new UnsupportedOperationException("Not supported.");
	}

	public List<TodoItem> getTodoItemsByGroupId(long groupId) {

		return todoItemPersistence.findByGroupId(groupId);
	}

	public List<TodoItem> getTodoItemsByGroupId(long groupId,
			int start,
			int end) {

		return todoItemPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<TodoItem> getTodoItemsByGroupId(long groupId,
			int start,
			int end,
			OrderByComparator<TodoItem> orderByComparator) {

		return todoItemPersistence.findByGroupId(groupId, start, end, orderByComparator);
	}

	public List<TodoItem> getTodoItemsByTitle(String title) {

		return todoItemPersistence.findByTitle(title);
	}

	public List<TodoItem> getTodoItemsByTitle(String title,
			int start,
			int end) {
		
		return todoItemPersistence.findByTitle(title, start, end);
	}

	public List<TodoItem> getTodoItemsByTitle(String title,
			int start,
			int end,
			OrderByComparator<TodoItem> orderByComparator) {

		return todoItemPersistence.findByTitle(title, start, end, orderByComparator);
	}


//	public List<TodoItem> getTodoItemsByDescription(String description) {
//
//		return todoItemPersistence.findByDescription(description);
//	}
//
//	public List<TodoItem> getTodoItemsByDescription(String description,
//			int start,
//			int end) {
//		
//		return todoItemPersistence.findByDescription(description, start, end);
//	}
//
//	public List<TodoItem> getTodoItemsByDescription(String description,
//			int start,
//			int end,
//			OrderByComparator<TodoItem> orderByComparator) {
//
//		return todoItemPersistence.findByDescription(description, start, end, orderByComparator);
	
	public List<TodoItem> getTodoItemsByKeywords(long groupId,
			String keywords,
			int start,
			int end,
			OrderByComparator<TodoItem> orderByComparator) {

		return todoItemLocalService.dynamicQuery(getKeywordSearchDynamicQuery(groupId, keywords), start, end,
				orderByComparator);
	}

	public long getTodoItemsCountByKeywords(long groupId,
			String keywords) {
		return todoItemLocalService.dynamicQueryCount(getKeywordSearchDynamicQuery(groupId, keywords));
	}

	private DynamicQuery getKeywordSearchDynamicQuery(long groupId,
			String keywords) {

		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));

		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();

			disjunctionQuery.add(RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("description", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("memo", "%" + keywords + "%"));
			dynamicQuery.add(disjunctionQuery);
		}

		return dynamicQuery;
	}
	
	@Reference
	TodoItemValidator _todoItemValidator;
}