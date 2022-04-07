package view;

import java.util.Scanner;

import dao.UserDAO;
import dto.UserDTO;

public class JoinView {
//	회원가입을 선택했을 때 보여주는 클래스, 기본 생성자를 재저의하여 Index페이지에서 실행되도록함.
	public JoinView() {
//		사용자 정보를 입력받을 꺼임
		Scanner sc = new Scanner(System.in);
//		데이터 베이스와 통신을 목적으로 생성함.
		UserDAO udao = new UserDAO();
//		아이디 정보를 입력받는다.
		System.out.print("아이디 : ");
		String userid = sc.next();
//		udao에서 데이터베이스에서 사용자 정보를 가져와서 이미 있는 아이디인지 검사하여 이하 내용을 진행
		if(udao.checkDup(userid)) {
//			비밀번호를 입력받음	
			System.out.print("비밀번호 : ");
			String userpw = sc.next();
//			이름을 입력받음	
			System.out.print("이름 : ");
			String username = sc.next();
//			나이를 입력받음	
			System.out.print("나이 : ");
			int userage = sc.nextInt();
//			핸드폰 입력받음	
			System.out.print("핸드폰 번호 : ");
			String userphone = sc.next();
//			주소를 입력받음	
			System.out.print("주소 : ");
//			주소는 해당 작성줄을 입력받아 이전의 엔터도 입력되어 scanner를 초기화 해주어야 한다.
			sc = new Scanner(System.in);
			String useraddr = sc.nextLine();
//			위의 정보들을 모두 포장할 클래스가 필요하다. 
			UserDTO user = new UserDTO(userid, userpw, username, userage, userphone, useraddr);
//		입력을 모두 받고 '데이터베이스'가 전달되어 저장되면 성공을 리턴, 그렇지 못하면 실패를 리턴한다.
//			데이터베이스와 통신할 클래스를 만드는데 14번째 줄의 UserDAO클래스가 그 역할을 수행한다.
			if(udao.join(user)) {
//				포장된 user(UserDTO)를 한번에 UserDAO에 넘겨서 데이터 베이스에 저장함.
				System.out.println("회원가입 성공!");
				System.out.println(username+"님 가입을 환영합니다!");
			}
			else {
				System.out.println("회원가입 실패 / 다시 시도해 주세요.");
			}
		}
		else {
			System.out.println("중복된 아이디가 있습니다. 다시 시도해 주세요.");
		}
	}
}







