# ADR 0001 — Introdução da camada Controller e persistência temporária no Controller
 * **Status: accepted**
 * **Data: 20/02/2026**
 * **Autores: Turma ADS3-2026-1 :: Arquitetura e Projetos de Software**
## Contexto
 * A aplicação Agenda de Contatos (desktop Java 21 / Swing) apresentava lógica de validação, regras de negócio e acesso à persistência espalhados nas Views (Form_Cadastro, Form_Listagem). Isso dificultava testes, aumentava acoplamento UI↔persistência e impedia evolução arquitetural controlada.
 * Objetivo pedagógico: promover separação de responsabilidades de forma incremental para ensinar princípios de arquitetura (alta coesão, baixo acoplamento, testabilidade) sem impor alta complexidade imediata.

## Decisão
 * Adotar abordagem "Controller first" (refactor incremental):
   * Criar pacote controllers com duas interfaces:
     * FormController — API para telas de cadastro/edição (ex.: create(Contato), update(originalName, Contato), validate(Contato)).
     * ListController — API para tela de listagem (ex.: listAll(), findByName(String), markInactiveByName(String)).
   * Implementar temporariamente a lógica e a persistência diretamente em uma classe concreta ContatoController que implementa ambas as interfaces.  
   * A persistência ficará por ora em arquivo texto (agenda.txt) e será acessada via API java.nio.file.
   * ContatoController deve ter o Path do arquivo injetável (para permitir testes com arquivos temporários).
   * Reescrever Views para depender apenas das interfaces (injeção/instanciação da implementação feita na inicialização das Views).  
   * Executar todas as operações de I/O a partir de chamadas em background (ex.: SwingWorker) para não bloquear o EDT.  
 * Documentar esta decisão via ADR e criar issue para extrair camada Repository/Service futuramente. (Por enquanto suspenso)

## Consequências

### Positivas
 * Aumento imediato da testabilidade (controllers testáveis sem UI).
 * Redução do acoplamento entre UI e lógica; maior coesão das responsabilidades relacionadas a contatos.
 * Facilita futuras extrações e refatorações (Repository/Service) por possuir pontos de encapsulamento bem definidos.

### Negativas / Riscos
 * Risco de acumular lógica de persistência no Controller (anti pattern) se a extração não ocorrer depois.
 * Possibilidade de concentração de responsabilidades no Controller (violação temporária do princípio de camada).
 * Persistência em texto plano tem limitações (consistência, concorrência, segurança) — deve ser vista como solução didática e temporária.

## Mitigações
 * Inserir TODO e issue rastreável "Extrair Repository/Service" com plano e prazo (ex.: até N2).
 * Injetar Path para permitir testes automáticos com arquivos temporários.
 * Manter métodos do Controller pequenos e bem nomeados (e.g., readAllLines(), appendLine(), updateLine()), para facilitar substituição posterior.
 * Usar SwingWorker para todas as operações de I/O invocadas pela UI.

## Alternativas consideradas
 * Manter lógica e persistência nas Views (Rejeitado)  
   * Simples inicialmente, porém mantém baixa testabilidade e alto acoplamento; não atende objetivo pedagógico.
 * Extrair as camadas Service  e Repository (Considerado, aceito para momento posterior)

## Follow up / Próximos passos
 * Criar issue tracking (Se estivéssemos utilizando uma ferramenta para a gestão do projeto):
   * #Extrair-Repository-Post-N1 com checklist de tarefas (definir interface Repository, mover I/O do Controller, atualizar testes e ADR).
 * Atualizar DAS e diagramas (C3/C2) para refletir Controller-first e, quando a extração ocorrer, atualizar ADR para registrar migração.
 * Exigir em entregas: controllers com Path injetável, testes unitários do Controller (mín. 3), Views delegando à interface e uso de SwingWorker para I/O.
 
## Referencias
 * Projeto “Agenda de Contatos” -> repository: https://github.com/marquesclayton/ads3.contatos
 * DAS — sessão “Atualização: Estratégia incremental de evolução (Controller first)”
 * Fowler — Strangler Fig Pattern (para migração incremental)
