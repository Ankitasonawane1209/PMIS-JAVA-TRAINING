package com.example.QuickRelief.repository;

import com.example.QuickRelief.model.Supply;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class SupplyRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SupplyRowMapper supplyRowMapper = new SupplyRowMapper();

    public SupplyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Supply> findAll() {
        String sql = "SELECT id, item_name, quantity FROM supplies ORDER BY id ASC";
        return jdbcTemplate.query(sql, supplyRowMapper);
    }

    public Optional<Supply> findById(Long id) {
        String sql = "SELECT id, item_name, quantity FROM supplies WHERE id = ?";
        List<Supply> results = jdbcTemplate.query(sql, supplyRowMapper, id);
        return results.stream().findFirst();
    }

    public Optional<Supply> findByItemName(String itemName) {
        String sql = "SELECT id, item_name, quantity FROM supplies WHERE LOWER(TRIM(item_name)) = LOWER(TRIM(?))";
        List<Supply> results = jdbcTemplate.query(sql, supplyRowMapper, itemName);
        return results.stream().findFirst();
    }

    public Supply save(Supply supply) {
        String sql = "INSERT INTO supplies (item_name, quantity) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, supply.getItemName());
            ps.setInt(2, supply.getQuantity() != null ? supply.getQuantity() : 0);
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            supply.setId(key.longValue());
        }
        return supply;
    }

    public Supply update(Supply supply) {
        String sql = "UPDATE supplies SET item_name = ?, quantity = ? WHERE id = ?";
        jdbcTemplate.update(sql, supply.getItemName(), supply.getQuantity(), supply.getId());
        return supply;
    }

    public void updateQuantity(Long id, int quantity) {
        String sql = "UPDATE supplies SET quantity = ? WHERE id = ?";
        jdbcTemplate.update(sql, quantity, id);
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM supplies WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
