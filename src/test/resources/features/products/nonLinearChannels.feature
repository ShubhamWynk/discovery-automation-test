Feature: Non-DTH Linear Channels Recommandations for user on the basis of user watch history and languages
  ->>

  Scenario: Verify Non Linear Channels product variant 1 for P0 language
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
    And Add contentId "LIVETV_LIVETVCHANNEL_COLORS_CINEPLEX_SUPERHITS" in params for recommendation
    And Fetch content from arsenal collection "axaut_2wnt20281760425945509"
    And Verify content type should be "LIVETVCHANNEL"
    And Verify content status should be "LIVE"
    And Verify content genres should be from "Sports, Reality TV, Lifestyle, English"
    And Verify content partner should be "ZEEDIGITAL, MWTV, AAJTAKLIVETV, HOTSTARLIVETV, DISTROTV, RUNNTV"
    Then Verify Content language is same from user P0 language

  Scenario: Verify Non Linear Channels product variant 1 P1 language
    Given We are using "rAtzURC-rWmhQ_DOv0" as a Xstream user
    And Change user selected languages to "ta,ml,te"
    And Add contentId "LIVETV_LIVETVCHANNEL_COLORS_CINEPLEX_SUPERHITS" in params for recommendation
    And Fetch content from arsenal collection "axaut_2wnt20281760425945509"
    And Verify content type should be "LIVETVCHANNEL"
    And Verify content status should be "PUBLISH"
    And Verify content genres should be from "Sports, Reality TV, Lifestyle, English"
    And Verify content partner should be "ZEEDIGITAL,MWTV,AAJTAKLIVETV,HOTSTARLIVETV,DISTROTV,RUNNTV"
    Then Verify Content language is same from user P1 language if P0 is not available

  Scenario: Verify input contentId should not be recommanded
    Given We are using "rAtzURC-rWmhQ_DOv0" as a Xstream user
    And Add contentId "LIVETV_LIVETVCHANNEL_COLORS_CINEPLEX_SUPERHITS" in params for recommendation
    And Fetch content from arsenal collection "axaut_2wnt20281760425945509"
    Then verify countentId "" should not be present in the recommaneded list
#
#  Scenario: Verify Non Linear Channels product variant 2
#    Given We are using "" as a Xstream user
#    And Fetch content of "varient 2" from arsenal collection ""