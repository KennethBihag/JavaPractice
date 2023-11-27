package Practice.jdbc;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.stream.StreamSupport;

import static java.lang.System.out;

public class MySqlConn {
    //static String uriFormat = "jdbc:mysql://localhost:3306/%s";
    static String uriFormat = "jdbc:mysql://localhost/%s?user=kenneth&password=kenneth";
    public static void selectAllFromTable(String database, String tableName) throws MyException {
        try {
            String myUri = String.format(uriFormat, database);
            //Connection conn = DriverManager.getConnection(myUri, "local", "local");
            Connection conn = DriverManager.getConnection(myUri);
            if (!conn.isValid(3))
                throw new MyException("Invalid connection!");
            String myQuery = String.format("SELECT * FROM %s LIMIT ? OFFSET ?;", tableName);
/*            Statement st = conn.createStatement();
            st.execute(myQuery);*/
            PreparedStatement st = conn.prepareStatement(myQuery);
            st.setInt(1,5);
            st.setInt(2,0);
            st.execute();
            ResultSet rs = st.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                    int sqlType = rsmd.getColumnType(i);
                    String colName = rsmd.getColumnName(i);
                    out.print(colName + ":");
                    switch (sqlType) {
                        case Types.NVARCHAR:
                        case Types.VARCHAR:
                            out.print(rs.getString(i));
                            break;
                        case Types.SMALLINT:
                        case Types.INTEGER:
                            out.print(rs.getInt(i));
                            break;
                        default:
                            out.print(rs.getObject(i));
                            break;
                    }
                    if(i != rsmd.getColumnCount())
                        out.print(" || ");
                }
                out.println();
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException sqle) {
            throw new MyException("Something went wrong!", sqle);
        }
    }

    public static void getAllTablesFromDb(String database) throws NamingException, SQLException {
/* using JEE
        InitialContext ic = new InitialContext();
        DataSource ds = (DataSource) ic.lookup("jdbc/mysql");
        Connection con = ds.getConnection("local","local");*/
        Connection con = DriverManager.getConnection(String.format(uriFormat,database),"local","local");
        String catalog = con.getCatalog();
        ResultSet allTables = con.getMetaData().getTables(catalog,database,"%",null);
        out.println("Database "+database+" has these tables:");
        while(allTables.next()){
            out.println("\t"+allTables.getString("TABLE_NAME"));
        }
        allTables.close();
        con.close();
    }

}
