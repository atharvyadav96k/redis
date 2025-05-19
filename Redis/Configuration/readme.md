# Redis Configuration
## Configuration

We can add following configuration

- port # set the port of server
    ```
        port 6379
    ```
- password # set password to connect to db
    ```
        requirepass your_password
    ```
- set maximum storage redis can use 
    ```
        maxmemory 1gb
    ```
- set maximum client connections
    ```
        maxclients 10000
    ```

- RDB ( save data in file after specific interval )
    ```
        save 900 1    # Save after 900 seconds if at least 1 key changed
    ```
- AOF ( save data after each change )
    ```
        appendonly yes
    ```
