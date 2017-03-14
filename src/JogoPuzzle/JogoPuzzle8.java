/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JogoPuzzle;

import Classes.Metodos;
import Classes.Nodo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo Vignolli
 */
public class JogoPuzzle8 {

    public static void main(String[] args) {
        
        //Matriz com os dados de origem do tabuleiro
        int[][] aOrigem  = {{2,3,7},{5,4,8},{0,6,1}};
        //Matriz com os dados com o destino esperado após a execução do jogo
        int[][] aDestino = {{1,2,3},{4,5,6},{7,8,0}};
        
        Nodo resultado = new Nodo(null, 0, 1, aOrigem);
        resultado.saida = "Passos a serem executados:";
        
        Nodo nDestino = new Nodo(null, 0, 1, aDestino);
        
        //Abertos
        List<Nodo> lista_a = new ArrayList();
        //Fechados
        List<Nodo> lista_f = new ArrayList();
        
        //Variáveis para controle de nodos envolvidos e profundidade
        int nTestados = 0;
        int profundidade = 0;
        
        //Enquanto a origem for diferente do destino
        while(!resultado.equals(nDestino)){
            if(nTestados == 0){
               lista_a.add(resultado);
            } 
            
            if(profundidade < resultado.nivel){
              profundidade = resultado.nivel;
            }
            
            //profundidade máxima = 30;
            if(resultado.nivel < 30){
                List<Nodo> lMovimentos = Metodos.moviPossiveis(resultado);
                for(Nodo movimentos : lMovimentos){
                    if(!Metodos.nodoExiste(lista_f,movimentos)){
                        movimentos.valHeuristica = Metodos.calculoHeuristica(movimentos.dadosJogo, nDestino.dadosJogo);
                        lista_a.add(movimentos);
                    }
                }
            } 
            Metodos.fecharNode(lista_f,lista_a,resultado);
            resultado = Metodos.buscaProximo(lista_a); 
        }
        
        String texto_saida = "";
        int movi_realizados = -1;
        while(resultado != null){
            movi_realizados++;
            texto_saida = resultado.saida + " \n" + texto_saida;
            resultado = resultado.pai;
        }
        texto_saida += "Fim de execução!";
        
        System.out.println(texto_saida);
        System.out.println("-----------------------------------");
        System.out.println("RESULTADOS OBTIDOS");
        System.out.println("Quantidade de Movimentos Realizados: "+ String.valueOf(movi_realizados));
        System.out.println("Nodos testados: "+ String.valueOf(nTestados));
        System.out.println("Profundidade: "+ String.valueOf(profundidade));
        System.out.println("-----------------------------------");
        
    }
    
}
