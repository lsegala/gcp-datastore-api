# Projeto para testar a conexão entre uma API desenvolvida em Java e um Datastore GCP

## Requisitos para rodar o projeto
* JDK 8+
* Maven 3+
* Conta criada no GCP

### Instalação JDK
* [Link](https://www.devmedia.com.br/instalacao-e-configuracao-do-pacote-java-jdk/23749)

### Instalação Maven
* [Link](https://cezarcruz.com.br/como-instalar-o-maven-windows/)

### Data Store GCP
* [Overview](https://cloud.google.com/datastore/docs/concepts/overview?hl=pt-br)
* [Modelo de dados](https://cloud.google.com/firestore/docs/data-model?hl=pt-br)

### Acesso Local ao serviço GCP
* [Link](https://cloud.google.com/docs/authentication/api-keys)
* Local padrão do arquivo de chave: /gcp/chave.json

### Upload da aplicação para o GCP
```
$ mvn clean package
$ mvn appengine:deploy
```
* [Refência](https://cloud.google.com/appengine/docs/standard/java/tools/uploadinganapp)

## API

O projeto é dividido em duas partes:

## Autenticação

* POST /users/signin?user={name}&password={pass}
    * Retorno 200: retorna a chave de acesso com validade temporária
    * Retorno 401: usuário ou senha inválidos
    
Nas chamadas subsequentes será necessário passar no header da requisição o token
Exemplo:
```
GET /url
Authencation: Bearer <token>
```
    
## Casos

* POST /casos
    * Recebe no corpo da requisição um caso para ser incluído na base
    * Retorno 200: retorna um objeto representando o caso com o id preenchido
* PUT /casos/{id}
    * Recebe no corpo da requisição um caso já existente para ser atualizado
    * Retorno 200: retorna um objeto representando as informações que foram atualizadas
    * Retorno 404: caso com id informado não existe na base
* GET /casos
    * Retorna uma lista de casos cadastrados no banco
* GET /casos/{id}
    * Retorna um objeto de acordo com o id informado
    * Retorno 200: objeto caso referente ao id
    * Retorno 404: não existe nenhum caso com o id informado