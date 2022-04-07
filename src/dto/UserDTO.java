package dto;

public class UserDTO {
	//Alt + Shift + A : 그리드 편집 모드(여러줄 동시에 편집)
	public String userid;
	public String userpw;
	public String username;
	public int userage;
	public String userphone;
	public String useraddr;
//	JoinView에서 전달 받은 인자들을 모두 기본생성자로 정의하였음. 
	public UserDTO(String userid, String userpw, String username, int userage, String userphone, String useraddr) {
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userage = userage;
		this.userphone = userphone;
		this.useraddr = useraddr;
	}
	@Override
//	동위객체는 같은 값으로 인식해야 함으로 equals를 재정의함.
	public boolean equals(Object obj) {
//	equals의 매개변수로 들어온 객체는 UserDTO타입인지 확인하고 
		if(obj instanceof UserDTO) {
			UserDTO target = (UserDTO)obj;
//			새로운 객체인 target객체의 userid와 매개변수로 받아온 객체의 userid를 비교하여
			if(target.userid.equals(this.userid)) {
//				같으면 true를,
				return true;
			}
		}
//		다르면 false를 리턴한다.
		return false;
	}
//	받아온 객체를 쉽게 보기 위해 재정의함
	@Override
	public String toString() {
		//apple	abcd1234	김사과	10	01012341234	서울시 강남구 역삼동
		return userid+"\t"+userpw+"\t"+username+
				"\t"+userage+"\t"+userphone+"\t"+useraddr;
	}
}













