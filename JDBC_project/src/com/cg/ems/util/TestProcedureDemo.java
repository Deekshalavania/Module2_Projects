package com.cg.ems.util;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class TestProcedureDemo {
	
	public static void main(String args[])
	{
		try {
			Connection con=DBUtil.getCon();
			CallableStatement cst=con.prepareCall("Call pr1(?,?)");
			cst.setInt(1,112);
			cst.registerOutParameter(2,Types.NUMERIC);
			ResultSet rs=cst.executeQuery();
			System.out.println("Salary is  "+cst.getInt(2));
			System.out.println("-------------------|--------------------");
			boolean bb=cst.execute();
			System.out.println("Salary is   "+cst.getInt(2));
			
		} 
		catch (SQLException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
