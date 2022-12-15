package com.Tourism.OnlineTourism.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
/**
 * this method is used  to fetch deta from mySql
 * @author Abhinav
 *
 */
public class MYSqlUtility {
	public void creatingDataOnMySqlTest(String url,String mySqlUn,String mySqlPwd) 
	{
		
		Driver db=null;
		try {
			db = new Driver();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DriverManager.registerDriver(db);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection=null;
		try {
			connection = DriverManager.getConnection(url,mySqlUn,mySqlPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement statement=null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result=0;
		try {
			result = statement.executeUpdate("insert into mobile values('mobileName',price,'brandName');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	statement.executeUpdate("insert into mobile values(('moto',12000,'motorola'),('nokia1',12000,'nokia');");
		
		if(result==1)
		{
			System.out.println("data updated successfully");
		}
		else
			System.out.println("data not updated successfully");
		
	}
}
