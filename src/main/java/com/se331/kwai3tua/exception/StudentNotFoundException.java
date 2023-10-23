package com.se331.kwai3tua.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Student with ID " + id + " not found");
    }
}