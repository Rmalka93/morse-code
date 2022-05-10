
public class Node<E> {
	private E data; // keep the data of the node
	private Node<E> leftSon; // left son of the root
	private Node<E> rightSon; // right son of the root

	// Constructor to create node
	public Node(E data, Node<E> left, Node<E> right) {
		this.data = data;
		this.leftSon = left;
		this.rightSon = right;
	}

	// getters and setters
	public E getData() {
		return this.data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(Node<E> leftSon) {
		this.leftSon = leftSon;
	}

	public Node<E> getRightSon() {
		return rightSon;
	}

	public void setRightSon(Node<E> rightSon) {
		this.rightSon = rightSon;
	}

}
