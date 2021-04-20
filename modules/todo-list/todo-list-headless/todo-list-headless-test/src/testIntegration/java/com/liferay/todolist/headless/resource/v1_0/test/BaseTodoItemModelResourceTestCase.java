package com.liferay.todolist.headless.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.function.UnsafeTriConsumer;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.todolist.headless.client.dto.v1_0.TodoItemModel;
import com.liferay.todolist.headless.client.http.HttpInvoker;
import com.liferay.todolist.headless.client.pagination.Page;
import com.liferay.todolist.headless.client.pagination.Pagination;
import com.liferay.todolist.headless.client.resource.v1_0.TodoItemModelResource;
import com.liferay.todolist.headless.client.serdes.v1_0.TodoItemModelSerDes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author ben
 * @generated
 */
@Generated("")
public abstract class BaseTodoItemModelResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_todoItemModelResource.setContextCompany(testCompany);

		TodoItemModelResource.Builder builder = TodoItemModelResource.builder();

		todoItemModelResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		TodoItemModel todoItemModel1 = randomTodoItemModel();

		String json = objectMapper.writeValueAsString(todoItemModel1);

		TodoItemModel todoItemModel2 = TodoItemModelSerDes.toDTO(json);

		Assert.assertTrue(equals(todoItemModel1, todoItemModel2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		TodoItemModel todoItemModel = randomTodoItemModel();

		String json1 = objectMapper.writeValueAsString(todoItemModel);
		String json2 = TodoItemModelSerDes.toJSON(todoItemModel);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		TodoItemModel todoItemModel = randomTodoItemModel();

		todoItemModel.setArticleId(regex);
		todoItemModel.setDescription(regex);
		todoItemModel.setGroup(regex);
		todoItemModel.setMemo(regex);
		todoItemModel.setTitle(regex);
		todoItemModel.setTodoItemId(regex);

		String json = TodoItemModelSerDes.toJSON(todoItemModel);

		Assert.assertFalse(json.contains(regex));

		todoItemModel = TodoItemModelSerDes.toDTO(json);

		Assert.assertEquals(regex, todoItemModel.getArticleId());
		Assert.assertEquals(regex, todoItemModel.getDescription());
		Assert.assertEquals(regex, todoItemModel.getGroup());
		Assert.assertEquals(regex, todoItemModel.getMemo());
		Assert.assertEquals(regex, todoItemModel.getTitle());
		Assert.assertEquals(regex, todoItemModel.getTodoItemId());
	}

	@Test
	public void testGetTodoItemModelsPage() throws Exception {
		Page<TodoItemModel> page = todoItemModelResource.getTodoItemModelsPage(
			RandomTestUtil.randomString(), null, Pagination.of(1, 2), null);

		Assert.assertEquals(0, page.getTotalCount());

		TodoItemModel todoItemModel1 =
			testGetTodoItemModelsPage_addTodoItemModel(randomTodoItemModel());

		TodoItemModel todoItemModel2 =
			testGetTodoItemModelsPage_addTodoItemModel(randomTodoItemModel());

		page = todoItemModelResource.getTodoItemModelsPage(
			null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(todoItemModel1, todoItemModel2),
			(List<TodoItemModel>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetTodoItemModelsPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		TodoItemModel todoItemModel1 = randomTodoItemModel();

		todoItemModel1 = testGetTodoItemModelsPage_addTodoItemModel(
			todoItemModel1);

		for (EntityField entityField : entityFields) {
			Page<TodoItemModel> page =
				todoItemModelResource.getTodoItemModelsPage(
					null,
					getFilterString(entityField, "between", todoItemModel1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(todoItemModel1),
				(List<TodoItemModel>)page.getItems());
		}
	}

	@Test
	public void testGetTodoItemModelsPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		TodoItemModel todoItemModel1 =
			testGetTodoItemModelsPage_addTodoItemModel(randomTodoItemModel());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		TodoItemModel todoItemModel2 =
			testGetTodoItemModelsPage_addTodoItemModel(randomTodoItemModel());

		for (EntityField entityField : entityFields) {
			Page<TodoItemModel> page =
				todoItemModelResource.getTodoItemModelsPage(
					null, getFilterString(entityField, "eq", todoItemModel1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(todoItemModel1),
				(List<TodoItemModel>)page.getItems());
		}
	}

	@Test
	public void testGetTodoItemModelsPageWithPagination() throws Exception {
		TodoItemModel todoItemModel1 =
			testGetTodoItemModelsPage_addTodoItemModel(randomTodoItemModel());

		TodoItemModel todoItemModel2 =
			testGetTodoItemModelsPage_addTodoItemModel(randomTodoItemModel());

		TodoItemModel todoItemModel3 =
			testGetTodoItemModelsPage_addTodoItemModel(randomTodoItemModel());

		Page<TodoItemModel> page1 = todoItemModelResource.getTodoItemModelsPage(
			null, null, Pagination.of(1, 2), null);

		List<TodoItemModel> todoItemModels1 =
			(List<TodoItemModel>)page1.getItems();

		Assert.assertEquals(
			todoItemModels1.toString(), 2, todoItemModels1.size());

		Page<TodoItemModel> page2 = todoItemModelResource.getTodoItemModelsPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<TodoItemModel> todoItemModels2 =
			(List<TodoItemModel>)page2.getItems();

		Assert.assertEquals(
			todoItemModels2.toString(), 1, todoItemModels2.size());

		Page<TodoItemModel> page3 = todoItemModelResource.getTodoItemModelsPage(
			null, null, Pagination.of(1, 3), null);

		assertEqualsIgnoringOrder(
			Arrays.asList(todoItemModel1, todoItemModel2, todoItemModel3),
			(List<TodoItemModel>)page3.getItems());
	}

	@Test
	public void testGetTodoItemModelsPageWithSortDateTime() throws Exception {
		testGetTodoItemModelsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, todoItemModel1, todoItemModel2) -> {
				BeanUtils.setProperty(
					todoItemModel1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetTodoItemModelsPageWithSortInteger() throws Exception {
		testGetTodoItemModelsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, todoItemModel1, todoItemModel2) -> {
				BeanUtils.setProperty(todoItemModel1, entityField.getName(), 0);
				BeanUtils.setProperty(todoItemModel2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetTodoItemModelsPageWithSortString() throws Exception {
		testGetTodoItemModelsPageWithSort(
			EntityField.Type.STRING,
			(entityField, todoItemModel1, todoItemModel2) -> {
				Class<?> clazz = todoItemModel1.getClass();

				String entityFieldName = entityField.getName();

				Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						todoItemModel1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						todoItemModel2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						todoItemModel1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						todoItemModel2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						todoItemModel1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						todoItemModel2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetTodoItemModelsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer
				<EntityField, TodoItemModel, TodoItemModel, Exception>
					unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		TodoItemModel todoItemModel1 = randomTodoItemModel();
		TodoItemModel todoItemModel2 = randomTodoItemModel();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(
				entityField, todoItemModel1, todoItemModel2);
		}

		todoItemModel1 = testGetTodoItemModelsPage_addTodoItemModel(
			todoItemModel1);

		todoItemModel2 = testGetTodoItemModelsPage_addTodoItemModel(
			todoItemModel2);

		for (EntityField entityField : entityFields) {
			Page<TodoItemModel> ascPage =
				todoItemModelResource.getTodoItemModelsPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(todoItemModel1, todoItemModel2),
				(List<TodoItemModel>)ascPage.getItems());

			Page<TodoItemModel> descPage =
				todoItemModelResource.getTodoItemModelsPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(todoItemModel2, todoItemModel1),
				(List<TodoItemModel>)descPage.getItems());
		}
	}

	protected TodoItemModel testGetTodoItemModelsPage_addTodoItemModel(
			TodoItemModel todoItemModel)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetTodoItemModelsPage() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testPostTodoItemModel() throws Exception {
		TodoItemModel randomTodoItemModel = randomTodoItemModel();

		TodoItemModel postTodoItemModel =
			testPostTodoItemModel_addTodoItemModel(randomTodoItemModel);

		assertEquals(randomTodoItemModel, postTodoItemModel);
		assertValid(postTodoItemModel);
	}

	protected TodoItemModel testPostTodoItemModel_addTodoItemModel(
			TodoItemModel todoItemModel)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteTodoItemModel() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteTodoItemModel() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetTodoItemModel() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetTodoItemModel() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetTodoItemModelNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPatchTodoItemModel() throws Exception {
		Assert.assertTrue(false);
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		TodoItemModel todoItemModel1, TodoItemModel todoItemModel2) {

		Assert.assertTrue(
			todoItemModel1 + " does not equal " + todoItemModel2,
			equals(todoItemModel1, todoItemModel2));
	}

	protected void assertEquals(
		List<TodoItemModel> todoItemModels1,
		List<TodoItemModel> todoItemModels2) {

		Assert.assertEquals(todoItemModels1.size(), todoItemModels2.size());

		for (int i = 0; i < todoItemModels1.size(); i++) {
			TodoItemModel todoItemModel1 = todoItemModels1.get(i);
			TodoItemModel todoItemModel2 = todoItemModels2.get(i);

			assertEquals(todoItemModel1, todoItemModel2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<TodoItemModel> todoItemModels1,
		List<TodoItemModel> todoItemModels2) {

		Assert.assertEquals(todoItemModels1.size(), todoItemModels2.size());

		for (TodoItemModel todoItemModel1 : todoItemModels1) {
			boolean contains = false;

			for (TodoItemModel todoItemModel2 : todoItemModels2) {
				if (equals(todoItemModel1, todoItemModel2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				todoItemModels2 + " does not contain " + todoItemModel1,
				contains);
		}
	}

	protected void assertValid(TodoItemModel todoItemModel) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("articleId", additionalAssertFieldName)) {
				if (todoItemModel.getArticleId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (todoItemModel.getCreator() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (todoItemModel.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("doneFlag", additionalAssertFieldName)) {
				if (todoItemModel.getDoneFlag() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dueDate", additionalAssertFieldName)) {
				if (todoItemModel.getDueDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("group", additionalAssertFieldName)) {
				if (todoItemModel.getGroup() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("memo", additionalAssertFieldName)) {
				if (todoItemModel.getMemo() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("progress", additionalAssertFieldName)) {
				if (todoItemModel.getProgress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (todoItemModel.getTitle() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("todoItemId", additionalAssertFieldName)) {
				if (todoItemModel.getTodoItemId() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<TodoItemModel> page) {
		boolean valid = false;

		java.util.Collection<TodoItemModel> todoItemModels = page.getItems();

		int size = todoItemModels.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field :
				ReflectionUtil.getDeclaredFields(
					com.liferay.todolist.headless.dto.v1_0.TodoItemModel.
						class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					ReflectionUtil.getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		TodoItemModel todoItemModel1, TodoItemModel todoItemModel2) {

		if (todoItemModel1 == todoItemModel2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("articleId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						todoItemModel1.getArticleId(),
						todoItemModel2.getArticleId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						todoItemModel1.getCreator(),
						todoItemModel2.getCreator())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						todoItemModel1.getDescription(),
						todoItemModel2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("doneFlag", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						todoItemModel1.getDoneFlag(),
						todoItemModel2.getDoneFlag())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dueDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						todoItemModel1.getDueDate(),
						todoItemModel2.getDueDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("group", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						todoItemModel1.getGroup(), todoItemModel2.getGroup())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("memo", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						todoItemModel1.getMemo(), todoItemModel2.getMemo())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("progress", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						todoItemModel1.getProgress(),
						todoItemModel2.getProgress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						todoItemModel1.getTitle(), todoItemModel2.getTitle())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("todoItemId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						todoItemModel1.getTodoItemId(),
						todoItemModel2.getTodoItemId())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_todoItemModelResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_todoItemModelResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, TodoItemModel todoItemModel) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("articleId")) {
			sb.append("'");
			sb.append(String.valueOf(todoItemModel.getArticleId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("creator")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(todoItemModel.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("doneFlag")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("dueDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(todoItemModel.getDueDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(todoItemModel.getDueDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(todoItemModel.getDueDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("group")) {
			sb.append("'");
			sb.append(String.valueOf(todoItemModel.getGroup()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("memo")) {
			sb.append("'");
			sb.append(String.valueOf(todoItemModel.getMemo()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("progress")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("title")) {
			sb.append("'");
			sb.append(String.valueOf(todoItemModel.getTitle()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("todoItemId")) {
			sb.append("'");
			sb.append(String.valueOf(todoItemModel.getTodoItemId()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected TodoItemModel randomTodoItemModel() throws Exception {
		return new TodoItemModel() {
			{
				articleId = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				doneFlag = RandomTestUtil.randomBoolean();
				dueDate = RandomTestUtil.nextDate();
				group = StringUtil.toLowerCase(RandomTestUtil.randomString());
				memo = StringUtil.toLowerCase(RandomTestUtil.randomString());
				title = StringUtil.toLowerCase(RandomTestUtil.randomString());
				todoItemId = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
			}
		};
	}

	protected TodoItemModel randomIrrelevantTodoItemModel() throws Exception {
		TodoItemModel randomIrrelevantTodoItemModel = randomTodoItemModel();

		return randomIrrelevantTodoItemModel;
	}

	protected TodoItemModel randomPatchTodoItemModel() throws Exception {
		return randomTodoItemModel();
	}

	protected TodoItemModelResource todoItemModelResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(":");
					sb.append(entry.getValue());
					sb.append(",");
				}

				sb.setLength(sb.length() - 1);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(",");
				}

				sb.setLength(sb.length() - 1);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseTodoItemModelResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.todolist.headless.resource.v1_0.TodoItemModelResource
		_todoItemModelResource;

}