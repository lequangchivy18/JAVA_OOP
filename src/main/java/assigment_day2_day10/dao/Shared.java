package assigment_day2_day10.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Shared {
    public Connection cn;

    //    public static void main(String[] args) {
    //        try {
    //            System.out.println("vào");
    //            Shared s = new Shared();
    //            s.KetNoi();
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        }
    //    }

    public void KetNoi() throws Exception {
        //B1 Xac dinh hqtcsdl
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //DESKTOP-KMNS09Q
        cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-KMNS09Q:1433;databaseName=CANDIDATE;user=sa; password=123456");
        System.out.println("Da ket noi");
    }
}
