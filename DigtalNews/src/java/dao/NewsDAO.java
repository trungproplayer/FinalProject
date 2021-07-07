/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.News;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bookm
 */
public class NewsDAO {

    Connection cnn;// Kết nối CSDL
    PreparedStatement ps; // Thực hiện câu lệnh SQL
    ResultSet rs; // Lưu trữ và xử lý dư liệu
    DBContext db = new DBContext();

    public News getTopOne() throws Exception {
        try {
            String sqlQuery = "SELECT TOP(1) * FROM digital \n"
                    + "ORDER BY timePost DESC ";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            News news = null;
            while (rs.next()) {
                news = new News(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(7),
                        db.getImagePath() + rs.getString(4),
                        rs.getDate(6),
                        rs.getString(5));
            }
            return news;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }

    public List<News> getTopFive() throws Exception {
        try {
            String sqlQuery = "SELECT TOP(5) * FROM digital \n"
                    + "WHERE timePost != (SELECT MAX(timePost) FROM digital) \n"
                    + "ORDER BY timePost DESC ";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            List<News> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new News(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(7),
                        db.getImagePath() + rs.getString(4),
                        rs.getDate(6),
                        rs.getString(5)));
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }

    public News findByID(int id) throws Exception {
        try {
            String sqlQuery = "SELECT * FROM digital WHERE ID = '" + id + "'";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            News digital = null;
            while (rs.next()) {
                digital = new News(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(7),
                        db.getImagePath() + rs.getString(4),
                        rs.getDate(6),
                        rs.getString(5));
            }
            return digital;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }

    }

    public List<News> findByTitle(String txt) throws Exception {
        try {
            String sqlQuery = "Select * from digital where title like ? ";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            ps.setString(1, "%" + txt + "%");

            rs = ps.executeQuery();
            List<News> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new News(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(7),
                        db.getImagePath() + rs.getString(4),
                        rs.getDate(6),
                        rs.getString(5)));
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }

    public int countDigitalByTitle(String txt) throws SQLException, Exception {
        try {
            String sqlQuery = "SELECT COUNT(*) FROM digital where title like ?";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            ps.setString(1, "%" + txt + "%");

            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
    }

    public List<News> search(String txt, int index) throws SQLException, Exception {
        List<News> ld = new ArrayList<>();
        try {
            String query = "select * from digital where title like ? order by id OFFSET ? ROW FETCH FIRST 2 ROWS ONLY;";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            ps.setInt(2, index);

            rs = ps.executeQuery();
            while (rs.next()) {
                ld.add(new News(rs.getInt(1),
                        setupTitile(rs.getString(2), txt),
                        rs.getString(3),
                        rs.getString(7),
                        db.getImagePath() + rs.getString(4),
                        rs.getDate(6),
                        rs.getString(5)));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
        return ld;
    }

    public List<News> searchTest(String txt) throws SQLException, Exception {
        List<News> ld = new ArrayList<>();
        try {
            String query = "select * from digital where title like ?";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                ld.add(new News(rs.getInt(1),
                        setupTitile(rs.getString(2), txt),
                        rs.getString(3),
                        rs.getString(4),
                        db.getImagePath() + rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7)));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, cnn);
        }
        return ld;
    }

    public static String setupTitile(String title, String txtSearch) {
        String[] test = new String[txtSearch.length() * 2];
        String textS = txtSearch.toUpperCase();
        String textS1 = txtSearch.toLowerCase();

        test[0] = textS;
        test[1] = textS1;

        for (int i = 1; i < textS.length(); i++) {
            String sString = textS.substring(i, i + 1);
            if (sString.codePointAt(0) > 64 && sString.codePointAt(0) < 91) {
                textS = textS.replaceAll(textS.substring(i, i + 1), sString.toLowerCase());
                test[i + 1] = textS;
            }

        }

        for (int i = 1; i < textS1.length(); i++) {
            String s2String = textS1.substring(i, i + 1);
            if (s2String.codePointAt(0) > 96 && s2String.codePointAt(0) < 123) {
                textS1 = textS1.replaceAll(textS1.substring(i, i + 1), s2String.toUpperCase());
                test[i + txtSearch.length()] = textS1;
            }

        }

        for (int i = 0; i < test.length; i++) {
            if(test[i] != null){
            String stReplace = "<mark>" + test[i] + "</mark>";
            title = title.replaceAll(test[i], stReplace);
            }
        }
        return title;
    }
    
}
