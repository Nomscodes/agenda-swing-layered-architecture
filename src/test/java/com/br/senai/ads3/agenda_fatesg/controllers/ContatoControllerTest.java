/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.br.senai.ads3.agenda_fatesg.controllers;

import com.br.senai.ads3.agenda_fatesg.domains.Contato;
import com.br.senai.ads3.agenda_fatesg.exceptions.BusinessException;
import com.br.senai.ads3.agenda_fatesg.exceptions.ValidationException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static org.junit.gen5.api.Assertions.assertEquals;
import static org.junit.gen5.api.Assertions.assertThrows;
import static org.junit.gen5.api.Assertions.assertTrue;
import org.junit.gen5.api.BeforeEach;
import org.junit.gen5.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 *
 * @author CLAYTON.MARQUES
 * 
 * Classe testada: ContatoController — responsável por validação, regras de negócio e persistência (arquivo agenda.txt).
 * Estratégia chave: isolar I/O usando um arquivo temporário (injetado via Path) para não mexer em dados reais e tornar testes reprodutíveis.
 */
public class ContatoControllerTest {

    /**
     * Instância do objeto sob teste.
     */
    ContatoController controller;
    
    /**
     * Caminho do arquivo usado pelo controller 
     * Será um arquivo temporário por teste.
     */
    Path storage;

    /**
     * 
     * @param temp 
     * 
     * Setup antes de cada teste 
     * @BeforeEach: método executado antes de cada @Test, garantindo estado limpo por teste
     * @TempDir (JUnit 5): injeta um diretório temporário exclusivo para o teste; é automaticamente limpo após o teste
     * Resultado: cada teste usa seu próprio arquivo agenda.txt isolado, evitando efeitos colaterais entre testes e do sistema.
     */
    @BeforeEach
    void setup(@TempDir Path temp) {
        storage = temp.resolve("agenda.txt");
        controller = new ContatoController(storage);
    }

    /**
     * 
     * Teste: validação de nome obrigatório
     * 
     * Objetivo: garantir que criar um contato sem nome lance ValidationException.
     * assertThrows: assegura que a chamada controller.create(dto) lança o tipo de exceção esperado.
     * Importância: verifica regras de validação antes de persistir dados inválidos.
     * 
     */
    @Test
    void create_whenNameMissing_thenValidationException() {
        Contato dto = new Contato("", "a@b.com", "123");
        assertThrows(ValidationException.class, () -> controller.create(dto));
    }
    
    /**
     * 
     * @throws Exception 
     * 
     * Teste: duplicidade de nome (negócio)
     * 
     * Preparação: escreve manualmente uma linha no arquivo temporário simulando um registro existente.
     * Objetivo: garantir que tentar criar contato com nome já cadastrado e ativo gera BusinessException.
     * Verifica regra de negócio de unicidade.
     * 
     */
    @Test
    void create_whenDuplicate_thenBusinessException() throws Exception {
        Files.writeString(storage, "Joao;j@x.com;111;ativo\n");
        Contato dto = new Contato("Joao", "j@x.com", "111");
        assertThrows(BusinessException.class, () -> controller.create(dto));
    }

    /**
     * @throws Exception 
     * 
     * Teste: criação bem‑sucedida persiste registro
     * 
     * Fluxo feliz: chama create com dados válidos.
     * Verificação: lê o arquivo temporário e confirma que uma linha começando por "Maria;" foi gravada.
     * Importante para garantir integração básica entre validação e persistência (no escopo do controller).
     * 
     */
    @Test
    void create_whenValid_thenSaved() throws Exception {
        Contato dto = new Contato("Maria", "m@x.com", "222");
        controller.create(dto);
        List<String> lines = Files.readAllLines(storage);
        assertTrue(lines.stream().anyMatch(l -> l.startsWith("Maria;")));
    }

    /**
     * 
     * @throws Exception 
     * 
     * Teste: listagem retorna apenas ativos
     * 
     * Preparação: escreve duas linhas, uma marcada inativo e outra ativo.
     * Objetivo: garantir que listAll filtre corretamente pelo status "ativo".
     * Asserções: tamanho da lista e nome do primeiro elemento confirmam comportamento.
     * 
     */
    @Test
    void listAll_returnsOnlyActive() throws Exception {
        Files.writeString(storage, "A;a@a.com;111;inativo\nB;b@b.com;222;ativo\n");
        List<Contato> list = controller.listAll();
        assertEquals(1, list.size());
        assertEquals("B", list.get(0).getNome());
    }

}
