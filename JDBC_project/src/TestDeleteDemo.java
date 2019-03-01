import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.ems.util.DBUtil;

public class TestDeleteDemo {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Emp Id");
		int eid=sc.nextInt();
		
		
		try {
			Connection con=DBUtil.getCon();
			String deleteOnId="Delete from emp1 where emp_id=(?)";
		
			PreparedStatement pst=con.prepareStatement(deleteOnId);
			pst.setInt(1, eid);
	
			int data=pst.executeUpdate();	
			System.out.println("Data is Deleted "+data);
		}
		
		 catch (SQLException | IOException e) 
		{
	
			e.printStackTrace();
		}
		
		

	}


}
