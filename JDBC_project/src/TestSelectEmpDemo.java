
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelectEmpDemo {

	public static void main(String[] args) 
	{
		Connection con=null;
		Statement st=null;
		try 
		{

		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe","System","Capgemini123");
		st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from emp1");
		System.out.println("ID\t\tName\t\tSalary\t\tDOJ");
		while(rs.next())
		{
			System.out.println(rs.getInt("emp_id")+"\t\t"
		                                  +rs.getString("emp_name")+"\t\t"+( +rs.getInt("emp_sal"))
		                                  +"\t\t"+rs.getDate("emp_doj"));
		}
		
	}


	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}

