package bstorm.be.demoservletjava23.repositories;

import bstorm.be.demoservletjava23.domain.entities.Product;
import bstorm.be.demoservletjava23.exceptions.EntityNotFoundException;
import bstorm.be.demoservletjava23.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepositoryImpl extends BaseRepositoryImpl<Product> implements ProductRepository {

    public ProductRepositoryImpl() {
        super("PRODUCT", "PRODUCT_ID");
    }

    @Override
    protected Product buildEntity(ResultSet rs) {
        try {
            return Product.builder()
                    .id(rs.getInt("PRODUCT_ID"))
                    .nameProduct(rs.getString("NAME"))
                    .description(rs.getString("DESCRIPTION"))
                    .quantity(rs.getInt("QUANTITY"))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product add(Product product) {
        try {
            Connection conn = DatabaseConnectionManager.openConnection();
            PreparedStatement psmt = conn.prepareStatement("INSERT INTO PRODUCT(NAME,DESCRIPTION,QUANTITY, TYPE_ID) " +
                    "VALUES(?,?,?,?) RETURNING *");
            psmt.setString(1, product.getNameProduct());
            psmt.setString(2, product.getDescription());
            psmt.setInt(3, product.getQuantity());
            psmt.setInt(4, product.getTypeId());

            ResultSet rs = psmt.executeQuery();

            if(!rs.next())
                throw new EntityNotFoundException();

            DatabaseConnectionManager.closeConnection();
            return buildEntity(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Integer id, Product product) {
        try {
            Connection conn = DatabaseConnectionManager.openConnection();
            PreparedStatement psmt = conn.prepareStatement("UPDATE PRODUCTS " +
                    "SET NAME = ?," +
                    "DESCRIPTION = ?,"+
                    "QUANTITY = ? " +
                    "WHERE PRODUCT_ID = ?");
            psmt.setString(1, product.getNameProduct());
            psmt.setString(2, product.getDescription());
            psmt.setInt(3, product.getQuantity());
            psmt.setInt(5,id);

            int nbRows = psmt.executeUpdate();

            DatabaseConnectionManager.closeConnection();

            return nbRows == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findByName(String search) {
        try {
            Connection conn = DatabaseConnectionManager.openConnection();
            PreparedStatement psmt = conn.prepareStatement("SELECT * FROM PRODUCT WHERE NAME = ?");
            psmt.setString(1,search);

            ResultSet rs = psmt.executeQuery();

            if(!rs.next())
                throw new EntityNotFoundException();

            Product product = buildEntity(rs);
            DatabaseConnectionManager.closeConnection();
            return product;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
