package com.wbarcellos.dao;

import com.wbarcellos.dao.generic.GenericDAO;
import com.wbarcellos.domain.Fornecedor;

public class FornecedorDAO extends GenericDAO<Fornecedor, Long> implements IFornecedorDAO {

	public FornecedorDAO() {
		super(Fornecedor.class);
	}

}
