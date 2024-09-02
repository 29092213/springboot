API de CRUD de Produtos
Este repositório contém uma API REST para o gerenciamento de produtos. Com esta API, é possível criar, listar, obter detalhes, atualizar e deletar produtos. A API é desenvolvida em Java com Spring Boot e utiliza o Postman para testar os endpoints.

Configuração Inicial
Para rodar este projeto localmente, siga as etapas abaixo:

Clone o repositório para a sua máquina local usando git clone.
Abra o projeto no seu IDE de preferência e aguarde a sincronização das dependências.
Configure uma instância local do banco de dados MySQL, conforme especificado em application.properties.
Execute a aplicação através do comando ./mvnw spring-boot:run no diretório raiz do projeto.
Endpoints da API
Abaixo estão detalhados os endpoints disponíveis na API:

1. Criar Produto
URL: POST /apicrud
Corpo:

{
  "name": "Produto Exemplo",
  "value": 19.99
}
Resposta: Retorna o produto criado com o status 201 Created.

2. Listar Todos os Produtos

URL: GET /apicrud

Resposta: Retorna uma lista de todos os produtos com o status 200 OK.

3. Obter Produto por ID
 
URL: GET /apicrud/{id}

Parâmetro: {id} é o UUID do produto.
Resposta: Retorna o produto correspondente ou 404 Not Found se não encontrado.

4. Atualizar Produto

URL: PUT /apicrud/{id}
Parâmetro: {id} é o UUID do produto.

Corpo:
{
  "name": "Produto Atualizado",
  "value": 29.99
}
Resposta: Produto atualizado ou 404 Not Found se não encontrado.

5. Excluir Produto

URL: DELETE /apicrud/{id}
Parâmetro: {id} é o UUID do produto.

Resposta: Mensagem de sucesso ou 404 Not Found se não encontrado.


Para testar a API, use o Postman:
Importe a coleção de requests disponibilizada no repositório.
Configure o método e URL conforme descrito nos endpoints acima.
Envie o request e observe a resposta.

//Espero que este read me, tenha ajudado, e dessa forma, consiga integrar essa api, no seu projeto.
