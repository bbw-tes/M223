package ch.zli.m223.services;

import ch.zli.m223.models.Task;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class TaskServiceIT {

    @Inject
    TaskService taskService;

    @Test
    void createTask_persistsTaskInDatabase() {
        // Arrange
        Task task = new Task();
        task.setTitle("Test Task");
        task.setDescription("Integrationstest");

        // Act
        Task savedTask = taskService.create(task);

        // Assert
        assertNotNull(savedTask.getId());
    }
}
