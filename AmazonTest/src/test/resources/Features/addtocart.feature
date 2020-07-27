Feature: Shooping Cart Functionality

  Scenario Outline: Check Successfully added to Cart
    Given User is in Amazon Page
    And User search the <item> to search box
    When the <item> displayed
    And user choose/select the <item>
    And user click the Add To Cart button
    Then user click the Cart Icon
    And check if the selected <item> was added

    Examples: 
      | item                                       |
      | Echo Dot (3rd Gen) Charcoal with Echo Auto |
      | Dell XPS 9300                              |

  Scenario Outline: Searching Any Product filter by number of stars and brand
    Given User is in Amazon Page
    And User search the <item> to search box
    And filter by number of <stars>
    And filter product by <brand>

    Examples: 
      | item   | stars | brand   |
      | laptop |     1 | Acer    |
      | laptop |     4 | Dell    |
      | laptop |     3 | Samsung |
      | laptop |     2 | HP      |

  Scenario Outline: Check Successfully added to Cart via Category
    Given User is in Amazon Page
    And navigate to Shop by category menu
    And user choose/select the <item>
    When the <item> displayed
    And user click the Add To Cart button
    Then user click the Cart Icon
    And check if the selected <item> was added

    Examples: 
      | item        |
      | Echo Show 5 |
      | Echo Show 8 |

  Scenario: Close Session
    Given Close Session
