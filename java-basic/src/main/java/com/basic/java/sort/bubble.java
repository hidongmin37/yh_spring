package com.basic.java.sort;

public class bubble {
	public static void bubbleSort(int[] arr) {
		// 버블 정렬
		for (int i = 1; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1]; // 두 데이터 위치 교환
					arr[j+1] = temp;
				}
			}
		}

		// 삽입 정렬
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j >0; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				} else {
					break;
				}

			}
		}

		// 선택 정렬
		for (int i = 0; i < arr.length-1; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;

		}


	}

	public static void main(String[] args) {
		int[] arr = {3,4,2,1,5,6,7,8,9};
		bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
}
