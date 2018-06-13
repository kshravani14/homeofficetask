-------------------------------------
HOME OFFICE - QA TECHNICAL TASK
-------------------------------------

Selenium Web driver and Java. (Optional Cucumber)

- Open etsy.com

- Search for sports shoes

- Select one of the suggested options while you type

- Om search page sort by price

- print the prices of top 10 items.


Use necessary assumption. Recommended to use some abstraction techniques like Page Objects.

----------------
HOW TO RUN TESTS
----------------

Test can be run 3 ways

1) mvn clean test
if we need to run specific tests then we can pass that parameter as mvn clean test -Dtag=@search

2) By running the cukes runner we can run the tests ( Project has RunTest.java which can be runned in IDE to run test)

3) If we have any IDE we can run the tests from the feature file at scenario level or feature level

Make sure browser is installed on the machine either chrome or firefox.

-----------------
NOTE
----------------

By default all test are configured to run for chrome browser but if we need to run the test against firefox then a vm
parameter needed passing i.e. -Dbrowser=firefox in any of the above execution

----------------------------------
BROWSER DRIVER PATH NEEDS PROVIDED
----------------------------------

As part of the latest webdriver implementation a separate executable for each driver is provided for selenium test which
needs to be put in class path, in order to simplfy that we have a config file in the project just provide the driver
paths in the project according to your machine and save the config file in the project before running the tests.

The drivers needed for tsets are

Chrome browser <=> Chromedriver (https://sites.google.com/a/chromium.org/chromedriver/downloads)

Firefox browser <=> Ghekodriver (https://github.com/mozilla/geckodriver/releases)


-----------------------------------
SAMPLE RESULTS
-----------------------------------

I have executed test scenario and it has passed it printed below results to the command prompt as

<=======================================================================>



Item Desc: Vintage OG 80s Nike Bruin <=> Item Cost: 723.53<br/>
Item Desc: Original 1985 Nike Air Jo <=> Item Cost: 655.75
Item Desc: Custom Nike Air Max Shoes <=> Item Cost: 617.90
Item Desc: Custom Nike Air Max Shoes <=> Item Cost: 617.90
Item Desc: Nike Air Jordan Shirt Vin <=> Item Cost: 570.02
Item Desc: Custom Primary Check OLD  <=> Item Cost: 540.66
Item Desc: Custom Vans SK8-HI ,Swaro <=> Item Cost: 540.66
Item Desc: Custom Primary Check OLD  <=> Item Cost: 540.66
Item Desc: Custom Primary Check OLD  <=> Item Cost: 540.66
Item Desc: Custom OLD SKOOL SHOES Va <=> Item Cost: 540.66


<=======================================================================>
