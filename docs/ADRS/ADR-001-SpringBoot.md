ADR-001 – Escolha do Framework: Spring Boot com Java 17
Autor: Lucas Barbosa.

Contexto
Este projeto tem como objetivo a criação de uma API RESTful para gerenciamento de pagamentos, priorizando uma arquitetura limpa, escalável e de fácil manutenção. Diante disso, foi necessário decidir qual stack de desenvolvimento backend utilizar, considerando os seguintes critérios:

Facilidade de desenvolvimento e manutenção

Comunidade ativa e ampla documentação

Suporte a boas práticas de arquitetura

Integração com bibliotecas modernas

Desempenho e confiabilidade

Decisão
Optamos por utilizar o Spring Boot como framework principal, em conjunto com a linguagem Java 17.

Justificativa
A escolha foi baseada nos seguintes fatores:

Produtividade: O Spring Boot acelera o desenvolvimento de aplicações Java, fornecendo configuração automática, starters e convenções que reduzem a necessidade de configurações manuais.

Comunidade e Ecossistema: Spring é um dos frameworks Java mais consolidados no mercado, com uma grande comunidade e vasto ecossistema de bibliotecas, tutoriais e soluções prontas.

Suporte a REST APIs: O Spring Boot oferece suporte nativo à construção de APIs RESTful com o Spring MVC, além de integração facilitada com bibliotecas como Spring Data JPA, Spring Security e OpenAPI.

Compatibilidade com Java 17: A versão Java 17 é LTS (Long-Term Support), oferecendo estabilidade, melhorias de desempenho e novos recursos de linguagem que aumentam a produtividade e legibilidade do código.

Padrões de mercado: O uso de Spring Boot com Java é amplamente adotado no mercado corporativo, o que facilita a integração com outros sistemas e a contratação de profissionais.

Alternativas Consideradas
Micronaut: Apresenta tempos de inicialização menores e menor consumo de memória, mas ainda tem menor adoção no mercado e menos materiais de suporte.

Quarkus: Ideal para aplicações nativas com GraalVM, porém possui curva de aprendizado mais acentuada e menor maturidade em comparação com o Spring.

Node.js com Express: Muito produtivo para APIs simples, porém não atende tão bem aos requisitos de robustez e tipagem forte desejados neste projeto.

Consequências
Adotaremos o ecossistema Spring no projeto, o que impactará a escolha de bibliotecas, arquitetura e forma de desenvolvimento.

A equipe deve ter (ou adquirir) familiaridade com o desenvolvimento em Java e com os conceitos do Spring Boot.

Ganho em padronização, modularidade e possibilidade de escalar o sistema conforme necessário.

