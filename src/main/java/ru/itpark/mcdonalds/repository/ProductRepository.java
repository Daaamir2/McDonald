package ru.itpark.mcdonalds.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.mcdonalds.entity.ProductEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final NamedParameterJdbcTemplate template;

    public ProductRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<ProductEntity> getAll() {
        return template.query("SELECT id, name, price, description, img FROM products",
                (rs, i) -> {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    String description = rs.getString("description");
                    String img = rs.getString("img");
                    return new ProductEntity(id, name, price, description, img);
                }
        );
    }

    public Optional<ProductEntity> getById(int id) {
        return template.query("SELECT id, name, price, description, img FROM products WHERE id = :id LIMIT 1",
                Map.of("id", id),
                (rs, i) -> new ProductEntity(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getString("img")
                )
        ).stream().findFirst();
    }

    public Optional<ProductEntity> getByName(String name){
        return template.query("SELECT id, name, price, description, img FROM products WHERE name = :name",
                Map.of("name", name),
                (rs, i) -> new ProductEntity(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getString("img")
                )
        ).stream().findAny();
    }

}
