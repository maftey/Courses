package edu.diary.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
 
public class DBInitialisator {
	private static Logger logger = Logger.getLogger("DBInitialisator");

	public static void resetDatabase() throws SQLException {
        String s = new String();
        StringBuffer sb = new StringBuffer();
        try {
            FileReader fr = new FileReader(new File(
            		"src/main/java/resourses/initDB.sql"));
            BufferedReader br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            br.close();
 
            // here is our splitter ! We use ";" as a delimiter for each request
            // then we are sure to have well formed statements
            String[] inst = sb.toString().split(";");
            Connection conn = DBConnection.openConnection();
             Statement statement = conn.createStatement();
 
            for (int i = 0; i < inst.length; i++) {
                // we ensure that there is no spaces before or after 
            	// 	the request string
                // in order to not execute empty statements
                if (!inst[i].trim().equals("")) {
                    statement.executeUpdate(inst[i]);
                    System.out.println(">>" + inst[i]);
                }
            }
           DBConnection.close(statement);
           DBConnection.closeConnection();
        } catch (Exception e) {
            System.out.println("*** Error : " + e.toString());
            System.out.println("*** ");
            System.out.println("*** Error : ");
            logger.info("Tables didn't created! " + e);
            System.out.println(sb.toString());
        }
    }
}
