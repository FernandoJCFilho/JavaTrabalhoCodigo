/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfaceSwing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Banco {

    private static String status = "Nao conectou";

    public static String SERVIDOR = "jdbc:mysql://localhost:3306/cadastro";
    public static String USUARIO = "root";
    public static String SENHA = "12345";
    public static Connection obterConexaoMySQL(){
        Connection conexao = null;
        
        try {
            
            conexao = DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);
            
            if (conexao != null){
                status = "Conectado";
            }
            
            return conexao;
        } catch (SQLException e) {
            System.out.println("Driver nao encontrado!");
            return null;
        }
    };
    
    public static String retornaStatusConecxao(){
        return status;
    }

    
    public static boolean fecharConexao(){
        try {
            Banco.obterConexaoMySQL().close();
            
            return true;
        } catch (SQLException e) {
            
            return false;
        }
    }
    
    
}
