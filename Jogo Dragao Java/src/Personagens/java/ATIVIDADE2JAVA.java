/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


// Vitor Pedruzzi, Kauan Modolo, João Pedro Becker

package Personagens.java;

import Armas.java.Fuzil;
import Armas.java.Faca;
import Armas.java.Revolver;
import Armas.java.Magia;
import Armas.java.Desarmado;
import Armas.java.Arma_IF;
import Armas.java.Fogo;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class ATIVIDADE2JAVA {


    public static void main(String[] args) {
    
        Soldado soldado = new Soldado();
        General general = new General();
        LutSumo lutSumo = new LutSumo();
        Mago mago = new Mago();
        DragaoAlado dragao = new DragaoAlado();

        soldado.setArma(new Revolver());
        general.setArma(new Fuzil());
        lutSumo.setArma(new Desarmado());
        mago.setArma(new Magia());
 

        JOptionPane.showMessageDialog(null, "Escolha 2 personagens para a batalha:");

        Personagem personagem1 = selecionarPersonagem(soldado, general, lutSumo, mago, dragao);
        Personagem personagem2 = selecionarPersonagem(soldado, general, lutSumo, mago, dragao);

        boolean continuarAcoes = true;

        while (continuarAcoes) {
            String escolhaAcaoString = JOptionPane.showInputDialog(
                "Escolha uma ação:\n"
                + "[1] - Ver informações\n"
                + "[2] - Trocar arma\n"
                + "[3] - Fugir\n"
                + "[0] - Sair"
            );

            if (escolhaAcaoString == null || escolhaAcaoString.equals("0")) {
                continuarAcoes = false;
            } else if (escolhaAcaoString.equals("1")) {
                exibirInformacoes(personagem1, personagem2);
            } else if (escolhaAcaoString.equals("2")) {
                trocarArma(personagem1);
                trocarArma(personagem2);
            } else if (escolhaAcaoString.equals("3")) {
                menuFugir(personagem1);
                menuFugir(personagem2);
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        }
    }

    private static Personagem selecionarPersonagem(
        Soldado soldado, General general, LutSumo lutSumo, Mago mago, DragaoAlado dragao
    ) {
        String escolhaPersonagemString = JOptionPane.showInputDialog(
            "Escolha um personagem para a batalha:\n"
            + "[1] - Soldado\n"
            + "[2] - General\n"
            + "[3] - Lutador de Sumô\n"
            + "[4] - Mago\n"
            + "[5] - Dragão Alado"
        );

        int escolhaPersonagem = Integer.parseInt(escolhaPersonagemString);

        if (escolhaPersonagem == 1) {
            return soldado;
        } else if (escolhaPersonagem == 2) {
            return general;
        } else if (escolhaPersonagem == 3) {
            return lutSumo;
        } else if (escolhaPersonagem == 4) {
            return mago;
        } else if (escolhaPersonagem == 5) {
            return dragao;
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida. Escolha novamente.");
            return selecionarPersonagem(soldado, general, lutSumo, mago, dragao);
        }
    }

    private static void trocarArma(Personagem personagem) {
        Arma_IF novaArma = selecionarArma(personagem);

        if (novaArma != null) {
            Arma_IF armaAntiga = personagem.getArma();
            personagem.setArma(novaArma);

            if (novaArma instanceof Fogo) {
                JOptionPane.showMessageDialog(
                    null,
                    personagem.getClass().getSimpleName() + " atacou com  "
                    + novaArma.getClass().getSimpleName() + " o oponente."
                );
            } else if (novaArma instanceof Faca) {
                JOptionPane.showMessageDialog(
                    null,
                    personagem.getClass().getSimpleName() + " atacou com uma faca."
                );
            } else if (novaArma instanceof Desarmado) {
                JOptionPane.showMessageDialog(
                    null,
                    personagem.getClass().getSimpleName() + " está desarmado."
                );
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    personagem.getClass().getSimpleName()
                    + " atirou no oponente com um "
                    + novaArma.getClass().getSimpleName()
                    + "."
                );
            }
        }
    }

    private static Arma_IF selecionarArma(Personagem personagem) {
        String escolhaArmaString = JOptionPane.showInputDialog(
            "Escolha uma nova arma para " + personagem.getClass().getSimpleName() + ":\n"
            + "[1] - Revolver\n"
            + "[2] - Fuzil\n"
            + "[3] - Faca\n"
            + "[4] - Magia\n"
            + "[5] - Fogo"
        );

        int escolhaArma = Integer.parseInt(escolhaArmaString);

        if (escolhaArma == 1) {
            return new Revolver();
        } else if (escolhaArma == 2) {
            return new Fuzil();
        } else if (escolhaArma == 3) {
            return new Faca();
        } else if (escolhaArma == 4) {
            if (personagem instanceof Mago) {
                return new Magia();
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Somente Mago pode usar Magia."
                );
                return null;
            }
        } else if (escolhaArma == 5) {
            if (personagem instanceof Mago || personagem instanceof DragaoAlado) {
                return new Fogo();
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Somente Mago e Dragão Alado podem soltar fogo."
                );
                return null;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida. Escolha novamente.");
            return selecionarArma(personagem);
        }
    }

    private static void exibirInformacoes(Personagem personagem1, Personagem personagem2) {
        JOptionPane.showMessageDialog(
            null,
            "Personagem 1: " + personagem1.getClass().getSimpleName()
            + "\nArma: " + personagem1.getArma().getClass().getSimpleName()
            + "\n\nPersonagem 2: " + personagem2.getClass().getSimpleName()
            + "\nArma: " + personagem2.getArma().getClass().getSimpleName()
        );
    }

private static void menuFugir(Personagem personagem) {
    String nomePersonagem = personagem.getClass().getSimpleName();

    String escolhaFugirString = JOptionPane.showInputDialog(
        null,
        "Escolha uma opção para " + nomePersonagem + " fugir:\n"
        + "[1] - Correr\n"
        + "[2] - Voar\n"
        + "[3] - Voltar"
    );

    if (escolhaFugirString != null) {
        int escolhaFugir = Integer.parseInt(escolhaFugirString);

        switch (escolhaFugir) {
            case 1:
                if (personagem instanceof DragaoAlado) {
                    JOptionPane.showMessageDialog(
                        null,
                        nomePersonagem + " não pode correr."
                    );
                } else {
                    JOptionPane.showMessageDialog(
                        null,
                        nomePersonagem + " correu para fugir do combate."
                    );
                }
                break;
            case 2:
                if (personagem instanceof DragaoAlado) {
                    if (((DragaoAlado) personagem).podeVoar()) {
                        ((DragaoAlado) personagem).usarHabilidadeDeVoo();
                    } else {
                        JOptionPane.showMessageDialog(
                            null,
                            nomePersonagem + " não pode voar para fugir."
                        );
                    }
                } else {
                    JOptionPane.showMessageDialog(
                        null,
                        nomePersonagem + " não pode voar."
                    );
                }
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Voltando ao menu de ações.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.");
                break;
        }
    }
}

private static void correr(Personagem personagem) {
    if (personagem instanceof DragaoAlado) {
        JOptionPane.showMessageDialog(
            null,
            personagem.getClass().getSimpleName() + " não pode correr."
        );
    } else {
        JOptionPane.showMessageDialog(
            null,
            personagem.getClass().getSimpleName() + " correu para fugir do combate."
        );
        
    }
}


private static void voar(Personagem personagem) {
    if (personagem instanceof DragaoAlado) {
        if (((DragaoAlado) personagem).podeVoar()) {
            ((DragaoAlado) personagem).usarHabilidadeDeVoo();
        } else {
            JOptionPane.showMessageDialog(
                null,
                personagem.getClass().getSimpleName() + " não pode voar para fugir."
            );
        }
    } else {
        JOptionPane.showMessageDialog(
            null,
            personagem.getClass().getSimpleName() + " não pode voar."
        );
    }
}

        

}
    

