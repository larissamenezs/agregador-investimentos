# Agregador de Investimentos

API REST para organizar investimentos em ações. A aplicação permite cadastrar usuários, criar contas de investimento para cada usuário, registrar ações e suas respectivas quantidades e consultar os investimentos associados a uma conta.

Na consulta de uma conta, a aplicação busca as cotações das ações na **BRAPI**, uma API externa que fornece dados do mercado financeiro. Com a cotação retornada e a quantidade registrada, calcula e apresenta o valor de cada posição.

## Tecnologias

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- OpenFeign
- Maven
- Docker Compose

## Pré-requisitos

- Java 21
- Docker e Docker Compose
- Token de acesso à BRAPI

## Configuração

Inicie o MySQL com Docker Compose:

```bash
docker compose up -d
```

O banco será criado na porta `3307`, com o nome `mydatabase`.

Configure a variável de ambiente `TOKEN` com seu token da BRAPI antes de iniciar a aplicação.

No PowerShell:

```powershell
$env:TOKEN="seu-token"
.\mvnw spring-boot:run
```

No Linux ou macOS:

```bash
export TOKEN="seu-token"
./mvnw spring-boot:run
```

A aplicação será iniciada localmente e estará disponível em `http://localhost:8080`.

## Endpoints

### Usuários

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/v1/users` | Cadastra um usuário |
| `GET` | `/v1/users` | Lista os usuários |
| `GET` | `/v1/users/{userId}` | Consulta um usuário pelo ID |
| `PUT` | `/v1/users/{userId}` | Atualiza o nome de usuário e/ou a senha |
| `DELETE` | `/v1/users/{userId}` | Exclui um usuário |

### Contas de investimento

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/v1/users/{userId}/accounts` | Cria uma conta de investimento para um usuário |
| `GET` | `/v1/users/{userId}/accounts` | Lista as contas do usuário |

### Ações

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/v1/stocks` | Cadastra uma ação |

### Ações associadas a uma conta

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/v1/accounts/{accountId}/stocks` | Associa uma ação e uma quantidade à conta |
| `GET` | `/v1/accounts/{accountId}/stocks` | Lista as ações da conta e consulta seus valores |

## Executar os testes

```bash
.\mvnw test
```
