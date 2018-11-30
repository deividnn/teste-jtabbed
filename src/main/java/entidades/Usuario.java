/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author deividnn
 */
public class Usuario implements Serializable{

    private Long id;
    private String usuario;
    private String senha;
    private String status;
    private Long usuarioAltera;
    private Date dataAltera;
    private String email;
    private String nivel;
    private Long loja;

    public Long getLoja() {
        return loja;
    }

    public void setLoja(Long loja) {
        this.loja = loja;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", senha=" + senha + ", status=" + status + ", usuarioAltera=" + usuarioAltera + ", dataAltera=" + dataAltera + ", email=" + email + ", nivel=" + nivel + '}';
    }
    
    

}
