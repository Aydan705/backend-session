package az.training.taskmanagement.exception;

/**
 * Business səviyyəsində sadə validation səhvləri üçün.
 * Lesson 6-da Bean Validation (@Valid) ilə tamamlanacaq.
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
