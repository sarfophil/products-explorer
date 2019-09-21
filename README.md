# Products-explorer
Demo Elasticsearch project with Spring Boot

## Branches

Branch                                                              | Notes
--------------------------------------------------------------------|------------------
[master](https://github.com/sarfophil/products-explorer/tree/master)| Implementation to search and 																	adding products to elastic server.      


## Setting up
Ensure you have the following installed on your PC:
	
   - docker
   - docker-compose

## Getting Started

- Using Maven
```cmd
> mvnw clean spring-boot:run
```
- Using Docker
```cmd
> docker  compose up -d
```

## Assignment of Status codes

- `GET :: 200`
- `POST:: 202`

## Importing Postman Collection
- Select File > Import Postman Collection.
- In the Import Postman Collection dialog, click Browse and select the Postman collection to import.
