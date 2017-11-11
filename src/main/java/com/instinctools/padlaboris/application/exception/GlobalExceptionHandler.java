package com.instinctools.padlaboris.application.exception;

import lombok.extern.slf4j.Slf4j;
import org.dozer.MappingException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

/**
 * Exception handler.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle {@link MappingException}.
     *
     * @param exception MappingException exception.
     * @return MappingException error message.
     */
    @ExceptionHandler(MappingException.class)
    public ResponseEntity mappingException(final MappingException exception) {

        final String content = exception.getMessage();

        log.warn(content);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(content);
    }

    /**
     * Handle {@link HttpRequestMethodNotSupportedException}.
     *
     * @param exception HttpRequestMethodNotSupportedException exception.
     * @return HttpRequestMethodNotSupportedException error message.
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity noSuchMethodException(final HttpRequestMethodNotSupportedException exception) {

        final String content = exception.getMessage();

        log.warn(content);

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(content);
    }

    /**
     * Handle {@link InvalidDataAccessApiUsageException}.
     *
     * @param exception InvalidDataAccessApiUsageException exception.
     * @return InvalidDataAccessApiUsageException error message.
     */
    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity invalidDataAccessApiUsageException(final InvalidDataAccessApiUsageException exception) {

        final String content = exception.getMessage();

        log.warn(content);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(content);
    }

    /**
     * Handle {@link Exception}.
     *
     * @param exception Exception exception.
     * @return Exception error message.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity otherException(final Exception exception) {

        final UUID errorUUID = UUID.randomUUID();

        log.error("Error-Id: {} - {}", errorUUID, exception.getMessage(), exception);

        final String content = "An error occurred!!! Please contact support!!! Error-Id: " + errorUUID;

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(content);
    }
}
