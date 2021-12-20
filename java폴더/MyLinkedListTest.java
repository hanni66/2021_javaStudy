package hw6_1;

class MyLinkedList {
	// private 인스턴스 변수 - 단순 연결 리스트의 첫번째 노드
	private Node head = null;
	int size;
	
	// 노드 구조를 정의하는 private 클래스
	private class Node {
		Node next = null; //다음 노드 객체를 가르키는 래퍼런스 변수
		String item;
	}
	
	// 매개변수로 받은 원소를 리스트 맨 앞에 삽입하는 메소드
	public void add(String item) {
		  Node newNode = new Node();    // 노드 객체 생성
		  newNode.item = item;          // 노드의 item에 item을 지정 
		  
		  newNode.next = head;          // 노드의 next를 head를 지정 
		  head = newNode;               // head에 노드를 지정
	}
	
	// 매개변수로 받은 원소가 리스트에 몇 개 있는지 세는 메소드
	public int count(String item) {
		Node tempNode = new Node();    // 노드 객체 생성 
		tempNode = head;               // 노드에 head를 지정 
	    size = 0;                      // size 0으로 지정
	    
	    while(tempNode != null) {           // 노드가 null이 아닐때까지 반복
	    	if (tempNode.item == item) {    // 노드의 item이 지정한 item이랑 같을 때 
		    	size ++;                    // size는 증가 
		    }
	    	tempNode = tempNode.next;       // 노드의 다음을 가리키는 next를 노드로 지정
	    }
	    return size;                        // size를 리턴 
	}
	
	// 리스트의 내용을 하나의 문자열로 구성하여 리턴하는 메소드
	@Override
	public String toString() {
		String slist = "";                   // 리스트 생성 
		Node tempNode = head;                // head를 노드로 지정 
		
		if(head == null) {                   // head가 null이라면 
			return "초기 리스트 = [ ]";          // 초기 리스트 리턴 
		}else {
			while(tempNode != null) {        // 노드가 비어있을 때까지 반복 
				slist += tempNode.item;      // item을 slist에 추가 
				if(tempNode.next != null) {  // next가 비어있지 않을 때 
					slist += ", ";           // , 추가 
				}
				tempNode = tempNode.next;    // 노드의 next를 노드에 지정 
			}
			return "[" + slist + "]";        // 리스트의 내용을 하나의 문자열로 리턴 
		}
	}
	
	// 매개변수로 받은 원소를 리스트에서 모두 삭제하고 삭제한 원소 수를 리턴하는 메소드
	public void remove(String item) {
		Node tempNode = new Node();    // 새로운 노드 객체 생성 
		tempNode = head;               // head를 노드에 지정 
		
        if(tempNode.item == item) {             // 노드의 item이랑 item이 같을 때 
        	head = tempNode.next;               // 노드의 next를 head에 지정 
        }
       	while(tempNode.next != null){           // 노드의 next가 null이 아닐 때까지 반복 
            if(tempNode.next.item == item){     // 노드의 next의 item이 item이랑 같으면 
                Node nextNode = tempNode.next;  // 노드의 next를 새로운 노드 객체에 지정 
                tempNode.next = nextNode.next;  // 새로운 노드의 next를 노드의 next로 지정 
            }else{                              // 노드의 next가 null이라면 
            	tempNode = tempNode.next;       // 노드의 next는 노드를 지정 
            }
        }
        return;
	}
	
}
public class MyLinkedListTest {

	public static void main(String[] args) {
		System.out.println("hw6_1 : 김하은");
		
		// (1) 공백 리스트 (MyLinkedList 객체)를 생성
		MyLinkedList list = new MyLinkedList();
		
		System.out.println();
		// (2) 리스트의 내용 출력
		System.out.println(list);        //System.out.println(list.toString());
		
		// (3) 다음 10개의 단어들을 순서대로 하나한 리스트의 맨 앞에 삽입
		list.add("DOG");
		list.add("cat");
		list.add("DVD");
		list.add("cup");
		list.add("can");
		list.add("DOG");
		list.add("cat");
		list.add("case");
		list.add("character");
		list.add("DOG");
		
		System.out.println();
		// (4) 리스트의 내용 출력
		System.out.println("단어 10개 삽입 후 = " + list); 
		
		// (5) 리스트에 EGG가 몇 개인지 알아내어 출력
		System.out.println("EGG 개수 = " + list.count("EGG"));
		
		// (6) 리스트에 DOG가 몇 개인지 알아내어 출력
		System.out.println("DOG 개수 = " + list.count("DOG"));
		
		System.out.println();
		// (7) 리스트에서 EGG 삭제한 후 리스트의 내용 출력
		list.remove("EGG");
		System.out.println("EGG 삭제 후 = " + list);
		
		// (8) 리스트에서 DOG 삭제한 후 리스트의 내용 출력
		list.remove("DOG");
		System.out.println("DOG 삭제 후 = " + list);
		
		// (7) 리스트에서 FAN 삽입한 후 리스트의 내용 출력
		list.add("FAN");
		System.out.println("FAN 삽입 후 = " + list);
		
		// (7) 리스트에서 DVD 삭제한 후 리스트의 내용 출력
		list.remove("DVD");
		System.out.println("DVD 삭제 후 = " + list);
		
	}

}
