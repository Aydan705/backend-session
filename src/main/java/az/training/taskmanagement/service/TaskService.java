package az.training.taskmanagement.service;

import az.training.taskmanagement.model.Priority;
import az.training.taskmanagement.model.Task;
import az.training.taskmanagement.model.TaskStatus;
import az.training.taskmanagement.repository.TaskRepository;
import az.training.taskmanagement.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Task üçün business logic.
 *
 * Task yaradılarkən əvvəlcə user-in mövcudluğu yoxlanılır -
 * bu, iki service/repository arasında əlaqənin nümunəsidir.
 */
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task createTask(String title, String description, Priority priority, Long userId) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title boş ola bilməz");
        }
        if (userRepository.findById(userId).isEmpty()) {
            throw new IllegalArgumentException("User tapılmadı: id=" + userId);
        }
        Task task = new Task(null, title, description,
                TaskStatus.TODO, priority == null ? Priority.MEDIUM : priority, userId);
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task tapılmadı: id=" + id));
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task updateStatus(Long id, TaskStatus status) {
        Task task = getTaskById(id);
        task.setStatus(status);
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        getTaskById(id); // mövcudluğu yoxla
        taskRepository.deleteById(id);
    }
}
