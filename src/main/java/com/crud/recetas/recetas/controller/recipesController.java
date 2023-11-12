package com.crud.recetas.recetas.controller;

import com.crud.recetas.recetas.models.recipes;
import com.crud.recetas.recetas.repository.recipesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="http://127.0.0.1:4200")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class recipesController {
    private final recipesRepository recipesR;


    @PostMapping("/newRecipe")
    public ResponseEntity<?> save(@RequestBody recipes recipe) {
        // Obtener el último ID ingresado
        String lastId = recipesR.findTopByOrderByIdDesc().map(recipes::getId).orElse("0");
        // Incrementar el ID en uno
        String nextId = String.valueOf(Integer.parseInt(lastId) + 1);
        // Establecer el nuevo ID en la receta
        recipe.setId(nextId);
        // Guardar la nueva receta
        recipesR.save(recipe);
        return null;
    }
    @GetMapping("/allRecipes")
    public List<recipes> findAll(){
        return recipesR.findAll();
    }
    @GetMapping("/search/{item}")
    public List<recipes> getRecetaByDificultad(@PathVariable String item){
        return recipesR.getRecetaByNivelDificultad(item);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        recipesR.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody recipes updatedRecipe) {
        if (!recipesR.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedRecipe.setId(id);
        recipesR.save(updatedRecipe);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
