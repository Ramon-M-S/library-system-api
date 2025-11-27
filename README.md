# 📚 API de Gestão de Biblioteca (Relacionamento One-to-Many)

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![MySQL](https://img.shields.io/badge/MySQL-DB-blue)

## 📝 Sobre o Projeto
Este projeto foca na **Modelagem de Dados Relacional** utilizando Spring Data JPA. O objetivo é demonstrar o domínio sobre mapeamento de entidades, relacionamentos entre tabelas e integridade de dados.

O sistema permite o gerenciamento de Autores e Livros, onde é aplicado o relacionamento **Um-para-Muitos (1:N)**: Um autor pode possuir diversos livros cadastrados, e cada livro é vinculado a um único autor.

## 🚀 Tecnologias Utilizadas
* **Java 17** & **Spring Boot 3**
* **Spring Data JPA** (Hibernate)
* **MySQL** (Banco de dados relacional)
* **Bean Validation** (Para garantir dados obrigatórios, ex: `@NotBlank`)
* **Lombok**

## ⚙️ Conceitos Aplicados
- [x] **Relacionamento @OneToMany e @ManyToOne:** Mapeamento bidirecional entre Autor e Livro.
- [x] **Chaves Estrangeiras (Foreign Keys):** Configuração automática via JPA.
- [x] **Cascade Types:** Persistência em cascata.
- [x] **Tratamento de Exceções:** Validação de input e Optional.

## 🔌 Endpoints Principais

### Autores
* `POST /api/biblioteca/autores` - Cadastra um novo autor.
* `GET /api/biblioteca/autores` - Lista autores e seus respectivos livros.

### Livros
* `POST /api/biblioteca/autores/{id}/livros` - Cadastra um livro vinculando-o automaticamente ao autor do ID informado.

## 🗄️ Estrutura do Banco
O sistema cria automaticamente as tabelas `autor` e `livro`, gerando a *constraint* de chave estrangeira (`autor_id`) na tabela de livros.

---
**Autor:** Ramon Moreira da Silva
