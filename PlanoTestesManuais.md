# Plano Testes Manuais

### Testes Manuais 3: Testes com arquivos de texto
- Repetimos o `Testes Manuais 2` utilizando arquivos de texto.

### Testes Manuais 2: Testes básicos da Console Application com Cesar, Rot e Vigenère

1. No modo **Cesar**, repetir os `Testes Manuais 1`.
2. No modo **Rot**:
- - Testar input de texto `cesar`, com rotação `9`. Resultado esperado: `lnbja`.
- - Testar input de texto `Cesar, Rotacao.`, com rotação `L`. Resultado esperado: `Npdlc, Czelnlz.`.
- - Testar input de texto especial ``¨&*(``, com rotação `H`. Resultado esperado: ``¨&*(``.
- - Testar input de texto `cesar` com rotação inválida `%`. Resultado esperado: `cesar`.
- - Testar input de texto `cesar` com rotação inválida `-80`. Resultado esperado: `cesar`.
- - Testar os testes acima de forma reversa para decifrar.
3. No modo **Vigenere**:
- - Testar input de texto `vigenere`, com chave `chave`. Resultado esperado: `xpgzrgye`.
- - Testar input de texto `Cesar, Rotacao.`, com chave `LaTa`. Resultado esperado: `Nelac, Rhtlcto.`.
- - Testar input de texto especial ``¨&*(``, com chave `chavus`. Resultado esperado: ``¨&*(``.
- - Testar input de texto `vigs` com chave inválida `%*()-)(_`. Resultado esperado: `vigs`.
- - Testar input de texto `vigs` com chave com caractere especial `ces8`. Resultado esperado: `xmys`.
- - Testar os testes acima de forma reversa para decifrar.

### Testes Manuais 1: Testes básicos da Console Application

1. Testar input de texto `cesar`, já testado internamente. Resultado esperado: `fhvdu`.
2. Testar input incluindo maiúsculas, minúsculas e espaço: `Teste de Cesar`. Resultado esperado: `Whvwh gh Fhvdu`.
3. Testar input apenas de símbolos para garantir um caminho ruim: `¨&*(`. Resultado esperado: `¨&*(`.
4. Repetimos os mesmos testes de input acima de forma reversa utilizando a opção `d` para decifrar.