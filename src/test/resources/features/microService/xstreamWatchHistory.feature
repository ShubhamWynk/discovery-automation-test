Feature: Xstream Watch History

  Background:
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user

  Scenario: Verify User Watch History of Last 14 days from parent Level of 5 min stream
    And Fetch user's "STREAM_BASED" watch history
      | dayFrom | dayTo | filter_type   | reduceToParent | streamtimeFrom |
      | 0       | 14    | tvshow, movie | true           | 300            |
    Then Verify user watch history of last 14 days from parent Level of 5 min stream

  Scenario: Verify User Watch History of Last 8-90 days which is watched atleast 20 percent
    And Fetch user's "STREAM_BASED" watch history
      | dayFrom | dayTo | filter_type   | reduceToParent | completionPercentFrom |
      | 8       | 90    | tvshow, movie | true           | 20                    |
    Then Verify user watch history of last 7 days which is completed atleast 20 percent

  Scenario: Verify User Watch History of Last 7 days which is watched atleast 20 percent
    And Fetch user's "STREAM_BASED" watch history
      | dayFrom | dayTo | filter_type   | reduceToParent | completionPercentFrom |
      | 0       | 7     | tvshow, movie | true           | 20                    |
    Then Verify user watch history of last 7 days which is completed atleast 20 percent

  Scenario: Verify User Watch History (free content) to be removed from Banner
    And Fetch user's "STREAM_BASED" watch history
      | filter_freeContent    | dayTo | filter_type   | reduceToParent | completionPercentFrom |
      | all, freeFirstEpisode | 90    | tvshow, movie | true           | 1                     |
    Then Verify user watch history of last 90 days which is completed atleast 50 percent

  Scenario: Verify User Watch History of Last 90 days which is watched atleast 50 percent
    And Fetch user's "STREAM_BASED" watch history
      | dayFrom | dayTo | filter_type   | reduceToParent | completionPercentFrom |
      | 0       | 90    | tvshow, movie | true           | 50                    |
    Then Verify user watch history of last 90 days which is completed atleast 50 percent

  Scenario: Verify User Watch History of Last 3 Months At Parent Level
    And Fetch user's "STREAM_BASED" watch history
      | dayFrom | dayTo | filter_type   | reduceToParent |
      | 0       | 90    | tvshow, movie | true           |
    Then Verify user watch history of last 90 days from parent Level should be visible

  Scenario: Verify User Watch History 3 Months Before Onboarding
    And Fetch user's "STREAM_BASED" watch history
      | filter_before_onboarding | filter_type   | reduceToParent |
      | 90                       | tvshow, movie | true           |
    Then Verify user watch history of last 3 Months before Onboarding should be filter out

  Scenario: Verify User Watch History 3 Months After Onboarding
    And Fetch user's "STREAM_BASED" watch history
      | filter_after_onboarding | filter_type   | reduceToParent |
      | 90                      | tvshow, movie | true           |
    Then Verify user watch history of last 3 Months from Onboarding should be filter out

  Scenario: Verify fetch content which are watched by atleast 1%
    And Fetch user's "STREAM_BASED" watch history
      | completionPercentFrom | filter_type                  | reduceToParent |
      | 1                     | tvshow, movie, sports, video | true           |
    Then Verify user watch history which is completed by 1 percent

  Scenario: Verify User Watch History of Last 90 days which is watched 0 to 20 percent
    And Fetch user's "STREAM_BASED" watch history
      | dayFrom | dayTo | filter_type   | reduceToParent | completionPercentFrom | completionPercentTo |
      | 0       | 90    | tvshow, movie | true           | 0                     | 20                  |
    Then Verify user watch history of last 90 days from parent Level should be visible

  Scenario: Verify Contents watched on 1 to 4 day Watch History consumed 5-85%
    And Fetch user's "STREAM_BASED" watch history
      | dayFrom | dayTo | filter_type   | reduceToParent | completionPercentFrom | completionPercentTo |
      | 1       | 4     | tvshow, movie | true           | 5                     | 85                  |
    Then Verify user watch history of last 90 days from parent Level should be visible

#    axaut_zx9b89071727696934317
  Scenario: Verify User Watch History Last 7 Days 1-85 % Completed with exist in recent true and with content duration filter
    And Fetch user's "STREAM_BASED" watch history
      | dayFrom | dayTo | filter_type   | reduceToParent | completionPercentFrom | completionPercentTo | contentDurationFrom | filter_existsInRecent |
      | 0       | 7     | tvshow, movie | true           | 1                     | 85                  | 1080                | true                  |
    Then Verify user Watch History Last 7 Days 1-85 % Completed with exist in recent true and with content duration filter

  Scenario: Verify User Watch History Last 7 Days 1-85 % Completed with exist in recent true and with content duration filter with free filter
    And Fetch user's "STREAM_BASED" watch history
      | dayFrom | dayTo | filter_type   | reduceToParent | completionPercentFrom | completionPercentTo | contentDurationFrom | filter_existsInRecent | filter_freeContent |
      | 0       | 7     | tvshow, movie | true           | 1                     | 85                  | 1080                | true                  | all                |
    Then Verify user Watch History Last 7 Days 1-85 % Completed with exist in recent true and with content duration filter with free filter

# axaut_dfqw98411764296922610
  Scenario: Verify xstream linear watch history in last 30 day sorted in recency
    And Fetch user's "linear_based" watch history
      | dayFrom | dayTo | linearWatchStrategy | filter_type   | exclude_filter_allGenres |
      | 0       | 30    | LIVETVCHANNEL       | livetvchannel | infotainment             |
    Then Verify xstream linear watch history in last 30 day sorted in recency

# axaut_ob6k02611764297015773
  Scenario: Verify xstream linear watch history in last 30 day sorted in frequency
    And Fetch user's "linear_based" watch history
      | dayFrom | dayTo | linearWatchSorting | linearWatchStrategy | filter_type   | exclude_filter_allGenres |
      | 0       | 30    | FREQUENCY          | LIVETVCHANNEL       | livetvchannel | infotainment             |
    Then Verify xstream linear watch history in last 30 day sorted in frequency


  Scenario: Verify xstream watch history
    And Fetch user's "STREAM_BASED" watch history
      | dayFrom | dayTo | filter_type   | reduceToParent |
      | 0       | 90    | tvshow, movie | true           |
    Then Verify


  Scenario: Verify user watch list
#    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
#    And Fetch user's "WATCH_LIST" using watch history api
#    Then Verify
