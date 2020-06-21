#!/usr/bin/env bash

$KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server kafka-1:9092 --topic topic1 --group group1 --consumer-property client.id=consumer