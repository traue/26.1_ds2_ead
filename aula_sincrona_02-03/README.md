# Desenvolvimento de Sistemas II — Aula 2
## Guia de Referência: Refatoração

Este repositório funciona como **material de consulta** da Aula 2.
O foco é entender **conceitos**, **vocabulário** e **técnicas principais de refatoração**.

---

## 1) Ideia central da aula

Refatorar é **melhorar a estrutura interna do código sem alterar seu comportamento externo**.

Em termos simples:
- o sistema continua entregando o mesmo resultado para o usuário;
- o código fica mais legível, coeso e fácil de manter;
- futuras mudanças tendem a ficar mais seguras.

---

## 2) Conceitos essenciais

### Padrão (pattern)
Um padrão descreve uma solução recorrente para um problema recorrente em um contexto.

### Níveis de padronização vistos na disciplina
- **Enterprise:** alinhamento de sistemas com processos e estratégia da organização.
- **Architecture:** organização macro da solução (camadas, serviços, componentes).
- **Design:** colaboração entre classes e objetos.
- **Programming:** escrita de código e microdecisões de implementação.

> Nesta aula, o foco está no nível **Programming**, com impacto direto em **Design**.

### Bad smell ("mau cheiro")
É um **sinal de problema de design** no código.

Importante:
- bad smell **não é bug**;
- bad smell indica que o código pode estar difícil de evoluir, entender ou testar.

---

## 3) Quando faz sentido refatorar

Você provavelmente deve refatorar quando encontrar:
- métodos muito longos;
- classes com responsabilidades demais;
- condicionais repetitivas e complexas;
- estruturas de dados confusas;
- código duplicado;
- nomes pouco expressivos.

---

## 4) Técnicas de refatoração (mapa rápido)

As técnicas foram organizadas em grupos (inspiração: catálogo de Fowler e organização do Refactoring Guru):

1. **Composing Methods**
   - foco: melhorar a escrita e organização de métodos.
   - exemplo clássico: `Extract Method`.

2. **Moving Features Between Objects**
   - foco: mover responsabilidades entre classes.
   - exemplo clássico: `Extract Class`.

3. **Organizing Data**
   - foco: representar e manipular dados de forma mais clara.
   - exemplo clássico: `Replace Array with Object`.

4. **Simplifying Conditional Expressions**
   - foco: reduzir complexidade de `if/else` e `switch`.
   - exemplo clássico: `Introduce Null Object`.

5. **Simplifying Method Calls**
   - foco: métodos mais coesos e com melhor separação de intenção.
   - exemplo clássico: `Separate Query from Modifier`.

6. **Dealing with Generalization**
   - foco: melhorar hierarquias de herança e abstrações.
   - exemplo clássico: `Extract Superclass`.

---

## 5) Três exemplos fundamentais da aula

### A) `Extract Method`
**Problema:** método faz muitas coisas ao mesmo tempo.

**Solução:** separar blocos lógicos em métodos menores com nomes claros.

**Ganho esperado:** leitura e manutenção melhores.

### B) `Extract Class`
**Problema:** uma classe concentra responsabilidades de domínios diferentes.

**Solução:** criar nova classe para isolar uma responsabilidade (ex.: endereço).

**Ganho esperado:** aumento de coesão e reuso.

### C) `Separate Query from Modifier`
**Problema:** mesmo método altera estado e devolve consulta.

**Solução:** separar métodos de comando (modificam) e consulta (apenas leem).

**Ganho esperado:** intenção explícita, testes mais simples e melhor previsibilidade.

---

## 6) Boas práticas ao refatorar

- Faça mudanças pequenas e incrementais.
- Garanta que o comportamento externo permaneça igual.
- Rode testes (quando existirem) a cada etapa.
- Prefira nomes claros para classes, métodos e variáveis.
- Avalie impacto antes de aplicar cada técnica (toda técnica tem trade-offs).

---

## 7) Checklist de autoestudo

Se você consegue marcar estes itens, a base da aula está consolidada:

- [ ] Sei explicar o que é refatoração sem confundir com correção de bug.
- [ ] Sei identificar pelo menos 3 bad smells em código simples.
- [ ] Consigo aplicar `Extract Method` e justificar a mudança.
- [ ] Consigo aplicar `Extract Class` e justificar a separação de responsabilidade.
- [ ] Entendo a diferença entre método de consulta e método modificador.

---

## 8) Fontes para consulta contínua

- Catálogo oficial de refatorações: https://refactoring.com/catalog/
- Refactoring Guru (visão didática): https://refactoring.guru/refactoring


