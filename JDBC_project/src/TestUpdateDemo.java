import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.ems.util.DBUtil;

public class TestUpdateDemo {
	
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
			String updateQuery="Update emp1 SET emp_name=?,emp_sal=? where emp_id=?";
			System.out.println("con.."+con);
			PreparedStatement pst=con.prepareStatement(updateQuery);
	        pst.setInt(3,eid);
			pst.setString(1,enm);
			pst.setFloat(2,esal);
			int data=pst.executeUpdate();	
			System.out.println("Data is Updated"+data);
		}
		
		 catch (SQLException | IOException e) 
		{
	
			e.printStackTrace();
		}
		
		

	}

	
}
