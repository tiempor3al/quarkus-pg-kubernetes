package mx.tiempor3al.models;

import io.vertx.mutiny.sqlclient.Row;

import java.math.BigDecimal;

public record Pokemon(
    Long id,
    String name,
    Long typeId,
    String typeName,
    BigDecimal height,
    BigDecimal weight,
    Integer hp,
    Integer attack,
    Integer defense,
    Integer specialAttack,
    Integer specialDefense,
    Integer speed,
    String description
) {
    public static Pokemon fromRecord(Row row) {
        return new Pokemon(
            row.getLong("id"),
            row.getString("name"),
            row.getLong("type_id"),
            row.getString("type_name"),
            row.getBigDecimal("height"),
            row.getBigDecimal("weight"),
            row.getInteger("hp"),
            row.getInteger("attack"),
            row.getInteger("defense"),
            row.getInteger("special_attack"),
            row.getInteger("special_defense"),
            row.getInteger("speed"),
            row.getString("description")
        );
    }
}
