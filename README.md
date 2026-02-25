# 📅 Agenda Swing: Evolução Arquitetural Didática

📌 **Sobre o Projeto**
Este projeto foi desenvolvido como parte do **Projeto Integrador na FATESG Senai** (Análise e Desenvolvimento de Sistemas). A "Agenda Swing" é um estudo de caso sobre a transição de um código monolítico para uma **Arquitetura em Camadas (3-Tier)**.

---

## 📚 Documentação e Guia Rápido
Acesse os documentos detalhados para entender a engenharia do projeto:

* 🚀 [**Guia de Instalação**](./docs/instalacao.md) - Como rodar o projeto localmente.
* 🏛️ [**Arquitetura do Sistema (DAS)**](./docs/Agenda_Swing_DOCUMENTO_ARQUITETURA_DE_SOFTWARE_DAS01.pdf)
* 📊 [**Diagramas UML**](./docs/diagramas/) - Visão visual da estrutura.

---

## 🏗️ Arquitetura do Sistema
O objetivo principal foi aplicar boas práticas de engenharia de software, separando responsabilidades:

* **Camada de Visão (UI):** Desenvolvida em **Java Swing**, focada na interação com o usuário.
* **Camada de Negócio (Business):** Responsável pelas validações e lógica do sistema.
* **Camada de Dados (Data/DAO):** Gerencia a persistência no **SQLite**, garantindo desacoplamento.

## 📂 Estrutura de Pastas
```text
├── docs/               # Documentação oficial (DAS e Diagramas)
├── src/
│   ├── ui/             # Telas e componentes Swing
│   ├── business/       # Regras de negócio e validações
│   └── data/           # Classes DAO e conexão com SQLite
├── lib/                # Bibliotecas e Drivers (.jar)
└── database/           # Arquivo do banco de dados SQLite
