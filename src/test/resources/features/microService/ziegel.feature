Feature: Ziegel Service

  @BroadbandUpSell
  Scenario: Verify Broadband upSell tile should be visible with deeplink of the recommended plan and title is update now.
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubType | activeBBFixedId | bbRecommendedId | _cpId        | partnerStatus                                                                                                                           |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE  | BLACK_55799     | BLACK_62372     | AMAZON_PRIME | appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as Broadband upSell tile on the banner

  @BroadbandUpSell
  Scenario: Verify When User is subscribed for the all the CP then Broadband upSell tile should behave as normal tile on the banner.
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubType | activeBBFixedId | bbRecommendedId | _cpId        | partnerStatus                                                                                                                                                |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE  | BLACK_55799     | BLACK_62372     | AMAZON_PRIME | amazon_prime:claimed,appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as normal tile on the banner

  @BroadbandUpSell
  Scenario: Verify normal tile should not be as Broadband upSell tile When these is no or wrong bbRecommendedId
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubType | activeBBFixedId | bbRecommendedId | _cpId        | partnerStatus                                                                                                                                                |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE  | BLACK_55799     | BLACK_6jhb2372  | AMAZON_PRIME | amazon_prime:claimed,appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as normal tile on the banner

  @BroadbandUpSell
  Scenario: Verify normal tile should not be as Broadband upSell tile When these is no or wrong activeBBFixedId
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubType | activeBBFixedId  | bbRecommendedId | _cpId        | partnerStatus                                                                                                                                                |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE  | BLACK_55ghvgh799 | BLACK_62372     | AMAZON_PRIME | amazon_prime:claimed,appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as normal tile on the banner

  @BroadbandUpSell
  Scenario: Verify normal tile should not be as Broadband upSell tile When these is no or wrong _cpId
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubType | activeBBFixedId | bbRecommendedId | _cpId   | partnerStatus                                                                                                                                                |
      | PX_r7GPUCo1kqaICY0 | XSTREAM | UPSELL_TILE  | BLACK_55799     | BLACK_62372     | APPLETV | amazon_prime:claimed,appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as normal tile on the banner

  @BroadbandUpSell
  Scenario: Verify normal tile should not be as Broadband upSell tile When _tileSubType is not UPSELL_TILE
    And fetch tile meta data for "tlxsta_ughs36681767604864445" tile without user query param
      | uid                | realm   | _tileSubType | activeBBFixedId | bbRecommendedId | _cpId   | partnerStatus                                                                                                                                                |
      | PX_r7GPUCo1kqaICY0 | XSTREAM |              | BLACK_55799     | BLACK_62372     | APPLETV | amazon_prime:claimed,appletv:claimed,jiohotstar:claimed,zeefive:claimed,xstreampremium:claimed,netflix:claimed,xstreampremium_paid,xstreampremium_telco_paid |
    Then Verify the tile behave as normal tile on the banner

#  Scenario: verify content from Automate tile from live Match using qusar

  Scenario: verify content from Static tile.

  Scenario: Verify response of tile when tileId is invalid

  Scenario: Verify response of tile when tileId is valid

  Scenario: Verify Dynamic tile response using contentId

#    content Tile and Regular Tile
  Scenario: Create tile with valid inputs

  Scenario: Create tile without segmentId
    When Create tile with these meta
      | displayTitle |
      |              |
    Then Verify

#    content Tile
  Scenario: Create content tile without contentId

  Scenario: Create content tile without displayTitle

  Scenario: Create content tile without title

#    Regular Tile
  Scenario: Create regular tile without artwork

  Scenario: Create regular tile without deeplink

  Scenario: Can Create Program tile in regular tile

  Scenario: Update Ziegel tile with valid inputs

  Scenario: Temporarily Delete tile with valid tileId
    When delete a live tile with tileId ""
    Then Verify tile should be deleted Temporary

  Scenario: Delete Ziegel tile with invalid tileId
    When delete a live tile with tileId ""
    Then Verify User not able to delete tile

  Scenario: Get Ziegel tile with valid tileId
    When fetch tile details for "" tileId
    Then Verify user able to fetch tile details with valid tileId

  Scenario: Get Ziegel tile with invalid tileId
    When fetch tile details for "" tileId
    Then Verify user not able to fetch tile details with invalid tileId



