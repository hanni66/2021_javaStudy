package hw9_2;
import java.util.Scanner;

class MyBinarySearchTree {
	private Node root = null;    // 루트 노드를 가리키는 인스턴스 변수

	// 노드 구조를 표현하는 클래스
	private class Node{
		String data;// 단어(키값)
		int count = 1;// 빈도
		Node leftChild;// 왼쪽 자식
		Node rightChild;// 오른쪽 자식
	}

	// 트리에 key를 삽입
	public void insert(String key) {
		root = insertKey(root, key);
	}

	// p를 루트로 하는 트리에 key를 삽입하고, 삽입 후 루트 리턴
	private Node insertKey(Node p, String key) {
		if(p == null) {
			Node temp = new Node();
			temp.data = key;
			return temp;
		}
		else if(key.compareTo(p.data)<0) {
			p.leftChild = insertKey(p.leftChild, key);//서브트리에 삽입
			return p;
		}
		else if(key.compareTo(p.data)>0) {
			p.rightChild = insertKey(p.rightChild, key);//서브트리에 삽입
			return p;
		}
		else {
			p.count++;
			return p;
		}
	}

	public int search(String key) {
		Node p = searchNode(key);
		if(p != null)
			return p.count;
		else
			return 0;
	}

	// 트리에서 key를 검색하여 빈도를 리턴
	public Node searchNode(String key) {
		Node p = root;
		while (p!=null) {
			if(key.compareTo(p.data) < 0) {
				p = p.leftChild;
			} else if(key.compareTo(p.data) > 0) {
				p = p.rightChild;
			}
			else 
				return p;
		}
		return null;
	}

	// 트리의 모든 키 : 빈도 쌍을 키값 오름차순으로 출력
	public void print() {
		inorder(root);
		System.out.println();
	}

	// p를 루트로 하는 트리를 중위 순회
	private void inorder(Node p) {
		if(p != null){
			inorder(p.leftChild);
			System.out.print(p.data +":"+ p.count+" ");
			inorder(p.rightChild);
		}
	}
}
public class MyBinarySearchTreeTest {
	public static void main(String[] args) {
		System.out.println("hw9_2: 김하은");

		// (1) MyBinarySearchTree 형 객체를 생성(tree라고 하자)
		MyBinarySearchTree tree = new MyBinarySearchTree();

		// (2) 한 줄의 단어 목록을 입력받아 각 단어를 tree에 삽입 
		Scanner sc = new Scanner(System.in);
		System.out.println("단어 목록 입력 (하나 이상의 공백으로 구분):");
		String word = sc.nextLine();
		String[] cword = word.trim().split("\\s+");    // 띄어쓰기 기준으로 단어 나눠서 배열에 저장하기

		for (int i=0; i<cword.length; i++) {
			tree.insert(cword[i]);
		}
		System.out.println();

		// (3) tree에 저장된 정보(단어와 빈도)를 단어 오름차순으로 출력
		System.out.print("트리 = ");
		tree.print();
		System.out.println();

		// (4) 한 줄의 검색할 단어 목록을 입력받아 각 단어를 tree에서 검색하여 빈도 출력 
		System.out.println("검색할 단어 목록 입력 (하나 이상의 공백으로 구분):");
		String sword = sc.nextLine();
		String[] searchW = sword.trim().split("\\s+"); 
		for (int i=0; i<searchW.length; i++) {
			System.out.print(searchW[i]+"의 빈도 = "+tree.search(searchW[i]));
			System.out.println();
		}
		sc.close();
	}
}
