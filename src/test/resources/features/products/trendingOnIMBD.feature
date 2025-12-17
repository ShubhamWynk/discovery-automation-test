Feature: Trending On IMBD

  Scenario: Var1| Pure Global ranking basis contents with de-duplication and removal of erotic contents,no RR.
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
    When Fetch content from arsenal collection "axaut_2wnt20281760425945509"
    Then Verify content should be sort in "" order of ""
    And Verify content should be deduped
    And Verify no erotic content should be present in the response

  Scenario: Var2| Global ranking basis contents with users languages filter(dom+ sig + USL), No RR.
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
    When Fetch content from arsenal collection "axaut_2wnt20281760425945509"
    Then Verify content should be reranked by users languages in "" order
    And Verify content should be sort in "" order of ""
    And Verify content should be deduped
    And Verify no erotic content should be present in the response

  Scenario: Var3| Global ranking basis contents with users languages filter(dom+ sig+USL), languages RR.
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
    When Fetch content from arsenal collection "axaut_2wnt20281760425945509"
    Then Verify content should be reranked by users languages in ""
    And Verify content should be sort in "" order of "" order
    And Verify content should be deduped
    And Verify no erotic content should be present in the response

  Scenario: Var4| Languages top ranked contents filtered by users languages filter(dom+ sig+USL), languages RR.
    Given We are using "PX_r7GPUCo1kqaICY0" as a Xstream user
    When Fetch content from arsenal collection "axaut_2wnt20281760425945509"
    Then Verify content should be reranked by users languages in ""
    And Verify content should be sort in "" order of "" order
    And Verify content should be deduped
    And Verify no erotic content should be present in the response
