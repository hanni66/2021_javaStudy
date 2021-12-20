package hw7_1;

import java.util.EmptyStackException;
import java.util.Scanner;

public class MyCharStack {
	
	// 노드 구조를 정의하는 private 클래스
	private class Node {
		char item;
	    Node nextNode;
	}
	
	// 스택의 top 원소 노드를 가리키는 private 인스턴스 변수
	private Node top = null;
	
	// isEmpty - 스택이 비었는지를 검사하는 public 메소드
	public boolean isEmpty() {
		return top == null;    // 스택이 비어있으면 true 반환 
	}
	
	// push - 스택에 원소를 삽입하는 public 메소드
	public void push(char data) { 
		Node node = new Node();  	 // 노드 생성
		node.item = data;			 // 매개변수로 받은 data를 node의 item에 넣기 
		node.nextNode = top;         // 새로운 노드.next에 top으로 지정 (삽입 과정)
		top = node;                  // 생성한 node를 top에 지정
	}
	
	// pop - 스택에 원소를 삭제하여 리턴하는 public 메소드
	public char pop() {
		if (isEmpty()) {                    // 가장 상단의 top이 null일 때 
			throw new EmptyStackException();  // 스택이 비어있는 경우 EmptyStackException 예외 발생  
		}
		else {
			char data = top.item;               // item은 삭제가 된 원소 
			top = top.nextNode;      // top에 top.nextNode을 지정 (삭제)
			return data;
		}
	}
	
	// peek - 스택에 원소를 탐색하여 리턴하는 public 메소드
	public char peek() {
		if (top == null) {     // top 노드가 비어 있을 때 
			throw new EmptyStackException();   // 예외 처리 
		}
		return top.item;   // top의 item을 return 
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw7_1 : 김하은");
		
	
		// (1) 공백 스택 생성
		MyCharStack stack = new MyCharStack();       // 입력 받은 item들을 저장할 스택 
		MyCharStack substack = new MyCharStack();    // 괄호를 비교하기 위해 사용할 substack
		
		// (2) 사용자로부터 한 줄의 괄호 수식 문자열을 입력받음
		System.out.print("괄호 수식 입력: ");
		String data = sc.next();  // 괄호 입력받기 
		boolean empty = true;     // 수식의 참 거짓을 반환하는 변수 
		
		// (3) 수식의 문자를 하나씩 차례대로 스택에 삽입
		for (int i=0; i<data.length(); i++) { // 괄호의 길이만큼 반복 
			char line = data.charAt(i);       // String으로 받은 data 한글자씩 보고 line에 저장 
			stack.push(line);				  // line을 스택에 넣기 (push)
			
			if (line == '(') { 			// 입력받은 괄호가 '('와 같으면 
				substack.push('(');			  
			}
			else if (line == '[') {     // 입력받은 괄호가 '['와 같으면 
				substack.push('[');	
			}
			else if(line == ')') {		// 입력받은 괄호가 ')'와 같으면 
				if(!substack.isEmpty()) {           // substack이 비어있지 않을 때 
					if(substack.peek() == '(') {    // substack을 탐색했을 때 '('와 같으면
						substack.pop();             // 괄호가 완성 -> pop으로 삭제!
					}
				}
					else {
						empty = false; // 잘못된 괄호 수식이므로 empty는 false
				}
			}
			else if(line == ']') {            // 입력받은 괄호가 ']'와 같으면 
				if( !substack.isEmpty()) {          // substack이 비어있지 않을 때 
					if(substack.peek() == '[') {    // substack을 탐색했을 때 '['와 같으면
						substack.pop();             // 괄호가 완성 -> pop으로 삭제!
						}
					}
						else {
							empty = false; // 잘못된 괄호 수식이므로 empty는 false
					}
			}
		}
		  
		// (4) 스택이 빌 때까지 스택에서 하나씩 삭제하여 출력 
		String a = "";                            // 빈 문자열 만들어주기 
		System.out.print("스택에서 삭제하여 출력 = ");
		while(!stack.isEmpty()) {                 // 스텍이 비어있지 않을 때까지 반복 
			a += stack.pop();                     // 문자열에 삭제한 원소들을 저장 
		}
		System.out.println(a);                    // 스텍에서 삭제하여 출력 
		
		// (5) 수식이 올바른 괄호 수식인가를 검사하여 결과를 출력 - 선택 과제 
		if (empty && substack.isEmpty()) {       // empty가 true이고, 스택이 비어있으면 "올바른 괄호 수식입니다." 출력
			System.out.println("올바른 괄호 수식입니다.");
		} 
		else {
			System.out.println("잘못된 괄호 수식입니다.");
		}
		sc.close();
	}

}
