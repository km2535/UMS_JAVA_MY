package view;

import java.util.Scanner;

import dao.ProductDAO;

public class ModifyProductView {
	public ModifyProductView() {
//		상품을 수정하기 위한 클래스임, 상품의 데이터베이스와 통신해야 되니 DAO를 가져온다.
		ProductDAO pdao = new ProductDAO();
//		사용자로부터 입력받아야 할 값이 있음
		Scanner sc = new Scanner(System.in);
//		상품의 List를 가져옴,.
		System.out.println(pdao.getList());
//		수정할 상품번호를 입력 받는다.
		System.out.print("수정할 상품 번호 : ");
		int prodnum = sc.nextInt();
		System.out.println("1. 가격수정\n2. 재고수정\n3. 설명수정");
		int choice = sc.nextInt();
		System.out.print("새로운 정보 : ");
//		새로운 정보는 이전에 엔터도 받을 수 있기때문에 아래와 같이 초기화
		sc = new Scanner(System.in);
		String newData = sc.nextLine();
//		3가지 정보를 유저로부터 입력 받았고 이것을 넘겨서 상품을 수정하도록 하자, 마찬가지로 데이터베이스에 있는 상품을 수정하는 것이니 dao에 만든다.
		if(pdao.modifyProduct(prodnum,choice,newData)) {
			System.out.println(prodnum+"번 상품이 정상적으로 수정되었습니다.");
		}
		else {
			System.out.println("알 수 없는 오류 / 다음에 다시 시도해 주세요.");
		}
	}
}




