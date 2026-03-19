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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.io.TempDir;

/**
 *
 * @author CLAYTON.MARQUES
 */
public class ContatoControllerTest {

//    ContatoController controller;
//    Path storage;
//
//    @BeforeEach
//    void setup(@TempDir Path temp) {
//        storage = temp.resolve("agenda.txt");
//        controller = new ContatoController(storage);
//    }
//
//    @Test
//    void create_whenNameMissing_thenValidationException() {
//        Contato dto = new Contato("", "a@b.com", "123");
//        assertThrows(ValidationException.class, () -> controller.create(dto));
//    }
//
//    @Test
//    void create_whenDuplicate_thenBusinessException() throws Exception {
//        Files.writeString(storage, "Joao;j@x.com;111;ativo\n");
//        Contato dto = new Contato("Joao", "j@x.com", "111");
//        assertThrows(BusinessException.class, () -> controller.create(dto));
//    }
//
//    @Test
//    void create_whenValid_thenSaved() throws Exception {
//        Contato dto = new Contato("Maria", "m@x.com", "222");
//        controller.create(dto);
//        List<String> lines = Files.readAllLines(storage);
//        assertTrue(lines.stream().anyMatch(l -> l.startsWith("Maria;")));
//    }
//
//    @Test
//    void listAll_returnsOnlyActive() throws Exception {
//        Files.writeString(storage, "A;a@a.com;111;inativo\nB;b@b.com;222;ativo\n");
//        List<Contato> list = controller.listAll();
//        assertEquals(1, list.size());
//        assertEquals("B", list.get(0).getNome());
//    }

}
