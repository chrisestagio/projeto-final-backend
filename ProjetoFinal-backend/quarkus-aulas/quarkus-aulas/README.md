# code-with-quarkus-aulas

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-aulas-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

Serviços REST com comunicação HTTP (Rest Client)

Este projeto contém dois microsserviços Java Quarkus, que se comunicam entre si via HTTP usando Rest Client.
O objetivo é demonstrar um CRUD básico e um endpoint que consome dados de outro serviço.

🚀 Tecnologias utilizadas

Java 17

Quarkus 3.x

RESTEasy Reactive

Rest Client

Jackson (JSON)

🧩 Arquitetura

O sistema é dividido em dois serviços independentes:

🔵 Serviço A – Aulas

📌 Porta padrão: 8080

Responsável por armazenar e gerenciar aulas.

Endpoints:
Método	Rota	Descrição

POST	/aulas	Criar nova aula

GET	/aulas	Listar todas as aulas

GET	/aulas/{id}	Buscar aula por ID

PUT	/aulas/{id}	Atualizar aula

DELETE	/aulas/{id}	Deletar aula


🟢 Serviço B – Pessoas

📌 Porta padrão: 8081

Gerencia pessoas e consome dados do serviço de Aulas.

Endpoints CRUD:
Método	Rota	Descrição

POST	/pessoas	Criar nova pessoa

GET	/pessoas	Listar pessoas

GET	/pessoas/{id}	Buscar por ID

PUT	/pessoas/{id}	Atualizar pessoa

DELETE	/pessoas/{id}	Excluir pessoa

⭐ Endpoint de comunicação entre serviços

O serviço de pessoas chama o serviço de aulas:

Método	Rota	Descrição
GET	/pessoas/aulas	Retorna as aulas do outro serviço (via Rest Client)

Este endpoint demonstra a comunicação HTTP exigida no trabalho.

▶️ Como rodar o projeto
1️⃣ Iniciar o serviço de aulas
cd quarkus-aulas
./mvnw quarkus:dev


Acessível em:
📌 http://localhost:8080/aulas

2️⃣ Iniciar o serviço de pessoas
cd quarkus-pessoas
./mvnw quarkus:dev


Acessível em:
📌 http://localhost:8081/pessoas


