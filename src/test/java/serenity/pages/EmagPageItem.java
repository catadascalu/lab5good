package serenity.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.emag.ro/apple-watch-3-gps-carcasa-silver-aluminium-42mm-white-sport-band-mtf22mp-a/pd/D1M1XVBBM/")
public class EmagPageItem extends PageObject {

    @FindBy(className = "js-reviews-search")
    private WebElementFacade searchTerms;

    @FindBy(className = "search-btn-submit")
    private WebElementFacade lookupButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public String getFilterSearch() {
        WebElementFacade titlePhrasing = find(By.className("search-reviews-results"));
        return titlePhrasing.getText();
    }

    public String getFilterSearchError() {
        WebElementFacade result = find(By.className("reviews-no-results"));
        return result.getText();
    }

}
