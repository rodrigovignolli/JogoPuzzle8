/*
 * Classe para criação de métodos e funções a serem usados na execução do Puzzle 8
 */
package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodrigo Vignolli
 */
public class Metodos {

    public static List<Nodo> moviPossiveis(Nodo result) {
        List<Nodo> listaResultados = new ArrayList();

        for (int i = 0; i < result.dadosJogo.length; i++) {
            for (int j = 0; j < result.dadosJogo[i].length; j++) {
                if (result.dadosJogo[i][j] == 0) {
                    if (i > 0) {
                        listaResultados.add(
                                movimentoIdeal(result, i, i - 1, j,  j)
                        );
                    }
                    if (i < 2) {
                        listaResultados.add(
                                movimentoIdeal(result, i, i + 1, j, j));
                    }
                    if (j > 0) {
                        listaResultados.add(
                                movimentoIdeal(result, i, i, j, j - 1));
                    }
                    if (j < 2) {
                        listaResultados.add(
                                movimentoIdeal(result, i, i, j, j + 1));
                    }
                }
            }
        }
        return listaResultados;
    }

    static Nodo movimentoIdeal(Nodo pai, int xnull, int xval, int ynull, int yval) {
        int[][] tabuleiro = new int[3][3];
        for (int i = 0; i < pai.dadosJogo.length; i++) {
            System.arraycopy(pai.dadosJogo[i], 0, tabuleiro[i], 0, pai.dadosJogo[i].length);
        }
        tabuleiro[xnull][ynull] = tabuleiro[xval][yval];
        tabuleiro[xval][yval] = 0;

        Nodo resultado = new Nodo(pai, 0, pai.nivel + 1, tabuleiro);
        resultado.saida = "Mova: " + String.valueOf(tabuleiro[xnull][ynull]);

        return resultado;
    }

    public static double calculoHeuristica(int[][] movimentoAtual, int[][] destino) {
        double valorCalc = 0;
        for (int i = 0; i < movimentoAtual.length; i++) {
            for (int j = 0; j < movimentoAtual[i].length; j++) {
                if (movimentoAtual[i][j] != destino[i][j]) {
                    double p_linha = (movimentoAtual[i][j] - 1) / 3;
                    double p_coluna = movimentoAtual[i][j] - p_linha * 3 - 1;
                    
                    double valDestino = Math.abs(j - p_coluna) + Math.abs(i - p_linha);
                    valorCalc += valDestino;
                }
            }
        }
        
        return valorCalc;
    }

    public static Nodo buscaProximo(List<Nodo> a) {
        Comparador comp = new Comparador();
        a.sort(comp);
        Nodo resultado = a.get(0);
        return resultado;
    }
    
    public static boolean nodoExiste(List<Nodo> f, Nodo movimento) {
        for(int i = 0; i < f.size(); i++){
            Nodo get = f.get(i);
            if(get.equals(movimento)){
               return true; 
            }
        }
        return false;
    }
    
    public static void fecharNode(List<Nodo> f, List<Nodo> a, Nodo resultado) {
        f.add(resultado);
        
        for(int i = 0; i < a.size(); i++){
            Nodo get = a.get(i);
            if(get.equals(resultado)){
                a.remove(i);
            }
        }
    }
}
