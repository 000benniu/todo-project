package com.liferay.todolist.internal.search.spi.model.index.contributor;

 import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.liferay.todolist.model.TodoItem;
import com.liferay.todolist.service.TodoItemLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

 @Component(
     immediate = true, 
     property = "indexer.class.name=com.liferay.todolist.model.TodoItem", 
     service = ModelIndexerWriterContributor.class
 )
 public class TodoItemModelIndexerWriterContributor
     implements ModelIndexerWriterContributor<TodoItem> {

     @Override
     public void customize(
         BatchIndexingActionable batchIndexingActionable,
         ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

         batchIndexingActionable.setPerformActionMethod(
             (TodoItem todoItem) -> {
                 Document document =
                     modelIndexerWriterDocumentHelper.getDocument(todoItem);

                 batchIndexingActionable.addDocuments(document);
             });
     }

     @Override
     public BatchIndexingActionable getBatchIndexingActionable() {

         return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
             todoItemLocalService.getIndexableActionableDynamicQuery());
     }

     @Override
     public long getCompanyId(TodoItem todoItem) {

         return todoItem.getCompanyId();
     }

     @Reference
     protected TodoItemLocalService todoItemLocalService;

     @Reference
     protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

 }