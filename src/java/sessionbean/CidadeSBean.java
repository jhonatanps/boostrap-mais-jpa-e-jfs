/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entidades.Cidade;

/**
 *
 * @author Cirim
 */
@Stateless
public class CidadeSBean {

    @PersistenceContext(unitName = "Sige-bootstrapPU")
    EntityManager em;
    
    public void salvar(Cidade cidade){
       em.merge(cidade); 
    }
    
    public void excluir(Cidade cidade){
        em.remove(em.find(Cidade.class,cidade.getId()));
    }
    
    public Cidade pesquisar(Long id){
        return em.find(Cidade.class, id);
    }
    
    public List<Cidade> pesquisar(String nome){
      List<Cidade> listaCidade;
      Query consulta = em.createNamedQuery("Cidade.findByNome");
      consulta.setParameter("nomeCidade", nome + "%");
      listaCidade = consulta.getResultList();
      return listaCidade;
    }
    

}
