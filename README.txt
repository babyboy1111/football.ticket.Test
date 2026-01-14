 commons/              # Base classes for WebDriver and reusable methods
 pageObjects/          # Page Object classes (HomePage, TicketPage)
 pageUIs/              # UI locators for each page
 utilities/            # Helper classes (e.g., logging, config)
 reportConfigs/        # Reporting setup (e.g., ExtentReports)
 resources/                # Config files (e.g., log4j2.xml, properties)

  test/ java/
    com.footballticket.testcase/  # Test classes (TC_Test, TC_02_TicketPurchaseFlow)
    resources/
         testing.properties     # Environment configs
         testing.xml            # TestNG suite configuration
**** Due to limit of time, this is all I can do. If I had more time here are the things that can be add to the framework : Test Data Management,
Assertions & Validation ,Error Handling ,  Screenshot , Wait utility , Cucumber....



        - Install dependencies:
        mvn clean install
        - Run tests: ( or click run/debug if you use Intellij)
        mvn test -DsuiteXmlFile=testing.xml
        - To run with different browsers: Update browser parameter in testing.xml:
        <parameter name="browser" value="chrome"/>



  Test Scenario
  1. 	Navigate to the Champions League Final 2025 page.
  2. 	Click the Buy Now button (opens ticket page in a new tab).
  3. 	Switch to the new tab and click Buy on the ticket page.
  4. 	Verify redirection to the checkout page.



