create index IX_FA06ED0 on TodoList_TodoItem (groupId);
create index IX_D9E1CEAE on TodoList_TodoItem (title[$COLUMN_LENGTH:75$]);
create index IX_ABFF928E on TodoList_TodoItem (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_39C76490 on TodoList_TodoItem (uuid_[$COLUMN_LENGTH:75$], groupId);