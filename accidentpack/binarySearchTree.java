
public class binarySearchTree<E> {
	private static class Node<E> {
        E data;
        Node<E> left, right;

        public Node(E object) {
            data = object;
            left = right = null;
        }
    }
    Node<E> root;

    public binarySearchTree() {
        root = null;
    }
    
    public void add(int value) {
        root = insert(root, value);
    }

    private Node<E> insert(Node<E> root, E object) {
        if (root == null) {
            root = new Node<E>(object);
            return root;
        }

        //Need binary search tree sorted insert if statements

        return root;
    }
	
}
