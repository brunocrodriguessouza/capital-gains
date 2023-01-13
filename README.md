# Code Challenge: Ganho de Capital
Programa de linha de comando (CLI) que calcula o imposto a
ser pago sobre lucros ou prejuízos de operações no mercado financeiro de ações. (Desafio Nubank)

## Contexto
*"O objetivo deste exercício é implementar um programa de linha de comando (CLI) que calcula o imposto a
ser pago sobre lucros ou prejuízos de operações no mercado financeiro de ações.
Por favor, leia as instruções abaixo e sinta-se à vontade para fazer perguntas, caso ache necessário."*


## Entrada
O programa vai receber listas, uma por linha, de operações do mercado financeiro de ações em formato
json através da entrada padrão ( stdin ). Cada operação desta lista contém os seguintes campos:

| Nome  |Significado |
| ------------- | ------------- |
| operationType  | Se a operação é uma operação de compra ( buy ) ou venda ( sell )  |
| unit-cost  | Preço unitário da ação em uma moeda com duas casas decimais  |
| quantity  | Quantidade de ações negociadas  |

## Este é um exemplo da entrada:<br/>

    [{"operationType": "buy", "unit-cost": 10.00, "quantity": 10000},{"operationType": "sell", "unit-cost": 20.00, "quantity": 5000}]
    [{"operationType": "buy", "unit-cost": 20.00, "quantity": 10000},{"operationType": "sell", "unit-cost": 10.00, "quantity": 5000}]

*"As operações estarão na ordem em que elas ocorreram, ou seja, a segunda operação na lista aconteceu
depois da primeira e assim por diante.
Cada linha é uma simulação independente, seu programa não deve manter o estado obtido em uma linha
para as outras."*

*"A última linha da entrada será uma linha vazia."*</br>

## Saída </br>

*"Para cada linha da entrada, o programa deve retornar uma lista contendo o imposto pago para cada
operação recebida. Os elementos desta lista devem estar codificados em formato json e a saída deve ser
retornada através da saída padrão ( stdout ). O retorno é composto pelo seguinte campo:"*

| Nome  |Significado |
| ------------- | ------------- |
| tax  | O valor do imposto pago em uma operação  |

## Este é um exemplo da saída:<br/>

    [{"tax":0.00}, {"tax":10000.00}]
    [{"tax":0.00}, {"tax":0.00}]
  
*"A lista retornada pelo programa deve ter o mesmo tamanho da lista de operações processadas na entrada.
Por exemplo, se foram processadas três operações (buy, buy, sell), o retorno do programa deve ser uma lista
com três valores que representam o imposto pago em cada operação."*

## Regras do Ganho de Capital<br/>

*"O programa deve lidar com dois tipos de operações ( buy e sell ) e ele deve seguir as seguintes regras:."*

*"O percentual de imposto pago é de 20% sobre o lucro obtido na operação. Ou seja, o imposto vai ser
pago quando há uma operação de venda cujo preço é superior ao preço médio ponderado de compra."*
*"Para determinar se a operação resultou em lucro ou prejuízo, você pode calcular o preço médio
ponderado, então quando você compra ações você deve recalcular o preço médio ponderado
utilizando essa fórmula: nova-media-ponderada = ((quantidade-de-acoes-atual * media-ponderada-
atual) + (quantidade-de-acoes-compradas * valor-de-compra)) / (quantidade-de-acoes-atual +
quantidade-de-acoes-compradas) . Por exemplo, se você comprou 10 ações por R$ 20,00, vendeu 5,
depois comprou outras 5 por R$ 10,00, a média ponderada é ((5 x 20.00) + (5 x 10.00)) / (5 + 5)
= 15.00."*

*"Você deve usar o prejuízo passado para deduzir múltiplos lucros futuros, até que todo prejuízo seja
deduzido."*

*"Prejuízos acontecem quando você vende ações a um valor menor do que o preço médio ponderado de
compra. Neste caso, nenhum imposto deve ser pago e você deve subtrair o prejuízo dos lucros
seguintes, antes de calcular o imposto."*

*"Você não paga nenhum imposto se o valor total da operação (custo unitário da ação x quantidade) for
menor ou igual a R$ 20000,00. Use o valor total da operação e não o lucro obtido para determinar se o
imposto deve ou não ser pago. E não se esqueça de deduzir o prejuízo dos lucros seguintes.
Nenhum imposto é pago em operações de compra."*
