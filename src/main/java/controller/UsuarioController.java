/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import entidades.Usuario;
import static telas.Menu.loja;
import util.Banco;
import util.Util;

/**
 *
 * @author deividnn
 */
public class UsuarioController {

   

    public Usuario acessar(String usuario, String senha) {
        Usuario u = null;
        Connection con = null;
        try {
            con = Banco.conectar();
            if (con != null) {
                String sql = "select * from usuario "
                        + " where (upper(usuario)=?"
                        + " and senha=?) "
                        + " or  (cast(id as text)=?"
                        + " and senha=?) "
                        // + " and loja=? "
                        + " limit 1 ";
                PreparedStatement st = con.prepareCall(sql);
                st.setString(1, usuario.toUpperCase());
                st.setString(2, Util.md5(senha));
                st.setString(3, usuario.toUpperCase());
                st.setString(4, Util.md5(senha));

                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    u = new Usuario();
                    u.setId(rs.getLong("id"));
                    u.setUsuario(rs.getString("usuario"));
                    u.setEmail(rs.getString("email"));
                    u.setUsuarioAltera(rs.getLong("usuario_altera"));
                    u.setNivel(rs.getString("nivel"));
                    u.setStatus(rs.getString("status"));
                    u.setDataAltera(rs.getTimestamp("data_altera"));
                    loja = rs.getLong("loja");
                    u.setLoja(loja);
                    return u;

                }
            }
            return u;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
            return u;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return u;
                }
            }
        }

    }

    public List<Usuario> pesquisar(String valor, String campo) {
        List<Usuario> l = new ArrayList<>();
        Connection con = null;
        try {
            con = Banco.conectar();
            if (con != null) {
                String sql = "select * from usuario "
                        + " where upper(cast(" + campo + " as text)) like '%" + valor.toUpperCase() + "%'"
                        + " and loja=" + loja + " "
                        + " order by " + campo + " desc ";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getLong("id"));
                    u.setUsuario(rs.getString("usuario"));
                    u.setEmail(rs.getString("email"));
                    u.setUsuarioAltera(rs.getLong("usuario_altera"));
                    u.setNivel(rs.getString("nivel"));
                    u.setStatus(rs.getString("status"));
                    u.setDataAltera(rs.getTimestamp("data_altera"));
                    u.setLoja(loja);
                    l.add(u);
                }
            }
            return l;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
            return new ArrayList<>();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return new ArrayList<>();
                }
            }
        }

    }

    public List<Usuario> lista() {
        List<Usuario> l = new ArrayList<>();
        Connection con = null;
        try {
            con = Banco.conectar();
            if (con != null) {
                String sql = "select * from usuario where loja=" + loja + " order by id desc";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getLong("id"));
                    u.setUsuario(rs.getString("usuario"));
                    u.setEmail(rs.getString("email"));
                    u.setUsuarioAltera(rs.getLong("usuario_altera"));
                    u.setNivel(rs.getString("nivel"));
                    u.setStatus(rs.getString("status"));
                    u.setDataAltera(rs.getTimestamp("data_altera"));
                    u.setLoja(loja);
                    l.add(u);
                }
            }
            return l;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
            return new ArrayList<>();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return new ArrayList<>();
                }
            }
        }

    }

    public boolean salvar(Usuario u) {

        Connection con = null;
        try {
            con = Banco.conectar();
            if (con != null) {
                String sql = "INSERT INTO public.usuario(\n"
                        + " usuario, senha, status, usuario_altera, data_altera, email, \n"
                        + " nivel,loja)\n"
                        + "    VALUES ( ?, ?, ?, ?, ?, ?, \n"
                        + "  ?,?);";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, u.getUsuario());
                st.setString(2, u.getSenha());
                st.setString(3, u.getStatus());
                st.setLong(4, u.getUsuarioAltera());
                st.setTimestamp(5, new Timestamp(Calendar.getInstance().getTimeInMillis()));
                st.setString(6, u.getEmail());
                st.setString(7, u.getNivel());
                st.setLong(8, loja);
                st.executeUpdate();
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return false;
                }
            }
        }

    }

    public boolean atualizar(Usuario u) {

        Connection con = null;
        try {
            con = Banco.conectar();
            if (con != null) {
                String sql = "UPDATE public.usuario\n"
                        + "   SET  usuario=?, status=?, usuario_altera=?, data_altera=?, \n"
                        + "       email=?, nivel=?\n"
                        + " WHERE id=?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, u.getUsuario());
                st.setString(2, u.getStatus());
                st.setLong(3, u.getUsuarioAltera());
                st.setTimestamp(4, new Timestamp(Calendar.getInstance().getTimeInMillis()));
                st.setString(5, u.getEmail());
                st.setString(6, u.getNivel());
                st.setLong(7, u.getId());
                st.executeUpdate();
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return false;
                }
            }
        }

    }
}
