### MoonActive automation functional tests

Automated functional tests for application MoonActive.


##### SetUp

1. Java
    1. download [java](https://java.com/en/download/)
    2. install java
    3. environment variable value:
        1. add variable $JAVA_HOME to the profile
        2. check java version in terminal -> run command `java -version`
    
2. Maven
    1. download [maven](https://maven.apache.org/)
    2. install maven
    3. environment variable value:
        1. add variables with maven location to the profile
        3. reopen terminal and run `mvn -v`

3. Appium
    1. download Appium and install
    2. set up Appium


##### Run Tests

1. open Appium and launch
2. connect device or start virtual device
3. go to the project in the terminal 
4. run command `mvn clean`
5. run command `mvn test`

**Additional information**

1. Framework for run tests - [TestNG](http://testng.org/doc/)
4. Framework for build automation project - [maven](https://maven.apache.org/)
3. Framework for build - [selenium](http://www.seleniumhq.org/docs/03_webdriver.jsp)
4. Framework for interpritea test on devises - [Appium](https://github.com/appium/appium-android-driver)
