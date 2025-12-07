Feature: Xstream Watch History

  Scenario: Verify xstream watch history
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch user's "STREAM_BASED" watch history
      | dayFrom | dayTo | filter_type    | reduceToParent |
      | 0       | 90    | tvshow, movie | true           |
    Then Verify


  Scenario: Verify user watch list
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch user's "WATCH_LIST" using watch history api
    Then Verify
