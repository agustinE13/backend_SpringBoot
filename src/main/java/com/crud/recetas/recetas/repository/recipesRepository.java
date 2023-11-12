package com.crud.recetas.recetas.repository;

import com.crud.recetas.recetas.models.recipes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface recipesRepository extends MongoRepository<recipes,String> {
    @Query("{'$or':[ {'title': { $regex: ?0, $options: 'i' }}, {'ingredients': {$elemMatch: {$eq: ?0}}},{'difficulty_level': ?0} ]}")
    List<recipes> getRecetaByNivelDificultad(String item);

    Optional<recipes> findTopByOrderByIdDesc();
}
