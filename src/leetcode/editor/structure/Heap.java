package leetcode.editor.structure;

public class Heap {
    private int[] a;
    private int max;
    private int n;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        max = capacity;
        n = 0;
    }

    public void insert(int val) {
        //增加，自下而上
        if (n == max) return;
        n++;
        a[n] = val;
        int i = n;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void removeMax() {
        if (n == 0) return;
        a[1] = a[n];
        n--;
        heapify(a, n, 1);
    }

    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }
}
