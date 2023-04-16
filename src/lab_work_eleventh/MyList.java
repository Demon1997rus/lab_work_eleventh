package lab_work_eleventh;

public class MyList {
	
	Node head = null;
	
	public void add(String value) {
		Node node = new Node();
		node.value = value;
		node.next = head;
		head = node;
	}
	
	public String toStringForward() {
		Node current = head;
		String result = "";
		while(current != null) {
			result += "[" + current.value + "] -->";
		    current = current.next;
		}
		return result;
	}	
	
	public String toStringBack() {
		Node current = head;
		StringBuilder result = new StringBuilder();
		while(current != null) {
			result.insert(0, "[" + current.value + "] -->");
		    current = current.next;
		}
		return result.toString();
	}
	
	public boolean delete(String value) {
		if(head == null)
			return false;
		if(head.value.compareTo(value) == 0) {
			head = head.next;
			return true;
		}
		
		Node pos = head;
		while(pos != null) {
			if(pos.next.value.compareTo(value) == 0) {
				pos.next = pos.next.next;
				return true;
			}
			pos = pos.next;
		}
		return false;
	}
	
	public void clear() {
		head = null;
	}
	
	public boolean search(String value) {
		Node pos = head;
		while(pos != null) {
			if(pos.value.compareTo(value) == 0) 
				return true;
			pos = pos.next;
		}
		return false;
	}
}
