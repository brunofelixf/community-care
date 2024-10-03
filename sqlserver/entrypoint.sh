#!/bin/bash

# Inicia o SQL Server em segundo plano
/opt/mssql/bin/sqlservr &

# Aguarda o SQL Server estar pronto
sleep 30s

# Executa o script de inicialização
sqlcmd -S localhost -U sa -P $SA_PASSWORD -i /init-db.sql

# Mantém o container em execução
wait
