package tree;

import lombok.Getter;
import lombok.Setter;

/**
 * 二叉树
 */
public class BinaryTree<T> {

    public void createTree() {

    }

    public void preOrder() {

    }

    public void inOrder() {

    }

    public void postOrder() {

    }

    @Getter
    @Setter
    private static class Node<T> {
        private Node<T> left;
        private Node<T> right;
        private T data;

        public Node() {
        }

        public Node(Node<T> left, Node<T> right, T data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }
}
