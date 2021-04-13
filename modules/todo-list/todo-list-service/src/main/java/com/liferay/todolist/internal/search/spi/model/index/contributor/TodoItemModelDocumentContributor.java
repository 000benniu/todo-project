package com.liferay.todolist.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.liferay.todolist.model.TodoItem;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true, 
    property = "indexer.class.name=com.liferay.todolist.model.TodoItem", 
    service = ModelDocumentContributor.class
)
public class TodoItemModelDocumentContributor
    implements ModelDocumentContributor<TodoItem> {

    @Override
    public void contribute(Document document, TodoItem todoItem) {

        // Strip HTML.
        String description = HtmlUtil.extractText(todoItem.getDescription());
        document.addText(Field.DESCRIPTION, description);

        String title = HtmlUtil.extractText(todoItem.getTitle());
        document.addText(Field.TITLE, title);

        document.addDate(Field.MODIFIED_DATE, todoItem.getModifiedDate());

        // Handle localized fields.
        for (Locale locale : LanguageUtil.getAvailableLocales(
            todoItem.getGroupId())) {

            String languageId = LocaleUtil.toLanguageId(locale);

            document.addText(
                LocalizationUtil.getLocalizedName(
                    Field.DESCRIPTION, languageId),
                description);
            document.addText(
                LocalizationUtil.getLocalizedName(Field.TITLE, languageId),
                title);
        }
    }
}
