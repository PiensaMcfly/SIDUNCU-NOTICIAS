
package com.siduncu_proyect.siduncuapp.Services;

import com.siduncu_proyect.siduncuapp.Models.Categoria;
import com.siduncu_proyect.siduncuapp.Repositories.ICategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author siduncuNotebook
 */
@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private ICategoriaRepository categoriaRepo;
    
    
    @Override
    public List<Categoria> getCategoria() {
        return categoriaRepo.findAll();
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepo.save(categoria);
        
    }

    @Override
    public void deleteCategoria(Long id) {
        categoriaRepo.deleteById(id);
    }

    @Override
    public Categoria findCategoria(Long id) {
        return categoriaRepo.findById(id).orElse(null);
    }

    @Override
    public void updateCategoria(Categoria categoria) {
        categoriaRepo.save(categoria);
    }
    
    
}
