package serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import serenity.pages.EmagPage;
import serenity.pages.EmagPageItem;

import static junit.framework.TestCase.assertTrue;

public class EmagSteps {

    EmagPage emagPage;
    EmagPageItem emagPageItem;

    @Step
    public void enters(String keyword) {
        emagPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        emagPage.lookup_terms();
    }

    @Step
    public void should_see_title(String title) {
        assertTrue(emagPage.getTitleSearch().contains(title));
        //assertThat(emagPage.getTitleSearch(), hasItem(containsString(title)));
    }

    @Step
    public void should_see_title_error(String title){
        assertTrue(emagPage.getTitleSearchError().contains("0 rezultate pentru: \"" + title + "\"" ));
    }

    @Step
    public void is_the_home_page() {
        emagPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    @Step
    public void enters_keyword(String keyword) {emagPageItem.enter_keywords(keyword);}

    @Step
    public void starts_filter() {emagPageItem.lookup_terms();}

    @Step
    public void is_the_item_page() {
        emagPageItem.open();
    }

    @Step
    public void looks_for_comment_filter(String name){
        enters_keyword(name);
        starts_filter();
    }

    @Step
    public void should_see_comments_filter(String keyword) {
        assertTrue(emagPageItem.getFilterSearch().contains(keyword));
        //assertThat(emagPage.getTitleSearch(), hasItem(containsString(title)));
    }

    @Step
    public void should_see_comments_filter_error(String keyword){
        assertTrue(emagPageItem.getFilterSearchError().contains("0 rezultate..." ));
    }

}
