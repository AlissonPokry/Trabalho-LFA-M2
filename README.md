# Trabalho LFA M2

Projeto em Java gerado a partir de uma gramática GALS para reconhecer e executar expressões com números binários.

## Objetivo

Este trabalho implementa um analisador léxico, sintático e semântico para uma linguagem simples de cálculos binários.

A linguagem permite:

- declarar variáveis;
- atribuir resultados de expressões;
- somar, subtrair, multiplicar e dividir;
- calcular exponenciação;
- calcular logaritmo na base 2;
- imprimir valores de variáveis.

## Arquivos principais

- `LFA-M2-v3.gals`: especificação da linguagem no GALS.
- `src/GALS/Lexico.java`: analisador léxico gerado.
- `src/GALS/Sintatico.java`: analisador sintático gerado.
- `src/GALS/Semantico.java`: ações semânticas da linguagem.
- `src/main/Main.java`: ponto de entrada para testar comandos.
- `build/classes`: pasta de saída da compilação.

## Exemplo de entrada

O arquivo `Main.java` usa uma string fixa para teste (alterar a string para outros testes):

```java
"A = 10; B = 11; print (A);"
```

Nesse exemplo:

- `A = 10;` salva o valor binário `10`;
- `B = 11;` salva o valor binário `11`;
- `print (A);` imprime o valor de `A`.

## Gramática

A gramática está definida em `LFA-M2-v3.gals`.

Principais comandos:

```gals
<instrucao> ::= imprime abrePar variavel #10 fechaPar fim #1
              | variavel #2 recebe <calcular> fim #3;
```

As ações semânticas `#1` a `#11` são tratadas no `switch` de `Semantico.java`.

## Como compilar

Na raiz do projeto, execute:

```bash
javac -d build/classes src/GALS/*.java src/main/Main.java
```

No Windows PowerShell:

```powershell
javac -d build\classes src\GALS\*.java src\main\Main.java
```

## Como executar

Após compilar:

```bash
java -cp build/classes main.Main
```

No Windows PowerShell:

```powershell
java -cp build\classes main.Main
```
