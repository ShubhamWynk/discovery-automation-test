Feature: Youtube Recommendations for a user

  Scenario: Verify Trending content from YouTube
    Given We are using "FdPTwN400Ax9YLEYD0" as a Xstream user and "XSTREAM" as realm
    And Fetch content from YouTube arsenal collection "axaut_dfap50681747644099844"
    And Verify content type for YouTube should be "TILE"
    And Verify model source should be "youtube"
