/**
 * @author winic
 */
package com.wbarcellos.exceptions;

public class DAOException extends Exception {

	private static final long serialVersionUID = 6188380601274834456L;

	public DAOException(String msg, Exception ex) {
        super(msg, ex);
    }
}
