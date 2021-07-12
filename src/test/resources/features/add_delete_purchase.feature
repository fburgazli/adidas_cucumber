Feature: Adidas add/delete/purchase an item feature

  Scenario: Adding an item to the cart
    Given Customer is on home page
    When Customer navigates to Laptop category
    And Customer clicks on Sony vaio i5
    Then Customer clicks on Add to cart and accepts pop up confirmation

  Scenario:
    Given Customer is on home page
    When Customer navigates to Laptop category
    And Customer clicks on Dell i7 8gb
    Then Customer clicks on Add to cart and accepts pop up confirmation

  Scenario:
    Given Customer navigates to Cart
    And Customer deletes Dell i7 8gb
    When Customer clicks on Place order
    And Customer fills in all web forms
    And Customer clicks on Purchase
    Then Verify the purchase amount equals expected total price.