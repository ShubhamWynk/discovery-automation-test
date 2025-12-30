Feature: Debug feature banner
  ->> Visual Skip
  ->> Slot based Visual Skip
  ->> Adds Slot Machine
  ->> Subscription Based reordering
  ->> Erotic content filter
  ->> UL Filter check

#  Svod 2.0 :- User Who can watch content which of external, Internal cp's with free contents
#  XPP/Svod :- User Who can watch content which of Internal cp's and free contents
# Free/Avod :- User Who can watch content which are free on our platform

  Background:
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
#    When Fetch content from arsenal collection "axaut_3enf79781764666331005"

#  Live Sports Tile Scenarios
#  1. Using LIVE_MATCH_OF_TOURNAMENT use case
#  2. Using LIVE_SPORT_VIDEO use case
  Scenario: Verify When sports content static tile is live then live content should be visible on top if the tile is placed on the n position.
    And build multiSource request in dynamic Meta
      | scoringMethod    | reducer | tileOutput |
      | collection_score | true    | true       |
    And build source collection list request for multiSource
      | collectionId                     | operator | score | order | type              | params                                                                                                    | contents                       |
      | axaut_md2l09171655715984559-test | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile | tlxsta_zy8n02301756717793339:1 |
    And fetch response for multiSource request
      | resolverStrategy | exclude_filter_adultContent |
      | DAG_BASED        | true                        |
    Then Verify sports content should be visible on top of the banner
    And Verify if pinned tile is present then sports content should not take that position and should be visible on next position.

  Scenario: Verify When sports content dynamic tile usecase LIVE_MATCH_OF_TOURNAMENT, is live then live content should be visible on top if the tile is placed on the n position.

  Scenario: Verify When sports content dynamic tile is live with other usecase LIVE_MATCHES then not visible on the top.

  Scenario: Verify When sports content tile is live and placed on the 10 position but we have one tile pinned on 1 position then sports tile should be visible on 2nd position.

  Scenario: When there are 2 contents live on banner and no pinned tile on top then both sports content should be visible on top in dec order of score.

  Scenario: When there are 2 contents live on banner and 2 pinned tile on top 1 and 3 then 1 sports content should be visible on 2 and second on 4 in dec order of score.

  Scenario: When there are 2 contents live on banner and 1 pinned tile on top 2nd position then 1 sports content should be visible on 1 and second on 3 in dec order of score.

  Scenario: When there are no contents live on banner and 2 pinned tile on top 1 and 3 but upcoming live content placed on 5 position then content should not be visible on bunner until live.

  Scenario: When user is Avod user and 2 contents are pinned 1,3 and 1 sports content then 1,3 is pinned content 2 is sports content 3 content from AVod and 1 content form (SVOD and SVOD 2.0).

  Scenario: When user is XPP/Svod 1.0 user and 2 contents are pinned 1,3 and 1 sports content then 1,3 is pinned content 2 is sports content then other 4 content from AVod + Svod (playable).

  Scenario: When user is Svod 2.0 user and 2 contents are pinned 1,3 and 1 sports content then 1,3 is pinned and content 2 is sports content then other 3 content from Svod 2.0 and other 1 content is from (SVOD + Avod).

  Scenario: When user is Svod 2.0 user then 3 content from Svod 2.0 and 3 content form (SVOD + Avod).

  Scenario: When user is XPP/Svod 1.0 user then 5 content from AVod + Svod and 1 content form (SVOD 2.0).

  Scenario: When user is Avod user then 3 content from AVod and 3 content form (SVOD and SVOD 2.0).

  Scenario: No erotic content should be present in the response.

  Scenario: All content should be from User languages.

  Scenario: Verify visual skip in hybrid banner.

  Scenario: Verify slot based visual skip in hybrid banner.
