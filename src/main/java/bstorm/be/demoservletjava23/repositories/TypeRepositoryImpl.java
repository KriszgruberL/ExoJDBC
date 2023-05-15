package bstorm.be.demoservletjava23.repositories;

import bstorm.be.demoservletjava23.domain.entities.Type;
import bstorm.be.demoservletjava23.exceptions.EntityNotFoundException;
import bstorm.be.demoservletjava23.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TypeRepositoryImpl extends BaseRepositoryImpl<Type> implements TypeRepository {

    public TypeRepositoryImpl() {
        super("TYPE", "TYPE_ID");
    }

    @Override
    protected Type buildEntity(ResultSet rs) {
        try {
            return Type.builder()
                    .typeId(rs.getInt("TYPE_ID"))
                    .typeName(rs.getString("TYPE_NAME"))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Type add(Type type) {
        try {
            Connection conn = DatabaseConnectionManager.openConnection();
            PreparedStatement psmt = conn.prepareStatement("INSERT INTO TYPE(TYPE_NAME) " +
                    "VALUES(?) RETURNING *");
            psmt.setString(1, type.getTypeName());

            ResultSet rs = psmt.executeQuery();

            if(!rs.next())
                throw new EntityNotFoundException();

            Type newType = buildEntity(rs);


            return newType;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Integer id, Type type) {
        try {
            Connection conn = DatabaseConnectionManager.openConnection();
            PreparedStatement psmt = conn.prepareStatement("UPDATE TYPE(TYPE_NAME) " +
                    "SET TYPE_NAME = ?" +
                    "WHERE TYPE_ID = ?");
            psmt.setString(1, type.getTypeName());
            psmt.setInt(2, type.getTypeId());

            int nbRow = psmt.executeUpdate();

            DatabaseConnectionManager.closeConnection();

            return nbRow == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
