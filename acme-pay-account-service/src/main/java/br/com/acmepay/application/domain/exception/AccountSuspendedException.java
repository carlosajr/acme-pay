package br.com.acmepay.application.domain.exception;

public class AccountSuspendedException extends Exception {

    public AccountSuspendedException(){
        super("DOCUMENT_SUSPENDED");
    }
}