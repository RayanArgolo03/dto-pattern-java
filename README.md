# Projeto de Gerenciamento de Clientes

Este é um projeto simples de gerenciamento de clientes que utiliza diversas tecnologias e padrões de design para garantir eficiência, modularidade e boas práticas de programação.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal do projeto.
- **Lombok**: Biblioteca para simplificar a criação de classes Java, eliminando a necessidade de escrever métodos getters, setters, constructors, etc.
- **Enum**: Utilizado para representar opções disponíveis no menu.
- **InputMismatchException**: Tratamento de exceções para garantir entrada de dados correta.
- **Builder Pattern**: Padrão de design utilizado para a construção de objetos complexos de forma mais legível e modular.
- **DTO (Data Transfer Object)**: Padrão utilizado para transferir dados entre camadas do aplicativo, encapsulando múltiplos objetos em uma classe.
- **Repository Pattern**: Abstração utilizada para a comunicação com o banco de dados, mantendo a lógica de persistência separada do restante do código.
- **Inner Class**: Utilizada no contexto do Builder Pattern para representar uma classe interna que auxilia na construção de objetos complexos.

## Como Executar o Projeto

1. Clone este repositório.
2. Certifique-se de ter o Java instalado em sua máquina.
3. Abra o projeto em sua IDE preferida.
4. Execute a classe `RunService` que contém o método `runApplication()`.

## Funcionalidades do Aplicativo

1. **CREATE**: Permite criar um novo cliente, exibindo os detalhes do cliente criado e salvando-o.
2. **PRINT**: Localiza um cliente existente e gera um relatório utilizando o padrão DTO.
3. **EXIT**: Encerra a execução do aplicativo.

## Observações

- O código inclui defesas contra entradas inválidas (InputMismatchException).
- Opções de menu não reconhecidas geram uma exceção (default switch).
- Mensagens de erro são exibidas para informar sobre problemas durante a execução.

## Contribuição

Sinta-se à vontade para contribuir para o desenvolvimento deste projeto. Abra uma **issue** se encontrar algum problema ou envie um **pull request** com melhorias. 

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
