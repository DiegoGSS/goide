# Design Estratégico

### Design Estratégico Vigènere

Analisando o algoritmo da cifra de Vigenère (pode ser na Wikipedia mesmo) percebemos que no fundo essa cifra funciona como uma aplicação de um ROT de valor igual ao da letra da chave respectiva a cada letra do texto original. E sabemos também que o ROT é simplesmente a rotação de caracteres. E finalmente, a cifra de César é um caso especial dessa rotação, equivalente a um ROT3.

**Vigènere**
Criptografar: OK
- Para cada caractere do texto OK
- - Determinar valor do rotacional pela chave OK
- - Aplicar rotacional ao caractere OK
Descriptogragar: OK
- Processo inverso do acima OK

**César**
Criptografar: OK
- Para cada caractere do texto OK
- - Aplicar rotacional ao caractere OK
Descriptogragar: OK
- Processo inverso do acima OK