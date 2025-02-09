
package com.siduncu_proyect.siduncuapp.Services;

import com.siduncu_proyect.siduncuapp.Models.Noticia;
import com.siduncu_proyect.siduncuapp.Repositories.InoticiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author siduncuNotebook
 */

@Service
public class NoticiaService implements INoticiaService{

    @Autowired
    private InoticiaRepository noticiaRepo;
    
    @Override
    public List<Noticia> getNoticia() {
        return noticiaRepo.findAll();
    }

    @Override
    public Noticia saveNoticia(Noticia noticia) {
        System.out.println("Tamaño del contenido: " + noticia.getContenido().length());
        return noticiaRepo.save(noticia);

    }

    @Override
    public void deleteNoticia(Long id) {
        try {
            noticiaRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Noticia findNoticia(Long id) {
        
        return noticiaRepo.findById(id).orElse(null);

    }

    @Override
    public void updateNoticia(Noticia noticia) {
        
        noticiaRepo.save(noticia);
    }
    
    
}
