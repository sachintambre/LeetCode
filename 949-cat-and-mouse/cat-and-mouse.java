class Solution {
    public int catMouseGame(int[][] graph) {
         final int n = graph.length;
        final int totalStates = n * n * 3;

        int[] results = new int[totalStates];
        int[] degrees = new int[totalStates];
        int[] queue = new int[totalStates];
        for (int m = 0; m < n; m++) {
            int mouseBase = m * n * 3;

            for (int c = 1; c < n; c++) {
                int base = mouseBase + c * 3;
                degrees[base + 1] = graph[m].length;
                int count = 0;
                int[] catNeighbors = graph[c];

                for (int i = 0; i < catNeighbors.length; i++) {
                    if (catNeighbors[i] != 0) {
                        count++;
                    }
                }

                degrees[base + 2] = count;
            }
        }

        int head = 0;
        int tail = 0;
        for (int c = 1; c < n; c++) {
            int state1 = c * 3 + 1;
            results[state1] = 1;
            queue[tail++] = state1;

            int state2 = c * 3 + 2;
            results[state2] = 1;
            queue[tail++] = state2;
        }
        for (int m = 1; m < n; m++) {
            int state1 = (m * n + m) * 3 + 1;
            results[state1] = 2;
            queue[tail++] = state1;

            int state2 = (m * n + m) * 3 + 2;
            results[state2] = 2;
            queue[tail++] = state2;
        }

        while (head < tail) {
            int stateId = queue[head++];
            int t = stateId % 3;
            int position = stateId / 3;
            int c = position % n;
            int m = position / n;

            int result = results[stateId];

            if (t == 1) {
                int[] neighbors = graph[c];

                for (int i = 0; i < neighbors.length; i++) {
                    int prevC = neighbors[i];

                    if (prevC == 0) {
                        continue;
                    }

                    int prevState = (m * n + prevC) * 3 + 2;

                    if (results[prevState] != 0) {
                        continue;
                    }

                    if (result == 2) {
                        results[prevState] = 2;
                        queue[tail++] = prevState;
                    } else {
                        int remaining = --degrees[prevState];

                        if (remaining == 0) {
                            results[prevState] = 1;
                            queue[tail++] = prevState;
                        }
                    }
                }

            } else {
                int[] neighbors = graph[m];

                for (int i = 0; i < neighbors.length; i++) {
                    int prevM = neighbors[i];

                    int prevState = (prevM * n + c) * 3 + 1;

                    if (results[prevState] != 0) {
                        continue;
                    }

                    if (result == 1) {
                        results[prevState] = 1;
                        queue[tail++] = prevState;
                    } else {
                        int remaining = --degrees[prevState];

                        if (remaining == 0) {
            
                            results[prevState] = 2;
                            queue[tail++] = prevState;
                        }
                    }
                }
            }
        }
        return results[(1 * n + 2) * 3 + 1];
    }
}
