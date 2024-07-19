package org.unibl.program.exception;

public class InstructorNotFoundException extends IllegalArgumentException{
    public InstructorNotFoundException() {
        super();
    }
    public InstructorNotFoundException(String message) {
        super(message);
    }
}
