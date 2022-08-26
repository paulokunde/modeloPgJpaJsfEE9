package beans;

//import br.com.feltex.academicnet.repositorio.AlunoRepositorio;
import entidades.Marca;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
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
    private List<Marca> itens = new ArrayList<>();

    @Getter
    @Setter
    private Marca selected;

    @Inject
    private MarcaFacade dao;

    @PostConstruct
    public void listarTodos() {
        itens = dao.findAll();
        System.out.println("Postconstruct Invocado, Lista:" + getTamanhoDaLista());
    }
    
    @Transactional
    public void create() {
        try {
            if(this.selected.getId() != null){
                dao.edit(selected);
                System.out.println("Atualizando....OK");
            }else{
                dao.create(selected);
                System.out.println("salvando....OK");
            }

        } catch (Exception e) {
            System.out.println("Erro ao Salvar....");
            e.printStackTrace();
            //return "Erro ao Salvar";
        }
    }
    public Marca prepareCreate() {
        selected = new Marca();
        System.out.println("prepareCreate....");
        return selected;
    }
    @Transactional
    public void update() {
        dao.edit(selected);
       
    }

    public Integer getTamanhoDaLista() {
        return itens.size();
    }

    public void setTamanhoDaLista(Integer size) {
        // Método criado para ser utilizado pelo primefaces
    }

}
