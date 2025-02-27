# Jpa (Java Persistence API)

## Tabelas

### @Entity: 
Classe Java para informar ao JPA que esta classe representa uma tabela em um banco de dados.
```java
@Entity 
public  class  User { 
    // O código da classe vai aqui
 }
 ```

### @Table

- name: Especifica o nome da tabela no banco de dados. Use este atributo para dar um nome personalizado à tabela, se necessário.
- schema: Especifica o esquema ao qual a tabela pertence. Um esquema é como uma pasta que contém objetos de banco de dados. Útil ao trabalhar com bancos de dados que suportam esquemas.
- catalog: Especifica o catálogo ao qual a tabela pertence. Um catálogo é um contêiner de nível superior que contém esquemas. Usado em bancos de dados com vários catálogos.
- indexes: Permite que você defina índices na tabela. Os índices melhoram o desempenho da consulta acelerando a recuperação de dados com base em colunas específicas.
- uniqueConstraints: Permite que você defina restrições na tabela para impor a exclusividade de valores em colunas específicas.

```java
@Entity
@Table(name = "users", schema = "public", catalog = "mydb", 
       indexes = @Index(columnList = "last_name"), 
       uniqueConstraints = @UniqueConstraint(columnNames = {"email", "username"}))
public class User { 
    // O código da classe vai aqui
 }

 ```

 ### @SecondaryTable
Especifica uma tabela secundária para a classe de entidade anotada. 
Especificar uma ou mais tabelas secundárias indica que os dados para a classe de entidade são armazenados em várias tabelas.

- name: define o nome da tabela.
- catalog: define o catálogo da tabela.
- schema: define o esquema da tabela
- pkJoinColumns: as colunas que são usadas para unir com a tabela primária
- foreignKey: usado para especificar ou controlar a geração de uma restrição de chave estrangeira para as colunas correspondentes ao pkJoinColumnselemento quando a geração de tabela está em vigor. 
- uniqueConstraints: Restrições exclusivas que devem ser colocadas na tabela. Elas são tipicamente usadas somente se a geração de tabela estiver em vigor.
- indexes: indices para a tabela.

``` java
    @Entity 
    @Table(name="CUSTOMER") 
    @SecondaryTable(name="CUST_DETAIL", 
        pkJoinColumns=@PrimaryKeyJoinColumn(name="CUST_ID")) 
    public class Customer { ... } 
```


### @Basic
É usada para mapear atributos simples de uma entidade

- optional: indica se o atributo é obrigatório ou não
- fetch:indica se o valor deve ser carregado imediatamente (fetch=FetchType.EAGER) ou sob demanda (fetch=FetchType.LAZY).

```java
@Basic(fetch = FetchType.LAZY) // Carregado apenas quando necessário
    @Column(name = "bio")
    private String bio;
```
### @Column

- name: Especifica o nome da coluna na tabela do banco de dados.
- nullable: Indica se a coluna permite valores nulos ou não.
unique: Especifica se os valores da coluna devem ser exclusivos ou não.
- length: Especifica o comprimento máximo da coluna para atributos baseados em string.
- precisione scale: Usado para atributos numéricos para especificar a precisão e a escala da coluna.
- insertablee updatable: Controla se a coluna deve ser incluída nas operações de inserção e atualização.

```java
@Entity 
public  class  User { 
    // id e outros campos 
    
     @Column(name = "first_name", nullable = false, length = 100, unique = true)
    private String firstName;

    @Column(precision = 10, scale = 2)
    private BigDecimal salary;


}
```


### @Temporal
Usada para definir datas (Date, Time e Timestamp)

### @Transient
Permite que um atributo não seja persistido

### @Id
assume que a coluna correspondente na tabela do banco de dados é a coluna de chave primária. 

```java
@Entity
public class User {
    @Id
    private Long id;
}
```

### @GeneratedValue
é usada em conjunto com @Id para indicar que o valor do identificador de uma entidade  será gerado automaticamente.

#### Atributos:
- strategy: 
   define como o banco de dados ou o Hibernate irá gerar automaticamente o valor do identificador (ID) da entidade.
   
   1. GenerationType.AUTO: o Hibernate decide automaticamente qual estratégia usar com base no banco de dados.
   2. GenerationType.IDENTITY:o Hibernate insere o registro sem definir o ID, e o banco gera um valor único.Pode ter limitações em inserção em massa
   3. GenerationType.SEQUENCE: Usa uma sequência do banco para gerar os IDs. Melhor desempenho do que IDENTITY, pois evita problemas com inserções em lote.
   4. GenerationType.TABLE: esta estratégia usa uma tabela de banco de dados separada para gerar valores de chave primária.

- generator:
  Especifica o nome do gerador a ser usado quando a estratégia for definida como GenerationType.SEQUENCEou GenerationType.TABLE. O gerador deve ser definido usando a anotação @SequenceGeneratorou , respectivamente @TableGenerator.

```java
@Id
@GeneratedValue(strategy = GenerationType.TABLE, generator = "book_generator")
@TableGenerator(name = "book_generator", table = "id_generator", schema = "bookstore")
private Long id;
```

### @Embedded
Usado para incorporar uma classe dentro de outra entidade

```java
@Embeddable
public class Endereco {
    private String rua;
    private String cidade;
    private String cep;

    // Getters e Setters
}
```
```java
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;

    @Embedded
    private Endereco endereco;

    // Getters e Setters
}
 ```

### @MappedSuperclass
é usada para criar uma classe base (superclasse) com atributos comuns, sem que ela se torne uma tabela no banco de dados. As classes que herdam dela terão esses atributos mapeados como se fossem seus próprios.

```java
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
```

```java
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    
}
```

```java
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    
}
```

## Mapeando associações/relacionamentos

### @OneToOne 1:1

  
  

  

 