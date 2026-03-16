package com.br.senai.ads3.agenda_fatesg.services;

import com.br.senai.ads3.agenda_fatesg.domains.Contato;
import com.br.senai.ads3.agenda_fatesg.exceptions.BusinessException;
import com.br.senai.ads3.agenda_fatesg.exceptions.ValidationException;
import com.br.senai.ads3.agenda_fatesg.repositories.ContatoRepository;
import com.br.senai.ads3.agenda_fatesg.repositories.IContatoRepository;
import com.br.senai.ads3.agenda_fatesg.validation.ContatoValidation;
import com.br.senai.ads3.agenda_fatesg.validation.ExceptionValidationCampo;
import com.br.senai.ads3.agenda_fatesg.validation.IContatoValidation;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CLAYTON.MARQUES
 */
public class ContatoService implements IContatoService {

    private final IContatoRepository repository;
    private final IContatoValidation validation;

    public ContatoService() {
        this.repository = new ContatoRepository();
        this.validation = new ContatoValidation(this.repository);
    }

    public ContatoService(Path storage) {
        this.repository = new ContatoRepository(storage);
        this.validation = new ContatoValidation(this.repository);
    }

    @Override
    public boolean inserir(Contato contato) throws ValidationException, BusinessException, ExceptionValidationCampo, Exception {
        this.validation.validarCampos(contato);
        this.validation.validaRegraInserir(contato);
        return this.repository.inserir(contato);
    }

    @Override
    public boolean alterar(Contato contato) throws ValidationException, BusinessException, ExceptionValidationCampo, Exception {
        this.validation.validarCampos(contato);
        this.validation.validarRegrasAlterar(contato);
        return this.repository.alterar(contato);
    }

    @Override
    public boolean excluir(Contato contato) throws BusinessException, Exception {
        this.validation.validaRegraInativar(contato);
        return this.repository.desativar(contato);
    }

    @Override
    public boolean excluir(String nome) throws BusinessException, Exception {
        Contato contato = this.buscarPorNome(nome);
        if (contato != null) {
            return excluir(contato);
        }
        return false;
    }

    @Override
    public List<Contato> listarPorNome(String name) throws BusinessException, Exception {
        List<Contato> all = this.buscarTodos();
        List<Contato> filtered = new ArrayList<>();
        for (Contato c : all) {
            if (c.getNome() != null && c.getNome().toLowerCase().contains(name.toLowerCase())) {
                filtered.add(c);
            }
        }
        return filtered;
    }

    @Override
    public Contato buscarPorNome(String name) throws BusinessException, Exception {
        List<Contato> all = this.buscarTodos();
        for (Contato c : all) {
            if (c.getNome() != null && c.getNome().toLowerCase().contains(name.toLowerCase())) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Contato> buscarTodos() throws BusinessException, Exception {
        return this.repository.buscarTodos();
    }

    @Override
    public List<Contato> buscarTodosAtivos() throws BusinessException, Exception {
        return this.repository.buscarTodos(true);
    }

    @Override
    public List<Contato> buscarTodosInativos() throws BusinessException, Exception {
        return this.repository.buscarTodos(false);
    }

    @Override
    public boolean contatoExiste(Contato contato) throws BusinessException, Exception {
        return this.repository.contatoExiste(contato);
    }

    @Override
    public boolean reativaContato(Contato contato) throws BusinessException, ExceptionValidationCampo, Exception {
        this.validation.validaRegraAtivar(contato);
        return this.repository.reativar(contato);
    }
}
