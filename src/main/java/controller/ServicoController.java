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
import entidades.Servico;
import static telas.Menu.loja;
import util.Banco;

/**
 *
 * @author deividnn
 */
public class ServicoController {

    public List<Servico> pesquisar(String valor, String campo) {
        List<Servico> l = new ArrayList<>();
        Connection con = null;
        try {
            con = Banco.conectar();
            if (con != null) {
                String sql = "select * from servico "
                        + " where upper(cast(" + campo + " as text)) like '%" + valor.toUpperCase() + "%'"
                        + " and loja=" + loja + " "
                        + " order by " + campo + " desc ";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Servico u = new Servico();
                    u.setId(rs.getLong("id"));
                    u.setDescricao(rs.getString("descricao"));
                    u.setPreco(rs.getBigDecimal("preco"));
                    u.setUsuarioAltera(rs.getLong("usuario_altera"));
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

    public List<Servico> lista() {
        List<Servico> l = new ArrayList<>();
        Connection con = null;
        try {
            con = Banco.conectar();
            if (con != null) {
                String sql = "select * from servico where loja=" + loja + " order by id desc";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Servico u = new Servico();
                    u.setId(rs.getLong("id"));
                    u.setDescricao(rs.getString("descricao"));
                    u.setPreco(rs.getBigDecimal("preco"));
                    u.setUsuarioAltera(rs.getLong("usuario_altera"));
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

    public boolean salvar(Servico u) {

        Connection con = null;
        try {
            con = Banco.conectar();
            if (con != null) {
                String sql = "INSERT INTO public.servico(\n"
                        + " descricao, preco, status, usuario_altera, data_altera,loja)\n"
                        + "    VALUES ( ?, ?, ?, ?, ?, ?);";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, u.getDescricao());
                st.setBigDecimal(2, u.getPreco());
                st.setString(3, u.getStatus());
                st.setLong(4, u.getUsuarioAltera());
                st.setTimestamp(5, new Timestamp(Calendar.getInstance().getTimeInMillis()));
                st.setLong(6, loja);
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

    public boolean atualizar(Servico u) {

        Connection con = null;
        try {
            con = Banco.conectar();
            if (con != null) {
                String sql = "UPDATE public.servico\n"
                        + "   SET  descricao=?, status=?, usuario_altera=?, data_altera=?, \n"
                        + "       preco=?\n"
                        + " WHERE id=?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, u.getDescricao());
                st.setString(2, u.getStatus());
                st.setLong(3, u.getUsuarioAltera());
                st.setTimestamp(4, new Timestamp(Calendar.getInstance().getTimeInMillis()));
                st.setBigDecimal(5, u.getPreco());
                st.setLong(6, u.getId());
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
