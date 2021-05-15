Kafka example 

https://www.youtube.com/watch?v=NjHYWEV_E_o&ab_channel=TechPrimers

Kafka startup commands 

ZooKeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

kafka server 

bin/kafka-server-start.sh config/server.properties 

topic creation

bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Kafka_example

consumer 
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Kafka_example --from-beginning