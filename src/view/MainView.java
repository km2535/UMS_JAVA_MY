package view;

import java.util.Scanner;

import dao.Session;

public class MainView {
	public MainView() {
		Scanner sc = new Scanner(System.in);
//		세션에서 로그인 정보를 가져옴.
		String userid = Session.get("login_id");
		
		while(true) {
			System.out.println("☆★☆★☆★☆★"+userid+"님 어서오세요~☆★☆★☆★☆★\n"
					+ "1. 상품추가\n2. 상품수정\n3. 상품삭제\n"
					+ "4. 내 상품 보기\n5. 상품 검색\n6. 내 정보 수정\n7. 로그아웃");
			int choice = sc.nextInt();
			switch(choice) {
			case 1: 
				break;
			case 2: 
				break;
			case 3: 
				break;
			case 4: 
				break;
			case 5: 
				break;
			case 6: 
				break;
			case 7: 
				break;
			}
		}
	}
}
