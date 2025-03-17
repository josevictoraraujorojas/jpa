# JPA - Sistema de Gerenciamento de Livros

## Descrição
Este repositório contém um projeto desenvolvido utilizando **Hibernate** para persistência de dados e **MySQL** como banco de dados. O sistema permite operações CRUD para **Livros, Editoras e Autores**.

## Tecnologias Utilizadas
- **Java 11**
- **Hibernate (ORM - versão 6.4.2.Final)**
- **MySQL**
- **Maven**
- **HikariCP** (Pool de conexões)
- **SLF4J + Logback** (Logging)
- **Jakarta XML Binding (JAXB)**

## Estrutura do Projeto
```
/src/main/java/org/registro
    /Autor      -> Classes de entidade Autor
    /AutorManager      -> Classes com o crud de Autor e conexão com o banco de dados
    /Editora       -> Classes de entidade Editora
    /EditoraManager     -> Classes com o crud de Editora e conexão com o banco de dados
    /Livro    -> Classes de entidade ivro
    /LivroManager     -> Classes com o crud de Livro e conexão com o banco de dados
  
/resources
    /hibernate.cfg.xml  -> Configuração do Hibernate
```

## Como Executar o Projeto
1. **Clonar o Repositório**
   ```sh
   git clone https://github.com/josevictoraraujorojas/jpa.git
   ```
2. **Configurar o Banco de Dados**
  - Criar um banco de dados MySQL
  - Atualizar `hibernate.cfg.xml` com as credenciais corretas

3. **Compilar e Executar**
   ```sh
   mvn clean install
   mvn exec:java
   ```

## Dependências do Projeto (Maven)
```xml
<dependencies>
    <!-- Hibernate Core -->
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>6.4.2.Final</version>
    </dependency>
    
    <!-- MySQL JDBC Driver -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.3.0</version>
    </dependency>

    <!-- JAXB API -->
    <dependency>
        <groupId>jakarta.xml.bind</groupId>
        <artifactId>jakarta.xml.bind-api</artifactId>
        <version>4.0.0</version>
    </dependency>
    
    <!-- JAXB Runtime -->
    <dependency>
        <groupId>org.glassfish.jaxb</groupId>
        <artifactId>jaxb-runtime</artifactId>
        <version>4.0.4</version>
    </dependency>

    <!-- HikariCP (Pool de Conexões) -->
    <dependency>
        <groupId>com.zaxxer</groupId>
        <artifactId>HikariCP</artifactId>
        <version>5.1.0</version>
    </dependency>

    <!-- Logger SLF4J + Logback -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>2.0.12</version>
    </dependency>
    
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.4.14</version>
    </dependency>
</dependencies>
```

## Autor
[José Victor Araujo Rojas](https://github.com/josevictoraraujorojas)

