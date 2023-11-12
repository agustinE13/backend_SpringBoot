package com.crud.recetas.recetas.service;

import com.crud.recetas.recetas.models.recipes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.crud.recetas.recetas.repository.recipesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class recipesService {
    private final recipesRepository recipesR;

    public void save (recipes recipe){
        recipesR.save(recipe);
    }

    public boolean existsById(String id) {
        return recipesR.existsById(id);
    }

    public recipes findById(String id) {
        return recipesR.findById(id).orElse(null);
    }
    public List<recipes> findAll(){
        return recipesR.findAll();
    }
    public  List<recipes> getRecetaByNivelDificultad(String dificultad){
        return recipesR.getRecetaByNivelDificultad(dificultad);
    }

    public void deleteById(String id){
        recipesR.deleteById(id);
    }
}
