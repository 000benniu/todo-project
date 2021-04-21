package com.liferay.todolist.headless.client.dto.v1_0;

import com.liferay.todolist.headless.client.function.UnsafeSupplier;
import com.liferay.todolist.headless.client.serdes.v1_0.TodoItemModelSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author ben
 * @generated
 */
@Generated("")
public class TodoItemModel implements Cloneable, Serializable {

	public static TodoItemModel toDTO(String json) {
		return TodoItemModelSerDes.toDTO(json);
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public void setArticleId(
		UnsafeSupplier<String, Exception> articleIdUnsafeSupplier) {

		try {
			articleId = articleIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String articleId;

	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	public void setCreator(
		UnsafeSupplier<Creator, Exception> creatorUnsafeSupplier) {

		try {
			creator = creatorUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Creator creator;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String description;

	public Boolean getDoneFlag() {
		return doneFlag;
	}

	public void setDoneFlag(Boolean doneFlag) {
		this.doneFlag = doneFlag;
	}

	public void setDoneFlag(
		UnsafeSupplier<Boolean, Exception> doneFlagUnsafeSupplier) {

		try {
			doneFlag = doneFlagUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean doneFlag;

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void setDueDate(
		UnsafeSupplier<Date, Exception> dueDateUnsafeSupplier) {

		try {
			dueDate = dueDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dueDate;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void setGroup(
		UnsafeSupplier<String, Exception> groupUnsafeSupplier) {

		try {
			group = groupUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String group;

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setMemo(UnsafeSupplier<String, Exception> memoUnsafeSupplier) {
		try {
			memo = memoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String memo;

	public Number getProgress() {
		return progress;
	}

	public void setProgress(Number progress) {
		this.progress = progress;
	}

	public void setProgress(
		UnsafeSupplier<Number, Exception> progressUnsafeSupplier) {

		try {
			progress = progressUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Number progress;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitle(
		UnsafeSupplier<String, Exception> titleUnsafeSupplier) {

		try {
			title = titleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String title;

	public String getTodoItemId() {
		return todoItemId;
	}

	public void setTodoItemId(String todoItemId) {
		this.todoItemId = todoItemId;
	}

	public void setTodoItemId(
		UnsafeSupplier<String, Exception> todoItemIdUnsafeSupplier) {

		try {
			todoItemId = todoItemIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String todoItemId;

	@Override
	public TodoItemModel clone() throws CloneNotSupportedException {
		return (TodoItemModel)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TodoItemModel)) {
			return false;
		}

		TodoItemModel todoItemModel = (TodoItemModel)object;

		return Objects.equals(toString(), todoItemModel.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return TodoItemModelSerDes.toJSON(this);
	}

}