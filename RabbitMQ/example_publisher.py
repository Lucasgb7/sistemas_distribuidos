# example_publisher.py
import pika, os, logging
logging.basicConfig()
# Parse CLODUAMQP_URL (fallback to localhost)
url = os.environ.get('CLOUDAMQP_URL', 'amqps://yixrfvrp:Dqo7-CU2AmPrmkVhr1fqk2g6h7HMF2c5@jackal.rmq.cloudamqp.com/yixrfvrp')
params = pika.URLParameters(url)
params.socket_timeout = 5
connection = pika.BlockingConnection(params)
channel = connection.channel()
channel.queue_declare(queue='pdfprocess')
# send a message
channel.basic_publish(exchange='', routing_key='pdfprocess', body='User information')
print ("[x] Message sent to consumer")
connection.close()