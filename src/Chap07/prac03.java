package Chap07;

public class prac03 {
    private int max;
    private int num;
    private int[] set;

    public prac03(int capacity) {
        num = 0;
        max = capacity;
        try {
            set = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public int indexOf(int n) {
        for (int i = 0; i < num; i++) {
            if (set[i] == n) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int n) {
        return (indexOf(n) != -1) ? true : false;
    }

    public boolean add(int n) {
        if (num >= max || contains(n) == true) {
            return false;
        } else {
            set[num++] = n;
            return true;
        }
    }

    public boolean remove(int n) {
        int idx;

        if (num <= 0 || (idx = indexOf(n)) == -1) {
            return false;
        } else {
            set[idx] = set[--num];
            return true;
        }
    }

    public void copyTo(prac03 s) {
        int n = (s.max < num) ? s.max : num;
        for (int i = 0; i < n; i++) {
            s.set[i] = set[i];
        }
        s.num = n;
    }

    public void copyFrom(prac03 s) {
        int n = (max < s.num) ? max : s.num;
        for (int i = 0; i < n; i++) {
            set[i] = s.set[i];
        }
        num = n;
    }

    public boolean equalTo(prac03 s) {
        if (num != s.num) {
            return false;
        }

        for (int i = 0; i < num; i++) {
            int j = 0;
            for ( ; j < s.num; j++) {
                if (set[i] == s.set[j]) {
                    break;
                }
            }
            if (j == s.num) {
                return false;
            }
        }
        return true;
    }

    public void unioOf(prac03 s1, prac03 s2) {
        copyFrom(s1);
        for (int i = 0; i < s2.num; i++) {
            add(s2.set[i]);
        }
    }

    public String toString() {
        StringBuffer temp = new StringBuffer("{");
        for (int i = 0; i < num; i++) {
            temp.append(set[i] + " ");
        }
        temp.append("}");

        return temp.toString();
    }

    // 집합 s의 부분집합인지 확인
    public boolean isSubsetOf(prac03 s) {
        for (int i = 0; i < num; i++) {
            int j = 0;
            for (; j < s.num; j++) {
                if (set[i] == s.set[j])
                    break;
            }
            if (j == s.num)
                return false;
        }
        return true;
    }

    // 집합 s의 진부분집합인지 확인
    public boolean isProperSubsetOf(prac03 s) {
        if (num >= s.num)
            return false;
        return s.isSubsetOf(s);
    }
}