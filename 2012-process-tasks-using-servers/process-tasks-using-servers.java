class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int numServers = servers.length;
      
        // Priority queue for idle servers
        // Sorted by: 1) server weight (ascending), 2) server index (ascending)
        PriorityQueue<int[]> idleServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];  // Compare by weight
            }
            return a[1] - b[1];  // Compare by index if weights are equal
        });
      
        // Priority queue for busy servers
        // Sorted by: 1) free time (ascending), 2) server weight (ascending), 3) server index (ascending)
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];  // Compare by free time
            }
            if (a[1] != b[1]) {
                return a[1] - b[1];  // Compare by weight if free times are equal
            }
            return a[2] - b[2];  // Compare by index if both free time and weight are equal
        });
      
        // Initialize idle servers queue with all servers
        // Each entry: [weight, index]
        for (int i = 0; i < numServers; i++) {
            idleServers.offer(new int[] {servers[i], i});
        }
      
        int numTasks = tasks.length;
        int[] result = new int[numTasks];
      
        // Process each task
        for (int taskIndex = 0; taskIndex < numTasks; taskIndex++) {
            int taskDuration = tasks[taskIndex];
          
            // Move servers that have become free at current time back to idle queue
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= taskIndex) {
                int[] freedServer = busyServers.poll();
                // Add back to idle queue: [weight, index]
                idleServers.offer(new int[] {freedServer[1], freedServer[2]});
            }
          
            // Assign task to a server
            if (!idleServers.isEmpty()) {
                // Use an idle server
                int serverIndex = idleServers.poll()[1];
                result[taskIndex] = serverIndex;
                // Add to busy queue: [free time, weight, index]
                busyServers.offer(new int[] {taskIndex + taskDuration, servers[serverIndex], serverIndex});
            } else {
                // All servers are busy, wait for the earliest one to become free
                int[] earliestFreeServer = busyServers.poll();
                int serverIndex = earliestFreeServer[2];
                result[taskIndex] = serverIndex;
                // Reschedule server: [new free time, weight, index]
                busyServers.offer(new int[] {earliestFreeServer[0] + taskDuration, earliestFreeServer[1], serverIndex});
            }
        }
      
        return result;
    }
}
