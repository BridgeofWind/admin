package util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CloseConnection {
	public static void close(Connection con,PreparedStatement ps){
		
			try {
				if(ps!=null)	ps.close();
				if(con!=null) con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
		
	}
}
