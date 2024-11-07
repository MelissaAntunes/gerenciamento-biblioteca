# Sistema de Gerenciamento de Biblioteca
## Visão Geral
O Sistema de Gerenciamento de Biblioteca é uma aplicação desktop desenvolvida em Java com JavaFX para gerenciamento de usuários, livros e administradores em uma biblioteca. O sistema permite adicionar, editar, excluir e consultar livros e administradores.

### Tecnologias Utilizadas
Linguagem de Programação: Java
Interface Gráfica: JavaFX
Banco de Dados: MySQL
IDE: IntelliJ IDEA
Controle de Versão: Git

### Funcionalidades
Cadastro de Funcionários 
 Edição e remoção de funcionários cadastrados.

Cadastro de Livros
 Adição de novos livros com informações como ID do livro, nome, autor, copias.
  Edição e remoção de livros cadastrados.

Tela de Administração
 Interface para visualização e edição de administradores.
  Funcionalidades de login para garantir o acesso restrito a administradores.
   Estrutura do Banco de Dados

### O banco de dados library foi projetado com as seguintes tabelas principais:

admin

user_id: ID do administrador (PK)

username: Nome de usuário

password: Senha

contact: Informações de contato

books

book_id: ID do livro (PK)

name: Título do livro

author: Autor

copies : Cópias 

staff

staff_id: ID do funcionário

name: nome do funcionário

contact: contato do funcionário 

### Requisitos
-Java 8 ou superior

-JavaFX

-MySQL: O banco de dados local deve ser configurado com as credenciais apropriadas para conectar à aplicação.

-IntelliJ IDEA ou outra IDE compatível com Java.

### Instalação e Execução
1. Configuração do Banco de Dados
Clone o repositório:
git clone https://github.com/MelissaAntunes/biblioteca.git

Crie o banco de dados biblioteca no MySQL:

CREATE DATABASE library;
Crie as tabelas necessárias com o seguinte script SQL:

sql
```
CREATE TABLE admin (
    user_id VARCHAR(255) PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    contact VARCHAR(255)
);
```
```
CREATE TABLE books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    copies INT
);
```
```
CREATE TABLE staff (
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    contact VARCHAR(255)
    
);
```

Certifique-se de configurar as credenciais do banco de dados no arquivo de configuração da aplicação.

2. Configuração do Projeto no IntelliJ IDEA
Abra o projeto no IntelliJ IDEA.
Certifique-se de que o JDK esteja configurado corretamente.
Instale a dependência do JavaFX se necessário.
3. Execução
Executar a aplicação no IntelliJ IDEA através do Run.
A interface gráfica permitirá interagir com as funcionalidades de gerenciamento da biblioteca.
Estrutura do Código
A aplicação está organizada em pacotes e classes, conforme abaixo:
