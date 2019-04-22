package portal;
import java.sql.*;

import portal.StreamStudent1;
import portal.StreamDao;

public class StreamDao 
{
public static Connection getConnection()
{
Connection con=null;
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
}
catch(Exception e)
{System.out.println(e);}
return con;
}

public static int save(StreamStudent1 obj)
{
int status=0;
try{
Connection con=StreamDao.getConnection();
PreparedStatement ps=con.prepareStatement ("insert into Stream  "+" (course_id,Stream_name) values (?,?)");
ps.setString(1, obj.getCourse_id());
ps.setString(2, obj.getStream_name());


status=ps.executeUpdate();
con.close();
}
catch(Exception ex){ex.printStackTrace();}
return status;
}
}
