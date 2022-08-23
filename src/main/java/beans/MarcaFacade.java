/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package beans;

import entidades.Marca;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author paulo
 */
@RequestScoped
@Named
//@Stateless
public class MarcaFacade extends AbstractFacade<Marca>{
    @PersistenceContext(unitName = "pgPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


    public MarcaFacade() {
        super(Marca.class);
    }
}
