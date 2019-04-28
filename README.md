# Stylelabs Assignment

This is a Stylelabs assignment. To run the feature test you need to do following setup-

Clone a repository using https or ssh
```bash
https: git clone https://github.com/vikrantkhemkar/StylelabsAssignment.git
or
ssh:git clone ssh:git@github.com:vikrantkhemkar/StylelabsAssignment.git
```
Install dependancies on local machine
```bash
mvn install
```
You can open project in eclipse and run a feature file or you can also execute from command prompt
```bash
In Eclipse, Right click on feature file > Run as > cucumber feature
or
mvn clean test -Dcucumber.options="features"
```

To run all features in one go
```bash
Open TestRun.java file and run as junit test
```
For running https://openweathermap.org/api set the environmental variable
```bash
export APPID=<API Key issued by Open weather API>  
```
If you are getting 401 even after setting environmental variable, please environmental variable in project run configuration.
