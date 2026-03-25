package org.example.todolist;

import jakarta.persistence.*;

@Entity
    @Table(name = "tasks")
    public class Task {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String title;
        private String status = "Pending";

        // getters and setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }

