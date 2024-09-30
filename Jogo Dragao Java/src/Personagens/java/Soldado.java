/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personagens.java;

/**
 *
 * @author alunolab08
 */
public class Soldado extends Personagem {
      public void atirar() {
        if (getArma() != null) {
            getArma().usaArma();
        } else {
            System.out.println("Soldado não tem arma para atirar");
        }
    }
}
