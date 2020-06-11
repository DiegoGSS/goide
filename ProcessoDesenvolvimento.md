# Processo de Desenvolvimento

### Commit 25
Ajustes dos textos do repositório.

### Commit 21
Arrumando o Readme e postando no GitHub \o/.

### Commit 20
Neste commit, implementamos nossa funcionalidade final do Problema 1: a cifração e decifração com arquivos de texto como input e output.
Colocamos essa funcionalidade em uma nova classe, adicionamos o uso delas em nossas classes de ConsoleApp e encapsulamos a parte encapsulável da lógica delas em uma classe básica.

Repetimos aqui os testes manuais da última etapa usando arquivos de texto.
E, não nos preocupamos muito com os casos de exceção já que nossa Console Application é bem básica e feita para uso rápido da biblioteca. Se um dia fizermos uma API robusta, será necessário fazer uma aplicação tolerante a falhas que usa a biblioteca e apresenta boa interface de usuário.

### Commit 19
Aqui nesse commit faremos uma pequena e importante melhoria: adicionar uma normalização de texto(trocar caracteres como "ô" por "o") para permitir que nosso programa receba caracteres com acento.
Fazemos testes para nossa classe e copiamos a implementação do Stack Overflow e seguimos a uma implementação em Java :).
Aqui duas coisas legais ocorrem:
1. Para garantir a consistência da classe Java, adicionamos testes relativos a normalização dos caracteres em português. Se precisarmos de mais normalizações, podemos adicionar os testes. Se eles começarem a falhar, podemos mudar a biblioteca.
2. Como os testes são composable, não é necessário adicionar novos testes nas classes antigas.
Feito tudo isso, fazemos alguns testes com textos com acentos na aplicação console e garantimos a melhoria.

### Commit 18
Feita a biblioteca, é hora de colocar as novas cifras na nosso Console Application. Além disso, é uma boa oportunidade para melhorar este código.
Nesse caso, criamos uma classe para a aplicação console de cada cifra, e deixamos a classe principal bem simples.
Organizamos também nossos strings úteis em constantes.
Finalmente, em termos de testes, os testes manuais vão dar ainda mais trabalho, mas ainda será a estratégia utilizada.
Feito isso, nossa aplicação console está basicamente pronta.

### Commit 17
Agora, para finalizar Vigenère e o Rot falta apenas a etapa final: decifrar. Como vimos, decifrar corresponde a operação oposta a cifrar.
Então, fazemos os testes e adicionamos as novas funções em `CharacterCoder`, `StringCoder`, `MainCyphers.RotCypher` e `MainCyphers.VigenereCypher`.
Também complementamos a aplicação coms testes integrados básicos para as três classes que são pontos de entrada da biblioteca e movemos a `MainCyphers.CesarCypher` para o pacote geral.
Finalmente, adicionamos teste de rotação inválida na classe `CharacterCoder` para garantir coverage completa dos testes.
Também adicionamos testes com chaves que incluem caracteres especiais em `StringCoder`.
Feito tudo isso nossa biblioteca está basicamente completa!

### Commit 16
Com o Rot feito, finalmente faremos nossa classe de `MainCyphers.VigenereCypher`. Manteremos os mesmos passos de sempre, torcendo para não termos mais problemas nos testes :).
Nesse caso, precisamos fazer mais uma correção: a chave não pode ser rotacionada quando os caracteres do texto são especiais.
Resolvendo isso os testes passam e finalizamos mais uma etapa.

### Commit 15
Agora, devemos criar uma classe pré Vigènere que permite a rotação de um texto por 'n' caracteres. Como sempre, começamos pelo teste, implementamos a classe e fazemos com que os testes passem. E, como no caso da `CesarCypherTest`, fazemos os mocks para testar a API sem retestar a aplicação.
Fazemos também um teste integrado simples, como demonstração e para garantir de forma simples todo o fluxo.
MAS OH NÃO, ALGO DEU ERRADO. O resultado esperado não corresponde ao obtido. O que pode ter dado errado?

Se observarmos bem, veremos que o problema é que estamos considerando o 'a' como rotação de valor 1, quando na verdade o 'a' significa rotação 0.
E por que esse erro chegou até aqui? Simples, os testes estavam errados.
**Aqui fica uma lição essencial do TDD: o centro do desenvolvimento fica nos testes. Portanto, eles devem ser feitos com muito cuidado e validados em si. Erros nos testes acarretam quase que necessariamente em erro na aplicação.**
Bom, está na hora de resolver os problemas:
1. Corrigimos os testes errados na classe `CharacterCoderTest`.
2. Corrigimos a classe `CharactedCoder`para que os testes passem.
3. Repetimos o processo para a classe `StringCoder`.
4. Repetimos o processo para a classe `MainCyphers.RotCypher`.
Feito tudo isso, finalmente esta etapa está finalizada.

### Commit 14
Agora, devemos incrementar a evolução do último commit permitindo que a rotação ocorra não apenas em caracteres, mas em Strings.
1. Primeiro elaboramos os novos testes para nossa classe `StringCoder`.
2. Em seguida, conforme começamos a implementar o código da classe, notamos a necessidade de criar um iterador de strings para simplificar e encapsular a lógica de iteração no string do texto e da chave.
3. Assim, elaboramos os testes novos na classe `BeautifulStringTest` (sim, nosso novo string é o `BeautifulString`).
4. Implementamos a classe nova e fazemos ela passar pelos testes.
5. Agora, voltamos a `StringCoder` e implementamos a nova função utilizando o `BeautifulString`.
6. Feita a função nova, e passados os testes, mais uma etapa está finalizada.

### Commit 13
Agora, com a cifra de Cesar 100% implementada podemos finalmente partir para a cifra de Vigènere.
Nesse commit faremos a primeira etapa, que é permitir valores diferentes para a rotação do número (hoje apenas permitimos rotação 3).
A estratégia será a seguinte:
- Em termos de codificação, temos testes para todas as possibilidades com rotação 3.
- Agora vamos testar a rotação de um caractere específico de todos os valores possíveis.
- Como os testes devem ser "composable" com isso nós cobriremos todos os casos, não é necessário testar todas as combinações de caracteres e valores de rotação.
Agora vamos aos passos de implementação:
1. Elaboramos os testes rotacionando um char minusculo de todos os fatores válidos (outros chars).
2. Fazemos o mesmo para rotacionar o char maiúsculo.
3. Finalmente fazemos o teste com caracteres especiais com um fator de rotação arbitrário.
4. Também fazemos um refactor para melhorar os nomes dos métodos e manter o método específico de César na API, pois ele será usado especificamente

### Commit 12
Agora para finalizar o trabalho do último commit, vamos adicionar a possibilidade decodificação na nossa Console Application.
Faremos a mesma estratégia anterior de testes manuais, listando os testes no arquivo: `PlanoTestesManuais.md`.
Como usual, primeiro montamos os testes e depois o código.
Após os testes passarem, o código está pronto!

### Commit 11
Agora finalmente começaremos a funcionalidade de decifrar. Como sempre, começaremos pelos testes.
1. Elaboramos os testes da rotação reversa dos caracteres (incluindo minúsculas, maiúsculas e caracteres especiais).
2. Criamos a função nova e refatoramos a classe original: `CharacterCoder`.
3. Elaboramos os testes da rotação reversa de sintrg de exemplo na classe `StringCoderTest` e implementamos a funcionalidade na classe.
4. Finalmente elaboramos os testes com mock na classe `CesarCypherTest` e finalizamos a API.

### Commit 10
Agora, feita a primeira entrega chegou o momento ideal de implementar a outra funcionalidade da cifra de Cesar a de descriptografar!... ou seria o momento ideal, caso não fosse detectado um débito técnico no código. Nesse commit resolveremos esse débito para ficarmos mais prontos para a implementação da nova funcionalidade.

Basicamente o teste da classe `CesarCypherTest` não é unitário e sim integrado. Isso não parece muito problemático, pois o sistema é pequeno, mas se o teste envolvesse mais de 10 classes os efeitos seriam sentidos. O ideal nesse caso é fazer um teste unitário que apenas garante que a classe chama corretamente as funções utilizadas e que ela sabe lidar com seus resultados. Isso pode se tornar mais interessante caso no futuro essa função além de chamar as funções internas, processe os textos por exemplo.
Fazemos o teste, uma pequena alteração na classe para permitir os testes com mock e sucesso!

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
Novamente você está feliz tomando seu café na firma falando sobre seu novo programa. E as pessoas gostam tanto que você faz uma demonstração em sua mesa. Logo seu amigo sugere o texto: `Hello World`. Mais simples impossível você pensa. Eis que você roda seu código e consegue o resultado: `Khoor=Zruog`. OH NÃO, DEU ERRADO. 

Risadas de um lado, frustração de outro, o programa quase funcionou. Mas claro, você deve ter percebido, você esqueceu de testar os caracteres especiais!  E como resolver isso? Claro, mais testes.

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
coreFunctions.StringCoderTest é a nossa classe de testes e usamos apenas um texto simples `cesar` que deve ser transformado em `fhvdu`. O teste basicamente verifica o funcionamento correto do for e que a função `coreFunctions.CharacterCoder.characterRotator` é chamada corretamente.
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