package dto;

public class ProductDTO {
	int prodnum;
	String prodname;
	int prodprice;
	int prodamount;
	String prodinfo;
	int likecnt;
	
	//어떤 유저가 올린 상품인지를 같이 저장해야 하므로 외부의 테이블과 연결이 필요하다.
	String userid;	//FK(Foreign Key)
// 일단 상품의 좋아요는 사용하지 않기 때문에 매개변수에서 제외하였다. 
	public ProductDTO(int prodnum, String prodname, int prodprice, int prodamount, String prodinfo,
			String userid) {
		this.prodnum = prodnum;
		this.prodname = prodname;
		this.prodprice = prodprice;
		this.prodamount = prodamount;
		this.prodinfo = prodinfo;
		this.likecnt = 0; 
		this.userid = userid;
	}
//	유저DAO랑 마찬가지로 equals메소드를 재정의한다.
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ProductDTO) {
			ProductDTO target = (ProductDTO)obj;
			return target.hashCode() == this.hashCode();
		}
		return false;
	}
//	해쉬코드는 간단하게 prodnum을 따른다. 
	@Override
	public int hashCode() {
		return prodnum;
	}
//	여기가 바로 우리가 데이터베이스에 넘겨줄 값의 형태임. 
	@Override
	public String toString() {
		return prodnum+"\t"+prodname+"\t"+prodprice+"\t"+
	prodamount+"\t"+prodinfo+"\t"+likecnt+"\t"+userid;
	}
}











