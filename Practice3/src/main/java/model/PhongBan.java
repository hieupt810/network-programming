package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PhongBan {
    private int id;
    private String tenpb;
    private String mota;

    public static String idFieldName() {
        return "id";
    }

    public static String tenpbFieldName() {
        return "tenpb";
    }

    public static String motaFieldName() {
        return "mota";
    }
}
