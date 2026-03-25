package org.example.todolist;

    import org.springframework.data.jpa.repository.JpaRepository;

    public interface TaskRepository extends JpaRepository<Task, Integer> {
    }
