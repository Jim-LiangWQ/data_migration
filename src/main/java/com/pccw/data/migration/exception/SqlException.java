package com.pccw.data.migration.exception;
/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:31
 **/
public class SqlException extends RuntimeException {

	private static final long serialVersionUID = 5451955224143866247L;


	public SqlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SqlException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SqlException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SqlException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
