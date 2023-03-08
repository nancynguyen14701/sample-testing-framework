# *** Sample Automation Framework ***

## 1. Description: 
This is a personal project that I build up based on my experience working with different testing automation frameworks. I would like to summarise and review my knowledge by creating a standard testing framework.

## 2. Project info: 
Programming language: Java

Dependency manager: Maven

Version control: Git

Testing tools: TestNG + Selenium WebDriver

Report tools: Allure

Build tool (CI/CD): Jenkins

Design pattern: Page Object Model, Page Factory

## 3. How to run test:

cd <project directory> and type one of following command lines:

> mvn test -Dbrowser=chrome

> mvn test -PChromeAutomation -Dbrowser=chrome

> mvn test -Dbrowser=chrome -DsuiteXmlFile=testng.xml


