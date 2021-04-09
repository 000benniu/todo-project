<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay"%>
<%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector"%>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend"%>

<%@ page import="com.liferay.todolist.model.TodoItem"%>
<%@ page import="com.liferay.todolist.web.constants.MVCCommandNames"%>

<%@ page import="java.util.Date"%>
<%@ page import="javax.portlet.WindowState"%>


<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />
<liferay-frontend:defineObjects />

