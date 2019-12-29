# Retail Service

This utility is compiled to enable cashiers to identify and calculate the correct bill according to the customer type.

## Purpose
To facilitate the cash handlers

	
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them

```
* JDK 8+
* Maven
* GIT
```

### Installing

A step by step series of examples that tell you how to get a development env running

Clone the repository [retail-service](https://github.com/mudassirshahzad/retail-service.git) 

```
git clone https://github.com/mudassirshahzad/retail-service.git
```

Run a maven clean install on the root folder

```
mvn clean install
```


### Launch the jacoco test coverate report

- After a successful maven build, Jacoco test coverage report can be seen from the  `[Repo Root Folder]/target/site/jacoco/index.html` 



### SonarQube report

- The project is linked to [SonarCloud](https://sonarcloud.io/dashboard?id=mudassirshahzad_retail-service)
- To check the latest sonar cloud report, run the following command

```
mvn verify sonar:sonar
```

Note: Refresh the [SonarCloud](https://sonarcloud.io/dashboard?id=mudassirshahzad_retail-service) page to see the latest changes.


### Object Oriented Analysis - Class diagram

- The class diagram is available in the repository root folder by the name "RetailServiceClassDigram.drawio".
- This diagram was generated using online tool: [https://www.draw.io/](https://www.draw.io/)

### Assumptions
 - The items will be scanned individually at checkout time, the program expects an item list
 - The user will be asked for a barcode or the cash handler will enter the user type manually(possibly from a front end), the program expects a user object


### Team Members

* **Mudassir Shahzad** 	- *Initial work* 	- 	www.mudassirshahzad.com
