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

package com.liferay.todolist.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TodoItem}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoItem
 * @generated
 */
public class TodoItemWrapper
	extends BaseModelWrapper<TodoItem>
	implements ModelWrapper<TodoItem>, TodoItem {

	public TodoItemWrapper(TodoItem todoItem) {
		super(todoItem);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("todoItemId", getTodoItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("doneFlag", isDoneFlag());
		attributes.put("progress", getProgress());
		attributes.put("dueDate", getDueDate());
		attributes.put("memo", getMemo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long todoItemId = (Long)attributes.get("todoItemId");

		if (todoItemId != null) {
			setTodoItemId(todoItemId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean doneFlag = (Boolean)attributes.get("doneFlag");

		if (doneFlag != null) {
			setDoneFlag(doneFlag);
		}

		Double progress = (Double)attributes.get("progress");

		if (progress != null) {
			setProgress(progress);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		String memo = (String)attributes.get("memo");

		if (memo != null) {
			setMemo(memo);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this todo item.
	 *
	 * @return the company ID of this todo item
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this todo item.
	 *
	 * @return the create date of this todo item
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this todo item.
	 *
	 * @return the description of this todo item
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this todo item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this todo item
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this todo item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this todo item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this todo item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this todo item
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this todo item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this todo item
	 */
	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return model.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return model.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return model.getDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized descriptions of this todo item.
	 *
	 * @return the locales and localized descriptions of this todo item
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the done flag of this todo item.
	 *
	 * @return the done flag of this todo item
	 */
	@Override
	public boolean getDoneFlag() {
		return model.getDoneFlag();
	}

	/**
	 * Returns the due date of this todo item.
	 *
	 * @return the due date of this todo item
	 */
	@Override
	public Date getDueDate() {
		return model.getDueDate();
	}

	/**
	 * Returns the group ID of this todo item.
	 *
	 * @return the group ID of this todo item
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the memo of this todo item.
	 *
	 * @return the memo of this todo item
	 */
	@Override
	public String getMemo() {
		return model.getMemo();
	}

	/**
	 * Returns the modified date of this todo item.
	 *
	 * @return the modified date of this todo item
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this todo item.
	 *
	 * @return the primary key of this todo item
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progress of this todo item.
	 *
	 * @return the progress of this todo item
	 */
	@Override
	public double getProgress() {
		return model.getProgress();
	}

	@Override
	public String getProgressBar() {
		return model.getProgressBar();
	}

	/**
	 * Returns the title of this todo item.
	 *
	 * @return the title of this todo item
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the todo item ID of this todo item.
	 *
	 * @return the todo item ID of this todo item
	 */
	@Override
	public long getTodoItemId() {
		return model.getTodoItemId();
	}

	/**
	 * Returns the user ID of this todo item.
	 *
	 * @return the user ID of this todo item
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this todo item.
	 *
	 * @return the user name of this todo item
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this todo item.
	 *
	 * @return the user uuid of this todo item
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this todo item.
	 *
	 * @return the uuid of this todo item
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this todo item is done flag.
	 *
	 * @return <code>true</code> if this todo item is done flag; <code>false</code> otherwise
	 */
	@Override
	public boolean isDoneFlag() {
		return model.isDoneFlag();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the company ID of this todo item.
	 *
	 * @param companyId the company ID of this todo item
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this todo item.
	 *
	 * @param createDate the create date of this todo item
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this todo item.
	 *
	 * @param description the description of this todo item
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this todo item in the language.
	 *
	 * @param description the localized description of this todo item
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this todo item in the language, and sets the default locale.
	 *
	 * @param description the localized description of this todo item
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescription(
		String description, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		model.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this todo item from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this todo item
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this todo item from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this todo item
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets whether this todo item is done flag.
	 *
	 * @param doneFlag the done flag of this todo item
	 */
	@Override
	public void setDoneFlag(boolean doneFlag) {
		model.setDoneFlag(doneFlag);
	}

	/**
	 * Sets the due date of this todo item.
	 *
	 * @param dueDate the due date of this todo item
	 */
	@Override
	public void setDueDate(Date dueDate) {
		model.setDueDate(dueDate);
	}

	/**
	 * Sets the group ID of this todo item.
	 *
	 * @param groupId the group ID of this todo item
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the memo of this todo item.
	 *
	 * @param memo the memo of this todo item
	 */
	@Override
	public void setMemo(String memo) {
		model.setMemo(memo);
	}

	/**
	 * Sets the modified date of this todo item.
	 *
	 * @param modifiedDate the modified date of this todo item
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this todo item.
	 *
	 * @param primaryKey the primary key of this todo item
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progress of this todo item.
	 *
	 * @param progress the progress of this todo item
	 */
	@Override
	public void setProgress(double progress) {
		model.setProgress(progress);
	}

	/**
	 * Sets the title of this todo item.
	 *
	 * @param title the title of this todo item
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the todo item ID of this todo item.
	 *
	 * @param todoItemId the todo item ID of this todo item
	 */
	@Override
	public void setTodoItemId(long todoItemId) {
		model.setTodoItemId(todoItemId);
	}

	/**
	 * Sets the user ID of this todo item.
	 *
	 * @param userId the user ID of this todo item
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this todo item.
	 *
	 * @param userName the user name of this todo item
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this todo item.
	 *
	 * @param userUuid the user uuid of this todo item
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this todo item.
	 *
	 * @param uuid the uuid of this todo item
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected TodoItemWrapper wrap(TodoItem todoItem) {
		return new TodoItemWrapper(todoItem);
	}

}