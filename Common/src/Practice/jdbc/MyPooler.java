package Practice.jdbc;

import com.zaxxer.hikari.*;

import java.io.PrintStream;
import java.sql.*;
import java.util.*;

import static java.lang.System.out;

public class MyPooler implements AutoCloseable {
    private static String defaultDb = "sakila";
    private static HikariDataSource dataSource;
    private static HikariPoolMXBean monitor;
    private List<Connection> conns;
    HikariConfig hc = new HikariConfig();
    {
        System.out.println("Creating a pool of db connections...");
        hc.setJdbcUrl(String.format(MySqlConn.uriFormat,defaultDb));
        dataSource = new HikariDataSource(hc);
        monitor = dataSource.getHikariPoolMXBean();
    }
    private Connection getPooledConnection(){
        Connection conn;
        try{
            conn = dataSource.getConnection();
            conns.add(conn);
        } catch (SQLException ex){
            System.out.print(ex);
            conn = null;
        }
        return conn;
    }
    private void displayPoolInfo(){
        int ac = monitor.getActiveConnections();
        int ic = monitor.getIdleConnections();
        int tc = monitor.getTotalConnections();
        System.err.printf("%d active + %d idle = %d connections\n",
                ac,ic,tc);
    }
    public MyPooler(short poolSize, short connsAtATime) throws SQLException {
        dataSource.setMaximumPoolSize(poolSize);
        conns = new ArrayList<Connection>(poolSize);
        for (int i = 0; i < poolSize; ++i) {
            if(i>connsAtATime-1)
                conns.get(conns.size()-connsAtATime).close();
            conns.add(getPooledConnection());
            Connection lastConn = conns.get(conns.size() - 1);
            out.println("Connection " + (i+1) + " " + lastConn);
            displayPoolInfo();
        }
    }
    @Override
    public void close() throws SQLException{
        for(Connection c : conns)
            c.close();
    }
}
