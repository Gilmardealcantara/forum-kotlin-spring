# API-kotlin-spring

# Topics
Web
    - Implemtação de GET, POST, PUT e DELETE
    - DTOs para representar as informações de input/output da API
    - Classes Mappers para conversão de DTOs
    - Validações utilizando o Bean Validation
    - Princípios do modelo REST
    - Tratamento de exceptions na API usando global handler
Data
    - Spring Data JPA
    - Flyway como ferramenta de migrations
    - Paginação e ordenação nas consultas
    - Cache
    - Queries personalizadas nas interfaces repository


# Requirements
    - java 11
    - maven ^3.8.1 

# Technologies
    - kotlin
    - spring 2.5.5
        - starter-web
        - starter-validation
        - starter-devtools
        - starter-test
        - starter-data-jpa
        - starter-cache
    - h2
    - flyway

# RUN
```
./mvnw clean install -DskipTests
./mvnw clean spring-boot: run
```

