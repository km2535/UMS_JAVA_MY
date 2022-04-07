package view;

import java.util.Scanner;

import dao.ProductDAO;
import dao.UserDAO;

public class MyInfoView {
	public MyInfoView() {
		Scanner sc = new Scanner(System.in);
//		여기서는 유저 정보를 사용해야 되기 때문에  UserDAO를 가져온다. 
		UserDAO udao = new UserDAO();
//		회원을 탈퇴하면 내가 올린 상품을 모두 제거해야 됨으로 ProductDAO도 가젼온다. 
		ProductDAO pdao = new ProductDAO();
//		user정보를 보여주는 메소드를 이용하여 정보를 보여줌.
		System.out.println(udao.myInfo());
//		수정할 값들을 사용자에게 보여주고 정수타입으로 입력 받는다.
		System.out.println("1. 비밀번호 수정\n2. 핸드폰 번호 수정\n3. 주소 수정\n4. 수정 취소\n5. 회원탈퇴");
		int choice = sc.nextInt();
		if(choice == 4) {
//			수정 취소를 하면 메인으로 돌려보내준다.
			System.out.println("메인으로 돌아갑니다.");
		} else if(choice == 5) {
//			회원 탈퇴 시 비밀번호를 다시 입력받는다.
			System.out.print("비밀번호 재입력 : ");
			String userpw = sc.next();
//			사용자 정보 확인을 한다.
			if(udao.checkPw(userpw)) {
//				일치하면 다음과 같이 상품을 모두 제거한다.
				pdao.removeAll();
//				회원 탈퇴를 한다.
				if(udao.leaveId()) {
					System.out.println("그동안 이용해 주셔서 감사합니다...☆ 기다릴게요....");
				}
			}
			else {
				System.out.println("비밀번호 오류");
			}
			
		} else {
//			그 외는 새로운 정보를 받는다.
			System.out.print("새로운 정보 : ");
			sc = new Scanner(System.in);
			String newData = sc.nextLine();
//			
			boolean check = false;
			switch(choice) {
			case 1:
//				비밀번호는 1번방으로 그 값을 넘겨준다.
				check = udao.modifyUser(1,newData);
				break;
//			case 2:
//				udao.modifyUser(4,newData);
//				break;
//			case 3:
//				udao.modifyUser(5,newData);
//				break;
				
			case 2: case 3:
//				마찬가지로 수정할 해당 index의 규칙성을 찾아 묶어줌.
				check = udao.modifyUser(choice+2,newData);
				break;				
			}
			if(check) {
//				true이면 정보수정 완료
				System.out.println("정보 수정 완료!");
			}
			else {
				System.out.println("정보 수정 실패");
			}
		}
	}
}








