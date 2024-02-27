package backjoon;

public class DoublyLinkedList {
	static class Node{
		int data;
		Node left,right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}
	static class dll{
		int size;
		Node head,tail;
		public dll() {
			this.head = null;
			this.tail = null;
			this.size = 0;
		}
		Node search(int index) {
//			System.out.println("head : "+head);
//			System.out.println("tail : "+tail);
			if(index <0 || index>= size) throw new IndexOutOfBoundsException();
			if(index>size/2) {
//				System.out.println("뒤에서");
				Node temp = this.tail;
				System.out.println(size-1 + " "+index);
				for (int i = size-1; i > index-1 ; i--) {
					temp = temp.left;
//					System.out.println(temp);
				}
				return temp;
			}else {
//				System.out.println("앞에ㅓ");
				Node temp = this.head;
				for (int i = 0; i < index; i++) {
					temp = temp.right;
				}
				return temp;
			}
		}
		void addFirst(int value) {
			Node temp = new Node(value);
			temp.right = this.head;
			if(head != null) {
				this.head.left = temp;
			}
			this.head = temp;
			this.size++;
			if(this.head == null)this.tail = this.head;
		}
		void addLast(int value) {
			Node temp = new Node(value);
			this.tail.right = temp;
			temp.left = this.tail;
			this.tail = temp;
			this.size++;
		}
		void add(int index, int value) {
			if(index == 0) {
				addFirst(value);
			}else if(index == size) {
				addLast(value);
			}else {
				Node leftTarget = search(index-1);
				Node rightTarget = leftTarget.right;
				Node temp = new Node(value);
				
				leftTarget.right = null;
				rightTarget.left = null;
				leftTarget.right = temp;
				rightTarget.left = temp;
				temp.left = leftTarget;
				temp.right = rightTarget;
				size++;
			}
		}
		void print() {
			System.out.println("size : "+size);
			System.out.println(head);
			System.out.println(tail);
			Node node = head;
			for (int i = 0; i < size; i++) {
				if(node == null) break;
				System.out.print(node.data+" ");
				node = node.right;
			}
			System.out.println();
		}
		@Override
		public String toString() {
			return "dll [size=" + size + ", head=" + head + ", tail=" + tail + "]";
		}
		
		
	}
	public static void main(String[] args) {
		dll doublyLinkedList = new dll();
		doublyLinkedList.add(0, 4);
		doublyLinkedList.add(0, 2);
		doublyLinkedList.add(0, 1);
		doublyLinkedList.add(2, 18);
		doublyLinkedList.print();
		System.out.println(doublyLinkedList.search(0).data);
		System.out.println(doublyLinkedList.search(1).data);
		System.out.println(doublyLinkedList.search(2).data);
		System.out.println(doublyLinkedList.search(3).data);
//		System.out.println(doublyLinkedList);
		
	}

}
