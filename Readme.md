<h3 align="left"> How To Run </h3>

- Clone the project and navigate to `Task1` directory

Run the following command

~~~
docker compose -f docker.yml up
~~~

There are two ways to run the tests

~~~
Run command `mvn test`
~~~

OR
- Right click on `testing.xml` and select run as TestNG



<h3 align="left"> Reporting </h3>

In case you used the first way to run the project you will find the `emailable-report` under target -> surefire-reports -> emailable-report.html

If you used the other way you will see a `test-output` folder in the root directory which will contain the same report

You can also view errorScreenshots which will be in the root directory (Please note that the same screenshots will also be available in the report)

The data files generated from HomePageTests will be under src -> resources -> excelfiles



<h3 align="left"> Project Structure </h3>

The `src` folder contains all packages related to the tests

Basic POM design has been followed. The base package has the driver class.
pageObjects holds class for homepage and loginPage. Tests package has all the tests.

Resources package has `config.properties` file which has `baseURL` and other properties.
It also has `Constants.java` which has data that is used throughout the projects. Endpoints, errorMessages and standardTimeOut etc

Utilities package has all helpers required like `ExcelUtil`, `DataProvider` and `TestListener`

