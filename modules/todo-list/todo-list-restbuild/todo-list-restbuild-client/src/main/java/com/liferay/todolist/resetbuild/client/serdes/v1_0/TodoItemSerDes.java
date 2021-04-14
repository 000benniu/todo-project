package com.liferay.todolist.resetbuild.client.serdes.v1_0;

import com.liferay.todolist.resetbuild.client.dto.v1_0.TodoItem;
import com.liferay.todolist.resetbuild.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author ben
 * @generated
 */
@Generated("")
public class TodoItemSerDes {

	public static TodoItem toDTO(String json) {
		TodoItemJSONParser todoItemJSONParser = new TodoItemJSONParser();

		return todoItemJSONParser.parseToDTO(json);
	}

	public static TodoItem[] toDTOs(String json) {
		TodoItemJSONParser todoItemJSONParser = new TodoItemJSONParser();

		return todoItemJSONParser.parseToDTOs(json);
	}

	public static String toJSON(TodoItem todoItem) {
		if (todoItem == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (todoItem.getCompanyId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"companyId\": ");

			sb.append(todoItem.getCompanyId());
		}

		if (todoItem.getCreateDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(todoItem.getCreateDate()));

			sb.append("\"");
		}

		if (todoItem.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(todoItem.getDescription()));

			sb.append("\"");
		}

		if (todoItem.getDoneFlag() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"doneFlag\": ");

			sb.append(todoItem.getDoneFlag());
		}

		if (todoItem.getDueDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dueDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(todoItem.getDueDate()));

			sb.append("\"");
		}

		if (todoItem.getGroupId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupId\": ");

			sb.append(todoItem.getGroupId());
		}

		if (todoItem.getMemo() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memo\": ");

			sb.append("\"");

			sb.append(_escape(todoItem.getMemo()));

			sb.append("\"");
		}

		if (todoItem.getProgress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"progress\": ");

			sb.append(todoItem.getProgress());
		}

		if (todoItem.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(todoItem.getTitle()));

			sb.append("\"");
		}

		if (todoItem.getTodoItemId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"todoItemId\": ");

			sb.append(todoItem.getTodoItemId());
		}

		if (todoItem.getUserName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userName\": ");

			sb.append("\"");

			sb.append(_escape(todoItem.getUserName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TodoItemJSONParser todoItemJSONParser = new TodoItemJSONParser();

		return todoItemJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(TodoItem todoItem) {
		if (todoItem == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (todoItem.getCompanyId() == null) {
			map.put("companyId", null);
		}
		else {
			map.put("companyId", String.valueOf(todoItem.getCompanyId()));
		}

		if (todoItem.getCreateDate() == null) {
			map.put("createDate", null);
		}
		else {
			map.put(
				"createDate",
				liferayToJSONDateFormat.format(todoItem.getCreateDate()));
		}

		if (todoItem.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(todoItem.getDescription()));
		}

		if (todoItem.getDoneFlag() == null) {
			map.put("doneFlag", null);
		}
		else {
			map.put("doneFlag", String.valueOf(todoItem.getDoneFlag()));
		}

		if (todoItem.getDueDate() == null) {
			map.put("dueDate", null);
		}
		else {
			map.put(
				"dueDate",
				liferayToJSONDateFormat.format(todoItem.getDueDate()));
		}

		if (todoItem.getGroupId() == null) {
			map.put("groupId", null);
		}
		else {
			map.put("groupId", String.valueOf(todoItem.getGroupId()));
		}

		if (todoItem.getMemo() == null) {
			map.put("memo", null);
		}
		else {
			map.put("memo", String.valueOf(todoItem.getMemo()));
		}

		if (todoItem.getProgress() == null) {
			map.put("progress", null);
		}
		else {
			map.put("progress", String.valueOf(todoItem.getProgress()));
		}

		if (todoItem.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(todoItem.getTitle()));
		}

		if (todoItem.getTodoItemId() == null) {
			map.put("todoItemId", null);
		}
		else {
			map.put("todoItemId", String.valueOf(todoItem.getTodoItemId()));
		}

		if (todoItem.getUserName() == null) {
			map.put("userName", null);
		}
		else {
			map.put("userName", String.valueOf(todoItem.getUserName()));
		}

		return map;
	}

	public static class TodoItemJSONParser extends BaseJSONParser<TodoItem> {

		@Override
		protected TodoItem createDTO() {
			return new TodoItem();
		}

		@Override
		protected TodoItem[] createDTOArray(int size) {
			return new TodoItem[size];
		}

		@Override
		protected void setField(
			TodoItem todoItem, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "companyId")) {
				if (jsonParserFieldValue != null) {
					todoItem.setCompanyId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createDate")) {
				if (jsonParserFieldValue != null) {
					todoItem.setCreateDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					todoItem.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "doneFlag")) {
				if (jsonParserFieldValue != null) {
					todoItem.setDoneFlag((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dueDate")) {
				if (jsonParserFieldValue != null) {
					todoItem.setDueDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "groupId")) {
				if (jsonParserFieldValue != null) {
					todoItem.setGroupId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "memo")) {
				if (jsonParserFieldValue != null) {
					todoItem.setMemo((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "progress")) {
				if (jsonParserFieldValue != null) {
					todoItem.setProgress(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					todoItem.setTitle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "todoItemId")) {
				if (jsonParserFieldValue != null) {
					todoItem.setTodoItemId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userName")) {
				if (jsonParserFieldValue != null) {
					todoItem.setUserName((String)jsonParserFieldValue);
				}
			}
			else if (jsonParserFieldName.equals("status")) {
				throw new IllegalArgumentException();
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
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

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}