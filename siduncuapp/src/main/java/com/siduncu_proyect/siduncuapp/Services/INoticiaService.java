
package com.siduncu_proyect.siduncuapp.Services;
import com.siduncu_proyect.siduncuapp.Models.Noticia;
import java.util.List;

/**
 *
 * @author siduncuNotebook
 */

public interface INoticiaService {
    public List<Noticia> getNoticia();
    
    public Noticia saveNoticia(Noticia noticia);
    
    public void deleteNoticia(Long id);
    
    public Noticia findNoticia(Long id);
    
    public void updateNoticia(Noticia noticia);
}
