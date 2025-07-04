@param dev.dtk.task_manager.Task.Task task

<tr id="task-edit" colspan="1">
    <td>
        <form
                hx-post="/update-task/${task.getId()}/description"
                hx-target="#task-${task.getId()}"
                hx-swap="outerHTML"
                hx-on::after-request="this.reset()"
                class="flex gap-2 whitespace-nowrap w-full"
        >
            <div class="flex-1 whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-white sm:pl-0">
                <%--                <label for="description-${task.getId()}">Description</label>--%>
                <textarea
                        id="description-${task.getId()}"
                        name="description"
                        required
                        class="shadow appearance-none border rounded text-gray-700 focus:outline-none focus:shadow-outline leading-tight w-full"
                >${task.getDescription()}</textarea>
            </div>
            <div class="flex flex-col gap-1 relative whitespace-nowrap py-4 pl-3 pr-4 text-right text-sm font-medium sm:pr-0">
                <button
                        hx-post="/update-task/${task.getId()}/description"
                        hx-target="#task-edit"
                        hx-swap="outerHTML"
                        type="submit"
                        value="Submit"
                >
                    @template.components.check()
                </button>
                <button
                        hx-get="/update-task/${task.getId()}/edit-cancel"
                        hx-target="#task-edit"
                        hx-swap="outerHTML"
                        type="button"
                        value="Cancel"
                >
                    @template.components.x()
                </button>
            </div>
        </form>
    </td>
    <td>
        <div class="whitespace-nowrap px-3 py-4 text-sm text-gray-300">
            @template.status-view(task = task)
        </div>
    </td>
    <td class="relative whitespace-nowrap py-4 pl-3 pr-4 text-right text-sm font-medium sm:pr-0">
        <button hx-delete="/delete-task/${task.getId()}"
                hx-target="closest tr"
                hx-swap="outerHTML swap:1s"
                class="text-indigo-400 hover:text-indigo-300">
            @template.components.trash()
        </button>
    </td>
</tr>
