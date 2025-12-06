Feature: Suggested downloads
  - This product is used to suggest the user to download more according to their download and most played songs
  - This service takes "MOST_PLAYED_SONG" and "DOWNLOAD_SONGS" for a user and find the common song
  - And Find 5 similar songs for those common songs and return the list of 30 songs

#  Scenario: Verify content should be same in suggest_downloads::1 from  SUGGEST_DOWNLOADS_SIMILAR_SONG
#    Given User get suggested download from pothunter
#      | similarContent                 | sources | userId             | languages | enableRplClustering | useSkippedSimilarSong | userMostPlayedSimilarSong | rplSizeCutoff | skippedSizeCutoff | rplModuleSizeCutoff | rplTimestampCutoff | skippedTimestampCutoff | rplModuleTimestampCutoff | rplModuleCollectionIdExclusion | candidateEligibilityCutoff | removeSourceContentInSimilarSongResponse | evaluateCandidate |
#      | SUGGEST_DOWNLOADS_SIMILAR_SONG |         | vGSTfgdMtg7bfWGG60 | hi, en    | false               | true                  | true                      | 30            | 10                | 1                   | 259200000          | 259200000              | 259200000                |                                | 20                         | true                                     | false             |
#    And User get suggested download from the collection
#    Then verify content should be same
#
#  Scenario: Similar songs of DOWNLOAD_SONGS and MOST_PLAYED_SONG should be in the SUGGEST_DOWNLOADS_SIMILAR_SONG
#    Given User get suggested download from pothunter
#      | similarContent | sources                          | userId             | languages | enableRplClustering | useSkippedSimilarSong | userMostPlayedSimilarSong | rplSizeCutoff | skippedSizeCutoff | rplModuleSizeCutoff | rplTimestampCutoff | skippedTimestampCutoff | rplModuleTimestampCutoff | rplModuleCollectionIdExclusion | candidateEligibilityCutoff | removeSourceContentInSimilarSongResponse | evaluateCandidate |
#      |                | DOWNLOAD_SONGS, MOST_PLAYED_SONG | vGSTfgdMtg7bfWGG60 | hi, en    |                     | true                  | true                      |               |                   |                     |                    |                        |                          |                                |                            | true                                     | false             |
#    And Find similar song of common songs in DOWNLOAD_SONGS and MOST_PLAYED_SONG
#    And User get suggested download from the collection
#    Then Verify similar songs should be in suggested download collection
