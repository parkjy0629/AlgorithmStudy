package Chap07;

public class prac04 {
    private int max;
    private int num;
    private int[] set;

    public prac04(int capacity) {
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

    public void copyTo(prac04 s) {
        int n = (s.max < num) ? s.max : num;
        for (int i = 0; i < n; i++) {
            s.set[i] = set[i];
        }
        s.num = n;
    }

    public void copyFrom(prac04 s) {
        int n = (max < s.num) ? max : s.num;
        for (int i = 0; i < n; i++) {
            set[i] = s.set[i];
        }
        num = n;
    }

    public boolean equalTo(prac04 s) {
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

    public void unioOf(prac04 s1, prac04 s2) {
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

    // s1과 s2의 교집합을 복사
    public void intersectionOf(prac04 s1, prac04 s2) {
        num = 0;
        for (int i = 0; i < s1.num; i++)
            if (s2.contains(s1.set[i]))
                add(s1.set[i]);
    }

    // s1과 s2의 차집합을 복사
    public void differenceOf(prac04 s1, prac04 s2) {
        num = 0;
        for (int i = 0; i < s1.num; i++)
            if (!s2.contains(s1.set[i]))
                add(s1.set[i]);
    }
}