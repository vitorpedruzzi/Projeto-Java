/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personagens.java;

import Armas.java.Fogo;
import Armas.java.Arma_IF;
import javax.swing.JOptionPane;

/**
 *
 * @author alunolab08
 */
public class DragaoAlado extends Personagem {

    public void soltarFogo() {
        JOptionPane.showMessageDialog(null, "Dragão alado soltando fogo!");
    }

    public void usarHabilidadeDeVoo() {
        JOptionPane.showMessageDialog(null, "Dragão alado fugiu da batalha voando!");
    }

    public void usarFogo() {
        Arma_IF fogo = new Fogo();
        setArma(fogo);
        JOptionPane.showMessageDialog(null, "Dragão alado equipou a arma de fogo!");
    }

    public boolean podeVoar() {
        // Implemente a lógica para determinar se o dragão alado pode voar
        return true; // ou qualquer lógica de verificação que defina se o dragão pode voar ou não
    }
    
    @Override
    public void falar() {
        
    }
    
}
