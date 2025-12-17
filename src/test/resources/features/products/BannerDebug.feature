Feature: Debug feature banner
  ->> Visual Skip
  ->> Slot based Visual Skip
  ->> Adds Slot Machine
  ->> Subscription Based reordering
  ->> Erotic content filter
  ->> UL Filter check

#  Svod 2.0 :- User Who can watch content which of external, Internal cp's with free contents
#  XPP/Svod :- User Who can watch content which of Internal cp's and free contents
# Free/Avod :- User Who can watch content which are free on our platform

  Scenario: When sports content tile is live then live content should be visible on top if the tile is placed on the 10 position.
  Scenario: When sports content tile is live and placed on the 10 position but we have one tile pinned on 1 position then sports tile should be visible on 2nd position.
  Scenario: When there are 2 contents live on banner and no pinned tile on top then both sports content should be visible on top in dec order of score.
  Scenario: When there are 2 contents live on banner and 2 pinned tile on top 1 and 3 then 1 sports content should be visible on 2 and second on 4 in dec order of score.
  Scenario: When there are 2 contents live on banner and 1 pinned tile on top 2nd position then 1 sports content should be visible on 1 and second on 3 in dec order of score.
  Scenario: When there are no contents live on banner and 2 pinned tile on top 1 and 3 but upcoming live content placed on 5 position then content should not be visible on bunner until live.

  Scenario: When user is Avod user and 2 contents are pinned 1,3 and 1 sports content then 1,3 is pinned content 2 is sports content 3 content from AVod and 1 content form (SVOD and SVOD 2.0).
  Scenario: When user is XPP/Svod 1.0 user and 2 contents are pinned 1,3 and 1 sports content then 1,3 is pinned content 2 is sports content then other 4 content from AVod + Svod (playable).
  Scenario: When user is Svod 2.0 user and 2 contents are pinned 1,3 and 1 sports content then 1,3 is pinned and content 2 is sports content then other 3 content from Svod 2.0 and other 1 content is from (SVOD + Avod).

  Scenario: When user is Svod 2.0 user then 3 content from Svod 2.0 and 3 content form (SVOD + Avod).
  Scenario: When user is XPP/Svod 1.0 user then 5 content from AVod + Svod and 1 content form (SVOD 2.0).
  Scenario: When user is Avod user then 3 content from AVod and 3 content form (SVOD and SVOD 2.0).

  Scenario: No erotic content should be present in the response.
  Scenario: All content should be from User languages.
  Scenario: Verify visual skip in hybrid banner.
  Scenario: Verify slot based visual skip in hybrid banner.
