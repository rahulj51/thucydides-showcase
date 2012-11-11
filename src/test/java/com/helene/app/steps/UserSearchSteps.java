package com.helene.app.steps;

import com.helene.app.pages.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

/**
 * Created with IntelliJ IDEA.
 * User: rahuljai
 * Date: 11/11/12
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserSearchSteps extends ScenarioSteps {

    public UserSearchSteps(Pages pages) {
        super(pages);
    }


    @Step
    public void enters(String keyword) {
        onHomePage().enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        onHomePage().lookup_terms();
    }

    private HomePage onHomePage() {
        return getPages().currentPageAt(HomePage.class);
    }

    private HomePage HomePage() {
        return getPages().currentPageAt(HomePage.class);
    }

    @Step
    public void should_see_definition_containing_words(String terms) {
        assertThat(HomePage().getExactMatches(), hasItem(containsString(terms)));
    }

    @Step
    public void is_the_home_page() {
        onHomePage().open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

}
