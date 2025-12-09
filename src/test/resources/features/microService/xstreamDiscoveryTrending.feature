Feature: Xstream Discovery Trending

  Scenario: Verify xstream top content
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch top trending content for "IPTV_TRENDING_PROGRAM" with params
      | dayFrom | dayTo | filter_type    | reduceToParent |
      | 0       | 90    | tvshow, movie | true           |
    Then Verify

  Scenario: Verify xstream top content for
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch top trending content for "IPTV_TRENDING_PROGRAM"
    Then Verify