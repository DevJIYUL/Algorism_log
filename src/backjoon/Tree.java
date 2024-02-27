package backjoon;

public class Tree {
	static class Node{
		int data;
		Node left,right;
		public Node() {
			super();
		}
		public Node(int data) {
			super();
			this.data = data;
		}
		
		
	}
	static class BinaryTree{
		Node root;
		public BinaryTree() {
			super();
		}
		
		void add(int data) {
			Node temp = new Node();
			temp.data = data;
			if(root == null) {
				root = temp;
			}else {
				root = addNode(root,temp);
			}
		}

		private Node addNode(Node root, Node temp) {
			if(root == null)return temp;
			else if(root.data>temp.data)root.left = addNode(root.left, temp);
			else root.right = addNode(root.right, temp);
			return root;
		}
		void Inorderprint() {
			leftInorder(root);
			System.out.println();
		}

		private void leftInorder(Node root2) {
			if(root2 == null)return;
			leftInorder(root2.left);
			System.out.print(root2.data+ " ");
			leftInorder(root2.right);
		}
		void remove(int data) {
			root = removeNode(root,data);
		}

		private Node removeNode(Node node, int data) {
			if(node==null) throw new RuntimeException("해당값없음");
			if(node.data<data) {
				// 루트에서 오른쪽 탐색
				node.right = removeNode(node.right, data);
			}else if(node.data>data) {
				// 루트에서 왼쪽 탐색
				node.left = removeNode(node.left, data);
			}else {
				// 해당 노드가 삭제 대상일때
				// 해당 노드가 리프노드인지 확인
				if(node.right !=null) {
					/* 오른쪽에 값이 존재한다면 
					 * 삭제대상보다 큰 노드(최종 목표 : 리프노드)를 찾아서
					 * 삭제대상과 큰 노드를 swap 하고 
					 * 큰 노드가 리프노트가 아닐수도 있으니 
					 * 왼쪽을 대상으로 removeNode실행
					 */
					Node child = findMin(node.right);
					int remove = data;
					node.data = child.data;
					child.data = remove;
					node.right = removeNode(node.right, data);
				}else if(node.left != null) {
					Node child = findMax(node.left);
					int remove =data;
					node.data = child.data;
					child.data = remove;
					node.left = removeNode(node.left, data);
				}else {
					node = null;
				}
			}
			return node;
		}

		private Node findMax(Node left) {
			if(left.right == null)return left;
			return findMax(left.right);
		}

		private Node findMin(Node right) {
			if(right.left == null)return right;
			return findMin(right.left);
		}
		
	}
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(7);
		bt.add(4);
		bt.add(2);
		bt.add(6);
		bt.add(10);
		bt.add(8);
		bt.add(12);
		bt.add(9);
		bt.remove(2);
		bt.Inorderprint();
	}

}
