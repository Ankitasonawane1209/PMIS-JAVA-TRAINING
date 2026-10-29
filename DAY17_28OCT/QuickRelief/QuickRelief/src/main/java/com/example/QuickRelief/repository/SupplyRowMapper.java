package com.example.QuickRelief.repository;

import com.example.QuickRelief.model.Supply;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplyRowMapper implements RowMapper<Supply> {

    @Override
    public Supply mapRow(ResultSet rs, int rowNum) throws SQLException {
        Supply supply = new Supply();
        supply.setId(rs.getLong("id"));
        supply.setItemName(rs.getString("item_name"));
        supply.setQuantity(rs.getInt("quantity"));
        return supply;
    }
}
