package com.cg.ems.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TsetResultSetMetaData {

	public static void main(String[] args) {

		try {
			Connection con=DBUtil.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from emp1");
			ResultSetMetaData rsmd=rs.getMetaData();
			int colCount=rsmd.getColumnCount();
			System.out.println("No. of columns: "+colCount);
			for(int i=1;i<colCount;i++)
			{
				System.out.println(i+ ": Column Name"+rsmd.getColumnName(i)+
						"Column Type:"+ rsmd.getColumnTypeName(i));
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
