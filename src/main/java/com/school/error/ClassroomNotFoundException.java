package com.school.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ClassroomNotFoundException
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
@SuppressWarnings("serial")
public class ClassroomNotFoundException extends RuntimeException {

    public ClassroomNotFoundException(String message) {
        super(message);
    }
}
