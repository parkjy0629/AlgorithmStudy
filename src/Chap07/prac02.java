package Chap07;

public class prac02 {
    private int max;
    private int num;
    private int[] set;

    public prac02(int capacity) {
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

    public void copyTo(prac02 s) {
        int n = (s.max < num) ? s.max : num;
        for (int i = 0; i < n; i++) {
            s.set[i] = set[i];
        }
        s.num = n;
    }

    public void copyFrom(prac02 s) {
        int n = (max < s.num) ? max : s.num;
        for (int i = 0; i < n; i++) {
            set[i] = s.set[i];
        }
        num = n;
    }

    public boolean equalTo(prac02 s) {
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

    public void unioOf(prac02 s1, prac02 s2) {
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

    // 집합 s와의 합집합 구하기
    public boolean add(prac02 s) {
        boolean flag = false;;

        for (int i = 0; i < num; i++) {
            if (add(set[i]) == true) {
                flag = true;
            }
        }

        return flag;
    }

    // 집합 s와의 교집합 구하기
    public boolean retain(prac02 s) {
        boolean flag = false;

        for (int i = 0; i < num; i++) {
            if (s.contains(set[i]) == false) {
                remove(set[i]);
                flag = true;
            }
        }

        return flag;
    }

    // 집합 s와의 차집합 구하기
    public boolean remove(prac02 s) {
        boolean flag = false;

        for (int i = 0; i < num; i++) {
            if (s.contains(set[i]) == true) {
                remove(set[i]);
                flag = true;
            }
        }
        
        return flag;
    }
}