# Teste-api-Fadesp
Repositório referente ao teste da Fadesp

# Para acessar o swagger:
http://localhost:8080/swagger-ui/index.html

# Para rodar o banco de dados h2:
http://localhost:8080/h2-console

Markdown

---
## Tabela de Endpoints: `PagamentoController`

| Método HTTP | URL | Descrição | Requisição (Body) | Respostas HTTP |
|---|---|---|---|---|
| **POST** | `/pagamentos` | Cria um novo pagamento | `PagamentoRequestDTO` (JSON) | **201 Created** – Sucesso<br>**400 Bad Request** – Erro de validação |
| **GET** | `/pagamentos/{idPagamento}` | Busca um pagamento por ID | — | **200 OK** – Pagamento encontrado<br>**404 Not Found** – Não encontrado |
| **POST** | `/pagamentos/filtros` | Busca pagamentos com filtros personalizados | `PagamentoFiltroDTO` (JSON) | **200 OK** – Lista de pagamentos |
| **GET** | `/pagamentos` | Lista todos os pagamentos do sistema | — | **200 OK** – Lista completa |
| **PUT** | `/pagamentos/{idPagamento}` | Atualiza um pagamento existente | `PagamentoRequestDTO` (JSON) | **204 No Content** – Atualizado<br>**404 Not Found** – Não encontrado |
| **DELETE** | `/pagamentos/{idPagamento}` | Exclusão lógica de um pagamento | — | **204 No Content** – Excluído com sucesso |


📄 Principais regras de negócio referentes ao Pagamento.

📌 Regras de Negócio – Atualização de Pagamento

Este documento descreve as regras de negócio aplicadas ao processo de atualização de status de um pagamento na aplicação.

✅ Regras Validadas Antes da Atualização

📌 Atualização da Data de Pagamento

Se o status atual for PENDENTE_PROCESSAMENTO e o novo status for PROCESSADO_SUCESSO, o campo dataPagamento é registrado com a data e hora atuais.

📌 Proibição de Alteração para Pagamentos Já Processados com Sucesso

Se o status atual for PROCESSADO_SUCESSO, não é permitido alterar o status.

📌 Restrição para Pagamentos com Falha de Processamento

Se o status atual for PROCESSADO_FALHA, o único status permitido como novo é PENDENTE_PROCESSAMENTO.

📌 Proibição de Alterações em Pagamentos Inativos

Se o status do pagamento for INATIVO, nenhuma atualização é permitida.

✅ Regras Validadas Antes da Inativação

O pagamento só pode ser inativado se o statusPagamento for PENDENTE_PROCESSAMENTO.



