Feature: Xstream Top Content
  ->> UseCases: HOMEPAGE_TOP_MOVIE, HOMEPAGE_TOP_SHOW,HOMEPAGE_TOP_SHOW_WITHOUT_CITY_LANG, CP_TOP_SHOW
  HOMEPAGE_TOP_MOVIE_WITHOUT_CITY_LANG, HOMEPAGE_TOP_MOVIE_DEDUP_TEST, HOMEPAGE_TOP_MOVIE, GEC_TOP_SHOW

  Scenario: Verify xstream top content
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch user's "HOMEPAGE_TOP_MOVIE" top content from xstream-top-content with params
      | dayFrom | dayTo | filter_type    | reduceToParent |
      | 0       | 90    | tvshow, movie | true           |
    Then Verify

  Scenario: Verify xstream top content
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch user's "HOMEPAGE_TOP_MOVIE" top content from xstream-top-content
    Then Verify