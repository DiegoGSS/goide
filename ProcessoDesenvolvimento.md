# Processo de Desenvolvimento

### Commit 6
Finalmente, com nossa função de rotação robusta vamos fazer uma função que consiga montar um texto cifrado!
Primeiro, faremos um teste adequado. No primeiro momento vamos utilizar outra classe, já que definimos a nossa classe inicial como um manipulador de caracteres.
StringCoderTest é a nossa classe de testes e usamos apenas um texto simples `cesar` que deve ser transformado em `fhvdu`. O teste basicamente verifica o funcionamento correto do for e que a função "CharacterCoder.characterRotator" é chamada corretamente.
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
Prmeiro fazemos o teste e deixamos ele falhar, classe: `CharacterCoderTest.groovy`.
Depois elaboramos a classe e a função do teste: `CharacterCoder.java`.
Feito isso, o teste passa e o primeiro passo está pronto.

### Commit 2
Definição do problema (`Problemas.md`) e elaboração do design estratégico.
- O primeiro passo para o desenvolvimento de um sistema utilizando [TDD](https://en.wikipedia.org/wiki/Test-driven_development) é a elaboração do design estratégico. O design estratégico consiste em uma forma de quebrar as funcionalidades do sistema em pequenos elementos testáveis e fáceis de compreender. No arquivo `DesignEstrategico.md` encontra-se a descrição do design elaborado para a resolução do problema.

### Commit 1
Criação do repositório e de seu `README.md`.