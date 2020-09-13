package com.aws.d;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonNotFoundExecption extends RuntimeException {

    private static final long serialVersionUID = -1944811610597772540L;

    public PersonNotFoundExecption(String message) {
        super(message);
    }

}
