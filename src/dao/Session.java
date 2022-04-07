package dao;

import java.util.HashMap;

public class Session {
//	로그인이 되었다면 그 정보를 계속 가지고 있어야 함으로 Session클래슬를 만들어 별도로 관리함.
//	아무나 접근 하면 안되니 private으로 정의하였음. HashMap으로 정의한 이유는 아래와 같이 넣기 위함
	//Session.datas.put("login_id","apple");
	private static HashMap<String, String> datas = new HashMap<String, String>();

//	put메소드를 정의하여 2개의 매개변수를 넣음. 	
	//Session.put("login_id","apple");
	public static void put(String key, String value) {
//		이때 put은 set의 고유 메소드
		datas.put(key, value);
	}
//	해당 정보를 가져오기위한 메소드로 key값을 부르면 값을 가져올 수 있음. 
	public static String get(String key) {
//		이때 get은 set의 고유 메소드
		return datas.get(key);
	}
//	위와 같이 정의하면 사용자를 호출할때 login_id를 호출하면 현재 로그인 된 사용자를 불러올 수 있다.
}
