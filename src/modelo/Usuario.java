/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Aluno
 */
public class Usuario {

    private int idUsuario, senha;
    private String nome, email, login;

    public Usuario(String nome, String email, String login, int senha) {
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.login = login;
    }

    public Usuario(int idUsuario, int senha, String nome, String email, String login) {
        this.idUsuario = idUsuario;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.login = login;
    }

    public Usuario(String login, int senha) {
        this.senha = senha;
        this.login = login;
    }
    
    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario() {

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return nome;
    }

}

