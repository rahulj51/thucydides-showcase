package com.helene.app.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created with IntelliJ IDEA.
 * User: rahuljai
 * Date: 11/11/12
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchByNameSteps {

    @Steps
    UserSearchSteps userSteps;


    @Given("The user wants to search for a movie")
    public void home_page() {
        userSteps.is_the_home_page();
    }


    @When("she searches for a movie called <name>")
    public void search_movie(String name) {
        userSteps.looks_for(name);
    }

    @Then("she sees a page that lists the movie <name> under Exact match")
    public void movie_is_enlisted_in_search_result(String name) {
        userSteps.should_see_definition_containing_words(name);
    }


}
