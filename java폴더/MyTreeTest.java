package hw9_1;

// 문장형 자료를 저장하는 이진 트리를 연결 자료구조로 구현한 클래스 
class MyLinkedTree {

	// 루트 노드를 가리키는 변수
	private Node root;

	// 노드 구조를 정의하는 클래스
	private class Node {
		char data;
		Node left;
		Node right;
	}

	// 생성자 
	public MyLinkedTree(char data, MyLinkedTree leftSubtree, MyLinkedTree rightSubtree) {
		root = new Node();
		root.data = data;

		if(leftSubtree == null)
			root.left = null;
		else
			root.left = leftSubtree.root;

		if(rightSubtree == null)
			root.right = null;
		else
			root.right = rightSubtree.root;
	}

	// 전위 순회를 위한 서비스 메소드 
	public void preOrder() {
		preOrder(root);
	}
	// 전위 순회하며 트리 노드 데이터를 출력하는 메소드
	public void preOrder(Node p) {
		if(p != null) {
			System.out.print(p.data + " ");
			preOrder(p.left);
			preOrder(p.right);
		}
	}
	// 중위 순회를 위한 서비스 메소드 
	public void inOrder() {
		inOrder(root);
	}
	// 중위 순회하며 트리 노드 데이터를 출력하는 메소드 
	public void inOrder(Node p) {
		if(p != null) {
			inOrder(p.left);
			System.out.print(p.data + " ");
			inOrder(p.right);
		}
	}
	// 후위 순회를 위한 서비스 메소드 
	public void postOrder() {
		postOrder(root);
	}
	// 후위 순회하며 트리 노드 데이터를 출력하는 메소드
	public void postOrder(Node p) {
		if(p != null) {
			postOrder(p.left);
			postOrder(p.right);
			System.out.print(p.data + " ");
		}
	}
}

//문자형 자료를 저장하는 이진 트리를 배열로 구현하는 클래스
class MyArrayTree {  
	// 배열 생성 
	private char[] charArray = new char[11];
	private int root = 0;

	//생성자 
	public MyArrayTree(char[] charArray) {
		this.charArray = charArray;
	}

	// 전위 순회를 위한 서비스 메소드 
	public void arrpreOrder() {
		arrpreOrder(root);
	}
	// 전위 순회하며 트리 노드 데이터를 출력하는 메소드
	public void arrpreOrder(int index) {
		if(index < charArray.length) {
			System.out.print(charArray[index] + " ");
			arrpreOrder(2*index+1);    // left
			arrpreOrder(2*index+2);    // right
		}
	}
	// 중위 순회를 위한 서비스 메소드 
	public void arrinOrder() {
		arrinOrder(root);
	}
	// 중위 순회하며 트리 노드 데이터를 출력하는 메소드 
	public void arrinOrder(int index) {
		if(index < charArray.length) {
			arrinOrder(2*index+1);    // left
			System.out.print(charArray[index] + " ");
			arrinOrder(2*index+2);    // right
		}
	}
	// 후위 순회를 위한 서비스 메소드 
	public void arrpostOrder() {
		arrpostOrder(root);
	}
	// 후위 순회하며 트리 노드 데이터를 출력하는 메소드
	public void arrpostOrder(int index) {
		if(index < charArray.length) {
			arrpostOrder(2*index+1);    // left
			arrpostOrder(2*index+2);    // right
			System.out.print(charArray[index] + " ");
		}
	}
}

//이진트리를 생성하고 순회하는 프로그램 
public class MyTreeTest {
	public static void main(String[] args) {
		System.out.println("hw9_1: 김하은");
		System.out.println();

		// (1) 노드 7개로 이루어진 MyLinkedTree형 예제 트리(linkedTree)를 다음과 같은 코드를 이용하여 생성
		MyLinkedTree tree7 = new MyLinkedTree('D', null, null);
		MyLinkedTree tree6 = new MyLinkedTree('C', null, null);
		MyLinkedTree tree5 = new MyLinkedTree('B', null, null);
		MyLinkedTree tree4 = new MyLinkedTree('A', null, null);
		MyLinkedTree tree3 = new MyLinkedTree('/', tree6, tree7);
		MyLinkedTree tree2 = new MyLinkedTree('*', tree4, tree5);
		MyLinkedTree linkedTree = new MyLinkedTree('-', tree2, tree3);

		// (2) linkedTree를 전위, 중위, 후위 순회
		System.out.println("연결 자료구조로 구현한 이진 트리 순회");
		System.out.print("전위 순회: ");
		linkedTree.preOrder();
		System.out.println();

		System.out.print("중위 순회: ");
		linkedTree.inOrder();
		System.out.println();

		System.out.print("후위 순회: ");
		linkedTree.postOrder();
		System.out.println();

		// (3) 노드 11개로 이루어진 MyArrayTree형 예제 트리(arrayTree)를 이용하여 생성
		char[] charArray = {'+', '-', '*', '*', '/', 'A', 'B', 'C', 'D', 'E', 'F'};
		MyArrayTree arrayTree = new MyArrayTree(charArray);

		// (4) arrayTree를 전위, 중위, 후위 순회
		System.out.println();
		System.out.println("배열로 구현한 이진 트리 순회");
		System.out.print("전위 순회: ");
		arrayTree.arrpreOrder();
		System.out.println();

		System.out.print("중위 순회: ");
		arrayTree.arrinOrder();
		System.out.println();

		System.out.print("후위 순회: ");
		arrayTree.arrpostOrder();
		System.out.println();
	}
}
