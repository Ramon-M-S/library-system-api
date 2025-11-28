# 📚 API de Gestão de Biblioteca (Library System)

![Java](https://img.shields.io/badge/Java-23-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![MySQL](https://img.shields.io/badge/MySQL-DB-blue)
![JPA](https://img.shields.io/badge/Hibernate-JPA-red)

## 📖 Sobre o Projeto
Este é um sistema robusto de **Gestão de Biblioteca** desenvolvido para demonstrar conhecimentos em desenvolvimento Back-End com Java e Spring Boot.

O projeto evoluiu de um simples catálogo para um sistema de gestão de empréstimos, aplicando conceitos de **Relacionamentos entre Entidades**, **Validações de Regra de Negócio** e **Arquitetura em Camadas** com uso de DTOs.

## 🚀 Funcionalidades Principais

### 1. Gestão de Acervo (CRUD)
- Cadastro e listagem de **Autores**.
- Cadastro de **Livros** vinculados automaticamente a um Autor (Relacionamento `@OneToMany`).

### 2. Sistema de Empréstimos (Novo!)
- **Registro de Empréstimo:** Permite que um usuário pegue um livro.
- **Devolução:** Atualiza o registro marcando a data de entrega.
- **Histórico:** Mantém o registro de todos os empréstimos passados.

### 3. Regras de Negócio (Business Logic)
- 🔒 **Validação de Disponibilidade:** O sistema **impede** automaticamente que um livro seja emprestado se ele já estiver em posse de outro usuário (sem data de devolução registrada).

## 🏛️ Arquitetura do Projeto
O projeto foi refatorado para seguir boas práticas de separação de responsabilidades:

* `controller`: Camada de entrada (API REST).
* `service/repository`: Camada de lógica e acesso ao banco de dados.
* `model`: Entidades JPA que espelham o banco de dados.
* `dto`: **Data Transfer Objects** para filtrar dados de entrada e saída, mantendo a API limpa.

## 🛠️ Tecnologias Utilizadas
* **Java 23** (LTS Features)
* **Spring Boot 3**
* **Spring Data JPA**
* **MySQL 8** (Banco de Dados Relacional)
* **Lombok** (Produtividade)
* **Maven** (Gerenciamento de dependências)

## ⚙️ Como Executar

### Pré-requisitos
1.  Java 17 ou superior instalado (Projeto configurado para Java 23).
2.  MySQL instalado e rodando.

### Passo a Passo
1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/SEU-USUARIO/library-system.git](https://github.com/SEU-USUARIO/library-system.git)
    ```
2.  **Configure o Banco de Dados:**
    Crie um banco no MySQL chamado `biblioteca_api` e configure seu usuário/senha no arquivo `src/main/resources/application.properties`.
3.  **Execute a aplicação:**
    Rode a classe `BibliotecaApiApplication.java` na sua IDE.

## 🔌 Documentação da API (Endpoints)

### 👤 Autores
* `POST /api/biblioteca/autores` - Cadastra Autor.
* `GET /api/biblioteca/autores` - Lista Autores e seus Livros.

### 📕 Livros
* `POST /api/biblioteca/autores/{id}/livros` - Cadastra Livro para um Autor específico.

### 🤝 Empréstimos
* `POST /api/biblioteca/emprestimos` - Realiza um empréstimo (Requer JSON com `livroId` e `nomeUsuario`).
    * *Validação:* Retorna **400 Bad Request** se o livro já estiver emprestado.
* `PUT /api/biblioteca/emprestimos/{id}/devolver` - Realiza a devolução do livro.

## 🧪 Exemplo de JSON (Para Testes)

**Realizar Empréstimo:**
```json
{
  "livroId": 1,
  "nomeUsuario": "Ramon Moreira"
}
```
👨‍💻 Autor:
Ramon Moreira da Silva