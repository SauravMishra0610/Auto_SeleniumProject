package com.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQL {
    final static String URL = "jdbc:mysql://localhost:3306/zillow";
    final static String USERNAME = "root";
    final static String PASSWORD = "MySQL";

    private static Connection conn	= null;     // session between java application and database
    private static Statement statement	= null; // methods to execute queries with the database
    private static ResultSet resultSet	= null;

    public static boolean open() {
        return open(URL, USERNAME, PASSWORD);
    }
    public static boolean open(String url, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, username, password);
            return true;
        }
        catch (Exception e)
        {
            System.out.println("ERROR: SQL open");
            e.printStackTrace();
        }
        return false;
    }
    public static boolean close()
    {
        boolean passAll = true;
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                passAll = false;
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                passAll = false;
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                passAll = false;
            }
        }
        return passAll;
    }
    public static List<List<String>> executeSelect(String SQLquery, boolean fieldLabel) {
        List<List<String>> tableList = new ArrayList<>();
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(SQLquery);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnTotal = metaData.getColumnCount();

            //Get the labels
            if (fieldLabel)
            {
                List<String> fieldList = new ArrayList<String>();
                for (int i=1; i<=columnTotal; i++)
                {
                    fieldList.add( metaData.getColumnLabel(i) );
                }
                tableList.add(fieldList);
            }

            //Get the data from the table
            while (resultSet.next()) {
                List<String> rowList = new ArrayList<String>();
                for (int i=1; i<=columnTotal; i++)
                {
                    rowList.add(resultSet.getString(i));
                }
                tableList.add(rowList);
            }
        }
        catch (Exception e) {
            System.out.println("ERROR: SQL selectResult");
            e.printStackTrace();
        }
        return tableList;
    }
    // Return the number of row updated
    public int executeUpdate(String SQLquery) {
        try {
            statement = conn.createStatement();
            int result = statement.executeUpdate(SQLquery);
            statement.executeQuery("commit;");
            return result;
        }
        catch (Exception e) {
            System.out.println("ERROR: SQL executeUpdate");
            e.printStackTrace();
        }
        return 0;
    }

    /* -----------------------------------------------------
    For testing purpose
    ----------------------------------------------------- */

    public static void main(String[] args) {
        open();
        List<List<String>> data = executeSelect("select * from employee", true);
        close();

        // Display result
        for (int i=0; i<data.size(); i++) {
            System.out.println(i +"__"+ data.get(i));
        }
    }
}
