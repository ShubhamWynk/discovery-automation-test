Feature: Layout Config Scenario
  - To create page, child page, section, template, fields
  - To edit page, child page, section, template, fields
  - To delete section, template, fields

#  Scenario: create New Template
#    Given User create payload for new template
#      | title                | key          | label         | contentType | collectionIdRequired | endpointRequired | defaultSource | fixedSource | defaultAction | defaultContentAction |
#      | Ad_Native_Card_Core2 | NATIVE_CARD2 | ADVERTISEMENT | AD          | YES                  | YES              | MUSIC_AD      | MUSIC_AD    | MUSIC_DEFAULT | LANDING              |
#    And User add supported client
#      | client        | minBuildNo | maxBuildNo |
#      | MUSIC_ANDROID | 200        | 10000      |
#      | MUSIC_IOS     | 300        | 10000      |
#    Then User hit post template endpoint to create new template
#    Then Verify Template should be added
##    Then User delete template
#
#  Scenario: create New Field
#    Given User create payload for new field
#      | title                   | key                     | type | category | source        | action  | templateKey            | frequentlyUsed |
#      | playbackPrefetchConfig2 | playbackPrefetchConfig2 | DATE | DISPLAY  | MUSIC_CONTENT | DEFAULT | BOTTOM_NAVIGATION_ITEM | true           |
#    Then User hit post Field endpoint to create new Field
#    Then Verify Field should be added
##    Then User delete field
#
#  Scenario: create New section
#    Given User create new section
#      | title            | moduleLimit | type  |
#      | Sports-all rails | 100         | FIXED |
#      | Sports-banner    | 100         | FIXED |
#    Then Verify new section should be added
#    # Then User delete section
#
#  Scenario: create New Child Page
#    Given User create new page
#      | title          | key          | pageType |
#      | Sports_child_2 | sportsChild2 | CHILD    |
#    Then User attach Sections and segment in page
#      | Sections                                        | Segment                                                                  |
#      | Sports-banner, Sports-all rails | XSTREAM DEFAULT SEGMENT (Read Only), XSTREAM DEFAULT SEGMENT (Read Only) |
#    Then Verify new "CHILD" page should be added
#
#  Scenario: create New Page
#    Given User create new page
#      | title  | key    | isEmptyAllowed | pageType |
#      | Horror | horror | true           | PARENT   |
#    Then User attach child page and segment in page
#      | Child Page         | Segment                             | adapterKeys | isFallback |
#      | Reality TV child 1 | XSTREAM DEFAULT SEGMENT (Read Only) | realityTV   | true       |
#    Then Verify new "PARENT" page should be added
#
## ======= ======= ======== EDIT =========== ========
#  Scenario: Edit section
#    Given User Edit "Romance Feature Banner 1" section
#      | title                    | moduleLimit | type  |
#      | Romance Feature Banner 1 | 50          | FIXED |
#    Then Verify new section should be added
#
#  Scenario: Edit Child Page
#    Given User Edit "Romance child 2" child page
#      | title           | key             | pageType | Sections               | Segment                           |
#      | Romance child 2 | Romance child 2 | CHILD    | Romance Feature Banner | MUSIC DEFAULT SEGMENT (Read Only) |
#    Then Verify new "CHILD" page should be added
#
#  Scenario: Edit Page
#    Given User Edit "Romance2" page
#      | title    | key | isEmptyAllowed | pageType | Child Page | Segment | adapterKeys | isFallback |
#      | Romance1 |     | true           | PARENT   |            |         |             |            |
#    Then Verify new "PARENT" page should be added
#
##    @skip
##  Scenario: Edit Template
##    Given User Edit "" template "" template Type
##      | title                | key          | label         | contentType | collectionIdRequired | endpointRequired | defaultSource | fixedSource | defaultAction | defaultContentAction |
##      | Ad_Native_Card_Core2 | NATIVE_CARD2 | ADVERTISEMENT | AD          | YES                  | YES              | MUSIC_AD      | MUSIC_AD    | MUSIC_DEFAULT | LANDING              |
##    And User edit supported client
##      | client        | minBuildNo | maxBuildNo |
##      | -             | -          | -          |
##      | MUSIC_ANDROID | 200        | 10000      |
##      | MUSIC_IOS     | 300        | 10000      |
##    Then User hit put template endpoint with the payload
##    Then Verify Template should be added
#
#  Scenario: create New Field
#    Given User edit "playbackPrefetchConfig2" field
#      | title                   | key                     | type | category | source        | action  | templateKey            | frequentlyUsed |
#      | playbackPrefetchConfig2 | playbackPrefetchConfig2 | DATE | DISPLAY  | MUSIC_CONTENT | DEFAULT | BOTTOM_NAVIGATION_ITEM | true           |
#    Then Verify Field should be added
#
#
#  Scenario Outline: XStream Page Creation
#    Given User create new section
#      | title                     | moduleLimit | type  |
#      | <Title> Feature Banner    | 100         | FIXED |
#      | <Title> section all rails | 100         | FIXED |
#    Then Verify new section should be added
#    Given User create new page
#      | title           | key         | pageType |
#      | <Title> child 1 | <Key>Child1 | CHILD    |
#    Then User attach Sections and segment in page
#      | Sections                                          | Segment              |
#      | <Title> Feature Banner, <Title> section all rails | <segment>, <segment> |
#    Then Verify new "CHILD" page should be added
#    Given User create new page
#      | title   | key   | pageType |
#      | <Title> | <Key> | PARENT   |
#    Then User attach child page and segment in page
#      | Child Page      | Segment   | adapterKeys | isFallback |
#      | <Title> child 1 | <segment> | <Key>       | true       |
#    Then Verify new "PARENT" page should be added
#
#    Examples:
#      | Title       | Key        | segment                             |
#      | Search Page | searchPage | XSTREAM DEFAULT SEGMENT (Read Only) |

