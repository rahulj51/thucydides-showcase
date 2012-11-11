In order to view the details of a movie, I should be able to search for a title from home page

Scenario: Searching by movie title

Given The user wants to search for a movie
When she searches for a movie called <name>
Then she sees a page that lists the movie <name> under Exact match

Examples:
|name|
|The Hangover|
