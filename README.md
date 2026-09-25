# API da Plataforma Financeira

Uma API REST feita com Spring Boot para gestão de finanças pessoais. O sistema gerencia a autenticação de usuários, contas, lançamento de transações e configuração de limites mensais por categoria.

## Arquitetura

O sistema utiliza uma arquitetura em camadas padrão do Java com Spring Boot.

- Controllers - Recebem as requisições HTTP e definem as rotas (usuários, contas, categorias e transações)
- Services - Contêm a regra de negócio, como a validação de limites e criptografia de senhas
- Repositories - Fazem a comunicação com o banco de dados usando Spring Data JPA
- DTOs - Objetos de transferência para validar as requisições e respostas
- Models - Entidades mapeadas para as tabelas do banco de dados

## Estrutura do Projeto

```text
financial-platform_/
├── src/
│   ├── main/java/com/app/financial_platform/
│   │   ├── controller/    # Endpoints da API REST
│   │   ├── service/       # Lógica de negócio
│   │   ├── repository/    # Acesso a dados
│   │   ├── dto/           # DTOs e validações (Jakarta)
│   │   ├── model/         # Entidades JPA
│   │   └── exception/     # Tratamento global de erros
│   └── main/resources/
│       └── application.properties # Credenciais e configurações
```

## Pré-requisitos

- Java 17 ou superior
- Maven
- PostgreSQL rodando localmente

## Instalação

Crie o banco de dados e o usuário no PostgreSQL antes de iniciar a aplicação:

```sql
CREATE DATABASE financial_platform;
CREATE USER bank_local WITH PASSWORD 'postgres';
GRANT ALL PRIVILEGES ON DATABASE financial_platform TO bank_local;
```

Para rodar a aplicação, execute:

```bash
./mvnw spring-boot:run
```

O servidor será iniciado na porta 8081.

## Uso

A API fornece os seguintes recursos principais:

- `POST /users` - Cadastra um novo usuário
- `POST /users/login` - Autentica o usuário no sistema
- `POST /transactions` - Cria um novo lançamento financeiro vinculado à conta do usuário
- `PATCH /categories/{id}/limit` - Atualiza o limite mensal de gastos de uma categoria

A classe `DatabaseSeeder` popula automaticamente o banco de dados com as categorias padrão quando a aplicação sobe pela primeira vez.
