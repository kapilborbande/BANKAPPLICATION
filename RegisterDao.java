package Bank.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Bank.model.Login;
import Bank.model.Register;

public class RegisterDao 
{
	public int create(List<Register> lstreg) {
		System.out.println("register controllet -test4");
		Register regmodel=lstreg.get(0);
		int i=0;
		Connection con=DataSource.getConnection();
		
		try {
			PreparedStatement pstate=con.prepareStatement("insert into bank values(?,?,?,?,?)");
			pstate.setInt(1,regmodel.getRno());
			pstate.setString(2,regmodel.getFname());
			pstate.setDouble(3,regmodel.getAccbal());
			pstate.setString(4,regmodel.getUname());
			pstate.setString(5,regmodel.getPass());

			i=pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	public List<Register> validateData(List<Login> lstlogin) {
		boolean b=false;
		Login lobj=lstlogin.get(0);		
		List<Register> lstreg=null;
		Connection con=DataSource.getConnection();
		try {
			PreparedStatement pstate = con.prepareStatement("select * from bank where user_name=? and user_pass=?");
			pstate.setString(1, lobj.getUsername());
			pstate.setString(2, lobj.getPass());
			ResultSet rs = pstate.executeQuery();			
			if (rs.next()) {
				b = true;
				lstreg=new ArrayList();
				Register r=new Register(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5));
				lstreg.add(r);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lstreg;

	}
	
		public List<Register> getAllData()
		{
			System.out.println("Helloooo world");
			List<Register> lst=new LinkedList<Register>();
			  Connection con=DataSource.getConnection();
			  
			  try {
				Statement s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				 ResultSet rs=s.executeQuery("select * from bank");
				 while(rs.next())
				 {
					 Register r=new Register();
					 r.setRno(rs.getInt(1));
					 r.setFname(rs.getString(2));
					 r.setPass(rs.getString(3));
					 r.setAccbal(rs.getDouble(4));
					 lst.add(r);
					 
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return lst;
	}
		
		public Register searchData(int rno)
		{
			Register r1=null;
			List<Register> lst=getAllData();
			System.out.println("HELLOOOOOO");
			
			
			for (Register r:lst)
			{
				if(r!=null)
				{
					System.out.println(r.getRno()+"\t"+r.getFname());
					r1=r;
					break;
				}
			}
			return r1;
		}

}
