/*
 * 파일명: MyUndirectedWeightedGraphTest.java
 * 작성일: 2021.11.23
 * 작성자: 김하은 
 * 설명: undirected weighted graph를 adjacency matrix로 구현하는 클래스 
 */
package hw10_1;
import java.util.Scanner;

class MyUndirectedWeightedGraph {
	private int[][] matrix;        // 인접 행렬
	private int numberOfVertices;  // 정점 수

	// 정수형 2차원 배열을 매개변수로 받아 그래프를 초기화
	public MyUndirectedWeightedGraph(int[][] matrix) {
		numberOfVertices = matrix.length;
		this.matrix = new int[numberOfVertices][numberOfVertices];

		for(int i=0; i<numberOfVertices; i++) {
			for(int j=0; j<numberOfVertices; j++) {
				if (this.matrix[i][j] < 0) {
					System.out.println("그래프에 없는 정점입니다.");
				} else if (matrix[i][j] > 0) {
					this.matrix[i][j] = 1;
				}
			}
		}
	}

	public void printAdjMatrix() {
		for(int i=0; i<numberOfVertices; i++) {
			for(int j=0; j<numberOfVertices; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println(); 
		}
	}

	// 정점의 차수를 구하여 리턴
	public int getDegree(int v) {
		int degree = 0;
		for (int i=0; i<numberOfVertices; i++) {
			if(matrix[v][i] != 0)
				degree += 1;
		}
		return degree;
	}

	//	 그래프의 간선 총 개수를 구하여 리턴
	public int getNumberOfEdges() {
		int numberOfEdges = 0;
		for(int i=0; i<numberOfVertices; i++) {
			for(int j=0; j<numberOfVertices; j++) {
				if(matrix[i][j] != 0)
					numberOfEdges += 1;
			}
		}
		return numberOfEdges / 2;
	}
}

public class MyUndirectedWeightedGraphTest{
	public static void main(String[] args) {
		System.out.println("hw10_1 : 김하은");
		Scanner sc = new Scanner(System.in);

		// (1) 10*10 크기의 인접 행렬 원소를 입력받아 그래프를 생성
		int[][]matrix = new int[10][10];
		System.out.println("10행 10열의 인접 행렬 원소 입력(whitespace로 구분): ");
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		MyUndirectedWeightedGraph graph = new MyUndirectedWeightedGraph(matrix);

		// (2) 정점 번호 v를 입력받음
		System.out.println();
		System.out.print("정점 번호(0~9) 입력: ");
		int v = sc.nextInt();

		System.out.println();

		// (3) v의 차수 출력
		System.out.print("정점 " + v + "의 차수 = " + graph.getDegree(v));

		System.out.println();
		// (4) 그래프의 간선 총 개수 출력
		System.out.print("그래프의 간선 총 개수 = " + graph.getNumberOfEdges());

		sc.close();
	}
}
