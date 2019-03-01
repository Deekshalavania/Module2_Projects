import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.ems.util.DBUtil;

public class TestInsertDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Emp Id");
		int eid=sc.nextInt();
		
		System.out.println("enter Emp Name");
		String enm=sc.nextLine();
		sc.nextLine();
		
		System.out.println("enter Emp Salary");
		Float esal=sc.nextFloat();
		
		try {
			Connection con=DBUtil.getCon();
			String insertQuery="INSERT INTO emp1"+"(emp_id,emp_name,emp_sal) "
			                 +"VALUES(?,?,?)";
			System.out.println("con.."+con);
			PreparedStatement pst=con.prepareStatement(insertQuery);
			pst.setInt(1, eid);
			pst.setString(2,enm);
			pst.setFloat(3,esal);
			int data=pst.executeUpdate();	
			System.out.println("Data is inserted"+data);
		}
		
		 catch (SQLException | IOException e) 
		{
	
			e.printStackTrace();
		}
		
		

	}

}
