
springAPI

# transacaoSpring
branch 'master' of https://github.com/perfilsecundario/transacaoSpring






SOBRE:

API REST que recebe Transações e dá estatísticas sob essas transações. A API foi criada utilizando-se de Java e Spring Boot.

Esta API foi idealizada com arquitetura Hexagonal, e alguns princícios de Clean Code e SOLID.
 
DOCUMENTAÇÃO:
http://localhost:8080/swagger-ui.html




__________________________________________________________________________________________________________________________________________________



ESCLARECIMENTO: MÉTODO GET E SUAS ESTATÍSTICAS

AS TRANSAÇÕES NO PASSADO NÃO SÃO TRAZIDAS PELO GET, somente as transações cuja data é o minuto atual são apresentadas na requisição get. 

Este comportamento é resultado de uma  interpretação da regra de negócios, onde não foi entendido que: as transações ocorridas no passado, mas inseridas agora, deveriam ser apresentadas. 

Válido frisar que, não há erro na funcionalidade do método ou na lógica de programação. Mas somente uma divergencia interpretativa sobre a regra de negócio. O comportamento deste método pode ser facilmentente modificado caso necessário.


__________________________________________________________________________________________________________________________________________________

DETALHES:




1. POST /transacao 
      Este é o endpoint que irá receber as Transações. Cada transação consiste de um valor e  uma dataHora de quando ela aconteceu (campos obrigatórios): 
      
      { 
       "valor": 123.45, 
       "dataHora": "2020-08-07T10:11:12.000Z" 
      } 

      Restrições e Domínio 
      
      • Uma transação aceita gera uma resposta 201 Created sem nenhum corpo; 
      • Uma transação recusada gera uma resposta 422 Unprocessable Entity com uma exceção global informando os erros encontrados;
      • Uma requisição com um corpo JSON inválido gera uma resposta 400 Bad Request sem nenhum corpo;
      • Toda transação DEVE ter valor e dataHora;  
      • Uma transação NÃO DEVE acontecer no futuro;  
      • Uma transação  ter acontecido a qualquer momento no passado ou no presente; 
      • Uma transação NÃO DEVE ter valor negativo;  
      • Uma transação DEVE ter valor igual ou maior que 0 (zero).
      
      
      
___________________________________________________________________________________________________________________________________________________      




2. DELETE /transacao 

      Esta requisição simplesmente apaga todos os dados de transação que estejam armazenados. 
      


___________________________________________________________________________________________________________________________________________________
        
    
    
    
3. GET /estatistica 


    Este endpoint retorna estatísticas das transações que aconteceram apenas no último minuto. A resposta retorna da seguinte forma: 
    
    { 
     "count": 10,  
     "sum": 1234.56, 
     "avg": 123.456, 
     "min": 12.34, 
     "max": 123.56 
    } 
    
    Estas estatísticas são geradas automaticamente pe objeto DoubleSummaryStatistics do Java 8+. 

  *** AS TRANSAÇÕES NO PASSADO NÃO SÃO TRAZIDAS PELO GET, somente as transações cuja data é o minuto atual são apresentadas na requisição get.



___________________________________________________________________________________________________________________________________________________



Restrições sob o Sistema/API

   1. Este sistema NÃO utiliza nenhum outro sistema ou biblioteca de amazenamento de dados por exemplo: H2, SQLite, MongoDB, etc.) ou Cache (Redis, Infinispan, Memcached,             Ehcache, etc.);  
   2. Esta API aceita e responder APENAS objetos JSON;  
   3. Este sistema TEM testes: unitário e de integração;  
   4. A saúde da API pode ser avaliada em http://localhost:8080/actuator.






