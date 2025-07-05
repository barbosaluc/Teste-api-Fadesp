Documentação da Arquitetura do Software
Visão Geral
Este projeto é uma aplicação Java estruturada para seguir boas práticas de organização de código, modularidade e manutenibilidade. A arquitetura é baseada em camadas e responsabilidades separadas, facilitando a escalabilidade e testes.

Estrutura do Projeto
Pacotes e suas responsabilidades
config
Contém classes relacionadas à configuração geral da aplicação, como beans do Spring, configurações de segurança, banco de dados e outras integrações.

controller
Responsável por receber as requisições HTTP, atuar como interface da API REST, e delegar para as camadas de serviço a lógica do negócio.

domain
Define as entidades e modelos de negócio principais do sistema, representando os dados centrais e regras do domínio.

dto
Contém os Data Transfer Objects, usados para transferência de dados entre as camadas da aplicação, especialmente para comunicação via API, garantindo encapsulamento e segurança dos dados.

exceptions
Define as classes de exceção customizadas para tratamento de erros específicos, melhorando a robustez da aplicação.

persistence
Responsável pela camada de acesso a dados, contendo os repositórios que interagem com o banco de dados, geralmente implementados com Spring Data JPA.

services
Contém as classes que implementam a lógica de negócio da aplicação. Atua como intermediária entre a camada de controller e a camada de persistência.

specification
Pacote destinado à implementação do padrão Specification para consultas dinâmicas e reutilizáveis, especialmente integrado com Spring Data JPA.

util
Contém classes utilitárias e helpers que fornecem funcionalidades de apoio para outras partes da aplicação.

Arquivos principais
TesteFadespApplication.java
Classe principal da aplicação, responsável por inicializar o contexto do Spring Boot.

TesteFadespApplicationTests.java
Classe de testes para validar o funcionamento da aplicação, geralmente utilizando frameworks de testes automatizados.

Tecnologias e Padrões Adotados
Spring Boot: Framework principal para desenvolvimento da aplicação backend.

Java 17: Versão da linguagem utilizada, garantindo suporte a recursos modernos.

Spring Data JPA: Para abstração e gerenciamento do acesso a banco de dados.

Design Pattern Specification: Para implementar filtros e regras dinâmicas de consulta.

Arquitetura em Camadas: Separação clara entre apresentação, negócio, persistência e domínio.

DTOs: Para controle e segurança na comunicação entre camadas e com o cliente.

Benefícios da Arquitetura
Modularidade: Facilita manutenção, testes e evolução da aplicação.

Separation of Concerns: Cada camada é responsável por um aspecto específico da aplicação.

Escalabilidade: Permite o crescimento da aplicação com baixo impacto na estrutura.

Testabilidade: Com camadas e responsabilidades definidas, facilita o desenvolvimento de testes unitários e de integração.

