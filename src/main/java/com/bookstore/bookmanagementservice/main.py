import json
from datetime import datetime
from dateutil import parser
from collections import defaultdict

class Time:
    def __init__(self, start_timestamp, end_timestamp, total_time, terminal_id, transaction_id):
        self.start_timestamp = start_timestamp
        self.end_timestamp = end_timestamp
        self.total_time = total_time
        self.terminal_id = terminal_id
        self.transaction_id = transaction_id

    def __str__(self):
        return f"Start: {self.start_timestamp}, End: {self.end_timestamp}, Total: {self.total_time}, Terminal: {self.terminal_id}, Transaction: {self.transaction_id}"

def get_socket_from_request(json_data, msg):
    socket = ""
    if json_data.get('terminalid'):
        if json_data.get('type') in ['Read', 'Write']:
            count = 0
            for c in msg:
                socket += c
                if c == '|':
                    count += 1
                if count == 3:
                    return socket
    return socket

def function():
    input_file = 'input.txt'  # Update this with your actual file path
    map_data = defaultdict(Time)

    with open(input_file, 'r') as file:
        for line in file:
            # Replacing @timestamp with timestamp to match valid JSON key
            line = line.replace('@timestamp', 'timestamp')
            msg_index = line.find('msg')
            msg = "\"" + line[msg_index:]
            line = line[:msg_index-2] + "}"

            # Parsing JSON
            json_data = json.loads(line)

            # Determine the type (Read/Write/Error) from the message
            if 'Read' in msg:
                json_data['type'] = 'Read'
            elif 'Write' in msg:
                json_data['type'] = 'Write'
            else:
                json_data['type'] = 'Error'

            if json_data['type'] in ['Read', 'Write']:
                socket = get_socket_from_request(json_data, msg)
                key = (json_data.get('terminalid', '') + json_data.get('transactionid', '') + socket).strip()

                if key not in map_data:
                    if json_data['type'] == 'Read':
                        t = Time(json_data['timestamp'], "", "", json_data['terminalid'], json_data['transactionid'])
                        map_data[key] = t
                else:
                    t = map_data[key]
                    start_time = parser.parse(t.start_timestamp)
                    end_time = parser.parse(json_data['timestamp'])
                    duration = end_time - start_time

                    t.end_timestamp = json_data['timestamp']
                    t.total_time = str(duration)[2:]  # Skipping the first two characters (like 'PT')
                    map_data[key] = t

    # Outputting the results
    for key, value in map_data.items():
        print(f"Key: {key} Value: {value}")

if __name__ == "__main__":
    function()
