package az.training.taskmanagement.exception;

/**
 * Axtarılan resurs (User, Task, ...) tapılmadıqda atılır.
 * Lesson 6-da bu, HTTP 404-ə map olunacaq.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public static ResourceNotFoundException of(String entity, Object id) {
        return new ResourceNotFoundException(entity + " tapılmadı: id=" + id);
    }
}
