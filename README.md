# poker-java
## Simple poker game library implementation

It is a simple 5-card hands comparator based on basic rules described by https://en.wikipedia.org/wiki/List_of_poker_hands

##Features:
* Supports decks that contains wildcard - Allowing Five of a Kind hand evaluation.
* Includes a Deck reset method to start a new game.
* Unit tests based on the Wiki page - all examples.
* Main.class contains a sample usage scenario. 

##Project Structure
The project is bases on Java 11 and uses Maven as a dependency management tool.

###Maven Goals
Maven goals could be executed using your local installation or via wrapper (preferred) 

#### Package (build)
Maven Surefire plugin triggers the unit tests and generates Jacoco reports upon completion

```bash
./mvnw package
```
#### Sonar (Quality & Code Analysis)
Sonar plugin submits source code and Jacoco reports to a Sonar server (localhost:9000) 
```bash
./mvnw sonar:sonar
```

##Libraries
This project uses the following libraries:
* Lombok
* JUnit
* Mockito
* Spock