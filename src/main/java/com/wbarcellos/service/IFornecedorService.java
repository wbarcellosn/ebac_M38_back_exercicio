package com.wbarcellos.service;

import com.wbarcellos.domain.Fornecedor;
import com.wbarcellos.exceptions.DAOException;
import com.wbarcellos.service.generic.IGenericService;

public interface IFornecedorService extends IGenericService<Fornecedor, Long> {

	Fornecedor buscarPorCNPJ(Long cnpj) throws DAOException;

}
