Feature: user growth platform
  #DISCO-663 #DISCO-596 #DISCO-755

  #DISCO-T52
#  Scenario Outline: user create new template for SMS for 1 variant
#    Given create templates for "<realm>" and "SMS" for "variant 1"
#      | name   | messageBody   | action   | smsHeader   | smsTemplateId   | smsType   | realm   | type   |
#      | <name> | <messageBody> | <action> | <smsHeader> | <smsTemplateId> | <smsType> | <realm> | <type> |
#  #  Then create campaign "<realm>" for "variant 1"
##    Then make campaign live "<realm>"
#
#    Examples:
#      | name | messageBody                               | action | smsHeader | smsTemplateId | smsType     | realm   | type |
#      | avod | Maximize the benefits of your Airtel Pack |        | 650015    |               | PROMOTIONAL | XSTREAM | SMS  |
#
#
#  Scenario Outline: user create new template for PUSH for 1 variant
#    Given create templates for "<realm>" and "PUSH" for "variant 1"
#      | name   | messageTitle   | messageBody   | richContents   | action   |
#      | <name> | <messageTitle> | <messageBody> | <richContents> | <action> |
#    Then create campaign "<realm>" for "variant 1"
##    Then make campaign live "<realm>"
#
#    Examples:
#      | name | messageTitle | messageBody | richContents | action | realm      |
#      | gdgd |              | dbb         | dbfbd        | dfbfd  | XSTREAM    |
#      | gdgd |              | dbb         | dbfbd        | dfbfd  | WYNK_MUSIC |
#
#  Scenario Outline: user create new template for PUSH for 2 variants
#    Given create templates for "<realm>" and "PUSH" for "variant 1"
#      | name | messageTitle | messageBody | richContents | action |
#      | abc  | ab           | dsj         | bhd          | sdj    |
#    And create templates for "<realm>" and "PUSH" for "variant 2"
#      | name | messageTitle | messageBody | richContents | action |
#      | xys  | xy           | vfds        | sds          | pod    |
#    Then create campaign "<realm>" for "variant 2"
#    Examples:
#      | realm      |
#      | XSTREAM    |
#      | WYNK_MUSIC |
#
#  Scenario Outline: user create new template for SMS for 2 variants
#    Given create templates for "<realm>" and "SMS" for "variant 1"
#      | name    | messageTitle | messageBody | action | smsHeader | smsTemplateId | smsType | collectionId                                                             |
#      | paridhi | paridhi jain | hello       | abc    | 620012    | AV            | hsh     | axaut_hccl699216891626595976-RANDOM, axaut_hccl699216891626595976-RANDOM |
#    And create templates for "<realm>" and "SMS" for "variant 2"
#      | name    | messageTitle  | messageBody | action | smsHeader | smsTemplateId | smsType | collectionId                        |
#      | shubham | shubham gupta | hey         | xys    | 620018    | AV            | poi     | axaut_hccl699216891626595098-RANDOM |
#    Then create campaign "<realm>" for "variant 2"
#      | title   |
#      | dbshjbf |
#    Examples:
#      | realm   |
#      | XSTREAM |
##      | WYNK_MUSIC |
#
#
##  Scenario: user create new template for xstream and sms
##    Given create templates for "XSTREAM" and "SMS"
##
##  Scenario: user create new template for xstream and push
##    Given create templates for "XSTREAM" and "PUSH"
##
##  Scenario: user create new template for wynk and sms
##    Given create templates for "WYNK_MUSIC" and "SMS"
##
##  Scenario: user create new template for wynk and push
##    Given create templates for "WYNK_MUSIC" and "PUSH"
##
##  Scenario: create campaign and live
##    Then create campaign "WYNK_MUSIC" for "variat 1"
##    Then make campaign live "XSTREAM"
#
#  Scenario Outline: make campaign live for all users
#    Given create templates for "<realm>" and "PUSH" for "variant 1"
#      | name   | messageTitle   | messageBody   | richContents   | action   | smsHeader   | smsTemplateId   | smsType   |
#      | <name> | <messageTitle> | <messageBody> | <richContents> | <action> | <smsHeader> | <smsTemplateId> | <smsType> |
#
#    Then create campaign "<realm>" for "<var>"
#    Then make campaign live for all users "<realm>"
#      | campaignId   | campaignName   | realm   |
#      | <campaignId> | <campaignName> | <realm> |
#
#    Examples:
#      | campaignId               | campaignName          | realm   |
#      | 66a2353cbbdc0562434aa584 | ugp_cricket_pre_match | XSTREAM |
#
#
#  Scenario Outline: user create new template for XSTREAM and Variant 2
#    Given create templates for "<realm>" and "<var>"
#
#      | name   | messageTitle   | messageBody   | richContents   | action   | smsHeader   | smsTemplateId   | smsType   |
#      | <name> | <messageTitle> | <messageBody> | <richContents> | <action> | <smsHeader> | <smsTemplateId> | <smsType> |
#    Then create campaign "<realm>" for "<var>"
#    Examples:
#      | realm | var | name | messageTitle | messageBody | richContents | action | smsHeader | smsTemplateId | smsType |






