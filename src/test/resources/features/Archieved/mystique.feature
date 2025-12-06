Feature: Mystique Sorting Service
  ( This service is use to sort content according to the sorting algo )

  - "shuffle" sorting service is use randomly sort all the song or content
  - "Trending" sorting service is use to boost trending songs in the content
  - "RPL boost and de-boost " sorting service sort RPL(recent played list) of user and boost or de-boost then in content List
  - "xstream-popularity" sorting service sort content according to the popularity of the content (popularity score fetch from catalog)
  - "popularity" sorting service sort content according to the popularity of the song (popularity score fetch from catalog)
  - "reranking" sorting service sort content according to the ranking score of that song
  - "mostPlayed" sorting service sort content according to the user's most played songs, it should be boosted in the list
  - "new_songs" sorting service sort content according to the new released songs, it should be boosted in the list
  - "CPReRank" sorting service sort content according to the "Content Provider" of the song it boost or de-boost the
      content of the particular "Content Provider" which is passed in "CPId" and it should be boosted and de-boosted
      according to the "rerankType"

   #DISCO-877
#  Scenario: verify mystique Shuffle sorting service
#    Given User set meta
#      | sortStrategy | segmentId |
#      | shuffle      |           |
#    And User set param
#      | mystiqueStrategy | n |
#      | shuffle          | 3 |
#    And User add content to be sorted
#      | contentId                                       | type | position |
#      | srch_universalmusic_00602435500362-USUM72018810 | SONG | 0        |
#      | srch_universalmusic_00602527874487-USUM71116290 | SONG | 1        |
#      | srch_universalmusic_00602435976471-USUM72102635 | SONG | 2        |
#      | srch_universalmusic_00602435296678-USUM72019170 | SONG | 3        |
#    Then User hit mystique apply api
#
#    #DISCO-459 DISCO-460
#  Scenario Outline: verify the functionality of RPL_boost and  RPL_de-boost sort service
#    Given get the rpl content for the "MOdGE8JM3IvRVcZSE0" user
#    And User set meta
#      | sortStrategy | segmentId |
#      | rpl_boost    |           |
#    And User set param
#      | mystiqueStrategy | uid                | cutOff | duration | boost        |
#      | rpl_boost        | MOdGE8JM3IvRVcZSE0 | 300    | DAYS     | <boostValue> |
#    And User add content to be sorted
#      | contentId                                       | type | position |
#      | srch_universalmusic_00602435500362-USUM72018810 | SONG | 0        |
#      | srch_universalmusic_00602527874487-USUM71116290 | SONG | 1        |
#      | srch_universalmusic_00602435976471-USUM72102635 | SONG | 2        |
#      | srch_universalmusic_00602435296678-USUM72019170 | SONG | 3        |
#    And User add "2" content from their rpl to be "<sortStrategy>"
#    Then User hit mystique apply api
#    Then Verify rpl content should be "<sortStrategy>"
#    Examples:
#      | sortStrategy | boostValue |
#      | Boosted      | positive   |
#      | de-Boosted   | negative   |
#
#    #DISCO-376
#  Scenario: verify mystique trending sorting service
#    Given User set meta
#      | sortStrategy | segmentId |
#      | trending     |           |
#    And User set param
#      | source      |
#      | SHAZAM,WYNK |
#    And User add content to be sorted
#      | contentId                                       | type | position |
#      | srch_universalmusic_00602435500362-USUM72018810 | SONG | 0        |
#      | srch_universalmusic_00602527874487-USUM71116290 | SONG | 1        |
#      | srch_universalmusic_00602435976471-USUM72102635 | SONG | 2        |
#      | srch_universalmusic_00602435296678-USUM72019170 | SONG | 3        |
#    And User add "2" trending songs in the list
#    And User hit mystique apply api
#    Then verify trending songs should be "Boosted"
#
#  Scenario: verify mystique re-ranking sorting service
#    Given User set meta
#      | sortStrategy | segmentId |
#      | reranking    |           |
#    And User set param
#      | mystiqueStrategy | userId             |
#      | reranking        | rNe-gHa4ZaZr0heK30 |
#    And User add content to be sorted
#      | contentId                                       | type | position |
#      | srch_universalmusic_00602435500362-USUM72018810 | SONG | 0        |
#      | srch_universalmusic_00602527874487-USUM71116290 | SONG | 1        |
#      | srch_universalmusic_00602435976471-USUM72102635 | SONG | 2        |
#      | srch_universalmusic_00602435296678-USUM72019170 | SONG | 3        |
#    And User hit mystique rerank service to get the score
#      | qid | user_id            | normalise_user | normalise_items | use_case |
#      | 24  | rNe-gHa4ZaZr0heK30 | false          | false           | song     |
#    And User hit mystique apply api
#    Then verify content should be reranked
#
#  Scenario: verify mystique popularity sorting service
#    Given User set meta
#      | sortStrategy | segmentId |
#      | popularity   |           |
#    And User set param
#      | mystiqueStrategy |
#      | popularity       |
#    And User add content to be sorted
#      | contentId                                       | type | position |
#      | srch_universalmusic_00602435500362-USUM72018810 | SONG | 0        |
#      | srch_universalmusic_00602527874487-USUM71116290 | SONG | 1        |
#      | srch_universalmusic_00602435976471-USUM72102635 | SONG | 2        |
#      | srch_universalmusic_00602435296678-USUM72019170 | SONG | 3        |
#    And User hit mystique apply api
#    Then verify content should be sorted according to popularity
#
#  Scenario: verify mystique Xstream popularity sorting service
#    Given User set meta
#      | sortStrategy       | segmentId |
#      | xstream-popularity |           |
#    And User set param
#      | mystiqueStrategy   |
#      | xstream-popularity |
#    And User add content to be sorted
#      | contentId                                          | type   | position |
#      | SONYLIV_VOD_MOVIE_1000199752                       | MOVIE  | 1        |
#      | HUNGAMA_TVSHOW_9829820                             | TVSHOW | 2        |
#      | HOICHOI_MOVIE_61f48684-d0f2-4aa1-a0ac-0c351280f19d | MOVIE  | 3        |
#    And User add popular content in the list
#    And User hit mystique apply api
#    Then verify content should be sorted according to Xstream popularity
#
#  Scenario Outline: verify mystique CPReRank sorting service
#    Given User set meta
#      | sortStrategy | segmentId |
#      | cpRerank     |           |
#    And User set param
#      | rerankType   | cpId         | upperIndex | lowerIndex |
#      | <rerankType> | srch_hungama | 30         | 5          |
#    And User add content to be sorted
#      | contentId                                       | type | position |
#      | srch_hungama_61993731                           | SONG | 0        |
#      | srch_universalmusic_00602435500362-USUM72018810 | SONG | 1        |
#      | srch_universalmusic_00602527874487-USUM71116290 | SONG | 2        |
#      | srch_universalmusic_00602435976471-USUM72102635 | SONG | 3        |
#      | srch_universalmusic_00602435296678-USUM72019170 | SONG | 4        |
#      | srch_hungama_2379437                            | SONG | 5        |
#    And User hit mystique apply api
#    Then verify content in cpid should be "<Operation>"
#
#    Examples:
#      | Operation  | rerankType |
#      | de-boosted | negative   |
#      | boosted    | positive   |
#
#  @skip
#  Scenario: verify mystique new song sorting service
#    Given User set meta
#      | sortStrategy | segmentId |
#      | new_songs    |           |
#    And User set param
#      | userId             | realm      |
#      | MOdGE8JM3IvRVcZSE0 | WYNK_MUSIC |
#    And User add content to be sorted
#      | contentId                                       | type | position |
#      | srch_universalmusic_00602435500362-USUM72018810 | SONG | 0        |
#      | srch_universalmusic_00602527874487-USUM71116290 | SONG | 1        |
#      | srch_universalmusic_00602435976471-USUM72102635 | SONG | 2        |
#      | srch_universalmusic_00602435296678-USUM72019170 | SONG | 3        |
#    And User add new song collection in the content list
#    And User hit mystique apply api
#    Then Verify new song collection should be boosted
#
#  @skip
#  Scenario: verify mystique most played sorting service
#    Given User set meta
#      | sortStrategy | segmentId |
#      | mostPlayed   |           |
#    And User set param
#      | userId             | lang  |
#      | MOdGE8JM3IvRVcZSE0 | en,hi |
#    And User add content to be sorted
#      | contentId                                       | type | position |
#      | srch_universalmusic_00602435500362-USUM72018810 | SONG | 0        |
#      | srch_universalmusic_00602527874487-USUM71116290 | SONG | 1        |
#      | srch_universalmusic_00602435976471-USUM72102635 | SONG | 2        |
#      | srch_universalmusic_00602435296678-USUM72019170 | SONG | 3        |
#    And User add most played songs from collection
#    And User hit mystique apply api
#    Then Verify new song collection should be boosted
