package com.se331.kwai3tua.exception;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(Long id) {
        super("Teacher with ID " + id + " not found");
    }
}