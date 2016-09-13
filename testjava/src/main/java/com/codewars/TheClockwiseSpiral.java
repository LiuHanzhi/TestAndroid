package com.codewars;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * https://www.codewars.com/kata/536a155256eb459b8700077e/train/java
 * success
 */
public class TheClockwiseSpiral {

    /**
     * clever
     * @param N
     * @return
     */
    public static int[][] createSpiral(int N) {
        int[][] s = new int[N][N];
        for (int turn = 0, n = N, now = 1; n > 0; turn++, n -= 2) {
            if (turn == N - 1 - turn) {
                s[turn][turn] = now;
                break;
            }
            int i, j;
            i = j = turn;
            for (; j < N - 1 - turn; j++) s[i][j] = now++;
            for (; i < N - 1 - turn; i++) s[i][j] = now++;
            for (; j > turn; j--) s[i][j] = now++;
            for (; i > turn; i--) s[i][j] = now++;
        }
        return s;
    }

    /**
     * public static int[][] createSpiral(int N) {
        ArrayList<KVBean> treeSet = new ArrayList<>();
        sort(treeSet, N);
        if (treeSet.size() == N * N) {
            int[][] reuslt = new int[N][N];
            Iterator<KVBean> iterator = treeSet.iterator();
            int count = 0;
            while (iterator.hasNext()) {
                KVBean kvBean = iterator.next();
                reuslt[kvBean.getI()][kvBean.getJ()] = count + 1;
                System.out.println("i:" + kvBean.getI() + ",j:" + kvBean.getJ());
                count++;
            }
            return reuslt;
        } else {
            return null;
        }

    }
*/
    private static void sort(ArrayList<KVBean> treeSet, int N) {
        int size = N * N;
        int index = 0;
        int total = 0;
        int count = 0;
        while (true) {
            if (total == size) {
                break;
            }

            switch (count % 4) {
                case 0:
                    for (int k = index; k < N - index; k++) {
                        KVBean kvBean = new KVBean();
                        kvBean.setI(index);
                        kvBean.setJ(k);
                        treeSet.add(kvBean);
                    }
                    total += (N - index * 2);
                    break;
                case 1:
                    for (int k = index + 1; k < N - index; k++) {
                        KVBean kvBean = new KVBean();
                        kvBean.setI(k);
                        kvBean.setJ(N - (index + 1));
                        treeSet.add(kvBean);
                    }
                    total += (N - index * 2 - 1);
                    break;
                case 2:
                    for (int k = N - index - 2; k >= index; k--) {
                        KVBean kvBean = new KVBean();
                        kvBean.setI(N - index - 1);
                        kvBean.setJ(k);
                        treeSet.add(kvBean);
                    }
                    total += (N - index * 2 - 1);
                    break;
                case 3:
                    for (int k = N - index - 2; k >= index + 1; k--) {
                        KVBean kvBean = new KVBean();
                        kvBean.setI(k);
                        kvBean.setJ(index);
                        treeSet.add(kvBean);
                    }
                    total += (N - index * 2 - 2);
                    break;
            }
            count++;
            if (count == 4) {
                count = 0;
                index++;
            }
        }
    }

    public static class KVBean {
        int i;
        int j;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }
    }
}