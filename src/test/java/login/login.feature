Feature: Login in the Vertrax System

  In order to login in the Vertrax  System
  As a user that's want to login un the System
  I want to be able to write username, pass and company

  Scenario Outline: Should login in the system with the correct credentials
    Given The login Page of the Vertrax System us open un the <environment>
    When I write <username> <password> and <company>
    Then The should open in the Dashboard Page
    Examples:
      | environment                          | username                  | password                  | company            |
      | "https://welltrax-alpha.vertrax.com" | "supportjupitertransport" | "supportjupitertransport" | "jupitertransport" |