package com.liferay.todolist.headless.client.serdes.v1_0;

import com.liferay.todolist.headless.client.dto.v1_0.TodoItemModel;
import com.liferay.todolist.headless.client.json.BaseJSONParser;

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
public class TodoItemModelSerDes {

	public static TodoItemModel toDTO(String json) {
		TodoItemModelJSONParser todoItemModelJSONParser =
			new TodoItemModelJSONParser();

		return todoItemModelJSONParser.parseToDTO(json);
	}

	public static TodoItemModel[] toDTOs(String json) {
		TodoItemModelJSONParser todoItemModelJSONParser =
			new TodoItemModelJSONParser();

		return todoItemModelJSONParser.parseToDTOs(json);
	}

	public static String toJSON(TodoItemModel todoItemModel) {
		if (todoItemModel == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (todoItemModel.getArticleId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"articleId\": ");

			sb.append("\"");

			sb.append(_escape(todoItemModel.getArticleId()));

			sb.append("\"");
		}

		if (todoItemModel.getCreator() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creator\": ");

			sb.append(String.valueOf(todoItemModel.getCreator()));
		}

		if (todoItemModel.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(todoItemModel.getDescription()));

			sb.append("\"");
		}

		if (todoItemModel.getDoneFlag() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"doneFlag\": ");

			sb.append(todoItemModel.getDoneFlag());
		}

		if (todoItemModel.getDueDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dueDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(todoItemModel.getDueDate()));

			sb.append("\"");
		}

		if (todoItemModel.getGroup() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"group\": ");

			sb.append("\"");

			sb.append(_escape(todoItemModel.getGroup()));

			sb.append("\"");
		}

		if (todoItemModel.getMemo() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"memo\": ");

			sb.append("\"");

			sb.append(_escape(todoItemModel.getMemo()));

			sb.append("\"");
		}

		if (todoItemModel.getProgress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"progress\": ");

			sb.append(todoItemModel.getProgress());
		}

		if (todoItemModel.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(todoItemModel.getTitle()));

			sb.append("\"");
		}

		if (todoItemModel.getTodoItemId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"todoItemId\": ");

			sb.append("\"");

			sb.append(_escape(todoItemModel.getTodoItemId()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TodoItemModelJSONParser todoItemModelJSONParser =
			new TodoItemModelJSONParser();

		return todoItemModelJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(TodoItemModel todoItemModel) {
		if (todoItemModel == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (todoItemModel.getArticleId() == null) {
			map.put("articleId", null);
		}
		else {
			map.put("articleId", String.valueOf(todoItemModel.getArticleId()));
		}

		if (todoItemModel.getCreator() == null) {
			map.put("creator", null);
		}
		else {
			map.put("creator", String.valueOf(todoItemModel.getCreator()));
		}

		if (todoItemModel.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put(
				"description", String.valueOf(todoItemModel.getDescription()));
		}

		if (todoItemModel.getDoneFlag() == null) {
			map.put("doneFlag", null);
		}
		else {
			map.put("doneFlag", String.valueOf(todoItemModel.getDoneFlag()));
		}

		if (todoItemModel.getDueDate() == null) {
			map.put("dueDate", null);
		}
		else {
			map.put(
				"dueDate",
				liferayToJSONDateFormat.format(todoItemModel.getDueDate()));
		}

		if (todoItemModel.getGroup() == null) {
			map.put("group", null);
		}
		else {
			map.put("group", String.valueOf(todoItemModel.getGroup()));
		}

		if (todoItemModel.getMemo() == null) {
			map.put("memo", null);
		}
		else {
			map.put("memo", String.valueOf(todoItemModel.getMemo()));
		}

		if (todoItemModel.getProgress() == null) {
			map.put("progress", null);
		}
		else {
			map.put("progress", String.valueOf(todoItemModel.getProgress()));
		}

		if (todoItemModel.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(todoItemModel.getTitle()));
		}

		if (todoItemModel.getTodoItemId() == null) {
			map.put("todoItemId", null);
		}
		else {
			map.put(
				"todoItemId", String.valueOf(todoItemModel.getTodoItemId()));
		}

		return map;
	}

	public static class TodoItemModelJSONParser
		extends BaseJSONParser<TodoItemModel> {

		@Override
		protected TodoItemModel createDTO() {
			return new TodoItemModel();
		}

		@Override
		protected TodoItemModel[] createDTOArray(int size) {
			return new TodoItemModel[size];
		}

		@Override
		protected void setField(
			TodoItemModel todoItemModel, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "articleId")) {
				if (jsonParserFieldValue != null) {
					todoItemModel.setArticleId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "creator")) {
				if (jsonParserFieldValue != null) {
					todoItemModel.setCreator(
						CreatorSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					todoItemModel.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "doneFlag")) {
				if (jsonParserFieldValue != null) {
					todoItemModel.setDoneFlag((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dueDate")) {
				if (jsonParserFieldValue != null) {
					todoItemModel.setDueDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "group")) {
				if (jsonParserFieldValue != null) {
					todoItemModel.setGroup((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "memo")) {
				if (jsonParserFieldValue != null) {
					todoItemModel.setMemo((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "progress")) {
				if (jsonParserFieldValue != null) {
					todoItemModel.setProgress(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					todoItemModel.setTitle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "todoItemId")) {
				if (jsonParserFieldValue != null) {
					todoItemModel.setTodoItemId((String)jsonParserFieldValue);
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