<%@ include file="/init.jsp"%>

 <div class="container-fluid-1280">
     <h1>${todoItem.getTitle()}</h1>
     <hr>

     <h2><liferay-ui:message key="todoItem-information" /></h2>
     <div class="todoItem-metadata">
         <dl>
            <dt><liferay-ui:message key="doneFlag" /></dt>
            <dd>${todoItem.getDoneFlag()}</dd>

             <dt><liferay-ui:message key="description" /></dt>
             <dd>${todoItem.getDescription(locale)}</dd>

             <dt><liferay-ui:message key="progress" /></dt>
             <dd>${todoItem.getProgressBar()}</dd>

             <dt><liferay-ui:message key="duedate" /></dt>
             <dd>${dueDate}</dd>
             
             <dt><liferay-ui:message key="created" /></dt>
             <dd>${createDate}</dd>
             <dt><liferay-ui:message key="created-by" /></dt>
             <dd>${todoItem.userName}</dd>
         </dl>
     </div>
 </div>