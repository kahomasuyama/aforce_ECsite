package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ProductBean;

public class ProductDAO extends DAO {

	//キーワード検索
	public List<ProductBean> search(String keyword) throws Exception {
		List<ProductBean> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("select * from product where name like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			ProductBean p=new ProductBean();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			list.add(p);
		}

		st.close();
		con.close();


		return list;

	}

	//価格帯検索
	public List<ProductBean> searchPrice1(String priceRange) throws Exception {
		List<ProductBean> list2=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("select * from product where PRICEID=1");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			ProductBean p=new ProductBean();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			list2.add(p);
		}

		st.close();
		con.close();


		return list2;

	}
	public List<ProductBean> searchPrice2(String priceRange) throws Exception {
		List<ProductBean> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("select * from product where PRICEID=2");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			ProductBean p=new ProductBean();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			list.add(p);
		}

		st.close();
		con.close();


		return list;

	}
	public List<ProductBean> searchPrice3(String priceRange) throws Exception {
		List<ProductBean> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("select * from product where PRICEID=3");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			ProductBean p=new ProductBean();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			list.add(p);
		}

		st.close();
		con.close();


		return list;

	}
//消すかも
//	public int getTotalPrice() throws Exception{
//		int totalPrice=0;
//		Connection con = getConnection();
//		PreparedStatement st = con.prepareStatement("SELECT sum(price) AS total_price FROM product");
//		ResultSet rs=st.executeQuery();
//		if(rs.next()){
//			totalPrice=rs.getInt("total_price");
//		}
//		ItemBean itemBean = new ItemBean();
//		itemBean.setTotalPrice(totalPrice);
//		st.close();
//		con.close();
//
//		return totalPrice;
//
//
//	}

	public int insert(ProductBean product) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("insert into product(name,price,priceid) values( ?, ?, ?)");
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		st.setString(3,product.getPriceRange());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}

	//管理者の商品削除
	public int delete(int id) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("delete from product where name=?");
		st.setInt(1, id);
		int lineD=st.executeUpdate();

		st.close();
		con.close();
		return lineD;
	}

}
