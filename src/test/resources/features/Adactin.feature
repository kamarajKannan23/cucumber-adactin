Feature: Verify Adactin Hotel booking deatils

  Scenario Outline: Verify Adactin Hotel booking deatils with orderId
    Given User is on the Adactin Hotel Page
    When User should login "<username>" and "<password>"
    And User should verify success msg
    And User should search hotel "<location>", "<hotels>" , "<room Type>" , "<number of Rooms>" , "<check In Date>" ,"<check Out Date>" ,"<adults per Room>" and "<children per Room>"
    And User should select hotel
    And User should book hotel "<first_name>","<last_name>","<address>","<Credit Card No>","<Credit Card Type>","<Expiry Month>","<Expiry Year>" and "<CVV Number>"
    Then User should verify order id

    Examples: 
      | username | password | location    | hotels         | room Type    | number of Rooms | check In Date | check Out Date | adults per Room | children per Room | first_name | last_name | address | Credit Card No      | Credit Card Type | Expiry Month | Expiry Year | CVV Number |
      | Kamal001 | Pass@123 | Los Angeles | Hotel Sunshine | Super Deluxe |               2 | 20/08/2022    | 22/08/2022     | 2 - Two         | 1 - One           | Kamal      | Raj       | Chennai | 4547 1929 0010 9165 | VISA             | June         |        2016 |        211 |
      | Kamal001 | Pass@123 | Sydney      | Hotel Hervey   | Standard     |               1 | 21/08/2022    | 22/08/2022     | 1 - One         | 0 - None          | Kamal      | Raj       | Chennai | 4547 1929 0010 9165 | VISA             | June         |        2016 |        211 |
      | Kamal001 | Pass@123 | New York    | Hotel Creek    | Standard     |               3 | 22/08/2022    | 23/08/2022     | 2 - Two         | 1 - One           | Kamal      | Raj       | Chennai | 4547 1929 0010 9165 | VISA             | June         |        2016 |        211 |
      | Kamal001 | Pass@123 | London      | Hotel Sunshine | Double       |               4 | 23/09/2022    | 24/09/2022     | 2 - Two         | 2 - Two           | Kamal      | Raj       | Chennai | 4547 1929 0010 9165 | VISA             | June         |        2016 |        211 |
      | Kamal001 | Pass@123 | Adelaide    | Hotel Hervey   | Super Deluxe |               1 | 23/08/2022    | 25/08/2022     | 1 - One         | 0 - None          | Kamal      | Raj       | Chennai | 4547 1929 0010 9165 | VISA             | June         |        2016 |        211 |
      | Kamal001 | Pass@123 | Los Angeles | Hotel Creek    | Deluxe       |               2 | 21/08/2022    | 23/08/2022     | 2 - Two         | 1 - One           | Kamal      | Raj       | Chennai | 4547 1929 0010 9165 | VISA             | June         |        2016 |        211 |
      | Kamal001 | Pass@123 | New York    | Hotel Sunshine | Super Deluxe |               3 | 25/08/2022    | 27/08/2022     | 2 - Two         | 1 - One           | Kamal      | Raj       | Chennai | 4547 1929 0010 9165 | VISA             | June         |        2016 |        211 |
      | Kamal001 | Pass@123 | London      | Hotel Cornice  | Deluxe       |               5 | 20/08/2022    | 21/08/2022     | 3 - Three       | 1 - One           | Kamal      | Raj       | Chennai | 4547 1929 0010 9165 | VISA             | June         |        2016 |        211 |
      | Kamal001 | Pass@123 | Paris       | Hotel Creek    | Double       |               6 | 22/08/2022    | 24/08/2022     | 3 - Three       | 2 - Two           | Kamal      | Raj       | Chennai | 4547 1929 0010 9165 | VISA             | June         |        2016 |        211 |
      | Kamal001 | Pass@123 | Paris       | Hotel Cornice  | Double       |               7 | 20/08/2022    | 23/08/2022     | 3 - Three       | 2 - Two           | Kamal      | Raj       | Chennai | 4547 1929 0010 9165 | VISA             | June         |        2016 |        211 |
