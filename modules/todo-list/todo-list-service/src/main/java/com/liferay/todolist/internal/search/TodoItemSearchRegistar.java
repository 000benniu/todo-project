package com.liferay.todolist.internal.search;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.liferay.todolist.model.TodoItem;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    service =  {TodoItemSearchRegistar.class}
)
public class TodoItemSearchRegistar {

    @Activate
    protected void activate(BundleContext bundleContext) {
    	
    	// will be called after the deploy.
    	System.out.println("Register for the class. START !!");
        _serviceRegistration = modelSearchRegistrarHelper.register(
            TodoItem.class, bundleContext,
            modelSearchDefinition -> {
                modelSearchDefinition.setDefaultSelectedFieldNames(
                    Field.ASSET_TAG_NAMES, Field.COMPANY_ID,
                    Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
                    Field.GROUP_ID, Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID,
                    Field.UID);

                modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(
                    Field.DESCRIPTION, Field.TITLE);

                modelSearchDefinition.setModelIndexWriteContributor(
                    modelIndexWriterContributor);

                modelSearchDefinition.setModelSummaryContributor(
                    modelSummaryContributor);
            });
    	System.out.println("Register for the class. DONE");
    }

    @Deactivate
    protected void deactivate() {
        _serviceRegistration.unregister();
    }

    @Reference(
        target = "(indexer.class.name=com.liferay.todolist.model.TodoItem)"
    )
    protected ModelIndexerWriterContributor<TodoItem>
        modelIndexWriterContributor;

    @Reference
    protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

    @Reference(
        target = "(indexer.class.name=com.liferay.todolist.model.TodoItem)"
    )
    protected ModelSummaryContributor modelSummaryContributor;

    private ServiceRegistration<?> _serviceRegistration;

}
