package org.hdivsamples;

import java.sql.Connection;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.sql.*;



@Controller
@RequestMapping("/api")
public class Feature1 {

    private Connection conn;

    public void setConnection(Connection conn){
        this.conn = conn;
    }

    public static int transform(String s){
        if (s == null)
            return Integer.parseInt(s.toString());
        else
            return -1;
    }

/*
        String query = "Select Item, SKU, InStockNo from Storage where name = " + name;
        try (Statement stmt = conn.createStatement()) {    
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getString("Item");
            }

        String query = "Select Item, SKU, InStockNo from Storage where name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);    
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getString("Item");
            }
 */

    
    @RequestMapping("/check")
    public String check(@RequestParam String name) {

        String query = "Select Item, SKU, InStockNo from Storage where name = " + name;
        try (Statement stmt = conn.createStatement()) {    
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getString("Item");
            }

        } catch (SQLException e){
            // ignore
        }
        return "Not found";
    }
    
}
