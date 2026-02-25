# 🗄️ Pasta de Banco de Dados (/database)

Este diretório é responsável pela camada de persistência de dados da **Agenda**, contendo esquemas, migrações e configurações de conexão.

## 📂 Conteúdo desta pasta

Coloque aqui os conteúdos, como models, seeds, configs, etc.
Exemplos:
* **Schema/Models:** Definição da estrutura das tabelas ou coleções (ex: Usuários, Compromissos).
* **Migrations:** Scripts para evolução da estrutura do banco de dados.
* **Seeds:** Dados iniciais para popular o sistema em ambiente de desenvolvimento.
* **Config:** Configurações de conexão (host, porta, credenciais).

## 🛠️ Arquivos Comuns

Coloque aqui os arquivos comuns, como por exemplo, script de criação das tabelas, lógicas de inicialização do cliente, dados de exemplo para teste, etc.
Exemeplos:
- `schema.sql` — Script de criação das tabelas.
- `connection.js` — Lógica de inicialização do cliente do banco de dados.
- `seed.json` — Dados de exemplo para testes.

---
> **Atenção:** Nunca faça commit de arquivos `.env` ou senhas reais nesta pasta. Utilize sempre variáveis de ambiente para gerenciar dados sensíveis.
