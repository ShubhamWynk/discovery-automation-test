Feature: Debug feature banner
  ->> Visual Skip 5 Sessions based
  ->> Slot based Visual Skip
  ->> Live Sports Tile on top of banner (LIVE_MATCH_OF_TOURNAMENT, LIVE_SPORT_VIDEO)
  ->> Adds Slot Machine functionality in banner
    -> Pinned Tile check - To verify pinned tile position in banner
  ->> Subscription Based reordering - To reorder contents based on user subscription type
    -> Svod 2.0 :- User Who can watch content which of external, Internal cp's with free contents
    -> XPP/Svod :- User Who can watch content which of Internal cp's and free contents
    -> Free/Avod :- User Who can watch content which are free on our platform
  ->> Erotic content filter(_adultContent) - To remove adult content from banner
  ->> UL Filter check - To remove contents not in user language from banner

  Prerequisites :-
  tlxsta_zy8n02301756717793339, tlxsta_uhir91321762325618571 - Pinned Tile 1,1 position
  tlxsta_8fw560791765539446323 - Pinned Tile 2,2 position
  tlxsta_nypz14021764847206649 - Pinned Tile 3,3 position
  - Pinned Tile 1,2 position
  - Pinned Tile 1,3 position
  - Dynamic Sports Tile 10 position
  tlxsta_225h79991767071939478, tlxsta_9kne94541757784501944 - Static Sports Tile n position

  Background:
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
    And build multiSource request in dynamic Meta
      | scoringMethod    | reducer | tileOutput |
      | collection_score | true    | true       |
    And pass params for multiSource request
      | resolverStrategy | exclude_filter_adultContent | filter_subscriptionBannerBoosting | filter_render_slot_persona_date_from | filter_render_slot_persona_date_to |
      | DAG_BASED        | true                        | XSTREAM                           | 2                                    | 16                                 |
#    And build source collection list request for multiSource
#      | collectionId                                        | operator | score | order | type              | params                                                                                                    |
#      | axaut_md2l09171655715984559-test                    | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile |
#      | axaut_4_NR_TR_new                                   | include  | 2     | 2     |                   | contentCount=25                                                                                           |
#      | axaut_bmzg38881763455717128                         | include  | 2     | 3     |                   | contentCount=10                                                                                           |
#      | axaut_ypyp18951763455274619                         | include  | 2     | 4     |                   | contentCount=10                                                                                           |
#      | axaut_7_WithinYear_Onboarded_IMDB_TMDB_Rated_recent | include  | 2     | 5     |                   | contentCount=2                                                                                            |
#      | axaut_1ozu92081759826861617                         | include  | 2     | 6     |                   | contentCount=2                                                                                            |
#      | axaut_goxe32721718098299613                         | include  | -5    | 7     |                   | retainScore=true                                                                                          |
#      | axaut_r9sp46641718018148784                         | include  | -32   | 8     |                   |                                                                                                           |
#      | axsta_1muo98031722511191136                         | exclude  | -32   | 9     |                   |                                                                                                           |
   #    When Fetch content from arsenal collection "axaut_3enf79781764666331005"


  Scenario: Verify When sports content static tile is live then live content should be visible on top if the tile is placed on the n position.
    And build source collection list request for multiSource
      | collectionId                     | operator | score | order | type              | params                                                                                                    | contents_list                                                                                                               |
      | axaut_md2l09171655715984559-test | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile | tlxsta_grhg64101726798474709:1,tlxsta_dpu533761765520157254:2,tlxsta_h5by30001765357353545:3,tlxsta_225h79991767071939478:4 |
      | axaut_4_NR_TR_new                | include  | 2     | 2     |                   | contentCount=25                                                                                           |                                                                                                                             |
    And fetch response for multiSource request
    Then Verify sports content should be visible on top of the banner
    And Verify if pinned tile is present then sports content should not take that position and should be visible on next position.

  Scenario: Verify When sports content static tile is live and one tile pinned at 1,1 then live content should be visible on top if the tile is placed on the n position.
    And build source collection list request for multiSource
      | collectionId                     | operator | score | order | type              | params                                                                                                    | contents_list                                                                                                                                              |
      | axaut_md2l09171655715984559-test | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile | tlxsta_grhg64101726798474709:1,tlxsta_dpu533761765520157254:2,tlxsta_h5by30001765357353545:3,tlxsta_225h79991767071939478:4,tlxsta_zy8n02301756717793339:5 |
      | axaut_4_NR_TR_new                | include  | 2     | 2     |                   | contentCount=25                                                                                           |                                                                                                                                                            |
    And fetch response for multiSource request
    And Verify if pinned tile is present then sports content should not take that position and should be visible on next position.

  Scenario: When there are 2 contents live on banner and no pinned tile on top then both sports content should be visible on top in dec order of score.
    And build source collection list request for multiSource
      | collectionId                     | operator | score | order | type              | params                                                                                                    | contents_list                                                                                                                                              |
      | axaut_md2l09171655715984559-test | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile | tlxsta_grhg64101726798474709:1,tlxsta_dpu533761765520157254:2,tlxsta_h5by30001765357353545:3,tlxsta_225h79991767071939478:4,tlxsta_9kne94541757784501944:5 |
      | axaut_4_NR_TR_new                | include  | 2     | 2     |                   | contentCount=25                                                                                           |                                                                                                                                                            |
    And fetch response for multiSource request
    Then Verify both sports content should be visible on top in dec order of score.

  Scenario: When there are 2 contents live on banner and 2 pinned tile on top 1 and 3 then 1 sports content should be visible on 2 and second on 4 in dec order of score.
    And build source collection list request for multiSource
      | collectionId                     | operator | score | order | type              | params                                                                                                    | contents_list                                                                                                                                                                             |
      | axaut_md2l09171655715984559-test | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile | tlxsta_grhg64101726798474709:1,tlxsta_dpu533761765520157254:2,tlxsta_nypz14021764847206649:3,tlxsta_225h79991767071939478:4,tlxsta_zy8n02301756717793339:5,tlxsta_9kne94541757784501944:6 |
      | axaut_4_NR_TR_new                | include  | 2     | 2     |                   | contentCount=25                                                                                           |                                                                                                                                                                                           |
    And fetch response for multiSource request
    Then Verify 1 sports content should be visible on 2 and second on 4 in dec order of score.

  Scenario: When there are 2 contents live on banner and 1 pinned tile on top 2nd position then 1 sports content should be visible on 1 and second on 3 in dec order of score.
    And build source collection list request for multiSource
      | collectionId                     | operator | score | order | type              | params                                                                                                    | contents_list                                                                                                                                                                             |
      | axaut_md2l09171655715984559-test | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile | tlxsta_grhg64101726798474709:1,tlxsta_dpu533761765520157254:2,tlxsta_h5by30001765357353545:3,tlxsta_225h79991767071939478:4,tlxsta_8fw560791765539446323:5,tlxsta_9kne94541757784501944:6 |
      | axaut_4_NR_TR_new                | include  | 2     | 2     |                   | contentCount=25                                                                                           |                                                                                                                                                                                           |
    And fetch response for multiSource request
    Then Verify 1 sports content should be visible on 1 and second on 3 in dec order of score.

  Scenario: When there are no contents live on banner and 2 pinned tile on top 1 and 3 but upcoming live content placed on 5 position then content should not be visible on bunner until live.
    And build source collection list request for multiSource
      | collectionId                     | operator | score | order | type              | params                                                                                                    | contents_list                                                                                                                                              |
      | axaut_md2l09171655715984559-test | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile | tlxsta_grhg64101726798474709:1,tlxsta_dpu533761765520157254:2,tlxsta_h5by30001765357353545:3,tlxsta_225h79991767071939478:4,tlxsta_zy8n02301756717793339:5 |
      | axaut_4_NR_TR_new                | include  | 2     | 2     |                   | contentCount=25                                                                                           |                                                                                                                                                            |
    And fetch response for multiSource request
    Then Verify upcoming live content should not be visible on bunner until live.

  Scenario: When user is Avod user and 2 contents are pinned 1,3 and 1 sports content then 1,3 is pinned content 2 is sports content 3 content from AVod and 1 content form (SVOD and SVOD 2.0).
    And build source collection list request for multiSource
      | collectionId                     | operator | score | order | type              | params                                                                                                    | contents_list                                                                                                                                              |
      | axaut_md2l09171655715984559-test | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile | tlxsta_grhg64101726798474709:1,tlxsta_dpu533761765520157254:2,tlxsta_h5by30001765357353545:3,tlxsta_225h79991767071939478:4,tlxsta_zy8n02301756717793339:5 |
      | axaut_4_NR_TR_new                | include  | 2     | 2     |                   | contentCount=25                                                                                           |                                                                                                                                                            |
    And fetch response for multiSource request
    Then Verify 1,3 is pinned content 2 is sports content 3 content from AVod and 1 content form (SVOD and SVOD 2.0).

  Scenario: When user is XPP/Svod 1.0 user and 2 contents are pinned 1,3 and 1 sports content then 1,3 is pinned content 2 is sports content then other 4 content from AVod + Svod (playable).
    And build source collection list request for multiSource
      | collectionId                     | operator | score | order | type              | params                                                                                                    | contents_list                                                                                                                                              |
      | axaut_md2l09171655715984559-test | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile | tlxsta_grhg64101726798474709:1,tlxsta_dpu533761765520157254:2,tlxsta_h5by30001765357353545:3,tlxsta_225h79991767071939478:4,tlxsta_zy8n02301756717793339:5 |
      | axaut_4_NR_TR_new                | include  | 2     | 2     |                   | contentCount=25                                                                                           |                                                                                                                                                            |
    And fetch response for multiSource request
    Then Verify 1,3 is pinned content 2 is sports content then other 4 content from AVod + Svod (playable).

  Scenario: When user is Svod 2.0 user and 2 contents are pinned 1,3 and 1 sports content then 1,3 is pinned and content 2 is sports content then other 3 content from Svod 2.0 and other 1 content is from (SVOD + Avod).
    And build source collection list request for multiSource
      | collectionId                     | operator | score | order | type              | params                                                                                                    | contents_list                                                                                                                                              |
      | axaut_md2l09171655715984559-test | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile | tlxsta_grhg64101726798474709:1,tlxsta_dpu533761765520157254:2,tlxsta_h5by30001765357353545:3,tlxsta_225h79991767071939478:4,tlxsta_zy8n02301756717793339:5 |
      | axaut_4_NR_TR_new                | include  | 2     | 2     |                   | contentCount=25                                                                                           |                                                                                                                                                            |
    And fetch response for multiSource request
    Then Verify 1,3 is pinned and content 2 is sports content then other 3 content from Svod 2.0 and other 1 content is from (SVOD + Avod).
#    // Subscription Based Reordering Scenarios
  Scenario: When user is Svod 2.0 user then 3 content from Svod 2.0 and 3 content form (SVOD + Avod).
    And build source collection list request for multiSource
      | collectionId                     | operator | score | order | type              | params                                                                                                    | contents_list                                                                                                                                              |
      | axaut_md2l09171655715984559-test | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile | tlxsta_grhg64101726798474709:1,tlxsta_dpu533761765520157254:2,tlxsta_h5by30001765357353545:3,tlxsta_225h79991767071939478:4,tlxsta_zy8n02301756717793339:5 |
      | axaut_4_NR_TR_new                | include  | 2     | 2     |                   | contentCount=25                                                                                           |                                                                                                                                                            |
    And fetch response for multiSource request
    Then Verify 3 content from Svod 2.0 and 3 content form (SVOD + Avod).

  Scenario: When user is XPP/Svod 1.0 user then 5 content from AVod + Svod and 1 content form (SVOD 2.0).
    And build source collection list request for multiSource
      | collectionId                     | operator | score | order | type              | params                                                                                                    | contents_list                                                                                                                                              |
      | axaut_md2l09171655715984559-test | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile | tlxsta_grhg64101726798474709:1,tlxsta_dpu533761765520157254:2,tlxsta_h5by30001765357353545:3,tlxsta_225h79991767071939478:4,tlxsta_zy8n02301756717793339:5 |
      | axaut_4_NR_TR_new                | include  | 2     | 2     |                   | contentCount=25                                                                                           |                                                                                                                                                            |
    And fetch response for multiSource request
    Then Verify 5 content from AVod + Svod and 1 content form (SVOD 2.0).

  Scenario: When user is Avod user then 3 content from AVod and 3 content form (SVOD and SVOD 2.0).
    And build source collection list request for multiSource
      | collectionId                     | operator | score | order | type              | params                                                                                                    | contents_list                                                                                                                                              |
      | axaut_md2l09171655715984559-test | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile | tlxsta_grhg64101726798474709:1,tlxsta_dpu533761765520157254:2,tlxsta_h5by30001765357353545:3,tlxsta_225h79991767071939478:4,tlxsta_zy8n02301756717793339:5 |
      | axaut_4_NR_TR_new                | include  | 2     | 2     |                   | contentCount=25                                                                                           |                                                                                                                                                            |
    And fetch response for multiSource request
    Then Verify 3 content from AVod and 3 content form (SVOD and SVOD 2.0).

#//  Erotic Content Filter Scenarios
  Scenario: No erotic content should be present in the Banner.
    Then Verify no erotic content is present in the Banner

#    // User Language Filter Scenarios
  Scenario: All content in Banner should be from User languages.
    Then Verify all content in Banner is from User languages

#  // Visual Skip Scenarios
  Scenario: Verify visual skip in hybrid banner.

  Scenario: Verify slot based visual skip in hybrid banner.

#  //Slot Machine Scenarios
  Scenario: Verify when two promoted tile is pinned on the same position then high score tile should be visible and other should be after the 7 position.
    And build source collection list request for multiSource
      | collectionId                     | operator | score | order | type              | params                                                                                                    | contents_list                                                                                                                                              |
      | axaut_md2l09171655715984559-test | include  | 4     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile | tlxsta_grhg64101726798474709:1,tlxsta_dpu533761765520157254:2,tlxsta_h5by30001765357353545:3,tlxsta_uhir91321762325618571:4,tlxsta_zy8n02301756717793339:5 |
      | axaut_4_NR_TR_new                | include  | 2     | 2     |                   | contentCount=25                                                                                           |                                                                                                                                                            |
    And fetch response for multiSource request
    Then Verify when two promoted tile is pinned on the same position then only one should be visible

    #  Scenario: Verify When sports content dynamic tile usecase LIVE_MATCH_OF_TOURNAMENT, is live then live content should be visible on top if the tile is placed on the n position.
#    Given fetch response for multiSource request
#    Then Verify source of sports content should be from LIVE_MATCH_OF_TOURNAMENT usecase
#    And Verify sports content should be visible on top of the banner
#
#  Scenario: Verify When sports content dynamic tile is live with other usecase like LIVE_MATCHES then not visible on the top.
#    Given fetch response for multiSource request
#    Then Verify tile should not be visible on top of the banner