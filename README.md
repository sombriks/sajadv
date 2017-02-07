# SAJ ADV

- sistema de gerenciamento de processos judiciais
- **módulo core**, que disponibilizará uma *API REST* para a gestão destes documentos
- **módulo web**, uma aplicação web desktop para consumir a *API REST* do **módulo core**

## Requisitos

- de modo a construir corretamente os módulos, as seguintes ferramentas base devem estar disponíveis:
  - java (1.8 ou superior, jdk da Oracle)
  - maven (3.3.9 ou superior)
  - nodejs (7.3 ou superior)
  - npm (3.10.10 ou superior)
- as dependências específicas para o java e para o node serão resolvidas, respectivamente, pelo maven e pelo npm
- o navegador de internet recomendado para o aplicativo web é o google-chrome (versão 55 ou superior), pois o javascript utilizado já faz uso de algumas das novas features da linguagem javascript (es6)

## Stack de tecnologia

- cada um dos aplicativos é construído em cima de uma plataforma distinta. o **core** é sobre a plataforma **java**, ao passo que o **web** é construído com o que há de mais sólido e moderno em javascript
  - o **sajadv-web** conta com as seguintes bibliotecas:
    - browserify (construção e organização de módulos javascript)
    - budo (test server do módulo cliente com reload automático)
    - mocha (ferramenta de testes para javascript)
    - angular (framework consolidado de mercado que implementa o padrão Model-View-View-Model)
    - angular-route (plugin para criação de SPA's (Single Page Application) utilizando angular)
    - angular-material (framework css para angular que implementa a especificação material design do google)
    - moment (biblioteca de manipulação de datas)
  - o **sajadv-core** conta com as seguintes bibliotecas:
    - flywaydb para o gerenciamento da modelagem e manipulação de bases relacionais
    - Especificação JEE 7 na forma do servidor Payara (uma versão do glassfish 4.1.1 comercialmente suportada)
      - A especificação em si é um guarda-chuva de tecnologias, e o servidor escolhido é uma das implementações de referência desta especificação. Em detalhe, veremos neste exemplo as seguintes tecnologias demonstradas do modo mais sucinto e eficiente possível:
      - EJB 3.1
      - JPA 2.1
      - JAX-RS 2.0
      - Servlet 3.1
      - As demais especificações do JEE 7 estão em uso de modo indireto ou não foram demonstradas por praticidade. Filas JMS, por exemplo, não agregariam muito ao projeto e foram deixadas de lado.

## Executando o sistema

- assumindo que os requisitos estejam devidamente instalados e disponíveis em linha de comando na estação de testes, devemos executar cada módulo individualmente
  - para executar o **módulo core**, dentro da pasta contendo o pom.xml devemos executar estes passos:
    - executar o comando ```mvn clean install``` para gerarmos o arquivo .war
    - efetuar o download do servidor payara-micro.
    - executar o servidor com o comando ```java -jar payara-micro-4.1.1.164.jar --logo --deploy target/sajadv-core-1.0-SNAPSHOT.war```
    - isso nos dará um serviço *REST* escrito em java rodando na porta 8080 da máquina local.
  - para executar o **módulo web** devemos executar este par de comandos:
    - ```npm install```
    - ```npm run dev```
    - isso nos dará um aplicativo rodando sobre o servidor de testes *budo*, na porta 9966, com hot-reload ativo. O servidor tentará ainda abrir o browser padrão do desktop para executar a aplicação.
    - caso deseje executar os testes de integração, o seguinte comando deve ser executado:
      - ```npm run test```
      - isso rodará uma pequena bateria de testes contra o módulo **sajadv-core**, chamando os recursos *REST* e verificando se o retorno é o esperado.

## Notas finais

- O compromiso inicial de camadas de serviço deve ser com ela mesma
- Questões envolvendo o problema do [select 1 + N](http://stackoverflow.com/questions/97197/what-is-the-n1-selects-problem) devem ser aderessadas quando da criação de uma API REST caso desejemos que ela seja performática. Preferencialmente só devemos fazer as consultas 'N' em telas de detalhe.
- O JEE ainda é a plataforma java mais sólida e madura. Iniciativas como o [Payara](http://www.payara.fish/) nos dão um vislumbre de como a plataforma pode não apenas entrar no circuito dos miroserviços, mas também ir além.
- Desde setembro de 2016 os navegadores mobile e desktop rodam nativamente os principais recursos do es6. A grande vantagem disso é que certas técnicas antes restritas apenas aos projetos dotados de babel agora podem ser prática comum sem a necessidade de ferramentas de transpilação tão pesadas. O setup apresentado, por exemplo, não faz uso de webpack ou babel, e o ganho na produtividade é imenso.
- O módulo cliente é configurável através de variáveis de ambiente. Esta técnica só é possível graças às várias facilidades oferecidas pelo browserify, que auxilia desde a organização de código até no empacotamente. Algumas otimizações ficaram de fora, mas há muito potencial a explorar ainda.
