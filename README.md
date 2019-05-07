# Como executar o backend:

Primeiro é necessário instalar e executar o Maven:
Maven pode ser adquirido através do link: https://maven.apache.org/download.cgi
 - apache-maven-3.6.1-bin.zip

Link direto: https://www-us.apache.org/dist/maven/maven-3/3.6.1/binaries/apache-maven-3.6.1-bin.zip

Ao finalizar o download, deve-se extrair o conteúdo do arquivo zip e criar a variável de ambiente: mvn.
Windows:
1. Sistema 'WinKey + pause'
2. Configurações avançadas do sistema
3. Aba: Avançado
4. Botão: Variáveis de ambiente
5. No campo de baixo: variáveis do sistema, botão: novo
6. nome: MAVEN_HOME, e caminho da pasta do maven '~/apache-maven-3.6.1' e OK.
7. Na variáveis do sistema, procurar por Path e Editar.
8. Na nova janela, botão: Novo, inserir caminho do Maven '~/apache-maven-3.6.1/bin'
9. Confirmar todas as janelas com OK.

#### Para executar o projeto-backend:
1. Abrir prompt
2. Entrar na pasta do projeto '(C:> dir ..~/cardapio_backend)'
3. Executar o comando: 'mvn spring-boot:run'

 
#### Para acessar o painel de banco de dados H2:
- 'http://localhost:8091/h2/'
- driver: org.h2.Driver
- Jdbc url: jdbc:h2:~/cardapio
- user: sa
- password: "vazio"


#### Para acessar somente a conexão REST:
- Abrir o software POSTMAN
- Metodos Get, Post, Put e Delete implementados
- Usar os URLs:

URL | Retorno
----|--------
http://localhost:8091/ingredients/ | Todos os ingredientes
http://localhost:8091/ingredients/{id} | Unico ingrediente com o {id}
http://localhost:8091/combinations/ | Todos as combinações (lanches)
http://localhost:8091/combinations/{id} | Unica combinação (lanche) com o {id}
http://localhost:8091/orders | Todos os pedidos em fila
http://localhost:8091/combinations/{id} | Unico pedido em fila com o {id}



