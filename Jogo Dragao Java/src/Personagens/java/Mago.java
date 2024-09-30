/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personagens.java;

/**
 *
 * @author alunolab08
 */
public class Mago extends Personagem {
    public void soltarMagia() {
        if (getArma() != null) {
            getArma().usaArma();
        } else {
            System.out.println("Mago não tem magia para soltar");
        }
    }
}
