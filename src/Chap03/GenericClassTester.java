package Chap03;
// 제네릭 클래스 예

public class GenericClassTester {
    // 제네릭 클래스의 파라미터를 T라고 작성
    static class GenericClass<T> {
        private T xyz;

        // 생성자
        GenericClass(T t) {
            this.xyz = t;
        }

        // xyz를 반환
        T getXyz() {
            return xyz;
        }
    }

    public static void main (String[] args) {
        // 다음과 같이 파라미터에 String을 넘길 수도 있고 Integer을 넘길 수도 있다.
        GenericClass<String> s = new GenericClass<String>("ABC");
        GenericClass<Integer> n = new GenericClass<Integer>(15);

        System.out.println(s.getXyz());
        System.out.println(n.getXyz());
    }
}
