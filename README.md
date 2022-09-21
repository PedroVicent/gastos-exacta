# Projeto Exacta (Controle de gastos)

Projeto proposto pela empresa ExactaWorks para teste de conhecimento técnico.

# Objetivo

Criar uma aplicação que faça o controle de gastos de uma pessoa.

## Tecnologias utilizadas 

- Java 8
- Spring Boot Framework
- JPA
- PostgreSQL

# Como executar

- Necessario ter o PostgreSQL rodando na maquina e criar um DB "gastosDB".
- Rodar o projeto a partir da main class "ExactaProjectApplication".

## Requisições Disponiveis

- POST - ("/gasto") - Passando a estrutura de um gasto no JSON da requisição com as propriedades - nomePessoa, descricao, valor, e uma Lista de "tags" (tags:[]).
- GET - ("/gasto") - Retornará todos os gastos em banco.
- GET - ("/gasto/{id}") - Retornará somente o gasto atribuido a determinado {id}.
