/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.esig.bean;

import br.com.crud.esig.dao.CarroDAO;
import br.com.crud.esig.entity.Carro;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rorop
 */
@ManagedBean
@SessionScoped
public class managedBean {

    private Carro car;
    private List<Carro> listaC;
    private CarroDAO dao = new CarroDAO();
    
    public managedBean() {
    }
    

    public Carro getCar() {
        return car;
    }

    public void setCar(Carro car) {
        this.car = car;
    }

    public List<Carro> getListaC() {
        return listaC;
    }

    public void setListaC(List<Carro> lista) {
        this.listaC = lista;
    }
    
    @PostConstruct
    public void inicializarCarro(){
        dao = new CarroDAO();
        listaC = dao.buscar();
        limparCarro();
    }
    
    public void limparCarro(){
        car = new Carro();
    }
    
    public void salvarCarro(){
        dao = new CarroDAO();
        if (car.getId() == null){
        dao.salvar(car);
        } else {
            dao.editar(car);
        }
        inicializarCarro();
    }
    
    public void deletarCarro(Carro iten){
        dao = new CarroDAO();
        dao.deletar(iten.getId());
        
        inicializarCarro();
    }
    
    public void carregarCarro(Carro item){
        car = item;
    }
}
