ADR-002 – Estrutura em Camadas da Arquitetura
Autor: Lucas Barbosa.

Contexto
Durante a definição da arquitetura da aplicação, foi necessário estabelecer uma estrutura que favoreça a organização do código, facilite a manutenção e permita a escalabilidade da solução. Diante disso, a equipe optou por adotar uma arquitetura em camadas, separando responsabilidades de forma clara.

Decisão
A arquitetura do projeto será estruturada em camadas distintas, organizadas da seguinte forma:

Camada de Apresentação (Controller)
Responsável por receber as requisições HTTP, validar dados de entrada e encaminhar as chamadas para a camada de serviço.

Camada de Serviço (Service)
Contém a lógica de negócio da aplicação. Atua como intermediária entre a apresentação e o acesso a dados, garantindo o encapsulamento das regras do domínio.

Camada de Acesso a Dados (Repository)
Gerencia a persistência e recuperação dos dados utilizando JPA/Hibernate. Isola o banco de dados da lógica de negócio.

Camada de Domínio (Model/Entity)
Define os modelos de dados e entidades do sistema, representando os conceitos centrais da aplicação.

Camada de DTOs e Mappers (Opcional)
Responsável pela transferência de dados entre camadas e pela transformação de objetos, promovendo desacoplamento e segurança de dados expostos.

Justificativa
Organização: Cada camada tem uma responsabilidade bem definida, o que facilita a leitura e manutenção do código.

Separação de responsabilidades (SoC): Reduz o acoplamento entre as partes da aplicação, tornando o sistema mais flexível.

Testabilidade: Com responsabilidades separadas, é possível testar cada camada de forma isolada (unitariamente ou com mocks).

Escalabilidade: Uma arquitetura bem segmentada permite crescimento do sistema sem perda de controle ou aumento excessivo da complexidade.

Alternativas Consideradas
Arquitetura Monolítica Simples (sem camadas definidas): Embora funcional em projetos pequenos, dificultaria a manutenção e a escalabilidade no médio/longo prazo.

Arquitetura Hexagonal (Ports & Adapters): Mais robusta e voltada para alta complexidade. Foi considerada excessiva para o escopo atual do projeto, mas poderá ser adotada futuramente em uma refatoração.

Consequências
O projeto terá um padrão claro de organização de pacotes e classes baseado na divisão por camadas.

Novos desenvolvedores poderão entender mais facilmente a estrutura e responsabilidade de cada componente.

A modularidade facilitará testes, refatorações e futuras evoluções da aplicação.

