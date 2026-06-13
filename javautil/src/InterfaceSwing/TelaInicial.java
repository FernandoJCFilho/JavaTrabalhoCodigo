/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfaceSwing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author LAB04-06
 */
public class TelaInicial {
    
    public static void montarTelaInicial() throws IOException{
    
        final JFrame oJFrameInicial = new JFrame("Tela Inicial") ;
        
        oJFrameInicial.setBounds(200, 170, 500, 200);
        oJFrameInicial.setLayout(null);
        
        JButton oJButtonTela1 = new JButton("Tela 1");
        oJButtonTela1.setBounds(60,60,100,30);
        oJFrameInicial.add(oJButtonTela1);
        
        JButton oJButtonTela2 = new JButton("Tela 2");
        oJButtonTela2.setBounds(200,60,100,30);
        oJFrameInicial.add(oJButtonTela2);
        
        JButton oJButtonTela3 = new JButton("Tela 3");
        oJButtonTela3.setBounds(340,60,100,30);
        oJFrameInicial.add(oJButtonTela3);
        
        oJButtonTela1.addMouseListener(new MouseAdapter(){
           
        @Override
        public void mouseClicked(MouseEvent e){
            try {
                oJFrameInicial.dispose();
                Tela.montarTela();
            } catch (IOException ex) {
                System.getLogger(TelaInicial.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        });
        
        oJFrameInicial.setVisible(true);
    }

}
