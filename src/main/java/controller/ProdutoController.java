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
import entidades.Produto;
import static telas.Menu.loja;
import util.Banco;

/**
 *
 * @author deividnn
 */
public class ProdutoController {

    public List<Produto> pesquisar(String valor, String campo) {
        List<Produto> l = new ArrayList<>();
        Connection con = null;
        try {
            con = Banco.conectar();
            if (con != null) {
                String sql = "select * from produto "
                        + " where upper(cast(" + campo + " as text)) like '%" + valor.toUpperCase() + "%'"
                        + " and loja=" + loja + " "
                        + " order by " + campo + " desc ";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Produto u = new Produto();
                    u.setId(rs.getLong("id"));
                    u.setDescricao(rs.getString("descricao"));
                    u.setValordia(rs.getBigDecimal("valor_dia"));
                    u.setUsuarioAltera(rs.getLong("usuario_altera"));
                    u.setStatus(rs.getString("status"));
                    u.setDataAltera(rs.getTimestamp("data_altera"));
                    u.setLoja(loja);
                    u.setFornecedor(rs.getString("fornecedor"));
                    u.setContato(rs.getString("contato"));
                    u.setEspecificacoes(rs.getString("especificacoes"));
                    u.setCaracteristicas(rs.getString("caracteristicas"));
                    u.setDataentrada(rs.getTimestamp("data_entrada"));
                    u.setEntrada(rs.getInt("entrada"));
                    u.setSaida(rs.getInt("saida"));
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

    public List<Produto> lista() {
        List<Produto> l = new ArrayList<>();
        Connection con = null;
        try {
            con = Banco.conectar();
            if (con != null) {
                String sql = "select * from produto where loja=" + loja + " order by id desc";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Produto u = new Produto();
                    u.setId(rs.getLong("id"));
                    u.setDescricao(rs.getString("descricao"));
                    u.setValordia(rs.getBigDecimal("valor_dia"));
                    u.setUsuarioAltera(rs.getLong("usuario_altera"));
                    u.setStatus(rs.getString("status"));
                    u.setDataAltera(rs.getTimestamp("data_altera"));
                    u.setLoja(loja);
                    u.setFornecedor(rs.getString("fornecedor"));
                    u.setContato(rs.getString("contato"));
                    u.setEspecificacoes(rs.getString("especificacoes"));
                    u.setCaracteristicas(rs.getString("caracteristicas"));
                    u.setDataentrada(rs.getTimestamp("data_entrada"));
                    u.setEntrada(rs.getInt("entrada"));
                    u.setSaida(rs.getInt("saida"));
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

    public boolean salvar(Produto u) {

        Connection con = null;
        try {
            con = Banco.conectar();
            if (con != null) {
                String sql = "INSERT INTO public.produto(\n"
                        + " descricao, valor_dia, status, usuario_altera, data_altera,loja,entrada,saida,"
                        + "contato,fornecedor,data_entrada,caracteristicas,especificacoes)\n"
                        + "    VALUES ( ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?);";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, u.getDescricao());
                st.setBigDecimal(2, u.getValordia());
                st.setString(3, u.getStatus());
                st.setLong(4, u.getUsuarioAltera());
                st.setTimestamp(5, new Timestamp(Calendar.getInstance().getTimeInMillis()));
                st.setLong(6, loja);
                st.setInt(7, u.getEntrada());
                st.setInt(8, u.getSaida());
                st.setString(9, u.getContato());
                st.setString(10, u.getFornecedor());
                st.setTimestamp(11, new Timestamp(u.getDataentrada().getTime()));
                st.setString(12, u.getCaracteristicas());
                st.setString(13, u.getEspecificacoes());
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

    public boolean atualizar(Produto u) {

        Connection con = null;
        try {
            con = Banco.conectar();
            if (con != null) {
                String sql = "UPDATE public.produto\n"
                        + "   SET  descricao=?, status=?, usuario_altera=?, data_altera=?, \n"
                        + "       valor_dia=?,entrada=?,saida=?,"
                        + "contato=?,fornecedor=?,data_entrada=?,caracteristicas=?,especificacoes=?\n"
                        + " WHERE id=?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, u.getDescricao());
                st.setString(2, u.getStatus());
                st.setLong(3, u.getUsuarioAltera());
                st.setTimestamp(4, new Timestamp(Calendar.getInstance().getTimeInMillis()));
                st.setBigDecimal(5, u.getValordia());                              
                st.setInt(6, u.getEntrada());
                st.setInt(7, u.getSaida());
                st.setString(8, u.getContato());
                st.setString(9, u.getFornecedor());
                st.setTimestamp(10, new Timestamp(u.getDataentrada().getTime()));
                st.setString(11, u.getCaracteristicas());
                st.setString(12, u.getEspecificacoes());
                st.setLong(13, u.getId());  
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
