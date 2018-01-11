package generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





import executor.IAutoConst;

public class DataBase {
	public static String getFirstValueFromDB(String sql){
		String url=Property.getValue(IAutoConst.SETTINGS_PATH,"DBURL");
		String un=Property.getValue(IAutoConst.SETTINGS_PATH,"DBUN");
		String pw=Property.getValue(IAutoConst.SETTINGS_PATH, "DBPW");
		String v="";
		try{
		Connection c=DriverManager.getConnection(url,un,pw);
		ResultSet res=c.createStatement().executeQuery(sql);
		res.next();
		v=res.getString(1);
		c.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return v;
	}
	public static ArrayList<String> getAlltValueFromDB(String sql){
		String url=Property.getValue(IAutoConst.SETTINGS_PATH,"DBURL");
		String un=Property.getValue(IAutoConst.SETTINGS_PATH,"DBUN");
		String pw=Property.getValue(IAutoConst.SETTINGS_PATH, "DBPW");
		ArrayList<String> v=new ArrayList<String>();
		try{
	    Connection c= DriverManager.getConnection(url,un,pw);
		ResultSet res=c.createStatement().executeQuery(sql);
		res.next();
		int cc=res.getMetaData().getColumnCount();
			for(int i=1;i<=cc;i++)
			{
			v.add(res.getString(i));
			}
		c.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return v;
	}


}
