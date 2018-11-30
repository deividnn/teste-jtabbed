/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author deividnn
 */
public class Servico implements Serializable{

    private Long id;
    private String descricao;
    private BigDecimal preco;
    private String status;
    private Long usuarioAltera;
    private Date dataAltera;
    private Long loja;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUsuarioAltera() {
        return usuarioAltera;
    }

    public void setUsuarioAltera(Long usuarioAltera) {
        this.usuarioAltera = usuarioAltera;
    }

    public Date getDataAltera() {
        return dataAltera;
    }

    public void setDataAltera(Date dataAltera) {
        this.dataAltera = dataAltera;
    }

    public Long getLoja() {
        return loja;
    }

    public void setLoja(Long loja) {
        this.loja = loja;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servico{" + "id=" + id + ", descricao=" + descricao + ", preco=" + preco + ", status=" + status + ", usuarioAltera=" + usuarioAltera + ", dataAltera=" + dataAltera + ", loja=" + loja + '}';
    }

   
    
    
    

}
