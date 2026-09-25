# Agregador de Investimentos

API REST desenvolvida com **Java 21 e Spring Boot** para gerenciamento de investimentos em ações.

A aplicação permite cadastrar usuários, criar contas de investimento, cadastrar ações e associar ações e quantidades às contas.

Na consulta dos investimentos, a aplicação integra com a **BRAPI** para obter as cotações das ações e calcular o valor atual de cada posição com base na quantidade cadastrada.

## Tecnologias

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* OpenFeign
* Maven
* Docker Compose

## Arquitetura

A aplicação utiliza uma arquitetura em camadas, separando as responsabilidades entre:

* **Controller:** exposição dos endpoints REST;
* **Service:** implementação das regras de negócio;
* **Repository:** acesso e persistência dos dados;
* **Entity:** representação das entidades persistidas no banco de dados;
* **DTO:** objetos utilizados na comunicação da API.

A integração com a BRAPI é realizada através do **OpenFeign**.

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
MySQL

Service
    ↓
OpenFeign
    ↓
BRAPI
```

## Pré-requisitos

* Java 21
* Docker
* Docker Compose
* Token de acesso da BRAPI

## Configuração

### 1. Clone o repositório

```bash
git clone https://github.com/larissamenezs/agregador-investimentos.git
cd agregador-investimentos
```

### 2. Inicie o banco de dados

O projeto utiliza MySQL através do Docker Compose.

```bash
docker compose up -d
```

O banco será disponibilizado localmente na porta `3307` e utilizará o banco de dados `mydatabase`.

### 3. Configure o token da BRAPI

A aplicação utiliza a variável de ambiente `TOKEN` para autenticação na BRAPI.

**Windows / PowerShell:**

```powershell
$env:TOKEN="seu-token"
.\mvnw spring-boot:run
```

**Linux / macOS:**

```bash
export TOKEN="seu-token"
./mvnw spring-boot:run
```

A aplicação será iniciada em:

```text
http://localhost:8080
```

## Endpoints

### Usuários

| Método   | Endpoint             | Descrição                               |
| -------- | -------------------- | --------------------------------------- |
| `POST`   | `/v1/users`          | Cadastra um usuário                     |
| `GET`    | `/v1/users`          | Lista os usuários                       |
| `GET`    | `/v1/users/{userId}` | Consulta um usuário pelo ID             |
| `PUT`    | `/v1/users/{userId}` | Atualiza o nome de usuário e/ou a senha |
| `DELETE` | `/v1/users/{userId}` | Exclui um usuário                       |

### Contas de investimento

| Método | Endpoint                      | Descrição                      |
| ------ | ----------------------------- | ------------------------------ |
| `POST` | `/v1/users/{userId}/accounts` | Cria uma conta de investimento |
| `GET`  | `/v1/users/{userId}/accounts` | Lista as contas de um usuário  |

### Ações

| Método | Endpoint     | Descrição         |
| ------ | ------------ | ----------------- |
| `POST` | `/v1/stocks` | Cadastra uma ação |

### Ações de uma conta

| Método | Endpoint                          | Descrição                                 |
| ------ | --------------------------------- | ----------------------------------------- |
| `POST` | `/v1/accounts/{accountId}/stocks` | Associa uma ação e sua quantidade à conta |
| `GET`  | `/v1/accounts/{accountId}/stocks` | Lista as ações e consulta seus valores    |

## Testes

Os testes automatizados podem ser executados através do Maven Wrapper.

**Windows:**

```powershell
.\mvnw test
```

**Linux / macOS:**

```bash
./mvnw test
```

## Objetivo

Projeto desenvolvido para praticar conceitos de desenvolvimento backend com **Java e Spring Boot**, incluindo:

* Desenvolvimento de APIs REST;
* Arquitetura em camadas;
* Injeção de dependências;
* DTOs;
* Validação de dados;
* Persistência com JPA/Hibernate;
* Integração com MySQL;
* Integração com API externa utilizando OpenFeign;
* Testes automatizados;
* Docker para ambiente de desenvolvimento.
