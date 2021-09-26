package Chap09;
import java.util.Comparator;

public class prac07<E> {
    class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = this;
        }

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private Node<E> crnt;

    public prac07() {
        head = tail = crnt = null;
    }

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;
        
        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        
        return null;
    }

    public void addFirst(E obj) {
        Node<E> ptr = head;
        head = tail = crnt = new Node<E>(obj);

        if (ptr != null) {
            tail.next = head;
        }
    }

    public void addLast(E obj) {
        if (head == null) {
            addFirst(obj);
        } else {
            Node<E> ptr = tail;
            ptr.next = crnt = tail = new Node<E>(obj, null);
        }
    }

    public void removeFirst() {
        if (head != null) {
            if (head == tail)
                head = tail = crnt = null;
            else {
                Node<E> ptr = head.next;
                head = crnt = ptr;
                tail.next = head;
            }
        }
    }

    public void removeLast() {
        if (head != null) {
            if (head == tail) {
                removeFirst();
            } else {
                Node<E> ptr = head;
                Node<E> pre = head;

                while (ptr.next != head) {
                    pre = ptr;
                    ptr = ptr.next;
                }

                pre.next = head;
                tail = crnt = pre;
            }
        }
    }

    public void remove(Node p) {
        if (head != null) {
            if (p == head) {
                removeFirst();
            } else if (p == tail) {
                removeLast();
            } else {
                Node<E> ptr = head;

                while (ptr.next != p) {
                    ptr = ptr.next;
                    if (ptr == null) {
                        return;
                    }
                }

                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    public void removeCurrentNode() {
        remove(crnt);
    }

    public void clear() {
        while (head != null) {
            removeFirst();
        }

        crnt = null;
    }

    public boolean next() {
        if (crnt == null || crnt.next == head) {
            return false;
        }

        crnt = crnt.next;
        return true;
    }

     public void printCurrentNode() {
        if (crnt == null) {
            System.out.println("선택한 노드가 없습니다.");
        } else {
            System.out.println(crnt.data.toString());
        }
     }

    public void dump() {
        if (head != null) {
            Node<E> ptr = head;

            do {
                System.out.println(ptr.data.toString());
                ptr = ptr.next;
            } while (ptr != head);
        }
    }

    public void purge(Comparator<? super E> c) {
        if (head == null) {
            return;
        }
        Node<E> ptr = head;

        do {
            int count = 0;
            Node<E> ptr2 = ptr;
            Node<E> pre = ptr;

            while (pre.next != head) {
                ptr2 = pre.next;
                if (c.compare(ptr.data, ptr2.data) == 0) {
                    remove(ptr2);
                    count++;
                } else {
                    pre = ptr2;
                }
            }

            if (count == 0) {
                ptr = ptr.next;
            } else {
                Node<E> temp = ptr;
                remove(ptr);
                ptr = temp.next;
            }
        } while (ptr.next != head);

        crnt = head;
    }

    public E retrieve(int n) {
        if (head != null) {
            Node<E> ptr = head;

            while (n >= 0) {
                if (n-- == 0) {
                    crnt = ptr;
                    return (ptr.data);
                }

                ptr = ptr.next;

                if (ptr == head) {
                    break;
                }
            }
        }

        return (null);
    }
}
