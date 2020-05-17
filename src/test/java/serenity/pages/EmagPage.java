package serenity.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.emag.ro/#opensearch")
public class EmagPage extends PageObject {

    @FindBy(name = "query")
    private WebElementFacade searchTerms;

    @FindBy(className = "searchbox-submit-button")
    private WebElementFacade lookupButton;

    public void enter_keywords(String keywords) {
        searchTerms.type(keywords);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public String getTitleSearch() {
        WebElementFacade titlePhrasing = find(By.className("listing-page-title"));
        return titlePhrasing.getText();
    }

    public String getTitleSearchError() {
        WebElementFacade titlePhrasing = find(By.className("listing-grid-title"));
        return titlePhrasing.getText();
    }
}
