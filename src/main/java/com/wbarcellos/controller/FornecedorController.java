package com.wbarcellos.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.wbarcellos.domain.Fornecedor;
import com.wbarcellos.service.IFornecedorService;

@Named
@ViewScoped
public class FornecedorController implements Serializable {

    private static final long serialVersionUID = -3729897625077458683L;

    private Fornecedor fornecedor;
    private Collection<Fornecedor> fornecedores;

    @Inject
    private IFornecedorService fornecedorService;

    private Boolean isUpdate;

    @PostConstruct
    public void init() {
        try {
            this.isUpdate = false;
            this.fornecedor = new Fornecedor();
            this.fornecedores = fornecedorService.buscarTodos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os fornecedores"));
        }
    }

    public void cancel() {
        try {
            this.isUpdate = false;
            this.fornecedor = new Fornecedor();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
        }
    }

    public void edit(Fornecedor fornecedor) {
        try {
            this.isUpdate = true;
            this.fornecedor = fornecedor;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar editar o fornecedor"));
        }
    }

    public void delete(Fornecedor fornecedor) {
        try {
            fornecedorService.excluir(fornecedor);
            fornecedores.remove(fornecedor);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o fornecedor"));
        }
    }

    public void add() {
        try {
        	System.out.println("Fornecedor antes de atualizar: " + fornecedor.toString());
            fornecedorService.cadastrar(fornecedor);
            this.fornecedores = fornecedorService.buscarTodos();
            this.fornecedor = new Fornecedor();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o fornecedor"));
        }
    }

    public void update() {
        try {
            System.out.println("Fornecedor antes de atualizar: " + fornecedor.toString());
            fornecedorService.alterar(this.fornecedor);
            cancel();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Fornecedor atualizado com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o fornecedor"));
        }
    }

    public Collection<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(Collection<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Boolean getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Boolean isUpdate) {
        this.isUpdate = isUpdate;
    }
}
