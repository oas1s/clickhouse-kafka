# clickhouse-kafka
  
  Simple application which connect kafka and Clickhouse Database 
  
  Table creation query:
  
  ```SQL
  CREATE TABLE queue (
    age UInt64,
    name String,
    surname String
  ) ENGINE = Kafka('localhost:9092', 'testtopic', 'group1', 'JSONEachRow');
  ```
  Kafka was up with Docker Container
  
  Docker Compose file in root https://github.com/oas1s/clickhouse-kafka/blob/main/docker-compose.yml
