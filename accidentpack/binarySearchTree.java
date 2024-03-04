
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
	 public int getCountTime(String time) {
        // TODO Auto-generated method stub
        return countHelper(root, time);
    }

    private int countHelper(Node<E> node, String time) {
        // TODO Auto-generated method stub
        if(node == null) return 0;
        int count = 0;
        Report report = (Report) node.data;
        if (report.getStart_Time().compareTo(time) >= 0) {
            count++; // Count the current report if its start time is on or after the given time
        }

        // Recursively count reports in the left and right subtrees
        count += countHelper(node.left, time);
        count += countHelper(node.right, time);

        return count;
    }
    public int getTotalCount() {
         return getTotalHelper(root);
    }

    private int getTotalHelper(Node<E> node) {
        // TODO Auto-generated method stub
        if(node == null)return 0;
        int count = 0;
        count++;
        count += getTotalHelper(node.left);
        count += getTotalHelper(node.right);
        return count;
    }
}
