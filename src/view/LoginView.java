package view;

import java.util.Scanner;

import dao.UserDAO;

public class LoginView {
//	로그인 정보를 입력 받는 창임. 
	public LoginView() {
//		사용자로부터 값을 입력 받아야 함으로 스캐너클래스를 사용함.
		Scanner sc = new Scanner(System.in);
//		데이터베이스에서 값을 가져와 정보가 일치하면 로그인 완료를, 그렇지 않으면 실패를 띄운다.
//		마찬가지로 유저 정보를 받아와 로그인시키기위해 객체화함.
		UserDAO udao = new UserDAO();
//		로그인에 필요한 정보를 받아옴
		System.out.print("아이디 : ");
		String userid = sc.next();
		System.out.print("비밀번호 : ");
		String userpw = sc.next();
//		UserDAO의 메소드를 정의하여 로그인 결과를 보여줌 
		if(udao.login(userid,userpw)) {
			System.out.println(userid+"님 어서오세요~");
//			성공시 메인창으로 이동함.
			//메인창 띄우기
			new MainView();
		}
		else {
			System.out.println("로그인 실패 / 다시 시도해 주세요.");
		}
	}
}




