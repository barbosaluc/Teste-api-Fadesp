ADR-006 – Uso do Spring Data JPA
Autor: Lucas Barbosa.

Contexto
A aplicação requer uma forma eficiente e padronizada de realizar operações de persistência de dados, como criação, leitura, atualização e exclusão (CRUD). Além disso, é importante manter a integridade do modelo de domínio e facilitar a integração com bancos de dados relacionais.

Decisão
Foi decidido que o projeto utilizará o Spring Data JPA como solução para o mapeamento objeto-relacional (ORM) e acesso aos dados.

Justificativa
Abstração de Repositórios: O Spring Data JPA permite a criação de repositórios baseados em interfaces, eliminando a necessidade de implementar métodos CRUD manualmente.

Integração com JPA/Hibernate: Fornece suporte completo à especificação JPA e integra de forma transparente com o Hibernate, amplamente utilizado e bem documentado.

Produtividade: Com o uso de convenções e anotações, o desenvolvimento de consultas e operações com o banco de dados torna-se mais rápido e menos propenso a erros.

Consultas Personalizadas: Permite a criação de queries personalizadas por meio de @Query ou pela derivação automática de métodos baseados em nomes (findBy, existsBy, etc.).

Gestão do Ciclo de Vida das Entidades: Possibilita o controle do estado das entidades, relacionamentos, transações e lazy loading com facilidade.

Alternativas Consideradas
JDBC puro: Apesar de oferecer controle total, demandaria muito mais código e manutenção, além de ser mais propenso a erros e inconsistências.

MyBatis: Fornece flexibilidade e controle nas consultas SQL, mas aumenta a complexidade e reduz os benefícios de abstração oferecidos pelo Spring Data JPA.

Hibernate nativo (sem Spring Data): Possui poder e flexibilidade, mas exigiria maior esforço de configuração e codificação.

Consequências
A estrutura de repositórios será baseada em interfaces que estendem JpaRepository ou CrudRepository.

O modelo de entidades deve ser cuidadosamente anotado com @Entity, @Table, @Id, @ManyToOne, entre outras anotações JPA.

A curva de aprendizado é baixa para quem já possui experiência com Spring, mas novos membros da equipe precisarão se familiarizar com os conceitos de JPA e ORM.

