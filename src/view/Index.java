package view;

import java.util.Scanner;

//index : 시작하는 페이지
public class Index {
	public static void main(String[] args) {
//		처음 화면, 시작
		System.out.println("22.03 개강반 최종 프로젝트 / UMS 프로그램 입니다.");
//		사용자로부터 여러 정보를 입력 받기위해 사용
		Scanner sc = new Scanner(System.in);
//		나가기를 하기 전까지 프로그램 실행
		while(true) {
//			선택창을 만들어 int타입의 정수를 입력받는다.
			System.out.println("1. 회원가입\n2. 로그인\n3. 나가기");
			int choice = sc.nextInt();
//			그 입력이 3일 경우 곧바로 프로그램을 종료
			//Controller
			if(choice == 3) {
				System.out.println("안녕히가세요");
				break;
			}
//			1또는 2일 경우 각각의 view단을 만들어 새로운 창을 보여준다.
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












