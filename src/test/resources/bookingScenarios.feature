Feature: Test booking app

  Scenario: Create booking

    Given I hit booking app url
    When i enter valid booking details and submit
    Then the booking is successfully added


  Scenario: Delete booking

    Given i hit the booking app url
    When i delete my previous booking
    Then the booking is removed from the page