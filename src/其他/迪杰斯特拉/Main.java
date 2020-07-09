package 其他.迪杰斯特拉;

import java.util.*;

public class Main {
    private static int MAX = 256;
    public static int[][] weight;

    public static int getVal(int[][] graph, int index) {
        return graph[index / graph.length][index % graph.length];
    }

    public static int getX(int[][] graph, int index) {
        return index / graph.length;
    }

    public static int getY(int[][] graph, int index) {
        return index % graph.length;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        int startX = in.nextInt();
        int startY = in.nextInt();
        int[][] graph = new int[height][width];
        int total = height * width;
        weight = new int[total][total];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                graph[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                weight[i][j] = MAX;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < weight.length; i++) {
            weight[i][i] = 0;
            int val = getVal(graph, i);
            int x = getX(graph, i);
            int y = getY(graph, i);
            if (x == 0 || x == height - 1) {
                list.add(i);
            }
            if (y == 0 || y == width - 1) {
                list.add(i);
            }
            if (y < (width - 1) && i + 1 < total && getVal(graph, i + 1) <= val) {
                weight[i][i + 1] = 1;
            }
            if (y != 0 && i - 1 >= 0 && getVal(graph, i - 1) <= val) {
                weight[i][i - 1] = 1;
            }
            if (i + width < total && getVal(graph, i + width) <= val) {
                weight[i][i + width] = 1;
            }
            if (i - width >= 0 && getVal(graph, i - width) <= val) {
                weight[i][i - width] = 1;
            }
        }

        int start = startX * width + startY;
        int resultIndex = -1;
        int resultLen = 256;
        for (int i = 0; i < list.size(); i++) {
            if (getVal(graph, list.get(i)) <= start) {
                int len = resolve(start, list.get(i));
                if (len < resultLen) {
                    resultLen = len;
                    resultIndex = list.get(i);
                }
            }
        }
        if (resultLen >= 256) {
            System.out.print("-1 -1 -1");
            return;
        }
        System.out.print(resultIndex / graph.length + " " + resultIndex % graph.length + " " + resultLen);
    }

    public static int resolve(int start, int end) {

        if (start < 0 || end < 0 || start >= weight.length || end >= weight.length) {
            return MAX;
        }

        boolean[] isVisited = new boolean[weight.length];
        int[] d = new int[weight.length];

        for (int i = 0; i < weight.length; i++) {
            isVisited[i] = false;
            d[i] = MAX;
        }
        d[start] = 0;
        isVisited[start] = true;
        int unVisitedNum = weight.length;
        int index = start;

        while (unVisitedNum > 0 && index != end) {
            int min = MAX;
            for (int i = 0; i < weight.length; i++) {
                if (min > d[i] && !isVisited[i]) {
                    min = d[i];
                    index = i;
                }
            }
            for (int i = 0; i < weight.length; i++) {
                if (d[index] + weight[index][i] < d[i]) {
                    d[i] = d[index] + weight[index][i];
                }
            }
            unVisitedNum--;
            isVisited[index] = true;
        }

        return d[end];
    }
}
