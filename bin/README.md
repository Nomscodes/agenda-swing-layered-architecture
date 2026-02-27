# ads3.contatos
# 📑 Agenda Swing: Evolução Arquitetural Didática
## Este projeto é uma aplicação de agenda pessoal desenvolvida em Java Swing. O objetivo central é demonstrar a evolução de um código funcional simples para uma Arquitetura em Camadas (Layered Architecture) profissional.
# 🚀 O Projeto
# Uma agenda para cadastro de contatos (Nome, E-mail e Telefone) com persistência em arquivo de texto (.txt), validações rigorosas e exclusão lógica.
# 🛠️ Tecnologias Utilizadas
   *   **JDK 21**: Utilizando as últimas funcionalidades da linguagem.
   *   **Maven**: Gestão de dependências e ciclo de vida do projeto.
   *   **Lombok**: Redução de código repetitivo através de anotações (Getters, Setters, Builders).
   *   **Java Swing**: Interface rica e funcional.
## Persistência: Arquivo Texto (.txt) via Java NIO
## Arquitetura: MVC + Service + Repository (Camadas)
# 📈 Jornada de Evolução (Roteiro Didático)
## Para fins de aprendizado, o repositório está organizado para que você acompanhe estas etapas:
   *   **Versão 1.0 (Monolítica)**: Toda a lógica (validação, persistência e UI) reside dentro dos eventos dos botões nos JFrames.
   *   **Versão 2.0 (MVC)**: Separação do Modelo (Dados) e do Controller (Fluxo), isolando a interface gráfica.
   *   **Versão 3.0 (Camadas de Serviço e Persistência)**: Introdução do Service para Regras de Negócio e Repository para isolar o acesso ao arquivo TXT.
   *   **Versão 4.0 (Robustez)**: Implementação de Exclusão Lógica (Soft Delete), tratamento de exceções customizadas e validação com Regex.
# 🏗️ Estrutura de Camadas Atual
   *   **model**: Contém a entidade Contato. Representa o "que" o sistema manipula.
   *   **view**: Telas Swing. Responsáveis apenas por capturar entradas e exibir saídas.
   *   **controller**: Orquestrador. Traduz as ações da View para o Service e padroniza as mensagens de retorno.
   *   **service**: O "Cérebro". Onde estão as regras: e-mail válido, telefone correto e se o nome é duplicado.
   *   **repository**: O "Braço". Única camada que sabe ler e escrever no arquivo agenda.txt.
   *   **utils**: Classes auxiliares como enums e objetos de transporte de mensagens.
# 📋 Regras de Negócio Implementadas
   *   **Unicidade**: Não podem existir dois contatos ativos com o mesmo nome.
   *   **Validação Regex**: E-mails e Telefones devem seguir padrões reais de formato.
   *   **Exclusão Lógica**: Ao excluir, o contato é marcado como inativo (não some do arquivo).
   *   **Recuperação**: Tentar cadastrar um nome inativo oferece ao usuário a opção de reativá-lo.
# 💻 Como Executar
  *   **Clone o repositório**: git clone https://github.com/marquesclayton/ads3.contatos.git
   *   Abra o projeto no NetBeans IDE.
   *   Certifique-se de que o JDK está configurado (versão 21 ou superior).
   *   Execute a classe view.ListaContatos.

# Diagrama de Componente
<img width="910" height="496" alt="Diagrama de componente" src="https://github.com/user-attachments/assets/260cf84a-23ca-4cce-a6c7-cb5f9d77ce18" />
