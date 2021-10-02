package Chap10;
import java.util.Comparator;
import  java.util.Scanner;
// 이진검색트리 클래스 BinTree<K, V> 이용 예

public class BinTreeTester {
    static Scanner stdIn = new Scanner(System.in);

    // 데이터 (회원번호 + 이름)
    static class Data {
        public static final int NO = 1;
        public static final int NAME = 2;

        private Integer no;         // 회원번호(키 값)
        private String name;        // 이름

        // 키 값
        Integer keyCode() {
            return  no;
        }

        // 문자열 반환
        public String toString() {
            return name;
        }

        // 데이터 입력
        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요.");

            if ((sw & NO) == NO) {
                System.out.print("번호 : ");
                no = stdIn.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.print("이름 : ");
                name = stdIn.next();
            }
        }
    }

    // 메뉴 열거형
    enum Menu {
        ADD("삽입"),
        REMOVE("삭제"),
        SEARCH("검색"),
        PRINT("표시"),
        TERMINATE("종료");

        private final String message;

        static Menu MenuAt(int idx) {
            for (Menu m : Menu.values()) {
                if (m.ordinal() == idx) {
                    return m;
                }
            }

            return null;
        }

        Menu (String string) {
            message = string;
        }

        String getMessage() {
            return message;
        }
    }

    // 메뉴 선택
    static Menu SelectMenu() {
        int key;

        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s ", m.ordinal(), m.getMessage());
            }
            System.out.print(" : ");
            key = stdIn.nextInt();
        } while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;
        Data data;
        Data ptr;
        Data temp = new Data();
        BinTree<Integer, Data> tree = new BinTree<Integer, Data>();

        do {
            switch (menu = SelectMenu()) {
                case ADD :              // 노드 삽입
                    data = new Data();
                    data.scanData("삽입", Data.NO | Data.NAME);
                    tree.add(data.keyCode(), data);
                    break;
                case REMOVE :           // 노드 삭제
                    temp.scanData("삭제", Data.NO);
                    tree.remove(temp.keyCode());
                    break;
                case SEARCH :           // 노드 검색
                    temp.scanData("검색", Data.NO);
                    ptr = tree.search(temp.keyCode());

                    if (ptr != null) {
                        System.out.println("그 번호의 이름은 " + ptr + "입니다.");
                    } else {
                        System.out.println("해당 데이터가 없습니다.");
                    }
                    break;
                case PRINT :            // 모든 노드의 키 값의 오름차순으로 출력
                    tree.print();
                    break;
            }
        } while (menu != Menu.TERMINATE);
    }
}
