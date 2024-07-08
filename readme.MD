<h1 align="center">
    Desafio Backend Magalu
</h1>

solução do desafio [backend Magalu](https://github.com/buildrun-tech/buildrun-desafio-backend-magalu/blob/main/problem.md)
## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Scheduler](https://spring.io/guides/gs/scheduling-tasks)



## Como Executar

- Clonar repositório git
```
git clone git@github.com:igorbarret0/magalu-challenge.git
```

- Construir o projeto:
```
./mvnw clean package
```


A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/)

-  NOTIFICATION
```
POST /notification - Salvar notificação

{
    "dateTime": "2024-07-08T14:55:00",
    "destination": "teste@email.com",
    "message": "welcome",
    "channel": "EMAIL"
}

```

```
GET /notification/{notificationId} - Consultar uma notificação 

```

```
DELETE /notification/{notificationId} - Cancelar notificação

```

