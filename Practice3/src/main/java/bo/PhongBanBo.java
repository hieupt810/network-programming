package bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PhongBan;
import utils.DbConnection;

public class PhongBanBo implements BaseBo<PhongBan, Integer> {
    private static final String TABLE = "phongban";

    @Override
    public PhongBan add(PhongBan data) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = String.format("INSERT INTO %s (%s, %s) VALUES (?, ?)", TABLE,
                    PhongBan.tenpbFieldName(),
                    PhongBan.motaFieldName());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, data.getTenpb());
            statement.setString(2, data.getMota());
            statement.executeUpdate();
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PhongBan edit(PhongBan data, Integer id) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = String.format("UPDATE %s SET %s = ?, %s = ? WHERE %s = ?", TABLE,
                    PhongBan.tenpbFieldName(),
                    PhongBan.motaFieldName(),
                    PhongBan.idFieldName());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, data.getTenpb());
            statement.setString(2, data.getMota());
            statement.setInt(3, id);
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
            String sql = String.format("DELETE %s WHERE %s = %s", TABLE, PhongBan.idFieldName(), id.toString());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PhongBan getById(Integer id) {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = String.format("SELECT * FROM %s WHERE %s = %s", TABLE, PhongBan.idFieldName(), id.toString());
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return PhongBan.builder()
                        .id(resultSet.getInt(PhongBan.idFieldName()))
                        .tenpb(resultSet.getString(PhongBan.tenpbFieldName()))
                        .mota(resultSet.getString(PhongBan.motaFieldName()))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PhongBan> getAll() {
        List<PhongBan> results = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            String sql = String.format("SELECT * FROM %s", TABLE);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                results.add(PhongBan.builder()
                        .id(resultSet.getInt(PhongBan.idFieldName()))
                        .tenpb(resultSet.getString(PhongBan.tenpbFieldName()))
                        .mota(resultSet.getString(PhongBan.motaFieldName()))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public List<PhongBan> searchPhongBan(String keyword) {
        List<PhongBan> phongBanList = new ArrayList<>();
        String sql = "SELECT * FROM phongban WHERE Tenpb LIKE ? OR MoTa LIKE ?";

        try (Connection connection = DbConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            // Gán giá trị cho các tham số trong câu truy vấn
            String searchKeyword = "%" + keyword + "%";
            statement.setString(1, searchKeyword);
            statement.setString(2, searchKeyword);

            // Thực thi câu truy vấn
            ResultSet resultSet = statement.executeQuery();

            // Xử lý kết quả trả về
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenpb = resultSet.getString("tenpb");
                String mota = resultSet.getString("mota");

                PhongBan phongBan = new PhongBan(id, tenpb, mota);
                phongBanList.add(phongBan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phongBanList;
    }

}
