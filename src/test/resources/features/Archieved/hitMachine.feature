Feature: hit machine
  #DISCO-663 #DISCO-596 #DISCO-755

  #DISCO-T52
#  Scenario: user create new druker content meta
#    Given User add content details
#      | key | contentType | distributionStrategy | isActive | killSwitchStrategy | knobStrategy |
#      |     |             |                      |          |                    |              |
#    Then User add content meta
#      | artistIds | languages | publishedYears | streamTarget | timeWindow | triggerTime |
#      |           |           |                |              |            |             |
#    Then User add client meta details
#      | clientKey | useContentDominantArtistFilter | useContentDominantLangFilter | useContentPublishedYearFilter | userRplStateFilter | windowIndex | windowSize |
#      |           |                                |                              |                               |                    |             |            |
#    Then User hit create druker content meta api
#    Then Validate new druker content meta should be created
#
#  #DISCO-T54 #DISCO-T53
#  Scenario: user create new Campaign
#    Given User create new Campaign
#      | campaignName | clientKey | contentType | isActive |
#      |              |           |             |          |
#    Then user add content meta with split percentage in Campaign
#      | drukerMetaContentId | percentage |
#      |                     |            |
#    Then User hit create Campaign api
#    Then Validate newly created Campaign
#
#  #DISCO-T56 #DISCO-T57
#  Scenario: user edit existing Campaign
#    Given User edit "test 3" Campaign
#      | campaignName | clientKey | contentType | isActive |
#      | test4        |           |             |          |
#    Then user add content meta with split percentage in Campaign
#      | drukerMetaContentId | percentage |
#      | -                   | 0          |
#    Then User hit edit Campaign api
#    Then Validate newly created Campaign
#
#  #DISCO-T55
#  Scenario: User add Campaign to the assortments
#    Given User select Campaign
#      | campaignName |
#      | test 3       |
#    Then User add the selected campaign to the "Song Assortment" assortments
#
#  #DISCO-T58
#  Scenario: User delete Campaign from the assortments
#    Given User select Campaign
#      | campaignName |
#      | test 3       |
#    Then User delete the selected campaign from the "Song Assortment" assortments