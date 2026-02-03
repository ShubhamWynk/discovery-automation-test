Feature: Iptv Banner Tile Validation
  --> Ticket - 2684,
  --> pinned tile scenario
  --> linear
  --> ott curated

#  Background:
#    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user

  @IPTV
  Scenario: Verify When User is Linear heavy user then Content starts from Linear and Round Robin with other ott content.
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
    And build multiSource request in dynamic Meta
      | scoringMethod    | reducer | tileOutput |
      | collection_score | true    | true       |
    And pass params for multiSource request
      | resolverStrategy | filter_subscriptionBannerBoosting |
      | DAG_BASED        | IPTV                              |
    And build source collection list request for multiSource
      | collectionId                | operator | score | order | type              | params                                                                                                    |
      | axaut_q7mi56361764332668736 | include  | 5     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile |
      | axaut_bw5120301764309557417 | include  | 4     | 2     |                   |                                                                                                           |
      | axaut_ypko98701768385515656 | include  | 4     | 3     | upsell_collection |                                                                                                           |
    And post process request with
      | enableDeduplication | deduplicationMethod          |
      | true                | live_channel_program_overlap |
    And fetch response for multiSource request
    Then Verify banner should be in round robin linear with ott

  @IPTV
  Scenario: Verify When User is Ott heavy user then Content starts from ott and Round Robin with Linear content.
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And build multiSource request in dynamic Meta
      | scoringMethod    | reducer | tileOutput |
      | collection_score | true    | true       |
    And pass params for multiSource request
      | resolverStrategy | filter_subscriptionBannerBoosting |
      | DAG_BASED        | IPTV                              |
    And build source collection list request for multiSource
      | collectionId                | operator | score | order | type              | params                                                                                                    |
      | axaut_q7mi56361764332668736 | include  | 5     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile |
      | axaut_bw5120301764309557417 | include  | 4     | 2     |                   |                                                                                                           |
      | axaut_ypko98701768385515656 | include  | 4     | 3     | upsell_collection |                                                                                                           |
    And post process request with
      | enableDeduplication | deduplicationMethod          |
      | true                | live_channel_program_overlap |
    And fetch response for multiSource request
    Then Verify banner should be in round robin linear with ott

  @IPTV
  Scenario: Verify When User is Balanced user then Content should be in Round Robin manner with Linear.
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
    And build multiSource request in dynamic Meta
      | scoringMethod    | reducer | tileOutput |
      | collection_score | true    | true       |
    And pass params for multiSource request
      | resolverStrategy | filter_subscriptionBannerBoosting |
      | DAG_BASED        | IPTV                              |
    And build source collection list request for multiSource
      | collectionId                | operator | score | order | type              | params                                                                                                    |
      | axaut_q7mi56361764332668736 | include  | 5     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile |
      | axaut_bw5120301764309557417 | include  | 4     | 2     |                   |                                                                                                           |
      | axaut_ypko98701768385515656 | include  | 4     | 3     | upsell_collection |                                                                                                           |
    And post process request with
      | enableDeduplication | deduplicationMethod          |
      | true                | live_channel_program_overlap |
    And fetch response for multiSource request
    Then Verify banner should be in round robin linear with ott

  @IPTV
  Scenario: Verify When User is Linear heavy user then Content starts from Linear and Round Robin with other ott content and one content is pinned
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
    And build multiSource request in dynamic Meta
      | scoringMethod    | reducer | tileOutput |
      | collection_score | true    | true       |
    And pass params for multiSource request
      | resolverStrategy | filter_subscriptionBannerBoosting |
      | DAG_BASED        | IPTV                              |
    And build source collection list request for multiSource
      | collectionId                | operator | score | order | type              | params                                                                                                    |
      | axaut_q7mi56361764332668736 | include  | 5     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile |
      | axaut_c1wg57211764332837799 | include  | 5     | 2     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile |
      | axaut_bw5120301764309557417 | include  | 4     | 3     |                   |                                                                                                           |
    And post process request with
      | enableDeduplication | deduplicationMethod          |
      | true                | live_channel_program_overlap |
    And fetch response for multiSource request
    Then Verify banner should be in round robin linear with ott

  @IPTV
  Scenario: Verify When User is Ott heavy user then Content starts from ott and Round Robin with Linear content and one content is pinned
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
    And build multiSource request in dynamic Meta
      | scoringMethod    | reducer | tileOutput |
      | collection_score | true    | true       |
    And pass params for multiSource request
      | resolverStrategy | filter_subscriptionBannerBoosting |
      | DAG_BASED        | IPTV                              |
    And build source collection list request for multiSource
      | collectionId                | operator | score | order | type              | params                                                                                                    |
      | axaut_q7mi56361764332668736 | include  | 5     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile |
      | axaut_c1wg57211764332837799 | include  | 5     | 2     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile |
      | axaut_bw5120301764309557417 | include  | 4     | 3     |                   |                                                                                                           |
    And post process request with
      | enableDeduplication | deduplicationMethod          |
      | true                | live_channel_program_overlap |
    And fetch response for multiSource request
    Then Verify banner should be in round robin linear with ott

# Broadband UpSell Scenarios
  @BroadbandUpSell @IPTV
  Scenario: Verify Only unsubscribed CP should be recommended from the upsell collection.
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
    And change user Live Attributes to
      | partnerStatus                                                                                                                           |
      | appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    And build multiSource request in dynamic Meta
      | scoringMethod    | reducer | tileOutput |
      | collection_score | true    | true       |
    And pass params for multiSource request
      | resolverStrategy | filter_subscriptionBannerBoosting |
      | DAG_BASED        | IPTV                              |
    And build source collection list request for multiSource
      | collectionId                | operator | score | order | type              | params                                                                                                    |
      | axaut_q7mi56361764332668736 | include  | 5     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile |
      | axaut_6md130811764308012237 | include  | 4     | 2     |                   |                                                                                                           |
      | axaut_ypko98701768385515656 | include  | 4     | 3     | upsell_collection |                                                                                                           |
    And post process request with
      | enableDeduplication | deduplicationMethod          |
      | true                | live_channel_program_overlap |
    And fetch response for multiSource request
    Then Verify Broadband upSell tile is present on the banner
    And Verify Only unsubscribed CP is recommended from the upsell collection

  @BroadbandUpSell @IPTV
  Scenario: Verify When User is subscribed for the all the CP then Broadband upSell tile should not be present on the banner
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And change user Live Attributes to
      | partnerStatus                                                                                                                                                |
      | amazon_prime:claimed,appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    And build multiSource request in dynamic Meta
      | scoringMethod    | reducer | tileOutput |
      | collection_score | true    | true       |
    And pass params for multiSource request
      | resolverStrategy | filter_subscriptionBannerBoosting |
      | DAG_BASED        | IPTV                              |
    And build source collection list request for multiSource
      | collectionId                | operator | score | order | type              | params                                                                                                    |
      | axaut_q7mi56361764332668736 | include  | 5     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile |
      | axaut_6md130811764308012237 | include  | 4     | 2     |                   |                                                                                                           |
      | axaut_ypko98701768385515656 | include  | 4     | 3     | upsell_collection |                                                                                                           |
    And post process request with
      | enableDeduplication | deduplicationMethod          |
      | true                | live_channel_program_overlap |
    And fetch response for multiSource request
    Then Verify Broadband upSell tile is not present on the banner

  @BroadbandUpSell @IPTV
  Scenario: Verify When User is subscribed for the all the CP through broadband then Broadband upSell tile should not be present on the banner
    Given We are using "p-cWmUEqg4MGRdaJp0" as a Xstream user
    And change user Live Attributes to
      | sd                                                                         |
      | amazon_prime:6102:3,appletv:596543:3,netflix:596543:3,hotstar_dth:596543:3 |
    And build multiSource request in dynamic Meta
      | scoringMethod    | reducer | tileOutput |
      | collection_score | true    | true       |
    And pass params for multiSource request
      | resolverStrategy | filter_subscriptionBannerBoosting |
      | DAG_BASED        | IPTV                              |
    And build source collection list request for multiSource
      | collectionId                | operator | score | order | type              | params                                                                                                    |
      | axaut_q7mi56361764332668736 | include  | 5     | 1     | banner_collection | fix_on_top=priority_tile,live_sport_redirect_tile,live_sport_video&temp_on_top=sports_video,promoted_tile |
      | axaut_6md130811764308012237 | include  | 4     | 2     |                   |                                                                                                           |
      | axaut_ypko98701768385515656 | include  | 4     | 3     | upsell_collection |                                                                                                           |
    And post process request with
      | enableDeduplication | deduplicationMethod          |
      | true                | live_channel_program_overlap |
    And fetch response for multiSource request
    Then Verify Broadband upSell tile is not present on the banner

#  Scenario:

#  From Client side
#  Scenario: Verify if user has all cp subscription then upsell tile should not be shown from discovery and should be shown for broadband upsell
