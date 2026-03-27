<div align="center">

<br/>

```text
 █████╗  ██████╗ ███████╗███╗   ██╗██████╗  █████╗ 
██╔══██╗██╔════╝ ██╔════╝████╗  ██║██╔══██╗██╔══██╗
███████║██║  ███╗█████╗  ██╔██╗ ██║██║  ██║███████║
██╔══██║██║   ██║██╔══╝  ██║╚██╗██║██║  ██║██╔══██║
██║  ██║╚██████╔╝███████╗██║ ╚████║██████╔╝██║  ██║
╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝╚═════╝ ╚═╝  ╚═╝
````
</div>

<div align="center">
  
### Personal Agenda System | Layered Architecture | Java Swing

**📑 Agenda Swing: Evolução Arquitetural Didática** Este projeto é uma aplicação de agenda pessoal desenvolvida em Java Swing com o objetivo central de demonstrar a evolução de um código funcional simples para uma **Arquitetura em Camadas (Layered Architecture)** profissional.

</div>

## 📋 Índice

  - [🚀 O Projeto](https://www.google.com/search?q=%23-o-projeto)
  - [🛠️ Tecnologias Utilizadas](https://www.google.com/search?q=%23-tecnologias-utilizadas)
  - [📈 Jornada de Evolução](https://www.google.com/search?q=%23-jornada-de-evolu%C3%A7%C3%A3o-roteiro-did%C3%A1tico)
  - [🏗️ Estrutura de Camadas](https://www.google.com/search?q=%23-estrutura-de-camadas-atual)
  - [💎 Regras de Negócio](https://www.google.com/search?q=%23-regras-de-neg%C3%B3cio-implementadas)
  - [💻 Como Executar](https://www.google.com/search?q=%23-como-executar)
  - [📐 Diagrama de Componente](https://www.google.com/search?q=%23-diagrama-de-componente)

## 🚀 O Projeto

Uma agenda para cadastro de contactos (Nome, E-mail e Telefone) com foco em:

  * Persistência em arquivo de texto (.txt) via **Java NIO**.
  * Validações rigorosas de dados com Regex.
  * Implementação de **Exclusão Lógica (Soft Delete)** para integridade de dados e auditoria.

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Descrição |
|---|---|
| **JDK 21** | Utilizando as últimas funcionalidades da linguagem Java. |
| **Maven** | Gestão de dependências e ciclo de vida do projeto. |
| **Lombok** | Redução de código repetitivo através de anotações (Getters, Setters, Builders). |
| **Java Swing** | Interface gráfica rica e funcional para Desktop. |
| **Persistência** | Arquivo Texto (.txt) com abstração para futura migração para SQL. |

## 📈 Jornada de Evolução (Roteiro Didático)

Para fins de aprendizado, o repositório está organizado para que você acompanhe estas etapas:

  * **Versão 1.0 (Monolítica):** Toda a lógica (validação, persistência e UI) reside dentro dos eventos dos botões nos JFrames.
  * **Versão 2.0 (MVC):** Separação do Modelo (Dados) e do Controller (Fluxo), isolando a interface gráfica.
  * **Versão 3.0 (Camadas de Serviço e Persistência):** Introdução do **Service** para Regras de Negócio e **Repository** para isolar o acesso ao arquivo TXT.
  * **Versão 4.0 (Robustez):** Implementação de **Soft Delete**, tratamento de exceções customizadas, validação com Regex e o padrão **Response** para comunicação entre camadas.

## 🏗️ Estrutura de Camadas Atual

  * **`model`**: Contém a entidade Contato. Representa o "que" o sistema manipula.
  * **`view`**: Telas Swing. Responsáveis apenas por capturar entradas e exibir saídas.
  * **`controller`**: Orquestrador. Traduz as ações da View para o Service e padroniza as mensagens de retorno.
  * **`service`**: O "Cérebro". Onde estão as regras: e-mail válido, telefone correto e se o nome é duplicado.
  * **`repository`**: O "Braço". Única camada que sabe ler e escrever no arquivo `agenda.txt`.
  * **`utils`**: Classes auxiliares como enums e objetos de transporte de mensagens (`Response<T>`).

## 💎 Regras de Negócio Implementadas

  * ✅ **Unicidade:** Não podem existir dois contactos ativos com o mesmo nome.
  * ✅ **Validação Regex:** E-mails e Telefones devem seguir padrões reais de formato.
  * ✅ **Exclusão Lógica:** Ao excluir, o contacto é marcado como inativo (não desaparece do arquivo físico).
  * ✅ **Recuperação:** Tentar cadastrar um nome inativo oferece ao usuário a opção de reativá-lo.

## 💻 Como Executar

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/marquesclayton/ads3.contatos-camadas.git](https://github.com/marquesclayton/ads3.contatos-camadas.git)
    ```
2.  Abra o projeto no seu IDE de preferência (NetBeans, IntelliJ ou VS Code).
3.  Certifique-se de que o **JDK 21** ou superior está configurado no seu ambiente.
4.  Execute a classe: `view.ListaContatos`.


## 📐 Diagrama de Componente

<div align="center">
<img width="910" alt="Diagrama de componente" src="https://github.com/user-attachments/assets/260cf84a-23ca-4cce-a6c7-cb5f9d77ce18" />
</div>
