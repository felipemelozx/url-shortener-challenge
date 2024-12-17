## Url shortener


This project was a solution to the challenge proposed on [GitHub repository](https://github.com/backend-br/desafios/blob/master/url-shortener/PROBLEM.md), where the goal was to create a service that would
return a shortened URL based on a URL provided by the user, thus giving you a shorter URL.
## Technology

Here are the technologies used in this project:

* Java version 17.0.0
* Spring Boot 3.4.0
* H2 database


## Dependencies

* Spring Boot Starters
    - spring-boot-starter-web
    - spring-data-jpa
    - h2-database
    - spring-boot-starter-test (scope test)

## Getting Started

### Pre-requisites

- Java 17
- Maven

### Build and Run

1. Clone the repository:
    ```bash
    git clone https://github.com/felipemelozx/url-shortener-challenge
    cd ./url-shortener-challenge
    ```

2. Build the project:
    ```bash
    mvn clean install
    ```
3. Run the project:
    ```bash
    mvn spring-boot:run
    ```

4. Access the application at `http://localhost:8080/shorten-url`

## Routes
- ####  Make a POST on the route return your short url.
- POST `http://localhost:8080/shorten-url`
- Body👇
 ```json
{
  "url": "https://backendbrasil.com.br"
}
```

## Links

- Repository: https://github.com/felipemelozx/url-shortener-challenge

## Versioning

0.0.1-SNAPSHOT

## Authors

* **Felipe Melo**

Please follow GitHub and join us! Thanks for visiting and happy coding!
