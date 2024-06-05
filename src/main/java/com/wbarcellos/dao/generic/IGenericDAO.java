package com.wbarcellos.dao.generic;

import java.io.Serializable;
import java.util.Collection;

import com.wbarcellos.domain.Persistente;
import com.wbarcellos.exceptions.DAOException;
import com.wbarcellos.exceptions.MaisDeUmRegistroException;
import com.wbarcellos.exceptions.TableException;
import com.wbarcellos.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericDAO <T extends Persistente, E extends Serializable> {

    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public void excluir(T entity) throws DAOException;

    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException;

    public Collection<T> buscarTodos() throws DAOException;
}
