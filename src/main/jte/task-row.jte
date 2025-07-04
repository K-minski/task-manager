@param dev.dtk.task_manager.Task.Task task

    <tr id="task-${task.getId()}">
        <td class="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-white sm:pl-0">
            <p>${task.getDescription()}</p>
        </td>
        <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-300">
            @template.status-view(task = task)
        </td>
        <td class="relative whitespace-nowrap py-4 pl-3 pr-4 text-right text-sm font-medium sm:pr-0">
            <button
                    hx-get="/update-task/${task.getId()}/edit"
                    hx-target="#task-${task.getId()}"
                    hx-swap="outerHTML"
                    class="text-indigo-400 hover:text-indigo-300">
                @template.components.pencil()
            </button>
            <button hx-delete="/delete-task/${task.getId()}"
                    hx-target="closest tr"
                    hx-swap="outerHTML swap:1s"
                    class="text-indigo-400 hover:text-indigo-300">
                @template.components.trash()
            </button>
        </td>
    </tr>
