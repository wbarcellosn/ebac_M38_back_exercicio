package com.wbarcellos.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.wbarcellos.dao.IFornecedorDAO;
import com.wbarcellos.domain.Fornecedor;
import com.wbarcellos.exceptions.DAOException;
import com.wbarcellos.exceptions.MaisDeUmRegistroException;
import com.wbarcellos.exceptions.TableException;
import com.wbarcellos.service.generic.GenericService;

@Stateless
public class FornecedorService extends GenericService<Fornecedor, Long> implements IFornecedorService {
	
	@Inject
	public FornecedorService(IFornecedorDAO fornecedorDAO) {
		super(fornecedorDAO);
	}

	@Override
	public Fornecedor buscarPorCNPJ(Long cnpj) throws DAOException {
		try {
			return this.dao.consultar(cnpj);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
