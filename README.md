# mock-transactions
Projeto teste que retorna uma lista de transações aleatórias como mock. Dado a mesma entrada de parametros sempre retornará a mesma saída.
Para o retorno do mock, tudo é gerado em tempo de execução, não existe nenhum tipo de repositório. O retorno da transação segue o padrão abaixo:

Transação

```
[GET] /<id>/transacoes/<ano>/<mes>

Content-type: application/json

[
  {
     "descricao": "string(10, 120)"
     "data": "long(timestamp)"
     "valor": "integer(-9.999.999, 9.999.999)"
  }  
]
```

#### Regras
- o id de usuário é um `número inteiro` de `1.000 a 100.000`
- o total de transações retornadas é igual ao `mês` * `primeiro dígito do id`. Ex.: id `2995`, mês `7`, `2 * 7 = 14 transações na lista`
- a descrição é gerada de forma ser legível e possui no mínimo 10 caracteres, por exemplo `babazuleco`
- o valor é gerado é baseado no id, mês e indice da transação
- a data é retornada em formato long, também é gerada baseada no mes, ano e id da transação
- dado a mesma entrada de parâmetros a saída sempre será a mesma
