package beans;

import static controles.util.JsfUtil.addErrorMessage;
import static controles.util.JsfUtil.addSuccessMessage;
import entidades.Marca;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import static java.util.EnumSet.range;
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
        
        try {
            itens = dao.findAll();
            addSuccessMessage("Itens:"+getTamanhoDaLista()+" listadoss" );
        } catch (Exception e) {
            addErrorMessage("Erro ao listar dados");
        }
        
        
    }
    
    @Transactional
    public void create() {
        try {
            if(this.selected.getId() != null){
                dao.edit(selected);
                addSuccessMessage("Item Atualizado");
            }else{
                dao.create(selected);
                addSuccessMessage("Item Criado");
            }

        } catch (Exception e) {
            addErrorMessage("Erro ao Remover item");
            addErrorMessage("Erro ao criar/atualizar o item");
        }
    }
    public Marca prepareCreate() {
        selected = new Marca();
        System.out.println("prepareCreate....");
        return selected;
    }
    
    @Transactional
    public void delete() {   
        try {
            dao.remove(selected);
            addSuccessMessage("Iten Removido com Sucesso");
        } catch (Exception e) {
            addErrorMessage("Erro ao Remover item");
        }
    }
    
    
    
    @Transactional
    public void update() {
        try {
            dao.edit(selected);
            addSuccessMessage("Iten Atualizados");
        } catch (Exception e) {
            addErrorMessage("Erro ao Remover item");
        }
        
       
    }
    
    public Integer getTamanhoDaLista() {
        return itens.size();
    }

    public void setTamanhoDaLista(Integer size) {
        // Método criado para ser utilizado pelo primefaces
    }

}
