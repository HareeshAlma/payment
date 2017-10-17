package com.ah.paymentstrategy.version2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class PaymentDAO {

	private static String  connectionUrl = "";
	private static Properties dbprops = null;
	static
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("");
		 dbprops = DatabaseProperties.getInstance().getProperties();
		connectionUrl = "jdbc:mysql://" 
				+ dbprops.getProperty("server") 
				+ ":" + dbprops.getProperty("port")
				+ "/" + dbprops.getProperty("database");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	{
		System.out.println("Called when the class is initialized");
	}
	
	public static Connection getConnection() throws Exception
	{
		
		
		Connection con = DriverManager.getConnection(connectionUrl, dbprops.getProperty("userid"), dbprops.getProperty("password"));
return con;
	}
	
	
	public int checkamount(int cardnumber,String date,int ccv,int amount){

		int amountavailable = 0;
		Connection con = null;
		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			//System.out.println("inside try");
			ResultSet rs = stmt.executeQuery("select amount from creditcarddetails where cardnumber = '"+cardnumber+"' and expiry = '"+date+"' and ccv = '"+ccv+"'");
			while(rs.next())
			{
				amountavailable = rs.getInt("amount");
			}
			
			

	}
		catch (Exception e) {
			System.out.println(e);
		}
		
		finally
		{
			if(con != null)
			{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		return amountavailable;
	}

	public int checkrewardsamount(int cardnumber,String date,int pin,int amount){

		int amountavailable = 0;
		Connection con = null;
		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			//System.out.println("inside try");
			ResultSet rs = stmt.executeQuery("select amount from rewardsdetails where cardnumber = '"+cardnumber+"' and expiry = '"+date+"' and pin = '"+pin+"'");
			while(rs.next())
			{
				amountavailable = rs.getInt("amount");
			}
			
			

	}
		catch (Exception e) {
			System.out.println(e);
		}
		
		finally
		{
			if(con != null)
			{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		return amountavailable;
	}

	
	public int checkpaypalamount(String email,String password,int amount){

		int amountavailable = 0;
		Connection con = null;
		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			//System.out.println("inside try");
			ResultSet rs = stmt.executeQuery("select amount from paypaldetails where email = '"+email+"' and password = '"+password+"' ");
			while(rs.next())
			{
				amountavailable = rs.getInt("amount");
			}
			
			

	}
		catch (Exception e) {
			System.out.println(e);
		}
		
		finally
		{
			if(con != null)
			{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		return amountavailable;
	}

}
