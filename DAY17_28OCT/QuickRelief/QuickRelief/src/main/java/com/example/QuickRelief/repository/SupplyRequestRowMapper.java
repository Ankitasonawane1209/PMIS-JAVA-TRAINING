package com.example.QuickRelief.repository;

import com.example.QuickRelief.model.SupplyRequest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplyRequestRowMapper implements RowMapper<SupplyRequest> {

    @Override
    public SupplyRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
        SupplyRequest request = new SupplyRequest();
        request.setId(rs.getLong("id"));
        request.setItemName(rs.getString("item_name"));
        request.setQuantity(rs.getInt("quantity"));
        request.setStatus(rs.getString("status"));
        request.setRequestedBy(rs.getString("requested_by"));
        return request;
    }
}
