@param dev.dtk.task_manager.Task.Task task

<button hx-patch="/update-task/${task.getId()}/status"
        hx-trigger="click"
        hx-target="this"
        hx-swap="outerHTML"
        class="text-indigo-400 hover:text-indigo-300">
    ${task.getStatus().toString()}
</button>