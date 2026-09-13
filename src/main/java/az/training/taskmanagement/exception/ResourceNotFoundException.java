package az.training.taskmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Axtarılan resurs tapılmadıqda atılır -> HTTP 404.
 *
 * Lesson 4: sadə @ResponseStatus ilə status kodu təyin edirik.
 * Lesson 6: @RestControllerAdvice ilə standart error body qaytaracağıq.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public static ResourceNotFoundException of(String entity, Object id) {
        return new ResourceNotFoundException(entity + " tapılmadı: id=" + id);
    }
}
