package view;

import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;
import dto.ProductDTO;

public class AddProductView {
//	상품을 추가하는 클래스임 
	public AddProductView() {
//		상품을 추가하기 위해서는 데이터베이스와 통신하는 객체를 만든다.
		ProductDAO pdao = new ProductDAO();
//		사용자가 입력한 정보를 입력받아야 됨으로 스캐너 사용
		Scanner sc = new Scanner(System.in);
//		사용자가 입력한 정보를 받는다. 
		System.out.print("상품 이름 : ");
		String prodname = sc.nextLine();
		System.out.print("상품 가격 : ");
		int prodprice = sc.nextInt();
		System.out.print("상품 재고 : ");
		int prodamount = sc.nextInt();
		System.out.print("상품 소개 : ");
		sc = new Scanner(System.in);
		String prodinfo = sc.nextLine();
//		사용자가 입력한 정보를 넘겨주는데 우리가 원하는 값을 String으로 넘기거나 비교하거나 데이터베이스에 넘기기 위해 값들을 한곳으로 모은다. 
//		우리는 사용자가 입력한 마지막 상품번호의 +1로 상품을 입력할 것이고 누가 입력했는지 정보도 담을 것이다. 
//		따라서 ProductDTO를 만드는데 고유 번호는  pdao로부터 가져옴. 
//		또한 마지막 누가 입력했는지 알기위해 Session에서 사용자 정보를 가져왔다. 
		ProductDTO product = new ProductDTO(pdao.getLastNum()+1, prodname, prodprice,
				prodamount, prodinfo, Session.get("login_id"));
//		pdao에 addProduct메소드를 만들어 product를 매개변수로 넘기자.
//		product의 정보를 pdao를 통해 데이터 베이스에 넣는 것임.
		if(pdao.addProduct(product)) {
			System.out.println(prodname+" 상품 추가 완료!");
		}
		else {
			System.out.println("알 수 없는 오류 / 다음에 다시 시도해 주세요.");
		}
	}
}














