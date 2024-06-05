/**
 * @author winic
 */
package com.wbarcellos.exceptions;

public class TipoChaveNaoEncontradaException extends Exception {

	private static final long serialVersionUID = -5168807605124558914L;

	public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
