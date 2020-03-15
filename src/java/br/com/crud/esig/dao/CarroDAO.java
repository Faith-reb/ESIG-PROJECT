/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.esig.dao;
import br.com.crud.esig.entity.Carro;
import br.com.crud.esig.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author rorop
 */
public class CarroDAO {
    private Session sessao;
    private Transaction trans;
    
    public void salvar(Carro car){
        
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            sessao.persist(car);
            
            sessao.getTransaction().commit();
            sessao.close();
    }
    
    public void editar(Carro car){
           
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            sessao.merge(car);
            sessao.getTransaction().commit();
        
            sessao.close();
        
    }
    
    public void deletar(Integer id){
             
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            sessao.delete(sessao.get(Carro.class, id));
            sessao.getTransaction().commit();
            sessao.close();
        
    }
    public  List<Carro> buscar(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        List<Carro> lista = sessao.getNamedQuery("Carro.findAll").list();
        sessao.close();
        return lista;
    }
    
    public Carro pesquisarPorId (Long id){
        sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        Carro car = (Carro) sessao.get(Carro.class, id);

        sessao.getTransaction().commit();
        sessao.close();

        return car;
    }
}
