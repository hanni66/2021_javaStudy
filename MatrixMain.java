package hw5_1;
import java.util.Scanner;
import java.util.Random;

class MyMatrix {
	private int[][] array;   // 정수형 차원 배열을 가리킬 변수 
	private int rnum;     // 행의 개수
	private int cnum;     // 열의 개수
	
	// 생성자 - 행의 개수, 열의 개수를 매개변수로 받아 초기 원소값이 0인 행렬을 생성
	public MyMatrix(int rnum, int cnum) { 
		this.rnum = rnum;
		this.cnum = cnum;
		this.array = new int[rnum][cnum];
	}
	
	// 추가한 생성자 -  행의 개수, 열의 개수, 배열을 가리킬 변수를 매개변수로 받아 행렬 생성
	public MyMatrix(int rnum, int cnum, int[][] array) {  
		this.rnum = rnum;
		this.cnum = cnum;
		this.array = array;
	}
	
	//set - 인덱스 i, j와 정수값을 매개변수로 받아 i행 j열 원소를 정수값으로 지정 
	// (i, j는 0부터 시작하는 배열 인덱스)
	public void set(int i, int j, int value) {
		array[i][j] = value;
	}

	//toString 오버라이드 - 행렬의 모든 원소들을 하나의 문자열로 만들어 리턴 (한 행이 한 줄에 표시되도록 함)
	public String toString() {
		String matrixS = "";
		
		for(int i=0; i<rnum; i++) {                // rnum만큼 반복
			for(int j=0; j<cnum; j++) {            // cnum만큼 반복 
				matrixS += array[i][j] + " ";      // 문자열에 행렬 저장하기 
				if(j == cnum -1)                   // cnum에서 1을 뺀 값이 j랑 같아지면 
					matrixS += ("\n");             // 문자열 줄바꿈하기
			}
		}

		return matrixS;
	}
	
	//transpose - 현재 행렬의 전치 행렬을 표현하는 새로운 MyMatrix 객체를 생성하여 리턴
	public MyMatrix transpose() {
		int[][] tarray = new int[cnum][rnum];
		
		for (int i = 0; i < rnum; i++) {			// rnum만큼 반복
	        for (int j = 0; j < cnum; j++) {		// cnum만큼 반복 
	            tarray[j][i] = array[i][j];			// 행과 열을 바꿔서 새로운 2차원 배열에 저장
	        }
	    }
		
		return new MyMatrix(cnum, rnum, tarray);
	}
}

public class MatrixMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		System.out.println("hw5_1: 김하은");
		System.out.println();
		// 행의 개수(row)와 열의 개수(column)를 입력받음
		System.out.print("행의 개수 입력: ");
		int rnum = sc.nextInt();	
		System.out.print("열의 개수 입력: ");
		int cnum = sc.nextInt();
		System.out.println();

		// row행 column열 크기의 행렬인 MyMatrix 객체 생성(matrix)
		MyMatrix matrix = new MyMatrix(rnum, cnum);
		
		// matrix의 원소들을 1~9 범위의 랜덤 정수값으로 각각 지정		
		for(int i=0; i< rnum; i++) {
			for(int j=0; j< cnum; j++) {
				int value = rd.nextInt(9 -1 +1)+1;
				matrix.set(i, j, value);
			}
		}
		
		// matrix 출력
		System.out.println("matrix = ");
		System.out.println(matrix.toString());
		
		// matrix의 전치 행렬인 새로운 행렬 객체 transposedMatrix를 구함 
		// 이 과정에서 matrix가 변경되면 안됨
		MyMatrix transposedMatrix = matrix.transpose();
		
		// transposedMatrix 출력 후 matrix 출력
		System.out.println("transposedMatrix = ");
		System.out.println(transposedMatrix);
		
		System.out.println("matrix = ");
		System.out.println(matrix.toString());
		
		sc.close();
	}

}
