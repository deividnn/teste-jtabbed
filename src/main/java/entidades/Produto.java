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
public class Produto implements Serializable {

    private Long id;
    private String descricao;
    private BigDecimal valordia;
    private String status;
    private Long usuarioAltera;
    private Date dataAltera;
    private Date dataentrada;
    private Long loja;
    private String especificacoes;
    private String caracteristicas;
    private String contato;
    private String fornecedor;
    private Integer entrada;
    private Integer saida;

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

    public BigDecimal getValordia() {
        return valordia;
    }

    public void setValordia(BigDecimal valordia) {
        this.valordia = valordia;
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

    public Date getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(Date dataentrada) {
        this.dataentrada = dataentrada;
    }

    public Long getLoja() {
        return loja;
    }

    public void setLoja(Long loja) {
        this.loja = loja;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getEntrada() {
        return entrada;
    }

    public void setEntrada(Integer entrada) {
        this.entrada = entrada;
    }

    public Integer getSaida() {
        return saida;
    }

    public void setSaida(Integer saida) {
        this.saida = saida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", valordia=" + valordia + ", status=" + status + ", usuarioAltera=" + usuarioAltera + ", dataAltera=" + dataAltera + ", dataentrada=" + dataentrada + ", loja=" + loja + ", especificacoes=" + especificacoes + ", caracteristicas=" + caracteristicas + ", contato=" + contato + ", fornecedor=" + fornecedor + ", entrada=" + entrada + ", saida=" + saida + '}';
    }

  

}
