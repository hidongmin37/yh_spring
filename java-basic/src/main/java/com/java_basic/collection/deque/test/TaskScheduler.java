package com.java_basic.collection.deque.test;

import java.util.ArrayDeque;

public class TaskScheduler {
    private static ArrayDeque<Task> deque = new ArrayDeque<>();


    public void addTask(Task task) {
        deque.offer(task);
    }

    public int getRemainingTasks() {
        return deque.size();
    }

    public void processNextTask() {
        for (Task task : deque) {
            task.execute();
            deque.pop();
        }
    }


}
