create table TodoList_TodoItem (
	uuid_ VARCHAR(75) null,
	todoItemId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	description STRING null,
	doneFlag BOOLEAN,
	progress DOUBLE,
	dueDate DATE null,
	memo VARCHAR(75) null
);