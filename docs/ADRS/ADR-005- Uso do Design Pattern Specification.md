ADR-005 – Uso do Design Pattern: Specification
Autor: Lucas Barbosa

Contexto
Durante a construção da camada de acesso a dados e da lógica de negócios, surgiu a necessidade de aplicar filtros e critérios de forma dinâmica e reutilizável, especialmente em consultas mais complexas. A abordagem tradicional com múltiplos métodos em repositórios (findBy...And...Or...) não era escalável ou flexível.

Decisão
Foi decidido que o projeto adotará o Design Pattern Specification para encapsular regras de filtragem de forma composável, reutilizável e desacoplada.

Justificativa
Flexibilidade nas Consultas: Permite a criação de filtros reutilizáveis e combináveis (com and, or, not), facilitando a composição de consultas complexas.

Organização do Código: Cada critério de consulta passa a ser uma classe ou expressão clara e reutilizável, evitando poluição dos repositórios com muitos métodos específicos.

Manutenção e Testabilidade: Cada especificação pode ser testada de forma isolada, melhorando a qualidade do código e facilitando futuras mudanças nas regras de negócio.

Integração com Spring Data JPA: O Spring Data oferece suporte nativo ao padrão Specification através da interface JpaSpecificationExecutor.

Desacoplamento das Regras: Ao encapsular as condições em classes separadas, as regras de filtragem ficam isoladas e seguem o princípio da responsabilidade única (SRP).

Alternativas Consideradas
Métodos derivados por nome no Spring Data JPA (findByStatusAndTipo...)
Viável para consultas simples, mas rapidamente se torna insustentável com múltiplos filtros opcionais e regras condicionais.

JPQL/Criteria API diretamente
Embora poderoso, o uso direto de Criteria torna o código mais verboso e difícil de manter, além de exigir lógica repetitiva para filtros compostos.

Consequências
Os repositórios que exigirem filtros dinâmicos passarão a implementar JpaSpecificationExecutor<T>.

A lógica de filtragem será extraída para classes Specification<T> separadas, promovendo reutilização e clareza.

Desenvolvedores precisarão entender o padrão Specification e sua sintaxe, exigindo uma breve capacitação técnica da equipe.

Ganho significativo de modularidade, testabilidade e escalabilidade em consultas complexas.