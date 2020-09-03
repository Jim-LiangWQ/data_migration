package com.pccw.data.migration.exception;

/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:31
 **/
public class TransactionException extends RuntimeException {


    public TransactionException(String message) {
        super(message);
    }

    public TransactionException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
