Feature: Non-DTH Linear Channels Recommandations for user on the basis of user watch history and languages

  genres = ["Entertainment", "News", "Lifestyle", "Movies", "Music", "Sports", "Devotional", "Documentary", "Business"]
  contentType = "LIVETVCHANNEL"
  contentStatus = "PUBLISH"
  partners = ["ZEEDIGITAL", "MWTV", "AAJTAKLIV", "HOTSTARLIVETV", "DISTROTV", "RUNNTV", "TIMESPLAY"]

  Verify if the Input content Id’s "genres" is no filtred genre then no recommendation form.
  Verify if the Input content Id’s "state" is not "PUBLISH" then the content and recommendation is not visible on the app.
  Verify if the Input content Id’s "playableContent.ty" is not "LIVETVCHANNEL" then no recommendation form.
  Verify if the Input content Id’s "CP" is not "Form the list" then no recommendation form.
  Verify if the Input content Id’s is empty than no recommendation.
  Verify if the Input content Id’s is there than Input contentId should not be recommanded.
  Verify recommended contentIds genres should contain atleast one genre of input contentId's genre
  Verify recommended contentId should be sorted in the order of genre matched highest to lowest.


  ->> Var 1:- Recommended PUBLISH LIVETVCHANNEL on the basis of user currently watched contentId.
  ->> Var 2:- Sort On the basis of Trending in last 30 min, Recommended PUBLISH LIVETVCHANNEL on the basis of user currently watched contentId.


  Scenario: Verify Non Linear Channels product variant 1 for P0 language
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
    And Add contentId "LIVETV_LIVETVCHANNEL_COLORS_CINEPLEX_SUPERHITS" in params for recommendation
    And Fetch content from arsenal collection "axaut_2wnt20281760425945509"
    And Verify content type should be "LIVETVCHANNEL"
    And Verify content status should be "PUBLISH"
    And Verify content genres should be from "Sports, Reality TV, Lifestyle, English"
    And Verify content partner should be "ZEEDIGITAL, MWTV, AAJTAKLIVETV, HOTSTARLIVETV, DISTROTV, RUNNTV"
    Then Verify Content language is same from user P0 language

  Scenario: Verify Non Linear Channels product variant 1 P1 language
    Given We are using "rAtzURC-rWmhQ_DOv0" as a Xstream user
    And Change user selected languages to "ta,ml,te"
    And Add contentId "LIVETV_LIVETVCHANNEL_COLORS_CINEPLEX_SUPERHITS" in params for recommendation
    And Fetch content from arsenal collection "axaut_2wnt20281760425945509"
    Then Verify Content language is same from user P1 language if P0 is not available
    Then verify countentId "" should not be present in the recommaneded list

  Scenario: Verify Non Linear Channels product variant 1 P1 language
    Given We are using "rAtzURC-rWmhQ_DOv0" as a Xstream user
    And Change user selected languages to "ta,ml,te"
    And Add contentId "LIVETV_LIVETVCHANNEL_COLORS_CINEPLEX_SUPERHITS" in params for recommendation
    And Fetch content from arsenal collection "axaut_2wnt20281760425945509"
    Then Verify Content language is same from user P1 language if P0 is not available
    Then verify countentId "" should not be present in the recommaneded list

  Scenario: Verify Non Linear Channels product variant 1 return no content when there is no input contentId
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
    And Fetch content from arsenal collection "axaut_gxyk63421760429200710"
    Then Verify no content recommanded when no input contentId


