Feature: migration Xstream
  - This script is use to migrate old Xstream page to new Xstream page, migrate these template
  - X_MOVIE_NOLOGO -> X_MASTER_RAIL
  - X_TVSHOW_NOLOGO_169 -> X_MASTER_RAIL
  - X_TVSHOW_BIG_43 -> X_MASTER_RAIL
  - Content Partner Rail -> X_Content_Partner_Rail_V2
  - X_BANNER -> X_INFINITY_BANNER
  - X_TVSHOW_LOGO_43 -> X_LIVE_TVCHANNELS
  - And other template should be migrated as it is.

#  Scenario: Migration of data for XStream app
#    Given Start Position 1
#    And User fetch sections from "PC Shorts TV" page - "PC Shorts TV_child_1" child Page and "PC-ShortsTV Section 1" section
#    And create modules for section and attach to "PC Shorts TV" page - "PC SHORTSTV child 2" child Page and "PC-ShortsTV Section 1 new" section
#    Then validate data should be migrated