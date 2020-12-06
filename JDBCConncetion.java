import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConncetion {

	public static void main(String[] args) throws SQLException {
		
	/*Connection url
	"jdbc:mysql://"+host+":"+port+"/databasename";
	"jdbc:mysql://"+localhost+":"+3306+"/Employee";
		
*/
	/*Create new database and create a table

	having two columns	1.Username 2.Password.
	Add 4 records in it.
	*/
		String host="localhost";
		String port="3306";
		
		
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/nov2020", "root", "vairaj");
		
		Statement s=con.createStatement();
		
		ResultSet rs=s.executeQuery("select * from Empinfo where fname='Arun';");
		
		while(rs.next())
		{
			System.out.println(rs.getString("lname"));
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getInt("age"));
			
		}
		
		
		
		
		
		
	}

}
