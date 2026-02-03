Feature: Ziegel Service


#  Verify Title, SubTitle, deeplink, DisplayTitle
#  Title :- For Just {differenceInPrice} More
#  DisplayTitle :- Update Now
#  deeplink :- xstream://airtelxstream.com?type=BB_UPGRADE_COMPARE_SINGLE_PLAN&productOfferingId={bbRecommendedId}&sourceName=banner
#  SubTitle :- Watch Content from Amazon Prime, Netflix And Apple TV+
#  cp name in front of subtitle which is recommanded contentId and Difference of cp should be visible in subtitle

  @BroadbandUpSell @IPTV
  Scenario: Verify Broadband upSell tile should be visible for the recommended plan
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId | bbRecommendedId | _cpId        | partnerStatus                                                                                                                           |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE    | BLACK_55799     | BLACK_62372     | AMAZON_PRIME | appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as Broadband upSell tile on the banner

  @BroadbandUpSell @IPTV
  Scenario: Verify Broadband upSell tile should be visible for the recommended plan of amazon prime
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId | bbPrimeRecommendedId | _cpId        | partnerStatus                                                                                                                           |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE    | BLACK_55799     | BLACK_62372          | AMAZON_PRIME | appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as Broadband upSell tile on the banner

  @BroadbandUpSell @IPTV
  Scenario: Verify Broadband upSell tile should be visible for the recommended plan of apple tv
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId | bbAppleRecommendedId | _cpId   | partnerStatus                                                                                                           |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE    | BLACK_55799     | BLACK_62372          | APPLETV | jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as Broadband upSell tile on the banner

  @BroadbandUpSell @IPTV
  Scenario: Verify Broadband upSell tile should be for the recommended plan of netflix
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId | bbNetflixRecommendedId | _cpId   | partnerStatus                                                                                                           |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE    | BLACK_55799     | BLACK_62372            | NETFLIX | appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as Broadband upSell tile on the banner

  @BroadbandUpSell @IPTV
  Scenario: Verify bbPrimeRecommendedId is picked  when two recommended(bbPrimeRecommendedId,bbRecommendedId) plans available.
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId | bbPrimeRecommendedId | bbRecommendedId | _cpId        | partnerStatus                                                                                                                           |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE    | BLACK_55799     | BLACK_55817          | BLACK_62372     | AMAZON_PRIME | appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as Broadband upSell tile on the banner

  @BroadbandUpSell @IPTV
  Scenario: Verify when two recommended plans(bbAppleRecommendedId,bbRecommendedId) and cpid is of AMAZON_PRIME then we pick bbRecommendedId bbRecommendedId for upsell banner
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId | bbAppleRecommendedId | bbRecommendedId | _cpId        | partnerStatus                                                                                                                           |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE    | BLACK_55799     | BLACK_55817          | BLACK_62372     | AMAZON_PRIME | appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as Broadband upSell tile on the banner

# negative cases
  @BroadbandUpSell @IPTV
  Scenario: Verify When User is subscribed for the all the CP then Broadband upSell tile should behave as normal tile on the banner.
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId | bbRecommendedId | _cpId        | partnerStatus                                                                                                                                                |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE    | BLACK_55799     | BLACK_62372     | AMAZON_PRIME | amazon_prime:claimed,appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as normal tile on the banner

  @BroadbandUpSell @IPTV
  Scenario: Verify normal tile should not be as Broadband upSell tile When these is no or wrong bbRecommendedId
    When fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId | bbRecommendedId | _cpId        | partnerStatus                                                                                                                                                |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE    | BLACK_55799     | BLACK_6jhb2372  | AMAZON_PRIME | amazon_prime:claimed,appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as normal tile on the banner

  @BroadbandUpSell @IPTV
  Scenario: Verify normal tile should not be as Broadband upSell tile When these is no or wrong activeBBFixedId
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId  | bbRecommendedId | _cpId        | partnerStatus                                                                                                                                                |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE    | BLACK_55ghvgh799 | BLACK_62372     | AMAZON_PRIME | amazon_prime:claimed,appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as normal tile on the banner

  @BroadbandUpSell @IPTV
  Scenario: Verify normal tile should not be as Broadband upSell tile When these is no or wrong _cpId
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId | bbRecommendedId | _cpId   | partnerStatus                                                                                                                                                |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE    | BLACK_55799     | BLACK_62372     | APPLETV | amazon_prime:claimed,appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as normal tile on the banner

  @BroadbandUpSell @IPTV
  Scenario: Verify normal tile should not be as Broadband upSell tile When _tileSubTypeV2 is not UPSELL_TILE
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId | bbRecommendedId | _cpId   | partnerStatus                                                                                                                                                |
      | PX_r7GPUCo1kqaICY0 | XSTREAM |                | BLACK_55799     | BLACK_62372     | APPLETV | amazon_prime:claimed,appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as normal tile on the banner

  @BroadbandUpSell @IPTV
  Scenario: Verify Broadband upSell tile should not be visible when active plan has more cps then recommended plan
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId | bbRecommendedId | _cpId        | partnerStatus                                                                                                                           |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE    | BLACK_62372     | BLACK_55799     | AMAZON_PRIME | appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as normal tile on the banner

  @BroadbandUpSell @IPTV
  Scenario: Verify Broadband upSell tile should not be visible when recommended plan and active plan has same price .
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId | bbRecommendedId | _cpId        | partnerStatus                                                                                                                           |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE    | BLACK_55797     | BLACK_55799     | AMAZON_PRIME | appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as normal tile on the banner

  @BroadbandUpSell @IPTV
  Scenario: Verify Broadband upSell tile should not be visible when recommended plan and active plan has same cps.
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId | bbRecommendedId | _cpId        | partnerStatus                                                                                                                           |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE    | BLACK_62374     | BLACK_55815     | AMAZON_PRIME | appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as normal tile on the banner

  @BroadbandUpSell @IPTV
  Scenario: Verify When User is subscribed for the all the CP through broadband pack then Broadband upSell tile should behave as normal tile on the banner.
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubTypeV2 | activeBBFixedId | bbRecommendedId | _cpId        | sd                                                                         |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE    | BLACK_55799     | BLACK_62372     | AMAZON_PRIME | amazon_prime:6102:3,appletv:596543:3,netflix:596543:3,hotstar_dth:596543:3 |
    Then Verify the tile behave as normal tile on the banner


#  @BroadbandUpSell @IPTV
#  Scenario: verify content from Automate tile for live Match using qusar

#  Scenario: verify content from Static tile
#    When fetch static tile details for "tlxsta_ughs36681767604864445" tile with user query param
#    Then Verify tiles details should be present
#
#  Scenario: Verify response of tile when tileId is invalid
#    When fetch static tile details for "tlxsta_ughs366817676dfvdfv04864445" tile with user query param
#    Then Verify response for invalid tileId
#
#  Scenario: Verify Dynamic tile response using contentId
#    When fetch static tile details for "tlxsta_ughs36681767604864445" tile with user query param
#    Then Verify tiles details should be present
#
##    content Tile and Regular Tile
#  Scenario: Create tile with valid inputs
#    When Create tile with these meta
#      |  |
#      |  |
#    Then Verify tile should be created successfully
#
#  Scenario: Create tile without segmentId
#    When Create tile with these meta
#      | displayTitle |
#      |              |
#    Then Verify user not able to create tile
#
##    content Tile
#  Scenario: Create content tile without contentId
#    When Create tile with these meta
#      | displayTitle |
#      |              |
#    Then Verify user not able to create tile
#
#  Scenario: Create content tile without displayTitle
#    When Create tile with these meta
#      | displayTitle |
#      |              |
#    Then Verify user not able to create tile
#
#  Scenario: Create content tile without title
#    When Create tile with these meta
#      | displayTitle |
#      |              |
#    Then Verify user not able to create tile
#
##    Regular Tile
#  Scenario: Create regular tile without artwork
#    When Create tile with these meta
#      | displayTitle |
#      |              |
#    Then Verify user not able to create tile
#
#  Scenario: Create regular tile without deeplink
#
#  Scenario: Verify user Can Create Program tile in regular tile
#
#  Scenario: Update Ziegel tile with valid inputs
#
#  Scenario: Temporarily Delete tile with valid tileId
#    When delete a live tile with tileId ""
#    Then Verify tile should be deleted Temporary
#
#  Scenario: Delete Ziegel tile with invalid tileId
#    When delete a live tile with tileId ""
#    Then Verify User not able to delete tile
#
#  Scenario: Get Ziegel tile with valid tileId
#    When fetch tile details for "" tileId
#    Then Verify user able to fetch tile details with valid tileId
#
#  Scenario: Get Ziegel tile with invalid tileId
#    When fetch tile details for "" tileId
#    Then Verify user not able to fetch tile details with invalid tileId



