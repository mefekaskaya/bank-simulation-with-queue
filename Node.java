
public class Node {
	private String name;
	private Node next;
	private Node prev;
	private int priority;
	
	public Node(String name, int priority) {
		this.name = name;
		this.next = null;
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getPriority() {
		return priority;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	
	
}
