package com.crud.recetas.recetas.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "receta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class recipes {
    @Id
    private String id;
    private String title;
    private String ingredients[];
    private Integer time;
    private String difficulty_level;
    private String images;
    private String video;
}