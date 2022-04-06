package view;

import java.util.Scanner;

import dao.UserDAO;
import dto.UserDTO;

public class JoinView {
	public JoinView() {
		Scanner sc = new Scanner(System.in);
		UserDAO udao = new UserDAO();
		
		System.out.print("아이디 : ");
		String userid = sc.next();
		if(udao.checkDup(userid)) {
			System.out.print("비밀번호 : ");
			String userpw = sc.next();
			System.out.print("이름 : ");
			String username = sc.next();
			System.out.print("나이 : ");
			int userage = sc.nextInt();
			System.out.print("핸드폰 번호 : ");
			String userphone = sc.next();
			System.out.print("주소 : ");
			sc = new Scanner(System.in);
			String useraddr = sc.nextLine();
		
			UserDTO user = new UserDTO(userid, userpw, username, userage, userphone, useraddr);
			if(udao.join(user)) {
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







