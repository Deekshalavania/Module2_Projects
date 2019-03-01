package com.cg.ems.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	private static String url=null;
	private static String usn=null;
	private static String pwd=null;
	private static String driver=null;
	private static Connection con=null;
	public static Connection getCon() throws SQLException, IOException 

	{
		Properties myprops=getProps();
		url=myprops.getProperty("dburl");
		usn=myprops.getProperty("dbunm");
		pwd=myprops.getProperty("dbpwd");
		if(con==null)
		{
			 con=DriverManager.getConnection(url, usn, pwd);
		
		}
		return con;
	}
	public static Properties getProps() throws IOException
	{
		Properties dbProps=new Properties();
		FileReader fr=new FileReader("dbonfo.properties");
		dbProps.load(fr);  //load all data in file and store in DbProp Object
		return dbProps;
	
}
}