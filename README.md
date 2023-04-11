# loans

A sample loan app for pezesha technical test.

## Prerequisites

1. MySQL running locally on port 3306.
2. [JDK version 17](https://www.oracle.com/ke/java/technologies/downloads/#java17).
3. A Rest client like [postman](https://www.postman.com/downloads/) or [insomnia](https://insomnia.rest/download) to test the rest endpoint.
4. [git](https://git-scm.com/downloads) if using unix based machine or [git-bash](https://gitforwindows.org/) if on windows.
5. [maven](#) version ........

## How to sun the application
##### Clone the repository

```git clone https://github.com/chess254/loans.git```

##### open your terminal and navigate to the cloned folder

``cd loans``

##### Edit the application.properties file in ```loans/src/main/resources``` and provide values for 
```agsl
spring.datasource.url=jdbc:mysql://<host>:<port>/<database_name>
spring.datasource.username=<database_username>
spring.datasource.password=<database_user_password>
```
##### substitute 
```
<host> (the url in which the mysql database is running locally)
<port> (port in which db is listening)
<database_username> ( username to the database)
<database_user_password (password for the database)> 

```

#### NB: Make sure the database is running on the host and port configured above before continuing to the following steps and localhost port 8080 is open.

##### clean and install the dependencies using maven
```mvn clean``` (on unix based) or ``` .\mvnw clean ``` (on windows)
 then 

```mvn install``` () or ```.\mvnw install``` to add the projects dependencies using maven and run the tests.

Run ```mvn spring-boot:run``` (unix based ) or ```.\mvnw spring-boot:run``` (on windows)
This will seed the database with initial dummy data from file ```loans/src/main/resources/schema.sql``` and start the application.


## Task: 1   A simple money transfer REST API

### Endpoints

#### 1. To add a new account
``` 
 POST 
 localhost:8080/accounts
```

  sample JSON payload: Must be positive
```json
{"deposit":  950998}
 ``` 

#### 2.  To retrieve all accounts.

``` 
 GET 
 localhost:8080/accounts
```

#### 3.  To retrieve account information by id.  

``` 
 GET 
 localhost:8080/accounts/{id}
```

#### 4.  To transfer money from one account to another.
```                                       
POST                                     
localhost:8080/transfers
```                                       
                                          
The fields sourceAccountId & destinationAccountId must be valid accounts in the database and amount should be greater than zero.
source account must have sufficient balance fot transfer to be successful.

sample JSON payload:
```json                                   
{
  "sourceAccountId" : 1,
  "destinationAccountId" : 2,
  "amount" : 500
}
 ```

## Task: 2  loan repayment calculator

####  In a web browser navigate to the http://localhost:8080/form to display form that takes in input values. Fill in the form and submit to display a table showing the breakdown of the loan repayments over the loan term.
#### or
#### Alternatively you can use the following endpoints that return the data in JSON format:

#### 
``` 
 POST 
 localhost:8080/calculate
```

sample JSON payload: Must be positive. The value for repaymentFrequency is; 

0 for monthly, 

1 for bi monthly 

or 2 for Weekly.
```json
{
 "loanAmount" :100,
 "loanTermMonths" : 2,
 "interestRate" : 10,
 "repaymentFrequency" : 1
}
 ``` 
sample JSON response: 
```json
{
 "loanAmount": 100.0,
 "loanTermMonths": 2,
 "interestRate": 10.0,
 "repaymentFrequency": "BIMONTHLY",
 "repayments": [
  {
   "month": 1,
   "paymentAmount": 51.25,
   "principal": 49.59,
   "interest": 1.67,
   "balance": 50.41
  },
  {
   "month": 2,
   "paymentAmount": 51.25,
   "principal": 50.41,
   "interest": 0.84,
   "balance": 0.0
  }
 ],
 "totalPaymentAmount": 102.5,
 "totalPrincipal": 100.0,
 "totalInterest": 2.51
}
 ``` 
