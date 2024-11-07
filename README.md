## Example of using the Apache POI Lib

#### An example in Java was implemented for manipulating a docx with the Apache Poi lib to change the placeholders of a document through data sent during the consumption of a post '/replaces' endpoint.

### Example Request

![image](https://github.com/user-attachments/assets/af7b42ac-ab60-4e0b-9234-97317ba4e1bf)


http://localhost:8080/replaces?docName=CI.docx

```
{
    "{NOME}": "Ana Maria de Almeida Milioli",
    "{NUMERO_TCT}": "0164/2024/FAPEMAT/IFMT",
    "{NUMERO}": "0898",
    "{ANO}": "2024",
    "{DATA}": "09/10/2024",
    "{VALOR_BOLSA}": "700,00",
    "{VIGENCIA}": "01/11/2024 a 31/10/2024",
    "{TIPO_BOLSA}": "Iniciação Científica"
}

```

#### Remembering that you must upload spring locally to use localhost.
