from tracing import instrument
instrument()


from tracing import instrument
instrument()
from kafka import KafkaProducer
producer = KafkaProducer(bootstrap_servers='localhost:9092')
for _ in range(1):
   producer.send('foobar', b'some_message_bytes')
   producer.flush()
