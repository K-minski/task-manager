package dev.dtk.task_manager.Task;

public enum TaskStatus {
    NOT_STARTED {
        @Override
        public String toString() {
            return "Not Started";
        }
    },
    IN_PROGRESS {
        @Override
        public String toString() {
            return "In Progress";
        }
    },
    COMPLETED {
        @Override
        public String toString() {
            return "Completed";
        }
    },
    ON_HOLD {
        @Override
        public String toString() {
            return "On Hold";
        }
    },
    CANCELLED {
        @Override
        public String toString() {
            return "Cancelled";
        }
    };
}
