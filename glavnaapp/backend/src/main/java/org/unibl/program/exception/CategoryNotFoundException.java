package org.unibl.program.exception;

public class CategoryNotFoundException extends IllegalArgumentException{
    public CategoryNotFoundException() {
        super();
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
