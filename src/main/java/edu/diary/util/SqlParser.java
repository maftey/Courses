package edu.diary.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SqlParser {
 
    private String sqlQuery;
  
    public String parseSqlFile() {
        String parsedString = "";
        ClassLoader classLoader = getClass().getClassLoader();
        File sqlFile = new File(classLoader.getResource("initDB.sql").getFile());
        StringBuffer sb = new StringBuffer();
 
        try {
            FileReader fr = new FileReader(new File("mySQLFile.sql"));
            BufferedReader br = new BufferedReader(fr);
 
            while ((parsedString = br.readLine()) != null) {
                sb.append(parsedString);
            }
            br.close();
            
             String[] sqlString = sb.toString().split(";");
 
            for (int i = 0; i < sqlString.length; i++)
            {
                // we ensure that there is no spaces before or after the request string
                // in order to not execute empty statements
                if(!sqlString[i].trim().equals(""));
                sqlQuery = sqlString.toString();
            }
        } catch (Exception e) {
          e.printStackTrace();
        }
        return sqlQuery;
 
    }
  }


