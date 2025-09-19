import java.util.*;
//day39 of daily log
class TaskManager {
    private static class Task {
        int userId, taskId, priority;
        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private final Map<Integer, Task> taskMap; 
    private final PriorityQueue<Task> pq;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (b.priority != a.priority) return b.priority - a.priority;
            return b.taskId - a.taskId;
        });

        for (List<Integer> t : tasks) {
            Task task = new Task(t.get(0), t.get(1), t.get(2));
            taskMap.put(t.get(1), task);
            pq.offer(task);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        pq.offer(task);
    }

    public void edit(int taskId, int newPriority) {
        Task old = taskMap.get(taskId);
        // old is guaranteed to exist per problem statement
        Task updated = new Task(old.userId, taskId, newPriority);
        taskMap.put(taskId, updated);
        pq.offer(updated); // old entries become stale
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId); // lazy deletion: stale entries remain in pq
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Task top = pq.poll();
            Task current = taskMap.get(top.taskId);

            // If current is null => task was removed; skip stale entry.
            // If current exists but priority differs => stale entry from before an edit; skip.
            if (current != null && current.priority == top.priority) {
                // Use current.userId (the latest mapping) – top.userId might be stale.
                taskMap.remove(top.taskId);
                return current.userId;
            }
            // otherwise stale entry -> continue
        }
        return -1;
    }
}
