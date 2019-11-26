/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

/**
 *
 * @author Aluno
 */
public class UsuarioDAO {

    private final Conexão con = new Conexão();
    private final String INSERTUSUARIO = "INSERT INTO USUARIO (NOME, EMAIL, USUARIO, SENHA ) VALUES (?,?,?,?,?)";
    private final String LOGIN = "SELECT USUARIO FROM USUARIO  WHERE USUARIO =  ? and  SENHA =  ?";

    public boolean insertUsuario(Usuario u) {
        try {
            // CONECTA
            con.conecta();

            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTUSUARIO);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setString(1, u.getNome().toUpperCase());
            preparaInstrucao.setString(2, u.getEmail().toUpperCase());
            preparaInstrucao.setString(4, u.getLogin().toUpperCase());
            preparaInstrucao.setInt(5, u.getSenha());

            // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();

            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException e) {
            return false;

        }
    }

 public boolean login(Usuario u) {
        boolean resultado = false;
        try {
            // CONECTA
            con.conecta();

            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LOGIN);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setString(1, u.getLogin().toUpperCase());
            preparaInstrucao.setInt(2, u.getSenha());

            // EXECUTA A INSTRUCAO
            ResultSet rs = preparaInstrucao.executeQuery();

            resultado = rs.next();

            // DESCONECTA
            con.desconecta();
        } catch (SQLException e) {
            System.out.println("erro " + e);

        }
        return resultado;
    }

}
