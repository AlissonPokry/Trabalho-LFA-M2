package GALS;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants
{
    Stack<Integer> stack = new Stack();
    Map<String, Integer> vars = new HashMap<String, Integer>();
    String variavelAtual;
    
    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("Acao #"+action+", Token: "+token);
        Integer a, b;
        try {
            switch (action)
            {

                case 1: //Mostra valor final
                    a = stack.pop();
                    System.out.print("Resultado: " + Integer.toBinaryString(a) + "\n");
                    break;
                case 2: //Guarda nome da variavel
                    variavelAtual = token.getLexeme();
                    break;
                case 3: //Salva valor calculado
                    vars.put(variavelAtual, stack.pop());
                    break;
                case 4: //Adição
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a.intValue() + b.intValue());
                    break;
                case 5: //Subtração
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a.intValue() - b.intValue());
                    break;
                case 6: //Multiplicação
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a.intValue() * b.intValue());
                    break;
                case 7: //Divisão
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a.intValue() / b.intValue());
                    break;
                case 8: //Potenciação
                    b = stack.pop();
                    a = stack.pop();
                    Double A = Math.pow(a, b);
                    stack.push(A.intValue());
                    break;
                case 9: //Le numero binario
                    stack.push(Integer.parseInt(token.getLexeme(), 2));
                    break;
                case 10: //Busca valor da variavel
                    stack.push(vars.get(token.getLexeme()));
                    break;
                case 11: //log
                    a = stack.pop();
                    Double log = Math.log(a) / Math.log(2);
                    stack.push(log.intValue());
                    break;
            }
        }
        catch (Exception e){
            throw new SemanticError("Variavel nao declarada");
        }
    }	
}
