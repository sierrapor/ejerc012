# Set up de la base de datos

Estamos utilizando docker-compose para levantar un docker mysql 8.0 la configuracion de este se encunetra en esta carpeta en el archvio docker-compose.yml, para levantarlo:

1. Instala docker:  [sigue la guia de instalacion oficial](https://docs.docker.com/engine/install/ubuntu/)

2. Instala docker compose

    1. Linux:

        **Requiere permisos de administrador**

        ``` bash
         apt install docker-compose
        ```

3. Arrancar  ejecuta en esta carpeta

    ``` yaml
      docker-compose up -d
    ```
