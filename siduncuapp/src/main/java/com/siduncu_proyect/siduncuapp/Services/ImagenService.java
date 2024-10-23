
package com.siduncu_proyect.siduncuapp.Services;

import com.siduncu_proyect.siduncuapp.Models.Imagen;
import com.siduncu_proyect.siduncuapp.Repositories.IImagenRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author siduncuNotebook
 */
public class ImagenService implements IImagenService {

    @Autowired
    IImagenRepository imagenRepository;
    
    @Override
    public List<Imagen> getImagen() {
        return imagenRepository.findAll();
    }

    @Override
    public Imagen saveImagen(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    @Override
    public void deleteImagen(Long id) {
        imagenRepository.deleteById(id);
    }

    @Override
    public Imagen findImagen(Long id) {
        return imagenRepository.findById(id).orElse(null);
    }

    @Override
    public void updateImagen(Imagen imagen) {
        imagenRepository.save(imagen);
    }
    
}
