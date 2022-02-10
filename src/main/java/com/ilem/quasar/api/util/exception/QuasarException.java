package com.ilem.quasar.api.util.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "NO SE CUENTA CON LA INFORMACION SUFICIENTE PARA TRIANGULAR")
public class QuasarException extends RuntimeException {
    public QuasarException(final String message) {
        super(message);
    }

    public QuasarException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
