# 📅 Agenda Swing: Evolução Arquitetural Didática

## 📌 Sobre o Projeto
Este projeto foi desenvolvido como parte do **Projeto Integrador na FATESG SENAI** (Análise e Desenvolvimento de Sistemas). A "Agenda Swing" é um estudo de caso prático sobre a transição de um código monolítico para uma **Arquitetura em Camadas (3-Tier)**, aplicando conceitos aprendidos no terceiro semestre.

## 📚 Documentação e Engenharia
Acesse os documentos detalhados para entender a construção do sistema:

* 🚀 **[Guia de Instalação](./docs)** - Como configurar o ambiente e rodar o projeto.
* 🏛️ **[Arquitetura do Sistema (DAS)](./docs)** - Documento de Arquitetura de Software baseado no modelo 4+1.
* 📊 **[Diagramas UML](./docs)** - Representação visual da estrutura de classes e fluxo.

## 🏗️ Arquitetura do Sistema
O foco principal foi a separação de responsabilidades para garantir manutenibilidade:

* **Camada de Visão (UI):** Desenvolvida em **Java Swing**, focada na interface e experiência do usuário.
* **Camada de Negócio (Business):** Contém as regras de negócio, validações e lógica principal.
* **Camada de Dados (Data/DAO):** Gerencia a persistência no **SQLite**, utilizando o padrão DAO para desacoplamento.

## 📂 Estrutura do Repositório
Baseado na organização atual do projeto:

* `bin/`: Arquivos binários compilados.
* `database/`: Localização do arquivo de banco de dados SQLite.
* `docs/`: Documentação técnica, incluindo o DAS e diagramas.
* `lib/`: Bibliotecas externas e drivers necessários (.jar).
* `src/`: Código-fonte organizado por pacotes (UI, Business, Data).
* `pom.xml`: Arquivo de configuração do Maven para gerenciamento de dependências.

## 👥 Equipe do Projeto
* **Alexander** — [Alexsanei](https://github.com/Alexsanei)
* **Caio Abreu** — [Caio4breu](https://github.com/Caio4breu)
* **Cassiano Abreu** — [Nomscodes](https://github.com/Nomscodes)
* **Gabriel Naoki** — [GabrielNaokiUT](https://github.com/GabrielNaokiUT)
* **Wyllian Mariano** — [wyllianmn](https://github.com/wyllianmn)
