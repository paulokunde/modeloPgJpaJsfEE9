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
public class MarcaMB implements Serializable {

    @Getter
    @Setter
    private List<Marca> marcas = new ArrayList<>();

    @Getter
    @Setter
    private Marca marca;

    @Inject
    private MarcaFacade marcaFacade;

    @PostConstruct
    public void listarTodos() {
        marcas = marcaFacade.findAll();
        System.out.println("Postconstruct Invocado, Lista:" + getTamanhoDaLista());
    }

    public void salvar() {
        try {

            marcaFacade.create(marca);
            System.out.println("salvando....OK");
            //return "Item Salvo";

        } catch (Exception e) {
            System.out.println("Erro ao Salvar....");
            //return "Erro ao Salvar";
        }
    }

    public void update() {
        marcaFacade.edit(marca);
        System.out.println("Update de Marca....");
    }

    public Integer getTamanhoDaLista() {
        return marcas.size();
    }

    public void setTamanhoDaLista(Integer size) {
        // Método criado para ser utilizado pelo primefaces
    }

}
