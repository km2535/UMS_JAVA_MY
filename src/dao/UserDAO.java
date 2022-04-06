package dao;

import java.util.HashSet;

import dto.UserDTO;

public class UserDAO {
	
	DBConnection conn = null;
	
	public UserDAO() {
		conn = new DBConnection("database/UserTable.txt");
	}
	
	public boolean join(UserDTO user) {
		return conn.insert(user.toString());
	}

	public boolean checkDup(String userid) {
		HashSet<String> rs = conn.select(0,userid);
		return rs.size() == 0;
	}

	//							apple		 abcd1234
	public boolean login(String userid, String userpw) {
		HashSet<String> rs = conn.select(0, userid);
		
		if(rs.size() == 1) {
			for(String line : rs) {
				//line : "apple	abcd1234	김사과	10	01012341234	서울시 강남구 역삼동"
				//"문자열1".split("문자열2") : "문자열1" 을 "문자열2" 기준으로 나누기
				// 						나뉘어진 문자열들이 담겨있는 배열 return
				//{"apple","abcd1234","김사과","10","01012341234","서울시 강남구 역삼동"}
				if(line.split("\t")[1].equals(userpw)) {
					//로그인 성공
//					Session.datas.put("login_id",userid);
					Session.put("login_id", userid);
					return true;
				}
				
			}
		}
		return false;
	}
}










