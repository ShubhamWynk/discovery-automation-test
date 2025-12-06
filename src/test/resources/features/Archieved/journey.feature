Feature: Zion Journey

#Operators :- EQ, NIN, IN, NEQ, REGEX
#Attribute :- common__usertype__daily, user_id
#Combinator:- AND, OR

#  Scenario: create segment
#    Given User create segment "Automated tested Segment"
#      | Attribute               | Operator | Attribute Value    | combinator |
#      | common__usertype__daily | EQ       | prepaid            | AND        |
#      | user_id                 | EQ       | MOdGE8JM3IvRVcZSE0 |            |
#      | user_id                 | EQ       | wRwSgauWpyqHxx1Uf0 | OR         |
#    Then Verify segment should be added
#
#  Scenario: create New tile
#    Given User create new tile with "MUSIC DEFAULT SEGMENT (Read Only)-de-variant 1" segment
#      | displayTitle      | title             | entity     | aspectRatio | deepLink       |
#      | shubham test tile | shubham test tile | LOCAL_TILE | RECTANGULAR | www.google.com |
#    And for "India" regions and "jpgtopngconverter-com (1).jpg" File
#    Then User hit tile create api
#
#  Scenario: create custom rail
#    Given User create new custom rail
#      | category            | title             | type   |
#      | FEATURED_COLLECTION | shubham test tile | STATIC |
#    And For "hi" Language and "India" regions
#    And User update collection by these tiles
#      | Tiles               |
#      | shubham test tile 2 |
#      | shubham test tile   |
#    Then User update Collection status
#      | status    | userId                |
#      | PUBLISHED | shubham.gupta@wynk.in |
#
#  Scenario: create playlist collection
#    Given User create new custom rail
#      | category | title             | type   | description                  | subtitle | userId                |
#      | PLAYLIST | shubham test tile | STATIC | Shubham create this playlist |          | shubham.gupta@wynk.in |
#    And For "electronic, sad, diwali" tags
#    And For "hi" Language and "India" regions
#    Then User add songs in the collection
#      | songs                 | language |
#      | Can't Stop Won't Stop | en       |
#    Then User add artworks
#      | file | type         | availableFrom | availableTill |
#      |      | COLLECTION   |               |               |
#      |      | BANNER       |               |               |
#      |      | NOTIFICATION |               |               |
#    Then User add timelines
#      | availableFrom | availableTill | refreshFrequencyDayOfWeek | refreshFrequencyDay |
#      | 12/09/2023    | 13/09/2023    |                           |                     |
#    Then User update Collection status
#      | status    | userId                |
#      | PUBLISHED | shubham.gupta@wynk.in |

