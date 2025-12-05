from tracing import instrument
instrument()
from tracing import instrument
instrument()
from kafka import KafkaConsumer
consumer = KafkaConsumer('foobar', bootstrap_servers='localhost:9092')
for msg in consumer:
   print(msg)
