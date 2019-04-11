package PageObjectsExternalFile;

import com.google.common.base.Preconditions;
import org.openqa.selenium.By;
import org.json.simple.JSONObject;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.pagefactory.AbstractAnnotations;
import org.openqa.selenium.support.pagefactory.Annotations;

import java.lang.reflect.Field;

class SearchWithAnnotations extends AbstractAnnotations {
    private final Field field;
    private Parser parse = new Parser();

    SearchWithAnnotations(Field field) {
        this.field = field;
    }

    @Override
    public By buildBy() throws IllegalArgumentException {
        SearchWith search = field.getAnnotation(SearchWith.class);

        if (search != null) {
            String pageName = search.page();
            Preconditions.checkArgument(isNotNullAndEmpty(pageName), "Page name is missing.");

            String elementName = search.name();
            Preconditions.checkArgument(isNotNullAndEmpty(elementName), "Element name is not found.");

            //String locatorsFile = search.locatorsFile();
            //Preconditions.checkArgument(isNotNullAndEmpty(locatorsFile), "Locators file name not provided");

            //return SearchWithProvider.getProvider(locatorsFile).getLocator(pageName, elementName);
            return getElementTypeAndValue(pageName, elementName);
        } else {
            return new Annotations(field).buildBy();
        }
    }

    @Override
    public boolean isLookupCached() {
        return (field.getAnnotation(CacheLookup.class) != null);
    }

    private boolean isNotNullAndEmpty(String arg) {
        return ((arg != null) && (!arg.trim().isEmpty()));
    }

    public By getElementTypeAndValue(String pageInbound, String nameInbound)
    {
        return parse.getElementTypeAndValue(pageInbound, nameInbound);
    }

    private class Parser  {
        public String getElementValue(String page, String searchData) {

            JSONObject jsonObject = (JSONObject) Base.locatorsFile;
            JSONObject pagina = (JSONObject) jsonObject.get(page.toLowerCase());
            JSONObject item = (JSONObject) pagina.get("data");

            return (String) item.get(searchData.toLowerCase());
        }

        public By getElementTypeAndValue(String pageInbound, String nameInbound) {

            JSONObject jsonObject = (JSONObject) Base.locatorsFile;
            JSONObject page = (JSONObject) jsonObject.get(pageInbound.toLowerCase());
            JSONObject name = (JSONObject) page.get(nameInbound);

            String type = (String) name.get("type");
            String value = (String) name.get("value");

            if ("class".equals(type))
            {
                return By.className(value);
            }

            if ("xpath".equals(type))
            {
                return By.xpath(value);
            }

            if ("css".equals(type))
            {
                return By.cssSelector(value);
            }

            if ("name".equals(type))
            {
                return By.name(value);
            }

            if ("id".equals(type))
            {
                return By.id(value);
            }

            if ("tag".equals(type))
            {
                return By.tagName(value);
            }

            if ("linktext".equals(type))
            {
                return By.partialLinkText(value);
            }

            return By.id("");

        }

    }
}
