Feature: Xstream Autostatic & Merged Collection Ranking Strategies Validation
  The purpose of this feature is to validate all ranking strategies,
  content ordering rules, dedup behavior, and user-language/CP priority
  ordering for curated & merged collections using REST APIs.

#  @smoke @autostatic
#  Scenario: Verify autostatic collection creation exposes ranking strategy options
#    Given I have access token for Xstream CMS
#    When I create a new auto-static collection with name "Test AutoStatic"
#    Then the response should include ranking strategy options
#      | SHUFFLE |
#    And the collection type should be "AUTO_STATIC"
#
#  @autostatic
#  Scenario: Validate that an existing static collection cannot be converted to autostatic
#    Given an existing static collection "COL_123"
#    When I try to update the type to "AUTO_STATIC"
#    Then I should receive an error message "Static collections cannot be converted to Autostatic"
#
#
#  #########################################################
#  # 1. PURE RANDOM SHUFFLE
#  #########################################################
#
#  @merged @shuffle
#  Scenario: Validate Pure_Random_Shuffling keeps list random but cached for 5 minutes
#    Given a merged collection "M1" with ranking strategy "SHUFFLE"
#    When I fetch the collection content list
#    Then the order should be randomized
#    And the order should remain consistent for 5 minutes
#
#
#  #########################################################
#  # 2. RANDOM SHUFFLE WITHIN LANGUAGE
#  #########################################################
#
#  @merged @languageShuffle
#  Scenario: Validate Random_Shuffling_within_Language ordering
#    Given a merged collection "M2" with ranking strategy "GROUP_BY_CONTENT_LANGAUGE_THEN_SHUFFLE_WITHIN_WINDOW"
#    When I fetch the collection content list
#    Then contents within each language should be shuffled
#    And languages should be arranged in round robin order
#
#
#  #########################################################
#  # 3. POPULARITY WINDOW SHUFFLE
#  #########################################################
#
#  @merged @popularityWindow
#  Scenario: Validate Random_within_Desc_Pop_Window ordering
#    Given a merged collection "M3" with ranking strategy "GROUP_BY_POPULARITY_WINDOW_THEN_SHUFFLE_WITHIN_WINDOW"
#    When I fetch the collection content list
#    Then content must be sorted by popularity windows
#      | 80-100 |
#      | 50-80  |
#      | 20-50  |
#      | 0-20   |
#    And contents within each window should be randomly arranged
#
#
#  #########################################################
#  # 4. DESC POPULARITY
#  #########################################################
#
#  @merged @descPopularity
#  Scenario: Validate Desc_Popularity ordering
#    Given a merged collection "M4" with ranking strategy "CONTENT_POPULARITY"
#    When I fetch the collection content list
#    Then contents must be sorted in descending popularity score
#    And new releases should be ranked appropriately based on popularity logic
#
#
#  #########################################################
#  # 5. Preferred CP (Content Provider)
#  #########################################################
#
#  @merged @preferredCP
#  Scenario: Validate CP-based round robin ordering
#    Given a merged collection "M5" with ranking strategy "GROUP_BY_PARTNER_THEN_MERGE"
#    And preferred CP order is
#      | CP1 | Lionsgate |
#      | CP2 | SonyLiv   |
#      | CP3 | Aha       |
#    When I fetch the collection content list
#    Then contents should be arranged in CP round robin order
#    And non-preferred CP content should appear at the end
#
#
#  #########################################################
#  # 6. USER ALL LANGUAGE MERGED
#  #########################################################
#
#  @userLang @ALL
#  Scenario: Validate User_All_Lang_Merged Language Ordering (Dom > Sig > USL)
#    Given a user with dominant language "En"
#    And significant languages "Ta, Hi"
#    And user selected languages "Hi, En, Ta"
#    And merged collection "M6" with strategy "GROUP_BY_CONTENT_LANG_UL_ORDERED_MERGE"
#    When I fetch the user-personalized collection
#    Then content languages should follow order:
#      | En | Ta | Hi |
#    And content should be placed in round robin accordingly
#
#
#  #########################################################
#  # 7. USER DOM + SIG Merged
#  #########################################################
#
#  @userLang @DOM_SIG
#  Scenario: Validate User_Dom_Sig_Lang_Merged ordering
#    Given a user with dominant language "En"
#    And significant languages "Ta, Hi"
#    And merged collection "M7" with strategy "GROUP_BY_CONTENT_LANG_UCL_ORDERED_MERGE"
#    When I fetch the personalized collection
#    Then the language order should be:
#      | En | Ta | Hi |
#    And content should be arranged in round robin
#
#
#  #########################################################
#  # 8. USL Merged
#  #########################################################
#
#  @userLang @USL
#  Scenario: Validate USL_Merged ordering
#    Given a user with USL list "Hi, Te, Ta"
#    And merged collection "M8" with strategy "GROUP_BY_CONTENT_LANG_USeL_ORDERED_MERGE"
#    When I fetch the personalized collection
#    Then content with USL languages should appear first
#    And remaining languages should follow original order
#
#
#  #########################################################
#  # 9. Merge by Source (User Language Affinity)
#  #########################################################
#
#  @sourceMerge
#  Scenario: Validate Merge-by-Source with user language affinity
#    Given collections:
#      | C1 | Hi, Gu, Bh |
#      | C2 | En         |
#      | C3 | Ta         |
#      | C4 | Te         |
#    And user dominant language "En"
#    And user significant language "Ta"
#    And strategy "GROUP_BY_SOURCE_THEN_MERGE"
#    When I fetch the merged content list
#    Then collections should be ordered as:
#      | C2 | C3 | C1 | C4 |
#    And content should be placed in round robin across collections
#
#
#  #########################################################
#  # 10. Merge by Source with Shuffle
#  #########################################################
#
#  @sourceShuffle
#  Scenario: Validate Merge-by-Source with shuffle and language affinity
#    Given collections and user affinities as above
#    And ranking strategy "GROUP_BY_SOURCE_THEN_SHUFFLE_WITHIN_WINDOW"
#    When I fetch the merged content list
#    Then source-level contents must be shuffled
#    And collections sorted by user language affinity
#    And round robin applied across shuffled collections
#
#
#  #########################################################
#  # 11. Dedup
#  #########################################################
#
#  @dedup
#  Scenario: Validate content dedup based on title across languages
#    Given merged collection "M10"
#    And dedup option is enabled
#    When I fetch the collection content list
#    Then duplicate titles across languages should be removed
#    And only the preferred language content should be retained
#
#
#  #########################################################
#  # 12. System vs User CP Priority
#  #########################################################
#
#  @cpUser
#  Scenario: Validate User CP Preference overrides System CP Order
#    Given system CP order exists
#    And user CP preferred order is configured
#    And merged collection "M11" with CP strategy is used
#    When I fetch the personalized collection
#    Then CP ordering must follow user preference first
#
#
#  #########################################################
#  # 13. User_all_lang_weighted_merged_shuffle
#  #########################################################
#
#  @advanced @weighted
#  Scenario: Validate user weighted language based shuffle ordering
#    Given a user with language affinity weights
#      | En | 0.9 |
#      | Ta | 0.7 |
#      | Hi | 0.4 |
#    And merged collection "M12" with strategy "User_all_lan_weighted_merged_shuffle"
#    When I fetch the personalized collection
#    Then ordering should reflect weighted round robin with randomization
