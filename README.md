# Readme

### How to set up the application

* Run the following commands to build and start the application in docker

  ```mvn clean package```

  ```docker compose up --build -d```


* After a successful startup by default, the application endpoints are available via the following location

  ```http://localhost:8080/v1/user-details-service/users```:


* Run the following command to shut down the application

  ```docker compose down```


* The application can be tested by importing the ```postman_collection.json``` into postman
  which is part of the project root directory. The collection consists of three request definitions:
  * ```create user``` can be used to add new users
  * ```get users``` can be used to receive the list of created users
  * ```depersonalize user``` is used for depersonalizing user personal information
