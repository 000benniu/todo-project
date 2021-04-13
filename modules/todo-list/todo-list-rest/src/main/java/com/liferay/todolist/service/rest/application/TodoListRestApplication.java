package com.liferay.todolist.service.rest.application;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.todolist.model.TodoItem;
import com.liferay.todolist.service.TodoItemLocalService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author ben
 */
@Component(
	immediate = true,
	property = {
		"liferay.auth.verifier=false",
		"liferay.oauth2=false",
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/greetings",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest"
	},
	service = Application.class
)
public class TodoListRestApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Path("/todolist")
	@Produces("text/plain")
	public String getTodoList() {
		String result = "";
		
		Company company;
		try {
			company = _companyService.getCompanyById(PortalUtil.getDefaultCompanyId());
			
			System.out.println("got company :" + company.getCompanyId());
			List<Group> groups = _groupLocalService.getGroups(company.getCompanyId(), 0, true);
			System.out.println("after groups...");
			
			List<TodoItem> todolist = new ArrayList<TodoItem>();
			for(Group group : groups) {
				System.out.println("got group :" + group.getGroupId());
				todolist.addAll(_todoItemLocalService.getTodoItemsByGroupId(group.getGroupId()));
			}
			
			return JSONFactoryUtil.serialize(todolist);
			
		} catch (PortalException e) {
			
			result += "erors:" + e.getMessage() ;
			e.printStackTrace();
		} catch (Exception e){
			result += "E erors:" + e.getMessage() ;
			e.printStackTrace();
		}
		return result;
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(
		@PathParam("name") String name,
		@QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}

	@Reference
	private CompanyService _companyService;
	@Reference
	private GroupLocalService _groupLocalService;
	
	@Reference
	private TodoItemLocalService _todoItemLocalService;

}