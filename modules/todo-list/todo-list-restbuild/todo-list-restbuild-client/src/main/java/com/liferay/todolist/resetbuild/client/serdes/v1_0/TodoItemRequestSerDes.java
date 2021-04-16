package com.liferay.todolist.resetbuild.client.serdes.v1_0;

import com.liferay.todolist.resetbuild.client.dto.v1_0.TodoItemRequest;
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
public class TodoItemRequestSerDes {

	public static TodoItemRequest toDTO(String json) {
		TodoItemRequestJSONParser todoItemRequestJSONParser =
			new TodoItemRequestJSONParser();

		return todoItemRequestJSONParser.parseToDTO(json);
	}

	public static TodoItemRequest[] toDTOs(String json) {
		TodoItemRequestJSONParser todoItemRequestJSONParser =
			new TodoItemRequestJSONParser();

		return todoItemRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(TodoItemRequest todoItemRequest) {
		if (todoItemRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (todoItemRequest.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(todoItemRequest.getDescription()));

			sb.append("\"");
		}

		if (todoItemRequest.getDueDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dueDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(todoItemRequest.getDueDate()));

			sb.append("\"");
		}

		if (todoItemRequest.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(todoItemRequest.getTitle()));

			sb.append("\"");
		}

		if (todoItemRequest.getUserName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userName\": ");

			sb.append("\"");

			sb.append(_escape(todoItemRequest.getUserName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TodoItemRequestJSONParser todoItemRequestJSONParser =
			new TodoItemRequestJSONParser();

		return todoItemRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(TodoItemRequest todoItemRequest) {
		if (todoItemRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (todoItemRequest.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put(
				"description",
				String.valueOf(todoItemRequest.getDescription()));
		}

		if (todoItemRequest.getDueDate() == null) {
			map.put("dueDate", null);
		}
		else {
			map.put(
				"dueDate",
				liferayToJSONDateFormat.format(todoItemRequest.getDueDate()));
		}

		if (todoItemRequest.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(todoItemRequest.getTitle()));
		}

		if (todoItemRequest.getUserName() == null) {
			map.put("userName", null);
		}
		else {
			map.put("userName", String.valueOf(todoItemRequest.getUserName()));
		}

		return map;
	}

	public static class TodoItemRequestJSONParser
		extends BaseJSONParser<TodoItemRequest> {

		@Override
		protected TodoItemRequest createDTO() {
			return new TodoItemRequest();
		}

		@Override
		protected TodoItemRequest[] createDTOArray(int size) {
			return new TodoItemRequest[size];
		}

		@Override
		protected void setField(
			TodoItemRequest todoItemRequest, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					todoItemRequest.setDescription(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dueDate")) {
				if (jsonParserFieldValue != null) {
					todoItemRequest.setDueDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					todoItemRequest.setTitle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userName")) {
				if (jsonParserFieldValue != null) {
					todoItemRequest.setUserName((String)jsonParserFieldValue);
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