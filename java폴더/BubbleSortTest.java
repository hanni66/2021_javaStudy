package hw11_1;

import java.util.Random;
import java.util.Scanner;

public class BubbleSortTest {

	public static void main(String[] args) {
		System.out.println("hw11_1: 김하은");

		//	(1) 정수 개수(n)를 입력받아 크기 n인 int형 배열을 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 개수 입력: ");
		int n = sc.nextInt();
		int[] array = new int[n];

		//	(2) n개의 랜덤 정수값을 생성하여 배열에 저장 
		Random random = new Random();
		for(int i=0; i<n; i++) {
			array[i] = random.nextInt();
		}
		System.out.println();

		//	(3) 정렬 전 배열 원소들을 출력
		System.out.print("정렬 전 = ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}

		//	(4) 배열 원소들을 버블 정렬
		bubbleSort(array);
		System.out.println();

		//	(5) 정렬 후 배열 원소들을 출력
		System.out.print("정렬 후 = ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}

		sc.close();
	}

	private static void bubbleSort(int[] array) {
		int n = array.length;
		int temp;
		for(int i=0; i<n; i++) {
			for(int j=1; j<(n-i); j++) {
				if(array[j] < array[j-1]) {
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
}
