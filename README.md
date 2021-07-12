# WebDriver Cucumber Examples

## features
Look at the below directory to see the cucumber Gherkin feature files
/playground/src/test/resources/features

## utils
Several utility methods are available

com.kavinschool.examples.utils

## runner
Use runner classes to run any of the feature files

## hooks
Contains the driver setup

## props
The single system level values are passed

## steps
The step definitions of Gherkin feature files generated code 

## How to run?

To run from cmd line

```
mvn test
```

To generate a cucumber report:

```
mvn verify -Dmaven.test.skip=true
```
