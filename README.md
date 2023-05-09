# flash-sale

## How to open it
- Prepare Necessary Servers
  - MySQL
  - Redis
    ```
    redis-server
    ```
  - Kafka
    ```
    cd /usr/local/kafka_2.13-3.4.0
    bin/zookeeper-server-start.sh config/zookeeper.properties
    cd /usr/local/kafka_2.13-3.4.0
    bin/kafka-server-start.sh config/server.properties
    ```