package javaapplication1;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {

    public void salvarproduto(Produto p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO db_produto.produtos (id, nome, quantidade, valorUnitario)VALUES(?, ?, ?, ?)");
            stmt.setInt(1, p.getIdp());
            stmt.setString(2, p.getNome());
            stmt.setInt(3, p.getQuantidade());
            stmt.setDouble(4, p.getValorUnitario());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con);
        }

    }

    public void excluirproduto(Produto p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM db_produto.produtos WHERE id = ?");
            stmt.setInt(1, p.getIdp());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "O Produto foi excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con);
        }

    }

    public List<Produto> lerproduto() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM db_produto.produtos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdp(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setValorUnitario(rs.getDouble("valorUnitario"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con);
        }
        return produtos;
    }

    public List<Produto> buscarporid(int newsearch) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM db_produto.produtos WHERE id = ?");
            stmt.setInt(1, newsearch);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdp(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setValorUnitario(rs.getDouble("valorUnitario"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con);
        }
        return produtos;
    }

}
