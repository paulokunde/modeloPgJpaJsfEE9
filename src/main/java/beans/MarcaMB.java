package beans;

//import br.com.feltex.academicnet.repositorio.AlunoRepositorio;
import entidades.Marca;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Named(value = "marcaMB")
@ViewScoped
public class MarcaMB implements Serializable{

    @Getter
    @Setter
    private List<Marca> marcas = new ArrayList<>();

    @Getter
    @Setter
    private Marca marca;

    @Inject
    //@EJB
    private MarcaFacade marcaFacade;
    
    @PostConstruct
    public void listarTodos(){
        EntityManager em = marcaFacade.getEntityManager();
        marcas = marcaFacade.findAll();
        System.out.println("Postconstruct Invocado, Lista:"+getTamanhoDaLista());
       
    }
            
    public Integer getTamanhoDaLista() {
        return marcas.size();
    }

    public void setTamanhoDaLista(Integer size) {
        // Método criado para ser utilizado pelo primefaces
    }
    
    
}
