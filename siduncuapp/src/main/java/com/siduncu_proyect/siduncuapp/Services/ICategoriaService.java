package com.siduncu_proyect.siduncuapp.Services;
import com.siduncu_proyect.siduncuapp.Models.Categoria;
import java.util.List;

/**
 * @author siduncuNotebook
 */
public interface ICategoriaService {
 
    public List<Categoria> getCategoria();
    
    public Categoria saveCategoria(Categoria categoria);
    
    public void deleteCategoria(Long id);
    
    public Categoria findCategoria(Long id);
    
    public void updateCategoria(Categoria categoria);
}
