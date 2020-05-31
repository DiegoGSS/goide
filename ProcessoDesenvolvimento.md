# Processo de Desenvolvimento

### Commit 9 
Se olharmos agora nosso design estratégico, veremos que a parte de criptografia está bascaimente pronta. Poderíamos de cara partir para a descriptografia, mas vamos tomar outra estratégia.
Neste commit já montaremos uma aplicação de console capaz de criptografar texto utilizando a cifra de César. Faremos isso pensando na ideia de já fazermos uma pequena entrega de valor um produto mínimo que já resolve um dos sub-problemas do nosso problema 1.
Nisso nos encontramos com alguns pontos importantes.
- Até o momento, focamos em [testes unitários](https://en.wikipedia.org/wiki/Unit_testing). Agora, com o desenvolvimento da aplicação de console não faz muito sentido elaborar um teste unitário, mas sim um teste de integração, capaz de testar o input e output do programa, passando pelas classes internas de criptografia.
- Testes de integração são mais custosos que os unitários, portanto não é viável testar todos os casos possíveis. Nesse caso ainda, como não temos requisitos muito claros e temos uma aplicação que ainda pode variar muito, vamos tomar uma terceria estratégia: a dos testes manuais.
- Com o tempo, poderemos alocar recursos para fazer testes automatizados de integração ou até de interface, de acordo com os requisitos, necessidades e usos mais críticos do cliente.
- Além dos testes, será necessário criar um módulo para a aplicação de console e isolar nossas classes de criptografia em outro módulo. Dessa forma, isolaremos a interface com o usuário da implementação dos algoritmos e será mais fácil elaborar outras formas de interface. Além disso, será possível também utilizar o módulo com os algoritmos como uma biblioteca.

Então, vamos ao trabalho!
1. Primeiro, passamos o nosso código atual para o novo módulo interno, nossa biblioteca `goide-core`.
2. Elaboramos um plano de testes manuais descrito no arquivo `PlanoTestesManuais.md` para nossa aplicação console. Faremos um plano bem simples, dado que é uma primeira entrega e que a interface ainda não foi bem definida.
3. Feito isso (os testes manuais não passam) faremos a aplicação console no novo módulo `goide-console-app`.
4. Com tudo feito, executaremos os testes manuais para garantir que eles resultam em sucesso.

### Commit 8
Novamente você está feliz tomando seu café na firma falando sobre seu novo programa. E as pessoas gostam tanto que você faz uma demonstração em sua mesa. Logo seu amigo sugere o texto: `Hello World`. Mais simples impossível você pensa. Eis que você roda seu código e consegue o resultado: `Khoor=Zruog`. OH NÃO, DEU ERRADO. Risadas de um lado, frustração de outro, o programa quase funcionou. Mas claro, você deve ter percebido, você esqueceu de testar os caracteres especiais!  E como resolver isso? Claro, mais testes.
Nesse caso, é bom pesquisar a tabela ASCII para entender melhor como funciona a codificação de caracteres em números. Feito isso, é importante elaborar um teste com alguns exemplos, que contemple caracteres especiais que vem antes e depois das letras na tabela e também entre as maiúsculas e minúsculas; a princípio não é necessário testar *todos* os caracteres.
Novamente, primeiro montamos o teste na classe "CharacterCoderTest", com 2 exemplos de cada região onde não há letras na tabela.
Em seguida, alteramos o código da classe para contemplar os caracteres especiais. Mudanças em ifs são sempre sensíveis e muito propícias a erros, mas aqui podemos fazer as alterações com confiança, pois nossos testes cobrem os casos de sucesso anteriores.
Feita a mudança tanto os novos testes como a demonstração para seu amigo funcionam.
PS: o teste não é feito direto na API apenas para facilitar o exemplo :).

### Commit 7 
Se voltarmos ao design estratégico, vemos que a funcionalidade de criptografar um texto usando a cifra de César está pronta! Portanto é um ótimo momento para adicionarmos uma função e classe de API, que possam ser o ponto de entrada no nosso código. Tecnicamente, poderíamos usar o que já temos, mas a ideia é expormos para fora apenas o que for interessante para o usuário.
Novamente, podemos começar com um teste CesarCypherTest igual ao do coreFunctions.StringCoderTest apenas para o exemplo básico.
Como sempre, criamos o teste para falhar, depois criamos a classe e finalmente o teste passa.
Vamos também aproveitar para isolar o nosso código interno em uma pasta separada, já começando a pensar no isolamento entre as partes. Num momento futuro, podemos acertar isso de forma definitiva.
E, finalmente, como nosso teste da API é preliminar, podemos, por hora, testar apenas um caso bastante simples.

### Commit 6
Finalmente, com nossa função de rotação robusta vamos fazer uma função que consiga montar um texto cifrado!
Primeiro, faremos um teste adequado. No primeiro momento vamos utilizar outra classe, já que definimos a nossa classe inicial como um manipulador de caracteres.
coreFunctions.StringCoderTest é a nossa classe de testes e usamos apenas um texto simples `cesar` que deve ser transformado em `fhvdu`. O teste basicamente verifica o funcionamento correto do for e que a função "coreFunctions.CharacterCoder.characterRotator" é chamada corretamente.
Após fazer o teste e a classe, vemos que o teste passa.
Se rodarmos uma ferramente de Code Coverage (como a do IntelliJ), veremos que estamos com cobertura de 100%, um bom sinal de que os testes estão indo bem.

### Commit 5
Tudo parece lindo e feliz, você deixa seu código na máquina e vai tomar café com seus colegas. E eis que falando com eles no café sobre como você progrediu rápido você percebe um deslize. Um erro falta. o alfabeto também possui letras MAIÚSCULAS não é mesmo?
Enfim, isso precisa ser resolvido. E faremos da mesma forma: adicionando testes e refatorando a classe existente.
Nesse caso achei melhor montar outro teste para deixar bem claro que os dois casos são um pouco diferentes e para facilitar a leitura.
Adicionando um if na classe de rotação, o problema é resolvido.
E, como esperado, os testes antigos continuam funcionando.

### Commit 4
O commit anterior foi muito básico, mas um bom ponto de partida. Agora podemos deixar ele mais geral.
Obviamente, existem muitas entradas possíveis para a rotação, a princípio todos os 26 caracteres. Podemos fazer isso facilmente no Spock.
E fazendo o teste rapidamente notamos o erro. Simplesmente somar 3 não resolve o problema, pois os últimos caracteres saem do "alcance" dos caracteres.
Logo, devemos fazer uma alteração na função para contemplar esses casos. A sacada é que como o teste contempla o funcionamento até o momento, não é preciso ter medo de alterar a função, os testes existentes garantem seu funcionamento.
Após a alteração (em caso de dúvidas, consultar as fontes sobre a cifra) os testes passam para todo o alfabeto.

### Commit 3
Criação do projeto em Java com testes em groovy (utilizando o framework Spock).
Com o design estratégico elaborado, devemos começar a implementação elaborando nosso primeiro teste!
Começaremos pelo problema mais simples (cifra de César), pelo ponto mais básico dela (rotação de um caractere por 3 posições).
E, finalmente, faremos o teste mais simples possível para começar: nossa função deve receber um caractere 'a' e retornar um 'd'.
O teste parece básico demais, mas é a melhor forma de começarmos. 
Prmeiro fazemos o teste e deixamos ele falhar, classe: `coreFunctions.CharacterCoderTest.groovy`.
Depois elaboramos a classe e a função do teste: `coreFunctions.CharacterCoder.java`.
Feito isso, o teste passa e o primeiro passo está pronto.

### Commit 2
Definição do problema (`Problemas.md`) e elaboração do design estratégico.
- O primeiro passo para o desenvolvimento de um sistema utilizando [TDD](https://en.wikipedia.org/wiki/Test-driven_development) é a elaboração do design estratégico. O design estratégico consiste em uma forma de quebrar as funcionalidades do sistema em pequenos elementos testáveis e fáceis de compreender. No arquivo `DesignEstrategico.md` encontra-se a descrição do design elaborado para a resolução do problema.

### Commit 1
Criação do repositório e de seu `README.md`.