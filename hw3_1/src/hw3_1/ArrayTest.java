package hw3_1;

import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw3_1: 김하은");

		// 정수 개수(배열 원소 수) 입력받기
		System.out.print("정수 개수 입력: ");
		int n = sc.nextInt();

		// n개의 정수를 입력받아 배열에 저장하기
		int[] arr = new int[n];     // 배열 생성
		int[] arr1 = null;   	// 새로 만들 배열의 크기 생성
		int count = 0;       		// 최대값의 개수

		System.out.print(n+"개의 정수 입력: ");
		for(int i=0; i<n; i++) {	 // 입력 받은 수만큼 반복
			int a = sc.nextInt();    // 입력받기
			arr[i] = a;    			 // 입력받은 정수 배열에 저장
		}

		// n개의 정수 중에서 최대값을 모두 제외하고 입력 순서대로 모두 출력하고 최대값 개수 출력
		int max = arr[0];    	    // 최대값의 초기값 설정하기
		for(int j=0; j<n; j++) {
			if(arr[j] > max) {       // 최대값 구하기
				max = arr[j];
			}
		}

		for(int i=0; i<n; i++) {
			if (arr[i] == max) {
				count++;			    						// arr의 값과 최대값이 같으면 개수 증가 
			}
		}

		arr1 = new int[n-count];     			// 총 개수에서 최대값의 개수 만큼 뺀 크기 할당

		for(int j=0, k=0; j< n; j++) {    // arr1 배열에 요소 넣어주기
			if(arr[j] == max) {           	// arr 배열의 요소가 최대값과 같을 때
				continue;				  						// 아래 문장을 건너뜀
			} else {                      	// arr 배열이 요소가 최대값과 같지 않을 때
				arr1[k++] = arr[j];		  			// arr1 배열에 arr배열의 요소를 넣어줌
			}
		}


		System.out.print("최대값 제외 = ");
		for (int l=0; l<arr1.length; l++) {    // arr1 배열에 있는 원소 출력
			System.out.print(arr1[l] + " ");
		}
		System.out.println();
		System.out.println("최대값 개수 = " + count);

		sc.close();
	}
}
