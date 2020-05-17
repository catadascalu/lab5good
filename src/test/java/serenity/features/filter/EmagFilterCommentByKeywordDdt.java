package serenity.features.filter;



import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenity.steps.serenity.EmagSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/EmagTestDataFilter.csv")
public class EmagFilterCommentByKeywordDdt {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://www.emag.ro/apple-watch-3-gps-carcasa-silver-aluminium-42mm-white-sport-band-mtf22mp-a/pd/D1M1XVBBM/")
    public Pages pages;

    public String name;
    public String result;

    @Qualifier
    public String getQualifier() {
        return name;
    }

    @Steps
    public EmagSteps steps;

    @Issue("#EMAG-2")
    @Test
    public void searchByKeyword() {
        steps.is_the_item_page();
        steps.looks_for_comment_filter(getName());
        steps.should_see_comments_filter(getResult());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result ) {
        this.result = result;
    }
}
