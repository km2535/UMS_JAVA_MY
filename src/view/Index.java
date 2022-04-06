package view;

import java.util.Scanner;

//index : 시작하는 페이지
public class Index {
	public static void main(String[] args) {
		System.out.println("22.03 개강반 최종 프로젝트 / UMS 프로그램 입니다.");
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. 회원가입\n2. 로그인\n3. 나가기");
			int choice = sc.nextInt();
			
			//Controller
			if(choice == 3) {
				System.out.println("안녕히가세요");
				break;
			}
			switch(choice) {
			case 1:
				//회원가입
				new JoinView();
				break;
			case 2:
				//로그인
				new LoginView();
				break;
			default:
				System.out.println("다시 입력하세요");
			}
		}
	}
}












