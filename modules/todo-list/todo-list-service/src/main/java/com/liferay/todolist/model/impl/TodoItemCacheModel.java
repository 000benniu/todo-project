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

package com.liferay.todolist.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.todolist.model.TodoItem;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TodoItem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TodoItemCacheModel
	implements CacheModel<TodoItem>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TodoItemCacheModel)) {
			return false;
		}

		TodoItemCacheModel todoItemCacheModel = (TodoItemCacheModel)object;

		if (todoItemId == todoItemCacheModel.todoItemId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, todoItemId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", todoItemId=");
		sb.append(todoItemId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", doneFlag=");
		sb.append(doneFlag);
		sb.append(", progress=");
		sb.append(progress);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", memo=");
		sb.append(memo);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TodoItem toEntityModel() {
		TodoItemImpl todoItemImpl = new TodoItemImpl();

		if (uuid == null) {
			todoItemImpl.setUuid("");
		}
		else {
			todoItemImpl.setUuid(uuid);
		}

		todoItemImpl.setTodoItemId(todoItemId);
		todoItemImpl.setGroupId(groupId);
		todoItemImpl.setCompanyId(companyId);
		todoItemImpl.setUserId(userId);

		if (userName == null) {
			todoItemImpl.setUserName("");
		}
		else {
			todoItemImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			todoItemImpl.setCreateDate(null);
		}
		else {
			todoItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			todoItemImpl.setModifiedDate(null);
		}
		else {
			todoItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			todoItemImpl.setTitle("");
		}
		else {
			todoItemImpl.setTitle(title);
		}

		if (description == null) {
			todoItemImpl.setDescription("");
		}
		else {
			todoItemImpl.setDescription(description);
		}

		todoItemImpl.setDoneFlag(doneFlag);
		todoItemImpl.setProgress(progress);

		if (dueDate == Long.MIN_VALUE) {
			todoItemImpl.setDueDate(null);
		}
		else {
			todoItemImpl.setDueDate(new Date(dueDate));
		}

		if (memo == null) {
			todoItemImpl.setMemo("");
		}
		else {
			todoItemImpl.setMemo(memo);
		}

		todoItemImpl.setStatus(status);
		todoItemImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			todoItemImpl.setStatusByUserName("");
		}
		else {
			todoItemImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			todoItemImpl.setStatusDate(null);
		}
		else {
			todoItemImpl.setStatusDate(new Date(statusDate));
		}

		todoItemImpl.resetOriginalValues();

		return todoItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		todoItemId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		doneFlag = objectInput.readBoolean();

		progress = objectInput.readDouble();
		dueDate = objectInput.readLong();
		memo = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(todoItemId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(doneFlag);

		objectOutput.writeDouble(progress);
		objectOutput.writeLong(dueDate);

		if (memo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memo);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long todoItemId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public boolean doneFlag;
	public double progress;
	public long dueDate;
	public String memo;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}