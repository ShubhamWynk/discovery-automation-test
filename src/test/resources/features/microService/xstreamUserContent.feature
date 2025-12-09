Feature: User Content Feature

#  Scenario: Verify content which are skipped by user in last five session.
#    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
#    And Fetch content from arsenal collection "axaut_goxe32721718098299613"
#    Then Verify the count of the content is unique session
#
#  Scenario: Verify content which are skipped by user in last five session.
#    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
#    And Fetch content from arsenal collection "axaut_goxe32721718098299613"
#    Then Verify the count of the content is unique session


  Scenario: Verify xstream User content
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch user's en-countered content for "HOMEPAGE_TOP_MOVIE" with params
      | dayFrom | dayTo | filter_type    | reduceToParent |
      | 0       | 90    | tvshow, movie | true           |
    Then Verify

  Scenario: Verify xstream User content for
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch user's en-countered content for "HOMEPAGE_TOP_MOVIE"
    Then Verify