## Projeto exemplo com Stateful SessionBean

Este projeto exemplifica o uso do `Stateful SessionBean`. 
Para execução deste projeto, construa-o com o Docker.

###Passos:
* docker build -t stateful .
* docker run -it -d -p 8080:8080 stateful

Acesse o link `http://192.168.99.100:8080/Stateful`. 
Lembrem-se, este endereço pode mudar confore configuração do Docker.
