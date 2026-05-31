# maiza-mirele-poo
# Sistema de Agenda

Um sistema simples de agenda que permite cadastrar contatos com datas de aniversário, pesquisar aniversariantes por data e remover contatos. Os dados são persistidos em arquivo utilizando serialização de objetos Java.

## Funcionalidades

- Cadastrar novo contato com nome e data de aniversário
- Pesquisar aniversariantes por dia e mês
- Remover contato por nome
- Salvar dados automaticamente em arquivo
- Recuperar dados salvos anteriormente

## Tecnologias Utilizadas

- Java 11+
- Serialização de objetos Java
- Collections Framework (HashMap)
- Tratamento de exceções

## Como Executar

1. Compile todos os arquivos:
   ```bash
   javac src/*.java -d .