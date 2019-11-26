/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Conta;

/**
 *
 * @author Aluno
 */
public class ContasDAO {
    private final Conexão con = new Conexão();
    private final String INSERTCONTAS = "INSERT INTO CONTAS (ID, CONCESSIONARIA, DESCRICAO, DATA_VENCIMENTO) VALUES (?,?,?,?)";

    public boolean insertUsuario(Conta a) {
        try {
            // CONECTA
            con.conecta();

            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTCONTAS);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setInt(1, a.getId());
            preparaInstrucao.setString(2, a.getConcessionaria());
            preparaInstrucao.setString(3, a.getDescricao());
            preparaInstrucao.setDate(4, a.getDataVencimento());

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

}
