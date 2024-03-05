
public class binarySearchTree<E extends Comparable<Report>> {
	private static class Node<E> {
        E data;
        Node<E> left, right;
        int leftChldrn = 0;
        int rightChldrn = 0;

        public Node(E object) {
            data = object;
            left = right = null;
        }
    }
    Node<E> root;

    /**
     * base constructor for creating empty BST
     */
    public binarySearchTree() {
        root = null;
    }
    
    /**
     * Add method for adding items to the BST
     * @param value
     */
    public void add(E value) {
        root = insert(root, value);
    }

    /**
     * Helper method for inserting reports in the correct place
     * to adhere to BST standards
     * @param start
     * @param object
     * @return
     */
    private Node<E> insert(Node<E> start, E object) {
        if (start == null) {
            start = new Node<E>(object);
            return start;
        }
        if (compare(object, start.data) < 0) {
			start.left = insert(start.left, object);
			start.leftChldrn += 1;
		} else if (compare(object, start.data) == 0) {
			start.right = insert(start.right, object);
			start.rightChldrn += 1;
		} else if (compare(object, start.data) > 0) {
			start.right = insert(start.right, object);
			start.rightChldrn += 1;
		}

      

        return start;
    }
    
    /**
     * Compare helper method for comparing the start times of reports in the
     * BST to dates in string form
     * @param object
     * @param a
     * @return value 
     */
    private int compare(E object, E a) {
    	
    	return object.compareTo((Report) a);
    }
	
    /**
     * public print method for printing BST in order
     */
    public void printTreeInOrder() {
    	inOrderTree(root);
    }
    /**
     * Helper method for printing the BST in order
     * @param nd
     */
    private void inOrderTree(Node<E> nd) {
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
    
    /**
     * Method to return total nodes in BST
     * @return
     */
    public int getChildren() {
    	return root.leftChldrn + root.rightChldrn + 1;
    }
    
    /**
     * Method to find the amount of reports
     * that happened on/after a given time without recursion.
     * @param time
     * @return count of child nodes under the first node that has start time within given time
     */
    public int findChildren(String time) {
    	Node<E> n = root;
    	Report e = (Report) n.data;
    	if(e.getStart_Time().compareTo(time) > 0) {
    		Report f = (Report) n.left.data;
    		int chk = 0;
    		while(f.getStart_Time().compareTo(time) >= 0) {
    			chk++;
    			chk += n.rightChldrn;
    			n = n.left;
    			f = (Report) n.left.data;
    		} return n.rightChldrn + chk + 1;
    	} n = root;
    	while(e.getStart_Time().compareTo(time) < 0) {
    		n = n.right;
    		if(n.data == null) {
    			return 0;
    		}
        	e = (Report) n.data;
    	} return n.rightChldrn + 1;
    }
}
