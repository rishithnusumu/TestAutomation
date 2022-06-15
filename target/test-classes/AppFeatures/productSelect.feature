Feature: Product Selection feature

  Scenario: select highest price product and add to Card
    Given User is on MyStore Page
    When user click on Dresses Tab
    And select highest priced product and add to cart
    Then product should added to Cart and get Success Message

