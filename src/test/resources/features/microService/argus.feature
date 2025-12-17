Feature: Argus

  Scenario: verify argus
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch content from argus for
      | dayFrom | dayTo | filter_type   | reduceToParent |
      | 0       | 90    | tvshow, movie | true           |
    Then Verify