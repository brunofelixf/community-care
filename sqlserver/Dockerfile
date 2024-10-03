FROM mcr.microsoft.com/mssql/server:2019-latest

ENV ACCEPT_EULA=Y
ENV SA_PASSWORD=P4ssw0rd

# Muda para o usuário root para instalar pacotes
USER root

# Instala dependências e o mssql-tools
RUN apt-get update && \
    apt-get install -y curl apt-transport-https gnupg && \
    curl https://packages.microsoft.com/keys/microsoft.asc | apt-key add - && \
    curl https://packages.microsoft.com/config/ubuntu/20.04/prod.list > /etc/apt/sources.list.d/mssql-release.list && \
    apt-get update && \
    ACCEPT_EULA=Y apt-get install -y msodbcsql17 mssql-tools unixodbc-dev && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Adiciona o mssql-tools ao PATH
ENV PATH="$PATH:/opt/mssql-tools/bin"

# Copia os scripts para o container
COPY init-db.sql /init-db.sql
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# Volta para o usuário mssql
USER mssql

# Define o entrypoint
ENTRYPOINT ["/entrypoint.sh"]
