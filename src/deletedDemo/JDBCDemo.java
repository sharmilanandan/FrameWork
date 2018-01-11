package deletedDemo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class JDBCDemo {

	public static void main(String[] args) throws SQLException {
		//setting url of database connection
		String url="jdbc:mysql://localhost:3306/logic";
		Connection c=(Connection) DriverManager.getConnection(url, "root", "");
		String sql="Select * from bsguw_customer";
		ResultSet res=c.createStatement().executeQuery(sql);
		int cc=res.getMetaData().getColumnCount();
		while(res.next())//means no rows
		{ 
			for(int i=1;i<=cc;i++)//for columns
			{
				String v=res.getString(i);
				System.out.println(v);
				
			}
			System.out.println("------------");
			
		}
		c.close();
		System.out.println("Done");
		
		
		

	}

}
