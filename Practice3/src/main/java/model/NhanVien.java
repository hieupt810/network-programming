package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NhanVien {
    private int id;
    private String hoten;
    private int idphongban;
    private String diachi;

    public static String idFieldName() {
        return "id";
    }

    public static String hotenFieldName() {
        return "hoten";
    }

    public static String idphongbanFieldName() {
        return "idpb";
    }

    public static String diachiFieldName() {
        return "diachi";
    }
}
