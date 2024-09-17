# APPFood API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

Este projeto foi desenvolvido utilizando **Java, Java Spring e PostgreSQL no banco de dados.** 

API desenvolvida para o desafio da empresa Grão Direto, com o intuito de criar um Back-end e um Front-end para um aplicativo de restaurantes.

## Table of Contents

- [Instalação](#instal)
- [Configuração](#configuration)
- [Uso](#uso)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Contributing](#contributing)

## Instal

1. Clone o repositório:

```bash
git clone https://github.com/otvferreira/foodapp-backend.git
```

2. Instale as dependências do Maven

## Uso

1. Inicie a aplicação com Maven
2. A Api estará acessível no endereço http://localhost:8080


## API Endpoints
A API possui os seguintes endpoints:

**Após o Login todas as requisições devem conter o Bearer Token**

**USUARIOS**

**GET USERS**
```markdown
GET /V1/user/ - Recebe a lista de todos os usuários.
```

**POST USERS**
```markdown
POST /V1/auth/register - Registrar um novo usuário.
```
```json
{
    "name": "Otávio",
    "password": "senha",
    "email": "otavio@example.com",
    "image": "",
    "phoneNumber": "34912345678",
}
```

**DELETE USERS**
```markdown
DELETE /V1/user/delete/otavio@example.com - Deletar um usuário.
```

**FIND USER**
```markdown
DELETE /V1/user/find/otavio@example.com - Buscar um usuário específico por email.
```

**ALTER USER**
```markdown
PUT /V1/user/alter/otavio@example.com - Alterar um usuário 
```
```json
{
	"name":"Otávio Ferreira",
	"email":"otavio@example.com",
	"phoneNumber":"34911111111"
}
```



**POST RESTAURANTS**
```markdown
POST /V1/restaurant/ - Registro de Restaurantes
```
```json
{
	"name":"KFC",
	"address":"Rua das Flores, 123",
	"phoneNumber":"34922222222",
	"image":"https://i.imgur.com/sZ1Jye3.png",
	"category":"Frango"
}
```

**GET RESTAURANTS**
```markdown
GET /V1/restaurant/find/{id} - Buscar restaurantes específicos pelo id.
```

**GET RESTAURANTS**
```markdown
GET /V1/restaurant/ - Buscar restaurantes (lista).
```

**PUT RESTAURANTS**
```markdown
PUT /V1/restaurant/alter/{id} - Alterar restaurantes.
```
```json
{
	"name": "KFC 212",
	"address": "Visconde do Rio Branco, 31",
	"phoneNumber": "34911111111",
	"image":"https://i.imgur.com/O5c3lyU.png"
}
```

**DELETE RESTAURANTS**
```markdown
DELETE /V1/restaurant/delete/{id} - Deletar restaurantes.
```



**POST PRODUCTS**
```markdown
POST /V1/product/ - Registro de Produtos.
```
```json
{
	"name":"Água",
	"description":"Água",
	"typeFood":"bebida",
	"image":"https://i.imgur.com/O5c3lyU.png",
	"restaurantId": 1,
	"price":"10.90"
}
```

**GET RESTAURANTS**
```markdown
GET /V1/product/ - Buscar restaurantes (lista).
```

**GET RESTAURANTS**
```markdown
GET /V1/product/find/{id} - Buscar restaurante.
```

**PUT RESTAURANTS**
```markdown
PUT /V1/product/alter/{id} - Alterar restaurante.
```
```json
{
	"name":"Água",
	"description":"Água",
	"typeFood":"bebida",
	"image":"https://i.imgur.com/O5c3lyU.png",
	"restaurantId": 1,
	"price":"10.90"
}
```

**DELETE RESTAURANTS**
```markdown
DELETE /V1/product/delete/{id} - Alterar restaurante.
```


## Database
Banco de dados PostgreSQL(https://www.postgresql.org/docs/)

