package com.andrei1058.bedwars.database;

import org.bukkit.Bukkit;

import java.sql.*;
import java.util.UUID;

public class BoosterSQL {

    private Connection conn;

    public void connect() {

        if (this.conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stardust?user=root&password=TransCraftStudio&autoReconnect=true");
            } catch (ClassNotFoundException | SQLException ignored) {
            }
        }
    }

    public void disconnect() {
        if (this.conn != null) {
            try {
                this.conn.close();
                this.conn = null;
            } catch (SQLException ignored) {
            }
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public Integer getMyBooster(UUID uuid) {
        this.connect();
        try (Statement stmt = this.conn.createStatement();) {
            String sql = String.format("SELECT * FROM `alonsolevels` WHERE `uuid`='%s'", uuid);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            return rs.getInt("lastlevel");
        } catch (SQLException ignored) {
        }
        this.disconnect();
        return null;
    }

}