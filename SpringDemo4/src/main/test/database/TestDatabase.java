package database;

import config.DatabaseConfig;
import config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


/**
 * Created by admin on 2017/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class})
public class TestDatabase {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() {
        String driver = "org.h2.Driver";
        String url = "jdbc:h2:file:data/sample";
        String user = "sa";
        String password = "";
        try {
            org.h2.tools.Server.createTcpServer().start();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
//            boolean b = conn.createStatement().execute("CREATE TABLE `users` (" +
//                    "`username`  varchar(10) ," +
//                    "`password`  varchar(10) ," +
//                    "`enabled`  int " +
//                    ")");
            boolean b1 = conn.createStatement().execute("INSERT INTO users (username, password, enabled) VALUES ('admin', '1111', 1)");
            System.out.println(b1);

            ResultSet rs = conn.createStatement().executeQuery("SELECT count(*) FROM users");
            rs.next();
            System.out.println(rs.getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDatasource() throws Exception {
        Connection conn = dataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT count(*) FROM users");
        rs.next();
        System.out.println(rs.getInt(1));
    }
}
