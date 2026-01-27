Feature: User Content Feature

  Background:
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user

  Scenario: Verify free content which are skipped by user from banner
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch user's en-countered content for "banner_view_content" with params
      | filter_freeContent    | filter_type                                                   |
      | all, freeFirstEpisode | tvshow, movie, sports, video, trailer, program, livetvchannel |
    Then Verify only free content which are skipped by user from banner should be visible

  Scenario: Verify all content which are skipped by user from banner
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch user's en-countered content for "banner_view_content" with params
      | filter_type                                                   |
      | tvshow, movie, sports, video, trailer, program, livetvchannel |
    Then Verify only content which are skipped by user from banner should be visible

  Scenario: Verify score of the content should be in 2^n where n is the count of skip
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch user's en-countered content for "banner_view_content" with params
      | filter_type                                                   |
      | tvshow, movie, sports, video, trailer, program, livetvchannel |
    Then Verify the score and count of the content which are skipped by user

  Scenario: Verify content which are selected by user during onboarding
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch user's en-countered content for "onboarding" with params
      | filter_type                                                   |
      | tvshow, movie, sports, video, trailer, program, livetvchannel |
    Then Verify only content which are selected by user during onboarding

  Scenario: Verify content which are clicked by User in last 2 sessions
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch user's en-countered content for "content_clicked" with params
      | filter_type                                                   |
      | tvshow, movie, sports, video, trailer, program, livetvchannel |
    Then Verify content which are clicked by User in last 2 sessions

  Scenario: Verify content which are clicked by User in last 5 sessions
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And Fetch user's en-countered content for "content_clicked" with params
      | filter_type                                                   | considerAllSession |
      | tvshow, movie, sports, video, trailer, program, livetvchannel | true               |
    Then Verify content which are clicked by User in last 5 sessions