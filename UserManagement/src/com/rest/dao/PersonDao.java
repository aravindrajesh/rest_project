package com.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rest.model.Person;

public class PersonDao {

	 private static String dbURL = "jdbc:derby://localhost:1527/sample;create=true;user=app;password=123";
	    private static String tableName = "posts";
	    // jdbc Connection
	    private static Connection conn = null;
	    private static Statement stmt = null;
	   
	    
	    
	    public void insertPerson(Person person,String firstname,String lastname,String email)
	    {
	    	createConnection();
	    	addmember(person,firstname, lastname, email);
	    	closeConnection();
	    	
	    	
	    }
	    
	    public List<Person> retreivePerson()
	    {   List<Person> personList = new ArrayList<>();
	    	createConnection();
	    	personList= retreive();
	    	closeConnection();
	    	
	    	return personList;
	    }
	    
	 
	    private static void createConnection()
	    {
	    	try
	        {
	            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
	            //Get a connection
	            conn = DriverManager.getConnection(dbURL); 
	        }
	        catch (Exception except)
	        {
	            except.printStackTrace();
	        }
	    }
	    public static void addmember(Person person,String firstname,String lastname, String email)
	    {
	    	try
	        {   
	    		String query ="insert into " + tableName + " (FIRSTNAME,LASTNAME,EMAILID) values (?,?,?)";
	    		
	           
	            PreparedStatement pstmt = conn.prepareStatement(query,new String[] { "USER_ID"});
	             pstmt.setString(1,firstname);
	             pstmt.setString(2,lastname);
	             pstmt.setString(3,email);
	             pstmt.executeUpdate();
	             ResultSet rs = pstmt.getGeneratedKeys();
	             if (rs.next()) {
	            	    long id = rs.getLong(1);
	            	    person.setId(id);
	            	    person.setFirstname(firstname);
	            	    person.setLastname(lastname);
	            	    person.setEmailid(email);
	            	    System.out.println("Inserted ID -" + id); // display inserted record
	            	}
	            pstmt.close();
	        }
	        catch (SQLException sqlExcept)
	        {
	            sqlExcept.printStackTrace();
	        }
	    }
	    
	    public static List<Person> retreive()
	    {
	    	List<Person> pList = new ArrayList<>();
	    	try
	        {   
	    		String query ="Select * from app." + tableName ;
	            PreparedStatement pstmt = conn.prepareStatement(query);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next())
	            {
	            	Person p = new Person();
	            	p.setEmailid(rs.getString("emailid"));
	            	p.setFirstname(rs.getString("firstname"));
	            	p.setLastname(rs.getString("lastname"));
	            	p.setId(rs.getLong(1));
	            	
	            	pList.add(p);
	            }
	              
	            pstmt.close();
	        }
	        catch (SQLException sqlExcept)
	        {
	            sqlExcept.printStackTrace();
	        }
	    	return pList;
	    }
	    
	    
	    private static void closeConnection()
	    {
	        try
	        {
	            if (stmt != null)
	            {
	                stmt.close();
	            }
	            if (conn != null)
	            {
	                DriverManager.getConnection(dbURL + ";shutdown=true");
	                conn.close();
	            }           
	        }
	        catch (SQLException sqlExcept)
	        {
	            
	        }

	    }
}


