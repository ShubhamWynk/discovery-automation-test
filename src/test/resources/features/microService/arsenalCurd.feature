Feature: Arsenal-Crud
  ** Collection Type -> **
  1. Static Collection :- collection of content :- manually curated by curators
  2. Automated Collection(Automated) :- collection of content :- dynamically populated based on rules/algorithms from downstream apis
  3. Auto_static Collection : - collection of content :-  manually curated by curators, But rearrange by downstream apis postprocessor

  **Collection Sub Type -> **
  1. Merger Collection -> collection of collection :-
     Return merged Contents form different collections in Merger Collection :- eg.  New Release
  2. generic collection :- collection of content :- eg.  continue watching, because you watched, trending now
  3. feature collection :- tiles :- banner
  4. Collection of collections :- pill collection rail

  ** Collection Status -> **
    1. Draft :- collection is in draft state
    2. Published :- collection is live on app
    3. Archived :- collection is archived

  When User Edit the collection, status will be changed to Published to Archived and one new draft will be created
  with status Draft with new documentId.
    ** Operations on Collection -> **
        1. Create Collection
        2. Update Collection
        3. Get Collection
        4. Delete Collection - Can delete only Draft Collection permanently

  Scenario: Get collection using valid collectionId
  Scenario: Get collection using invalid collectionId

  Scenario: Create Static Collection with valid inputs
  Scenario: Create Automated Collection with valid inputs
  Scenario: Create Auto_static Collection with valid inputs
  Scenario: Create Merger Collection with valid inputs
  Scenario: Create Feature Collection with valid inputs

  Scenario: Update Static Collection with valid inputs
  Scenario: Update Automated Collection with valid inputs
  Scenario: Update Auto_static Collection with valid inputs
  Scenario: Update Merger Collection with valid inputs
  Scenario: Update Feature Collection with valid inputs

  Scenario: Verify can delete Draft collection Permanently
  Scenario: Verify cannot delete Published collection Permanently
  Scenario: Verify User can publish Draft collection
  Scenario: Verify User can publish Archived collection
  Scenario: Verify cannot publish Published collection
  Scenario: Verify User can archive Published collection when editing collection
  Scenario: Verify cannot archive Draft collection
  Scenario: Verify cannot archive Archived collection
  Scenario: Verify cannot create collection with invalid inputs
  Scenario: Verify cannot update collection with invalid inputs
  Scenario: Verify cannot create Merger collection with invalid sub-collectionIds
  Scenario: Verify cannot update Merger collection with invalid sub-collectionIds
  Scenario: Verify language of Contents in hybrid collection should be as usl of user
  Scenario: Verify fetch only published version of collection using serving api








  
