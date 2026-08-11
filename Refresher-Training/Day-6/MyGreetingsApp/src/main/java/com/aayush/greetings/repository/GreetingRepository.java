package com.aayush.greetings.repository;

import com.aayush.greetings.model.Greeting;
import com.aayush.greetings.util.DBUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GreetingRepository {

    public List<Greeting> findByUserId(int userId) {
        String sql = "SELECT * FROM greetings WHERE user_id = ? ORDER BY id DESC";
        List<Greeting> greetings = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    greetings.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching greetings", e);
        }
        return greetings;
    }

    public Greeting findById(int id, int userId) {
        String sql = "SELECT * FROM greetings WHERE id = ? AND user_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setInt(2, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching greeting", e);
        }
        return null;
    }

    public void save(Greeting greeting) {
        String sql = "INSERT INTO greetings (name, user_id) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, greeting.getName());
            ps.setInt(2, greeting.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving greeting", e);
        }
    }
    // edit Greeting 
    public void update(Greeting greeting) {
        String sql = "UPDATE greetings SET name = ? WHERE id = ? AND user_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, greeting.getName());
            ps.setInt(2, greeting.getId());
            ps.setInt(3, greeting.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating greeting", e);
        }
    }
    // delete Greeting 
    public void delete(int id, int userId) {
        String sql = "DELETE FROM greetings WHERE id = ? AND user_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setInt(2, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting greeting", e);
        }
    }

    private Greeting mapRow(ResultSet rs) throws SQLException {
        Greeting g = new Greeting();
        g.setId(rs.getInt("id"));
        g.setName(rs.getString("name"));
        g.setUserId(rs.getInt("user_id"));
        return g;
    }
}
