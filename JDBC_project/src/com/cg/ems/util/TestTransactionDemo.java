package com.cg.ems.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransactionDemo {

	public static void main(String[] args) 
	{
		Connection con=null;
     try {
		 con=DBUtil.getCon();
		con.setAutoCommit(false);
		String update1="Update emp1 set emp_name = 'Vaiashali'"+
						"where emp_id=111";
		String update2="Update emp1 set emp_name = 'Devangana'"+
				"where emp_id=112";
		Statement st=con.createStatement();
		st.addBatch(update1);
		st.addBatch(update2);
		int arr[]=st.executeBatch();
		con.commit();
		System.out.println("Updated Successfully");
	} 
     catch (SQLException | IOException e) 
     {
    	 try 
    	 {
			con.rollback();
		} 
    	 catch (SQLException e1)
    	 {
			e1.printStackTrace();
		}
		e.printStackTrace();
		
	}
     finally {
    	 
    	 try {
			con.close();
		
		} 
    	 catch (SQLException e)
    	 {
		
			e.printStackTrace();
		}
    	 
     }
     

	}

}
