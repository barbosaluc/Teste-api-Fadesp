ADR-003 – Uso do Lombok
Autor: Lucas Barbosa.

Contexto
Durante o desenvolvimento da aplicação, identificamos a recorrência de códigos repetitivos em classes de modelo e DTOs, como construtores, métodos getters/setters, equals(), hashCode() e toString(). Para reduzir essa verbosidade e melhorar a legibilidade do código, foi considerada a utilização de ferramentas que automatizem a geração desses trechos.

Decisão
Foi decidido que a biblioteca Project Lombok será utilizada no projeto para reduzir a quantidade de código boilerplate nas classes Java.

Justificativa
Redução de Código Repetitivo: Com anotações como @Getter, @Setter, @ToString, @EqualsAndHashCode e @AllArgsConstructor, o Lombok gera automaticamente métodos que seriam escritos manualmente.

Melhoria na Legibilidade: O código das entidades e modelos fica mais limpo, focado apenas nos atributos e regras de negócio, facilitando a leitura e manutenção.

Produtividade: A equipe ganha agilidade no desenvolvimento, evitando a necessidade de gerar e manter manualmente métodos simples e padronizados.

Integração Simples: O Lombok é amplamente utilizado e possui integração estável com IDEs como IntelliJ IDEA e Eclipse, além de ser compatível com ferramentas de build como Maven e Gradle.

Alternativas Consideradas
Não utilizar Lombok: Manter o código 100% manual evitaria dependências externas, mas aumentaria significativamente a verbosidade do projeto e exigiria mais tempo de desenvolvimento e manutenção.

Utilizar outras ferramentas de geração de código: Nenhuma alternativa apresentou o mesmo nível de integração, maturidade e adoção no ecossistema Java.

Consequências
O projeto passa a depender da biblioteca Lombok, o que exige que os desenvolvedores configurem corretamente suas IDEs para suportar suas anotações.

A leitura do código exige familiaridade com as anotações do Lombok, o que pode gerar uma leve curva de aprendizado para novos membros da equipe.

Garante um código mais enxuto, limpo e de fácil manutenção ao longo do desenvolvimento da aplicação.

