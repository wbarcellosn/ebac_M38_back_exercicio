/**
 * @author winic
 */
package com.wbarcellos.exceptions;

public class TipoElementoNaoConhecidoException extends Exception {

	private static final long serialVersionUID = 237359739094611557L;

	public TipoElementoNaoConhecidoException(String msg) {
        this(msg, null);
    }

    public TipoElementoNaoConhecidoException(String msg, Throwable e) {
        super(msg, e);
    }

}
