package Contact;

import java.sql.*;
import java.util.*;
public class addContact {
	public void add() throws SQLException{
		savedContact use=new savedContact();
		String query="Insert into Contact (NAME,PHONE,EMAIL) values(?,?,?)";
		Connection con=DbConnection.getConnection();
		PreparedStatement pre=con.prepareStatement(query);
		pre.setString(1,use.name);
		pre.setString(2,use.phonenum);
		pre.setString(3,use.email);
		pre.executeUpdate();
	}
	public void update() throws SQLException{
		savedContact s=new savedContact();
		String query="update Contact set NAME=?,PHONE=?,EMAIL=?";
		Connection con=DbConnection.getConnection();
		PreparedStatement pre=con.prepareStatement(query);
		pre.setString(1,s.name);
		pre.setString(2,s.phonenum);
		pre.setString(3,s.email);
		int rowAffected=pre.executeUpdate();
		if(rowAffected>0)
		{
			System.out.println("UPDATE SUCCESSFULLY");
		}
		else {
			System.out.print("Contact NOt FOUND ----");
		}
	}
	public void view() throws SQLException{
		String query="select * from contact";
		Connection con=DbConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			System.out.println("NAME: "+rs.getString(1));
			System.out.println("PHONE NUM:"+rs.getString(2));
			System.out.println("EMAIL :"+rs.getString(3));
		}
		System.out.println("---------->");
	}
	public void delet() throws SQLException{
		Scanner scan=new Scanner(System.in);
		System.out.println("ENTER DELET NAME");
		String delname=scan.next();
		savedContact sav=new savedContact(delname);
		
		String query="delete from Contact where NAME=?";
		Connection con=DbConnection.getConnection();
		PreparedStatement pre=con.prepareStatement(query);
		pre.setString(1,sav.name);
		int rowaffect=pre.executeUpdate();
		if(rowaffect>0)
		{
			System.out.println("DELET SUCCESSFULLY");
		}
		else {
			System.out.println("CONTACT NOT FOUND");
		}
	}
}