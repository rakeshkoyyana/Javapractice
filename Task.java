package task;
import java.util.*;
import java.sql.*;
public class Task {

	public static void main(String[] args)throws Exception {
Scanner sc;Connection conn;String x;int count=0;String c;
do{
	sc=new Scanner(System.in);
System.out.println("EMPID:");int a1=sc.nextInt();
System.out.println("EMPNAME:");String a2=sc.next();
System.out.println("EMPSAL:");int a3=sc.nextInt();
conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
x="insert into Emp(EMPID,EMPNAME,EMPSAL) values(?,?,?)";
PreparedStatement s=conn.prepareStatement(x);
s.setInt(1,a1);
s.setString(2,a2);
s.setInt(3,a3);
int r=s.executeUpdate();
if(r>0) {
	count++;
	System.out.println(" inserted");
}
 c=sc.next();
}while(c.equalsIgnoreCase("yes"));
System.out.println(count+" are inserted in the table");

conn.close();
sc.close();
	}

}
