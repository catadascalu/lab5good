package serenity.features.search;


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

//import lab5project.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/EmagTestDataSearch.csv")
public class EmagSearchKeywordStoryDdt {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @ManagedPages(defaultUrl = "https://www.emag.ro/#opensearch")
    public Pages pages;

    public String name;
    public String title;

    @Qualifier
    public String getQualifier() {
        return name;
    }

    @Steps
    public EmagSteps steps;

    @Issue("#EMAG-1")
    @Test
    public void searchByKeyword() {
        steps.is_the_home_page();
        steps.looks_for(getName());
        steps.should_see_title(getTitle());
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
