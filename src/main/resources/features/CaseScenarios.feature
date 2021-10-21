Feature: Case Scenarios
  Scenario: Credit card api quantity check
    When get "/api/v1/credit_cards?_quantity=12"
    Then status code should be return 200 ok
    And response body total field should be 12
    And response body data field list size should be 12

  Scenario: Text api field check
    When get "/api/v1/texts?_quantity=1"
    Then status code should be return 200 ok
    And title field is not null
    And author field is not null
    And genre field is not null
    And content field is not null

  Scenario: Text api content field character size 0 check
    When get "/api/v1/texts?_quantity=1&_characters=0"
    Then status code should be return 200 ok
    And  content field should be contains 0 character

  Scenario: Text api content field character size 200 check
    When get "/api/v1/texts?_quantity=1&_characters=200"
    Then status code should be return 200 ok
    And content field should be contains 200 character

  Scenario: Text api content field character size 500 check
    When get "/api/v1/texts?_quantity=1&_characters=500"
    Then status code should be return 200 ok
    And content field should be contains 500 character

  Scenario: Text api custom content check
    When get "/api/v1/custom?_quantity=1&name=name&lmd=dateTime&phone=phone&description=text"
    Then status code should be return 200 ok
    Then custom fields should not be null



