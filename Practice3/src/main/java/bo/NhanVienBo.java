package bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NhanVien;
import utils.DbConnection;

public class NhanVienBo implements BaseBo<NhanVien, Integer> {
    private static final String TABLE = "nhanvien";

    @Override
    public NhanVien add(NhanVien data) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = String.format("INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)",
                    TABLE,
                    NhanVien.hotenFieldName(),
                    NhanVien.idphongbanFieldName(),
                    NhanVien.diachiFieldName());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, data.getHoten());
            statement.setInt(2, data.getIdphongban());
            statement.setString(3, data.getDiachi());
            statement.executeUpdate();
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public NhanVien edit(NhanVien data, Integer id) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ? WHERE %s = ?",
                    TABLE,
                    NhanVien.hotenFieldName(),
                    NhanVien.idphongbanFieldName(),
                    NhanVien.diachiFieldName(),
                    NhanVien.idFieldName());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, data.getHoten());
            statement.setInt(2, data.getIdphongban());
            statement.setString(3, data.getDiachi());
            statement.setInt(4, id);
            statement.executeUpdate();
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = String.format("DELETE FROM %s WHERE %s = ?",
                    TABLE,
                    NhanVien.idFieldName());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public NhanVien getById(Integer id) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = String.format("SELECT * FROM %s WHERE %s = ?",
                    TABLE,
                    NhanVien.idFieldName());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return NhanVien.builder()
                        .id(resultSet.getInt(NhanVien.idFieldName()))
                        .hoten(resultSet.getString(NhanVien.hotenFieldName()))
                        .idphongban(resultSet.getInt(NhanVien.idphongbanFieldName()))
                        .diachi(resultSet.getString(NhanVien.diachiFieldName()))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<NhanVien> getAll() {
        List<NhanVien> nhanVienList = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            String sql = String.format("SELECT * FROM %s", TABLE);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                NhanVien nhanVien = NhanVien.builder()
                        .id(resultSet.getInt(NhanVien.idFieldName()))
                        .hoten(resultSet.getString(NhanVien.hotenFieldName()))
                        .idphongban(resultSet.getInt(NhanVien.idphongbanFieldName()))
                        .diachi(resultSet.getString(NhanVien.diachiFieldName()))
                        .build();
                nhanVienList.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanVienList;
    }

}
