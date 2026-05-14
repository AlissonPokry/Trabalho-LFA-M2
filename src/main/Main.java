package main;

import GALS.*;
import java.io.IOException;
import java.io.StringReader;

public class Main {
    
    public static void main(String[] args) throws IOException{
         try
         {
            Lexico lexico = new Lexico(new StringReader("A = 10; B = 11; print (A);"));

            Sintatico sintatico = new Sintatico();
            Semantico semantico = new Semantico();

            sintatico.parse(lexico, semantico);
        }
        catch (LexicalError | SyntacticError e){
            System.out.println("Erro ao executar comando.");
        }
        catch ( SemanticError e ){
            System.out.println("Variavel não encontrada.");
        }
    }
}
