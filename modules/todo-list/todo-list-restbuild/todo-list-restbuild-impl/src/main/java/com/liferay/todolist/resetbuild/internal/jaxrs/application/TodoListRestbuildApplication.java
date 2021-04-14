package com.liferay.todolist.resetbuild.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author ben
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/todo-list-restbuild",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=TodoListRestbuild"
	},
	service = Application.class
)
@Generated("")
public class TodoListRestbuildApplication extends Application {
}