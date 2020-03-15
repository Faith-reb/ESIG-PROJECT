/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.esig.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rorop
 */
@Entity
@Table(name = "carro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carro.findAll", query = "SELECT c FROM Carro c")
    , @NamedQuery(name = "Carro.findById", query = "SELECT c FROM Carro c WHERE c.id = :id")
    , @NamedQuery(name = "Carro.findByModelo", query = "SELECT c FROM Carro c WHERE c.modelo = :modelo")
    , @NamedQuery(name = "Carro.findByFabricante", query = "SELECT c FROM Carro c WHERE c.fabricante = :fabricante")
    , @NamedQuery(name = "Carro.findByCor", query = "SELECT c FROM Carro c WHERE c.cor = :cor")
    , @NamedQuery(name = "Carro.findByAno", query = "SELECT c FROM Carro c WHERE c.ano = :ano")})
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "fabricante")
    private String fabricante;
    @Basic(optional = false)
    @Column(name = "cor")
    private String cor;
    @Basic(optional = false)
    @Column(name = "ano")
    private String ano;

    public Carro() {
    }

    public Carro(Integer id) {
        this.id = id;
    }

    public Carro(Integer id, String modelo, String fabricante, String cor, String ano) {
        this.id = id;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.cor = cor;
        this.ano = ano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crud.esig.entity.Carro[ id=" + id + " ]";
    }
    
}
