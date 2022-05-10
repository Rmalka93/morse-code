
public class BTree<E> {

	private Node<E> root; // node to the root of the tree
	private int size; // keep how many junction in tree
	private Node<E> thisNode = root;// current node
	private String pre = ""; // string to hold the result of pre order

	// empty constructor
	public BTree() {
		this.root = null;
		this.size = 0;
	}

	// add new junction
	public boolean addByPath(E data, String path) {

		// check if null
		if (path == null)
			return false;

		// if string is legal
		for (int i = 0; i < path.length(); i++)
			if (!(path.charAt(i) == 'R') && !(path.charAt(i) == 'L'))
				return false;

		// if the tree is empty create new root
		if (this.size == 0 && path == "") {
			this.size = 1;
			this.root = new Node(data, null, null);
			return true;
		}

		// update the thisNode with the root
		this.thisNode = this.root;
		
		// run on the string add according to chars
		for (int i = 0; i < path.length(); i++) {
			// the right cases
			if (path.charAt(i) == 'R') {
				// check if father exist
				if (this.thisNode != null)
					// check if son exist, if true skip to the son
					if (thisNode.getRightSon() != null)
						this.thisNode = thisNode.getRightSon();

					else {
						// if the son is empty and char(i) is not the last char
						if (this.thisNode.getRightSon() == null && i < path.length() - 1)
							return false;
						// create new son
						this.thisNode.setRightSon(new Node(data, null, null));
						this.size++;
						return true;
					}
			}
			// the left cases
			else if (path.charAt(i) == 'L') {
				// check if father exist
				if (this.thisNode != null)
					// check if son exist, if true skip to the son
					if (thisNode.getLeftSon() != null)
						this.thisNode = thisNode.getLeftSon();

					else {
						// if the son is empty and i is not the last char
						if (this.thisNode.getLeftSon() == null && i < path.length() - 1)
							return false;
						// create new son
						this.thisNode.setLeftSon(new Node(data, null, null));
						this.size++;
						return true;
					}
			}
		}
		return false;
	}

	// private method, visit all the nodes and make a string
	private void visit(Node<E> node) {
		
		pre = pre + (String) node.getData() + ", ";
		// if son is not empty get his data
		if (node.getLeftSon() != null)
			visit(node.getLeftSon());

		if (node.getRightSon() != null)
			visit(node.getRightSon());
	}
	// toString according to pre order of the tree
	public String pre() {
		// the string after update
		String endPre = "";
		
		// call visit and create the right string
		visit(root);
		//copy the string pre and remove the 2 last chars
		for (int i = 0; i < pre.length() - 2; i++)
			endPre = endPre + pre.charAt(i);

		return endPre;
	}

	public int getSize() {
		return this.size;
	}

	// get the data in node by path
	public E findByPath(String path) {
		// null case
		if (path == null)
			return null;

		E element = null;

		for (int i = 0; i < path.length(); i++) {
			// first time update the node
			if (i == 0)
				this.thisNode = this.root;
			// if node is real check the data R or L
			if (this.thisNode != null) {
				if (path.charAt(i) == 'R') {
					this.thisNode = this.thisNode.getRightSon();

				} else if (path.charAt(i) == 'L') {
					this.thisNode = this.thisNode.getLeftSon();

				}
			} // update the element if is the last char of string and not null
			if (i == path.length() - 1 && this.thisNode != null)
				element = this.thisNode.getData();
		}

		return element;
	}

}
