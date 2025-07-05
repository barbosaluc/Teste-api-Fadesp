ADR-004 – Banco de Dados H2
Autor: Lucas Barbosa.

Contexto
Durante a fase inicial do desenvolvimento, foi necessário escolher um banco de dados para ser utilizado em ambiente local e de testes. O objetivo era permitir testes rápidos, simples e independentes de infraestrutura externa, priorizando agilidade no ciclo de desenvolvimento.

Decisão
Foi decidido que o projeto utilizará o banco de dados H2 como solução em memória para ambientes de desenvolvimento e testes automatizados.

Justificativa
Leveza e Simplicidade: O H2 é um banco de dados leve, que pode ser executado inteiramente em memória, sem necessidade de instalação ou configuração externa.

Facilidade de Integração: Integra-se nativamente com o Spring Boot, que permite sua configuração com poucas linhas no application.properties.

Velocidade de Execução: Por ser executado em memória, oferece desempenho elevado, ideal para rodar testes de integração e automação.

Console Web: O H2 oferece uma interface web simples para visualizar e consultar os dados durante o desenvolvimento.

Ambiente Isolado: Permite testes independentes e reproduzíveis, evitando dependência de ambientes de banco de dados externos.

Alternativas Consideradas
PostgreSQL local: Embora seja o banco-alvo em produção, exigiria instalação e configuração, dificultando o setup inicial e a automação de testes.

MySQL/MariaDB local: Enfrenta os mesmos desafios do PostgreSQL quanto à dependência externa e tempo de inicialização.

SQLite: Também é leve, mas tem suporte mais limitado a recursos avançados de SQL e integração menos fluida com Spring Data JPA.

Consequências
O banco H2 será utilizado apenas nos ambientes de desenvolvimento e testes, e será substituído pelo banco de produção (ex: PostgreSQL) nos ambientes superiores.

A equipe deve garantir que as queries e configurações JPA sejam compatíveis com ambos os bancos, evitando comandos específicos que possam falhar na produção.

Será necessário manter perfis distintos (dev, test, prod) no application.yml ou application.properties para alternar entre os bancos de forma segura.

