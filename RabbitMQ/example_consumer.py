# example_consumer.py
import pika, os, time

def pdf_process_function(msg):
    print(" PDF processing")
    print(" [x] Received " + str(msg))
    time.sleep(5) # delays for 5 seconds
    print(" PDF processing finished");
    return;

# Access the CLODUAMQP_URL environment variable and parse it (fallback to localhost)
#url = os.environ.get('CLOUDAMQP_URL', 'amqps://yixrfvrp:Dqo7-CU2AmPrmkVhr1fqk2g6h7HMF2c5@jackal.rmq.cloudamqp.com/yixrfvrp')
url = os.environ.get('CLOUDAMQP_URL','amqps://tqzvyxix:oGh4wcsnvBrG2U5zzQBDgkcFH_ff8B8C@jackal.rmq.cloudamqp.com/tqzvyxix') # URL professor
params = pika.URLParameters(url)

connection = pika.BlockingConnection(params)
channel = connection.channel() # start a channel
channel.queue_declare(queue='pdfprocess_aula') # Declare a queue

# create a function which is called on incoming messages
def callback(ch, method, properties, body):
    pdf_process_function(body)

# set up subscription on the queue
channel.basic_consume('pdfprocess', callback, auto_ack=True)

# start consuming (blocks)
channel.start_consuming()
connection.close()