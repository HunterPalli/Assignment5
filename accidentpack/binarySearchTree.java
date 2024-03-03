
public class binarySearchTree<E extends Comparable<Report>> {
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
    
    public void add(E value) {
        root = insert(root, value);
    }

    private Node<E> insert(Node<E> root, E object) {
        if (root == null) {
            root = new Node<E>(object);
            return root;
        }
        if (compare(object, root.data) < 0) {
			root.left = insert(root.left, object);
		} else if (compare(object, root.data) == 0) {
			root.right = insert(root.right, object);
		} else if (compare(object, root.data) > 0) {
			root.right = insert(root.right, object);
		}

        //Need binary search tree sorted insert if statements

        return root;
    }
    
    private int compare(E object, E a) {
    	
    	return object.compareTo((Report) a);
    }
	
    public void printTreeInOrder() {
    	inOrderTree(root);
    }
    private void inOrderTree(Node nd) {
    	if(nd == null) {
    		return;
    	}
    	inOrderTree(nd.left);
    	System.out.println(nd.data.toString());
    	inOrderTree(nd.right);
    }
}
