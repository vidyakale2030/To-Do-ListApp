package org.example.todolist;
    import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    @CrossOrigin
    public class TaskController {

        private final TaskRepository repo;

        public TaskController(TaskRepository repo) {
            this.repo = repo;
        }

        // ✅ Add task
        @PostMapping("/add")
        public String addTask(@RequestParam String title) {
            Task t = new Task();
            t.setTitle(title);
            repo.save(t);
            t.setStatus("pending");
            return "Task Saved in DB ✅";
        }

        // ✅ Get all tasks
        @GetMapping("/tasks")
        public List<Task> getTasks() {
            return repo.findAll();
        }

        // ✅ Delete
        @DeleteMapping("/delete/{id}")
        public String deleteTask(@PathVariable int id) {
            repo.deleteById(id);
            return "Deleted";
        }

        // ✅ 🔥 FIXED UPDATE METHOD
        @PutMapping("/update/{id}")
        public String updateTask(@PathVariable int id) {
            Task task = repo.findById(id).orElse(null);

            if (task != null) {
                if (task.getStatus().equals("Pending")) {
                    task.setStatus("Completed");
                } else {
                    task.setStatus("Pending");
                }
                repo.save(task); // 🔥 VERY IMPORTANT
            }

            return "Completed Successfully 🔄";
        }
    }
