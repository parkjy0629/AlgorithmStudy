package Chap10;
import java.util.Comparator;

public class prac02<K, V> {
    static class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> left;
        private Node<K, V> right;

        Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        void print() {
            System.out.println(data);
        }
    }

    private Node<K, V> root;
    private Comparator<? super K> comparator = null;

    public prac02() {
        root = null;
    }

    public prac02(Comparator<? super K> c) {
        this();
        comparator = c;
    }

    private int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1, key2);
    }

    public V search(K key) {
        Node<K, V> p = root;

        while (true) {
            if (p == null) {
                return null;
            }

            int cond = comp(key, p.getKey());

            if (cond == 0) {
                return p.getValue();
            } else if (cond < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
    }

    private void addNode(Node<K, V> node, K key, V data) {
        int cond = comp(key, node.getKey());

        if (cond == 0) {
            return;
        } else if (cond < 0) {
            if (node.left == null) {
                node.left = new Node<K, V>(key, data, null, null);
            } else {
                addNode(node.left, key, data);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<K, V>(key, data, null, null);
            } else {
                addNode(node.right, key, data);
            }
        }
    }

    public void add(K key, V data) {
        if (root == null) {
            root = new Node<K, V>(key, data, null, null);
        } else {
            addNode(root, key, data);
        }
    }

    public boolean remove(K key) {
        Node<K, V> p = root;
        Node<K, V> parent = null;
        boolean isLeftChild = true;

        while (true) {
            if (p == null) {
                return false;
            }

            int cond = comp(key, p.getKey());

            if (cond == 0) {
                break;
            } else {
                parent = p;

                 if (cond < 0) {
                     isLeftChild = true;
                     p = p.left;
                 } else {
                     isLeftChild = false;
                     p = p.right;
                 }
            }
        }

        if (p.left == null) {
            if (p == root) {
                root = p.right;
            } else if (isLeftChild) {
                parent.left = p.right;
            } else {
                parent.right = p.right;
            }
        } else if (p.right == null) {
            if (p == root) {
                root = p.left;
            } else if (isLeftChild) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
        } else {
            parent = p;
            Node<K, V> left = p.left;
            isLeftChild = true;

            while (left.right != null) {
                parent = left;
                left = left.right;
                isLeftChild = false;
            }

            p.key = left.key;
            p.data = left.data;

             if (isLeftChild) {
                 parent.left = left.left;
             } else {
                 parent.right = left.left;
             }
        }

        return true;
    }

    private void printSubTree(Node node) {
        if (node != null) {
            printSubTree(node.left);
            System.out.println(node.key + " " + node.data);
            printSubTree(node.right);
        }
    }

     public void print() {
        printSubTree(root);
     }

     private void printReverse(Node node) {
        if (node != null) {
            printReverse(node.right);
            System.out.println(node.key + " " + node.data);
            printReverse(node.left);
        }
     }

     public void printR() {
        printReverse(root);
     }

     public Node<K, V> getMinNode() {         // 가장 작은 키 값 반환
        Node<K, V> p = root;

        if (p == null) {         // 트리가 비어 있는 경우
            return null;
        } else {
            while (p.left != null)
                p = p.left;
            return p;
        }
     }

    public Node<K, V> getMaxNode() {         // 가장 큰 키 값 반환
        Node<K, V> p = root;

        if (p == null) {         // 트리가 비어 있는 경우
            return null;
        } else {
            while (p.right != null)
                p = p.right;
            return p;
        }
    }

    // 최소 key의 값을 반환
    public K getMinKey() {
        Node<K, V> minNode = getMinNode();
        return (minNode == null ? null : minNode.getKey());
    }

    // 최소 key의 값을 갖는 노드의 데이터를 반환
    public V getDataWithMinKey() {
        Node<K, V> minNode = getMinNode();
        return (minNode == null ? null : minNode.getValue());
    }

    // 최대 key의 값을 반환
    public K getMaxKey() {
        Node<K, V> maxNode = getMaxNode();
        return (maxNode == null ? null : maxNode.getKey());
    }

    // 최대 key의 값을 갖는 노드의 데이터를 반환
    public V getDataWithMaxKey() {
        Node<K, V> maxNode = getMinNode();
        return (maxNode == null ? null : maxNode.getValue());
    }
}
