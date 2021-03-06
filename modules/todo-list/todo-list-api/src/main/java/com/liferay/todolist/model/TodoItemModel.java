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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the TodoItem service. Represents a row in the &quot;TodoList_TodoItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.todolist.model.impl.TodoItemModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.todolist.model.impl.TodoItemImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoItem
 * @generated
 */
@ProviderType
public interface TodoItemModel
	extends BaseModel<TodoItem>, GroupedModel, LocalizedModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a todo item model instance should use the {@link TodoItem} interface instead.
	 */

	/**
	 * Returns the primary key of this todo item.
	 *
	 * @return the primary key of this todo item
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this todo item.
	 *
	 * @param primaryKey the primary key of this todo item
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this todo item.
	 *
	 * @return the uuid of this todo item
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this todo item.
	 *
	 * @param uuid the uuid of this todo item
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the todo item ID of this todo item.
	 *
	 * @return the todo item ID of this todo item
	 */
	public long getTodoItemId();

	/**
	 * Sets the todo item ID of this todo item.
	 *
	 * @param todoItemId the todo item ID of this todo item
	 */
	public void setTodoItemId(long todoItemId);

	/**
	 * Returns the group ID of this todo item.
	 *
	 * @return the group ID of this todo item
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this todo item.
	 *
	 * @param groupId the group ID of this todo item
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this todo item.
	 *
	 * @return the company ID of this todo item
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this todo item.
	 *
	 * @param companyId the company ID of this todo item
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this todo item.
	 *
	 * @return the user ID of this todo item
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this todo item.
	 *
	 * @param userId the user ID of this todo item
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this todo item.
	 *
	 * @return the user uuid of this todo item
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this todo item.
	 *
	 * @param userUuid the user uuid of this todo item
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this todo item.
	 *
	 * @return the user name of this todo item
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this todo item.
	 *
	 * @param userName the user name of this todo item
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this todo item.
	 *
	 * @return the create date of this todo item
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this todo item.
	 *
	 * @param createDate the create date of this todo item
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this todo item.
	 *
	 * @return the modified date of this todo item
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this todo item.
	 *
	 * @param modifiedDate the modified date of this todo item
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the title of this todo item.
	 *
	 * @return the title of this todo item
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this todo item.
	 *
	 * @param title the title of this todo item
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this todo item.
	 *
	 * @return the description of this todo item
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this todo item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this todo item
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this todo item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this todo item. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this todo item in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this todo item
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this todo item in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this todo item
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this todo item.
	 *
	 * @return the locales and localized descriptions of this todo item
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this todo item.
	 *
	 * @param description the description of this todo item
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this todo item in the language.
	 *
	 * @param description the localized description of this todo item
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this todo item in the language, and sets the default locale.
	 *
	 * @param description the localized description of this todo item
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(
		String description, Locale locale, Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this todo item from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this todo item
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this todo item from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this todo item
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale);

	/**
	 * Returns the done flag of this todo item.
	 *
	 * @return the done flag of this todo item
	 */
	public boolean getDoneFlag();

	/**
	 * Returns <code>true</code> if this todo item is done flag.
	 *
	 * @return <code>true</code> if this todo item is done flag; <code>false</code> otherwise
	 */
	public boolean isDoneFlag();

	/**
	 * Sets whether this todo item is done flag.
	 *
	 * @param doneFlag the done flag of this todo item
	 */
	public void setDoneFlag(boolean doneFlag);

	/**
	 * Returns the progress of this todo item.
	 *
	 * @return the progress of this todo item
	 */
	public double getProgress();

	/**
	 * Sets the progress of this todo item.
	 *
	 * @param progress the progress of this todo item
	 */
	public void setProgress(double progress);

	/**
	 * Returns the due date of this todo item.
	 *
	 * @return the due date of this todo item
	 */
	public Date getDueDate();

	/**
	 * Sets the due date of this todo item.
	 *
	 * @param dueDate the due date of this todo item
	 */
	public void setDueDate(Date dueDate);

	/**
	 * Returns the memo of this todo item.
	 *
	 * @return the memo of this todo item
	 */
	@AutoEscape
	public String getMemo();

	/**
	 * Sets the memo of this todo item.
	 *
	 * @param memo the memo of this todo item
	 */
	public void setMemo(String memo);

	/**
	 * Returns the status of this todo item.
	 *
	 * @return the status of this todo item
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this todo item.
	 *
	 * @param status the status of this todo item
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this todo item.
	 *
	 * @return the status by user ID of this todo item
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this todo item.
	 *
	 * @param statusByUserId the status by user ID of this todo item
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this todo item.
	 *
	 * @return the status by user uuid of this todo item
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this todo item.
	 *
	 * @param statusByUserUuid the status by user uuid of this todo item
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this todo item.
	 *
	 * @return the status by user name of this todo item
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this todo item.
	 *
	 * @param statusByUserName the status by user name of this todo item
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this todo item.
	 *
	 * @return the status date of this todo item
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this todo item.
	 *
	 * @param statusDate the status date of this todo item
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this todo item is approved.
	 *
	 * @return <code>true</code> if this todo item is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this todo item is denied.
	 *
	 * @return <code>true</code> if this todo item is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this todo item is a draft.
	 *
	 * @return <code>true</code> if this todo item is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this todo item is expired.
	 *
	 * @return <code>true</code> if this todo item is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this todo item is inactive.
	 *
	 * @return <code>true</code> if this todo item is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this todo item is incomplete.
	 *
	 * @return <code>true</code> if this todo item is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this todo item is pending.
	 *
	 * @return <code>true</code> if this todo item is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this todo item is scheduled.
	 *
	 * @return <code>true</code> if this todo item is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

}