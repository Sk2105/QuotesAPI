# Quotes DB

This is a simple API for a Quotes Database. It allows you to create, retrieve, update and delete quotes.

## Getting Started

1. Clone the repository(`git clone https://github.com/sk2105/quotes-api.git`)
2. Start the server(`mvn spring-boot:run`)
3. Run the tests

## API Endpoints

The API has the following endpoints:

- GET /quotes - Get all quotes

```bash
curl -X GET http://localhost:8080/quotes
    -H "Authorization: Bearer <token>"
```

- GET /quotes?author={author} - Get quotes by author

```bash
curl -X GET http://localhost:8080/quotes?author={author}
    -H "Authorization: Bearer <token>"
```

- GET /quotes?category={category} - Get quotes by category

```bash
curl -X GET http://localhost:8080/quotes?category={category}
    -H "Authorization: Bearer <token>"
```

- GET /quotes?author={author}&category={category} - Get quotes by author and category

```bash
curl -X GET http://localhost:8080/quotes?author={author}&category={category}
    -H "Authorization: Bearer <token>"
```

- GET /quotes?page={page}&size={size} - Get quotes by page and size

```bash
curl -X GET http://localhost:8080/quotes?page={page}&size={size}
    -H "Authorization: Bearer <token>"
```

- GET /quotes/{id} - Get a quote by ID

```bash
curl -X GET http://localhost:8080/quotes/{id}
    -H "Authorization: Bearer <token>"
 ```

- POST /quotes - Create a new quote

```bash
curl -X POST http://localhost:8080/quotes
    -H "Authorization: Bearer <token>"
    -H "Content-Type: application/json"
    -d '{"quote": "Quote text", "author": "Author name", "category": "Category name"}'
```

- DELETE /quotes/{id} - Delete a quote by ID

```bash
curl -X DELETE http://localhost:8080/quotes/{id}
    -H "Authorization: Bearer <token>"
```

- GET /auth/login - Login endpoint

```bash
curl -X POST http://localhost:8080/auth/login
    -H "Content-Type: application/json"
    -d '{"username": "username","email": "email", "password": "password"}'
```

- GET /auth/register - Register endpoint

```bash
curl -X POST http://localhost:8080/auth/register
    -H "Content-Type: application/json"
    -d '{"username": "username","email": "email", "password": "password"}'
```

## Security

The API uses JWT authentication for user authentication. The JWT token is stored in the `Authorization` header of the
request.

## Resources

- [Spring Boot](https://spring.io/projects/spring-boot) - A framework for building Spring applications
- [Spring Security](https://spring.io/projects/spring-security) - A framework for building secure applications
- [JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/) - JPA is a specification for
  object-relational mapping
- [Supabase](https://supabase.io/) - A cloud database for developers to build and run applications
- [Java JWT](https://github.com/auth0/java-jwt) - A Java library for encoding and decoding JWTs
- [Lombok](https://projectlombok.org/) - A code generation library for Java
- [Maven](https://maven.apache.org/) - A build automation tool

## My Message

Thanks💖 for using this API! If you have any questions or feedback, please don't hesitate to reach out to me on [GitHub](https://github.com/sk2105) or [LinkedIn](https://www.linkedin.com/in/sachin91/).



