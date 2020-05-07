package com.dao;

import com.models.Good;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class GoodDAOImpl implements GoodDAO{

    private static String url;
    private static String username;
    private static String password;
    private  String sql;

    @PostConstruct
    private void init(){
        url = "jdbc:mysql://localhost:3306/SpringDB?useSSL=false&amp;serverTimezone=UTC&amp;characterEncoding=UTF-8";
        username = "root";
        password = "root";
    }

    @Override
    public void insertGood(Good good){
        sql = "insert into goods(title, amount, description) values (?, ?, ?);";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, good.getTitle());
            stmt.setInt(2, good.getAmount());
            stmt.setString(3, good.getDescription());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateGood(Good good) {
        sql = "UPDATE goods SET title = "+ good.getTitle() + ", amount="+ good.getAmount()+", description="+ good.getDescription()+ "WHERE id=" + good.getId()+";";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            conn.prepareStatement(sql).executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteGood(int id) {
        sql = "delete from goods where id=" + id + ";";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            conn.prepareStatement(sql).executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
    }


    @Override
    public Good getGoodById(int id) {
        Good result = null;
        sql = "select * from goods where id= " + id + ";";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                result = new Good(
                        rs.getInt("Id"),
                        rs.getString("title"),
                        rs.getInt("amount"),
                        rs.getString("description")
                );
            }
        } catch (Exception e){
            System.out.println(e);
        } return result;
    }


    @Override
    public List<Good> listOfGoods() {
        List<Good> result = new ArrayList<>();
        sql = "select * from goods;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                Good good = new Good(
                        rs.getInt("Id"),
                        rs.getString("title"),
                        rs.getInt("amount"),
                        rs.getString("description")
                );
                result.add(good);
            }
        } catch (Exception e){
            System.out.println(e);
        } return result;
    }
}
