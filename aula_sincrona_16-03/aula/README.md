Tema: Padrões GRASP – primeiros princípios de atribuição de responsabilidades

**Objetivo de hoje:** Entender como decidir qual classe deve fazer o quê em sistemas orientados a objetos.

## Parte I - Intro

Hoje vamos estudar padrões de atribuição de responsabilidades, chamados GRASP.”

**GRASP** = General Responsibility Assignment Software Patterns

Essencialmente são padrões que ajudam a reponder “quem deve fazer o que dentro de um sistema?”

Por exemplo:

![Captura de Tela 2026-03-16 às 12.58.25.png](attachment:32c66080-e8ea-4442-bf5a-afb1391a8e43:Captura_de_Tela_2026-03-16_as_12.58.25.png)

Seria algo assim:

```java
class Pedido {
    List<Item> itens;
}

class Item {
    double preco;
    int quantidade;
}
```

Mas.. quem deve calcular o total de uma compra?

- o pedido?
- o item?
- ou outra classe?

Esse é um tipo de decisão é atribuição de responsabilidade e que estão ligadas aos **métodos** de uma classe.

Neste caso, a classe que possui as informações necessárias para o cálculo. Como o modelo é parcial, precisaríamos analisar melhor o contexto todo para responder quem deve calcular.

## Pate II: Information Expert

Como vimos, quem deve ser responsável por uma **operação** é **quem tem as informações** necessárias para tal.

> **Deixe na mão de quem sabe**
>

### Exemplo

Um sistema de compartilhamento de bikes (tipo as do Itaú):

- Usuário pega bicicleta numa estação

![Captura de Tela 2026-03-16 às 13.19.37.png](attachment:0bf8bdd8-55f3-4a07-82be-bbf49ce5e70f:Captura_de_Tela_2026-03-16_as_13.19.37.png)

A implementação disso seria mais ou menos assim:

```java
class Ride {
    private Bike bike;
    private int durationMinutes;
}
```

```java
class Bike {
    private double pricePerMinute;
}
```

E agora… quem deve calcular o preço da corrida?

Considerando os conceitos do **Information Expert**, o correto é:

Consideramos que a classe Ride tem:

- duração
- referência à bike

Logo ela sabe calcular o custo.

Algo assim:

```java
class Ride {

    private Bike bike;
    private int durationMinutes;

    public double calculatePrice() {
        return durationMinutes * bike.getPricePerMinute();
    }
}
```

```java
class Bike {

    private double pricePerMinute;

    public double getPricePerMinute() {
        return pricePerMinute;
    }
}
```

Se colocarmos o cálculo em outra classe como, por exemplo “PriceService” estaríamos violando Information Expert, pois ala não possui as informações necessárias para executar a responsabilidade.

Lembre-se que o padrão GRASP afirma que uma responsabilidade deve ser atribuída à classe que possui os dados necessários para realizá-la!

Neste exemplo, que você acha que deveria calcular o preço da corrida?

1. Bike
2. Ride
3. User
4. CorridaService

- Resposta

  a - Ride


## Pate III: **Creator**

Ideia central:  “Quem deve criar objetos?”

A criação geralmente deve ser feita por uma classe que **usa** **ou contém** o objeto criado!

No exemplo acima, do compartilhamento de bikes, quem deve criar a classe “Ride”?

Possibilidades:

- User
- Bike
- RideController
- RideService

Neste caso, quem “cria uma corrida” é o usuário, então a classe “User" acaba sendo mais adequada… nosso diagrama ficaria assim:

![Captura de Tela 2026-03-16 às 13.32.32.png](attachment:5566bc86-3b70-42c6-a383-bfc9e7e2f468:Captura_de_Tela_2026-03-16_as_13.32.32.png)

E a implementação dela seria algo assim:

```java
class User {

    private List<Ride> rides = new ArrayList<>();

    public Ride startRide(Bike bike) {
        Ride ride = new Ride(bike);
        rides.add(ride);
        return ride;
    }
}
```

O usuário, neste caso representado pela classe User:

- usa Ride
- mantém histórico
- possui relação lógica

Logo ele é um bom Creator 🙂

## Parte IV Controler

Ideia geral: O **Controller** recebe eventos do sistema, mas ele não é UI!

Os **Controllers** ficam geralmente na camada de lógica de negócio

Imagine o seguinte fluxo do usuário para iniciar uma corrida:

*UI → Controller → Domínio*

Neste caso o Controller:

- recebe requisição
- delega para domínio

Então teremos uma nova classe.. a RideController, como por exemplo:

![Captura de Tela 2026-03-16 às 13.41.30.png](attachment:e179d5ce-561a-4b14-86c7-eeec19ed042a:Captura_de_Tela_2026-03-16_as_13.41.30.png)

Cuja implementação provavelmente ficaria assim:

```java
class RideController {

    public Ride startRide(User user, Bike bike) {
        return user.startRide(bike);
    }
}
```

Lembre-se: Controller **coordena**, mas não faz tudo.

E agora… Estaria errado ou correto:

```java
class RideController {

   public double calculatePrice(Ride ride){
       return ride.getDuration()*ride.getBike().getPrice();
   }

}
```

- **Resposta**

  Errado!

  Porque Ride já sabe calcular.


## Parte V: Low Coupling e High Cohesion

Ideia geral: Servem para verificar qualidade do design, ou seja, esses padrões são avaliativos em relação à modelagem de um projeto

### Baixo acoplamento

Antes de mais nada, acoplamento = dependência entre classes.

Por exemplo, se tivermos a classe “RiderManager” com a seguinte estrutura?

```java
class RideManager {

    Database db;
    Bike bike;
    Payment payment;
    GPS gps;
    User user;
}
```

Ela está correta ou não?

Não! pois a mudança em qualquer outra classe impactaria diretamente as outras

### Alta coesão

Ideia geral: A Classe deve ter responsabilidades relacionadas

Exemplo:

```java
class BikeSystem {

   calculateRidePrice()
   sendEmail()
   generateReport()
   connectDatabase()
}
```

Essa classe é boa ou ruim?

Péssima! Isso é classe canivete suíço, com responsabilidades demais.

## Fechamento

Information Expert → Quem tem informação faz o trabalho.

Creator → Quem usa/contém cria o objeto.

Controller → Recebe eventos do sistema.

Low Coupling → Classes pouco dependentes.

High Cohesion → Classes com responsabilidades focadas.