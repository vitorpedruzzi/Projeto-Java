/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personagens.java;

import Armas.java.Arma_IF;

/**
 *
 * @author alunolab08
 */
public class Personagem {
    
    private boolean podeVoar;
     private Arma_IF arma;

    public void desenhar() {
        System.out.println("Desenhando o personagem");
    }

    public void falar() {
        System.out.println("Personagem falando");
    }

    public void setArma(Arma_IF arma) {
        this.arma = arma;
    }

    public Arma_IF getArma() {
        return arma;
    }
    
    
    public boolean podeVoar() {
        return this.podeVoar;
    }
    
    
    
    
   
    
    
    
    
}
