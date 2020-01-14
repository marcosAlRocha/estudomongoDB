package com.mrxatecnologia.springmongo.services.Exceptions;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String mesg) {
      super(mesg);
    }
}
