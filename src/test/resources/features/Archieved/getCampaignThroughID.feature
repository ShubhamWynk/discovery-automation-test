Feature: get campaign through id

#  Scenario: get campaign details through id for XSTREAM realm
#    Given get campaign details for "XSTREAM"
#      | id                       |
#      | 66b30dacbb10fd328e843d2e |
#    Then user set data which needs to be updated and update campaign for "XSTREAM"
#      | description                                 | title      |
#      | Hello world !! | qa-testing |


#  Scenario: get campaign details through id for WYNK_MUSIC realm
#    Given get campaign details for "WYNK_MUSIC"
#      | id                       |
#      | 6646eebc0d2a5146b3fe771e |

  Scenario: get campaign split percentage through id for XSTREAM realm
    Given get campaign split percentage for "XSTREAM"
      | id                       |
      | 66b30dacbb10fd328e843d2e |


    Scenario: get all campaigns
      Given get all campaigns details


    Scenario: