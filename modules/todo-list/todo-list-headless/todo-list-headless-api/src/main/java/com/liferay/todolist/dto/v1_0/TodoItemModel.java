package com.liferay.todolist.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ben
 * @generated
 */
@Generated("")
@GraphQLName("TodoItemModel")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "TodoItemModel")
public class TodoItemModel implements Serializable {

	public static TodoItemModel toDTO(String json) {
		return ObjectMapperUtil.readValue(TodoItemModel.class, json);
	}

	@Schema(
		description = "A journal articleId if there is a web content article for this todoItem."
	)
	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	@JsonIgnore
	public void setArticleId(
		UnsafeSupplier<String, Exception> articleIdUnsafeSupplier) {

		try {
			articleId = articleIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "A journal articleId if there is a web content article for this todoItem."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String articleId;

	@Schema
	@Valid
	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	@JsonIgnore
	public void setCreator(
		UnsafeSupplier<Creator, Exception> creatorUnsafeSupplier) {

		try {
			creator = creatorUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Creator creator;

	@Schema(description = "The description of the todoItem.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The description of the todoItem.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String description;

	@Schema(description = "Todo Item finished flag.")
	public Boolean getDoneFlag() {
		return doneFlag;
	}

	public void setDoneFlag(Boolean doneFlag) {
		this.doneFlag = doneFlag;
	}

	@JsonIgnore
	public void setDoneFlag(
		UnsafeSupplier<Boolean, Exception> doneFlagUnsafeSupplier) {

		try {
			doneFlag = doneFlagUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Todo Item finished flag.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Boolean doneFlag;

	@Schema(description = "Todo Item finished diedline date.")
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@JsonIgnore
	public void setDueDate(
		UnsafeSupplier<Date, Exception> dueDateUnsafeSupplier) {

		try {
			dueDate = dueDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Todo Item finished diedline date.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date dueDate;

	@Schema(description = "The group the todoItem belongs to.")
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@JsonIgnore
	public void setGroup(
		UnsafeSupplier<String, Exception> groupUnsafeSupplier) {

		try {
			group = groupUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The group the todoItem belongs to.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String group;

	@Schema(description = "Todo Item addtional memo.")
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@JsonIgnore
	public void setMemo(UnsafeSupplier<String, Exception> memoUnsafeSupplier) {
		try {
			memo = memoUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Todo Item addtional memo.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String memo;

	@Schema(description = "Percentage of the progress.")
	@Valid
	public Number getProgress() {
		return progress;
	}

	public void setProgress(Number progress) {
		this.progress = progress;
	}

	@JsonIgnore
	public void setProgress(
		UnsafeSupplier<Number, Exception> progressUnsafeSupplier) {

		try {
			progress = progressUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Percentage of the progress.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Number progress;

	@Schema(description = "The todoItem title.")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnore
	public void setTitle(
		UnsafeSupplier<String, Exception> titleUnsafeSupplier) {

		try {
			title = titleUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The todoItem title.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String title;

	@Schema(description = "The todoItem internal ID.")
	public String getTodoItemId() {
		return todoItemId;
	}

	public void setTodoItemId(String todoItemId) {
		this.todoItemId = todoItemId;
	}

	@JsonIgnore
	public void setTodoItemId(
		UnsafeSupplier<String, Exception> todoItemIdUnsafeSupplier) {

		try {
			todoItemId = todoItemIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The todoItem internal ID.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String todoItemId;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (articleId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"articleId\": ");

			sb.append("\"");

			sb.append(_escape(articleId));

			sb.append("\"");
		}

		if (creator != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creator\": ");

			sb.append(String.valueOf(creator));
		}

		if (description != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(description));

			sb.append("\"");
		}

		if (doneFlag != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"doneFlag\": ");

			sb.append(doneFlag);
		}

		if (dueDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dueDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dueDate));

			sb.append("\"");
		}

		if (group != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"group\": ");

			sb.append("\"");

			sb.append(_escape(group));

			sb.append("\"");
		}

		if (memo != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memo\": ");

			sb.append("\"");

			sb.append(_escape(memo));

			sb.append("\"");
		}

		if (progress != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"progress\": ");

			sb.append(progress);
		}

		if (title != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(title));

			sb.append("\"");
		}

		if (todoItemId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"todoItemId\": ");

			sb.append("\"");

			sb.append(_escape(todoItemId));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		defaultValue = "com.liferay.todolist.dto.v1_0.TodoItemModel",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(value);
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}