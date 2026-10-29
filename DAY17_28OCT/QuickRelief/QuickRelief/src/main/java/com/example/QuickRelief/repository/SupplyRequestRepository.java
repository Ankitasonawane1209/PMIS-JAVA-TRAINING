package com.example.QuickRelief.repository;

import com.example.QuickRelief.model.SupplyRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class SupplyRequestRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SupplyRequestRowMapper supplyRequestRowMapper = new SupplyRequestRowMapper();

    public SupplyRequestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SupplyRequest save(SupplyRequest request) {
        String sql = "INSERT INTO requests (item_name, quantity, status, requested_by) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, request.getItemName());
            ps.setInt(2, request.getQuantity() != null ? request.getQuantity() : 0);
            ps.setString(3, request.getStatus());
            ps.setString(4, request.getRequestedBy());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            request.setId(key.longValue());
        }
        return request;
    }

    public List<SupplyRequest> findAll() {
        String sql = "SELECT id, item_name, quantity, status, requested_by FROM requests ORDER BY id ASC";
        return jdbcTemplate.query(sql, supplyRequestRowMapper);
    }

    public Optional<SupplyRequest> findById(Long id) {
        String sql = "SELECT id, item_name, quantity, status, requested_by FROM requests WHERE id = ?";
        List<SupplyRequest> results = jdbcTemplate.query(sql, supplyRequestRowMapper, id);
        return results.stream().findFirst();
    }
}
