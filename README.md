# API-bank

API que realiza um CRUD para simular um cadastro de pessoas. 

Para cada tipo de processamento, é necessário enviar os dados no formato JSON.

A API verifica se o CPF e EMAIL são validos ou se já existem no sistema, se a DATA de NASCIMENTO é no passodo e se a quantidade de carcacteries do NOME e maior que 3 e menor que 100. Caso algum desses dados não corresponda a regra implementada, uma exception será lançada. 

A API permite consultar os dados por ID e de todos os cadastros.

A API permite realizar UPDATE.

A API permite raalizar DELETE por ID.

# Tecnologias utilizadas
- Java 11
- Spring Boot 2.6.1
- Maven
- Hibernate

## Arquitetura 
*main:*
1. Entity  
2. Repository
3. Service
4. Controller
5. Exception
6. DTO

## Base de Dados 
H2

## Como executar
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/adilson-junior/bank.git

# entrar na pasta do projeto back end
cd bank

# executar o projeto
./mvnw spring-boot:run
```

## Caso prefira não baixar o projeto você pode executar os teste pelo servidor Heroku onde hospedei a API para testes.
Link https://facility-bank.herokuapp.com/api/v1/people 

## Como testar 
O sistema possui os endpoints: 
<br>
**``POST /api/v1/people``**: Envia um requisição para o processamento de cadastro.
<br>
*Exemplo do corpo da requisição para cadastro:*
```bash
{
    "name":"Maria Ferreira",
    "cpf":"95811241011",    
    "email":"mariaferreira@gmail.com",
    "birthDate":"1983-01-01"
}
```
*Exemplo do corpo da resposta para cadastro:*
```bash
{
    "mensage": "Created person with ID 1"
}
```
 **``PUT /api/v1/people``**: Envia uma requisição para o processamento de atualização de cadastro.
 <br>
*Exemplo do corpo da requisição para atualizar um cadastro:*
```bash
{
    id":"1",
    "name":"Maria Ferreira da Conceição",
    "cpf":"95811241011",    
    "email":"mariaferreira@gmail.com",
    "birthDate":"1983-01-01"
}
```
*Exemplo do corpo da resposta para atualização:*
```bash
{
    "mensage": "Updated person with ID 1"
}
```

**``GET /api/v1/people/1``**: Envia uma requisição de consulta de cadastro por id informado na URL.
<br>
*Exemplo do corpo da resposta para consulta por id:*
```bash
{
    "id": 1,
    "name":"Maria Ferreira da Conceição",
    "cpf":"95811241011",    
    "email":"mariaferreira@gmail.com",
    "birthDate":"1983-01-01"
}
```
**``GET /api/v1/people``**: Envia uma requisição de consulta de todos cadastros.
<br>
*Exemplo do corpo da resposta para consulta de pagamentos
```bash
[
     {
        "id": 1,
        "name": "Maria Ferreira da Conceição",
        "cpf": "95811241011",
        "email": "mariaferreira@gmail.com",
        "birthDate": "01/01/1983"
    }
    {
        "id": 2,
        "name": "Vaneza Gonzaga",
        "cpf": "45235926080",
        "email": "vaneza@gmail.com",
        "birthDate": "10/11/1985"
    },
   
]
```
**``DELETE /api/v1/people/1 ``**: Envia uma requisição de delete por id informado na URL.
<br>
*Exemplo do corpo da resposta para delete
```bash
{
    "mensage": "Deleted Person whith ID  1"
}
```
# Desenvolvedor

Adilson Junior - Desenvolvedor Java Pleno

LinkedIn: https://www.linkedin.com/in/adilson-junior-a646a488/

