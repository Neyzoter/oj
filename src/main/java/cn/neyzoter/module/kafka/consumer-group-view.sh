#/bin/bash

$KAFKA_HOME/bin/kafka-consumer-groups.sh --bootstrap-server kafka-1:9092 --group DemoConsumer --describe