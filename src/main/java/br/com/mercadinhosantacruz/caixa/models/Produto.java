/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mercadinhosantacruz.caixa.models;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;


public class Produto {

    public static void remover(int id, JdbcTemplate jdbc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private int id;
    private String nome;
    private int quantidade;
    private float preco;

    public Produto(String nome, int quantidade, float preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

          
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

  public void salvar(JdbcTemplate jdbc){
      jdbc.update ("INSERT INTO produtos (Nome, preco, quantidade)" +
                "VALUES (?, ?, ?)", (ps) -> {
                    ps.setString(1, nome);
                    ps.setFloat(2, preco);
                    ps.setInt(3, quantidade);
                }
      );
  }
  
  public static List<Produto> listar(JdbcTemplate
      jdbc){
      List<Produto> produtos =
              new ArrayList<>();
      jdbc.query("SELECT * FROM produtos;",
              (rs)->{
                  do{
                    Produto p = new Produto(
                     rs.getString("nome"), 
                     rs.getInt("quantidade"),
                     rs.getFloat("preco"));  
                  p.id = rs.getInt("id");
                  produtos.add(p);
                  } while(rs.next());
      });
      
      return produtos;
  }
  
  }
    
    
    


