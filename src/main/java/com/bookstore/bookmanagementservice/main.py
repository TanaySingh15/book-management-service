import json
from datetime import datetime
import pandas as pd

class JsonData:
    def __init__(self, storecode=None, engineid=None, terminalId=None, transactionId=None, 
                 thread=None, process=None, log=None, lvl=None, timestamp=None, app=None, type=None):
        self.storecode = storecode
        self.engineid = engineid
        self.terminalid = terminalId  # Adjust for camelCase terminalId
        self.transactionid = transactionId  # Adjust for camelCase transactionId
        self.thread = thread
        self.process = process
        self.log = log
        self.lvl = lvl
        self.timestamp = timestamp
        self.app = app
        self.type = type

class TimeData:
    def __init__(self, start_timestamp, end_timestamp="", total_time="", terminal_id="", transaction_id=""):
        self.start_timestamp = start_timestamp
        self.end_timestamp = end_timestamp
        self.total_time = total_time
        self.terminal_id = terminal_id
        self.transaction_id = transaction_id

def get_socket_from_request(json_data, msg):
    socket = ""
    if json_data.terminalid and (json_data.type == "Read" or json_data.type == "Write"):
        count = 0
        for i in range(len(msg)):
            c = msg[i]
            socket += c
            if c == '|':
                count += 1
            if count == 3:
                return socket
    return socket

def process_file(file_path):
    map_data = {}
    with open(file_path, 'r') as file:
        for line in file:
            line = line.replace('@timestamp', 'timestamp')
            msg = "\"" + line[line.index("msg"):]
            json_str = line[:line.index("msg") - 2] + "}"
            json_data = json.loads(json_str, object_hook=lambda d: JsonData(**d))

            if "Read" in msg:
                json_data.type = "Read"
            elif "Write" in msg:
                json_data.type = "Write"
            else:
                json_data.type = "Error"

            if json_data.type == "Read" or json_data.type == "Write":
                socket = get_socket_from_request(json_data, msg)
                key = ""
                if json_data.terminalid:
                    key = json_data.terminalid
                if json_data.transactionid:
                    key += json_data.transactionid
                key += socket

                if json_data.type:
                    if key not in map_data:
                        if json_data.type == "Read":
                            t = TimeData(json_data.timestamp, terminal_id=json_data.terminalid, transaction_id=json_data.transactionid)
                            map_data[key] = t
                    else:
                        t = map_data[key]
                        start_time = datetime.fromisoformat(t.start_timestamp)
                        end_time = datetime.fromisoformat(json_data.timestamp)
                        duration = end_time - start_time
                        t.end_timestamp = json_data.timestamp
                        t.total_time = str(duration)
                        map_data[key] = t

    return map_data

def write_to_excel(map_data, output_file):
    data = []
    for key, value in map_data.items():
        data.append({
            "Key": key,
            "Start Timestamp": value.start_timestamp,
            "End Timestamp": value.end_timestamp,
            "Total Time": value.total_time,
            "Terminal ID": value.terminal_id,
            "Transaction ID": value.transaction_id
        })
    
    df = pd.DataFrame(data)
    df.to_excel(output_file, index=False)

if __name__ == "__main__":
    file_path = "C:/Users/Tanay/Desktop/test/input.txt"
    output_file = "output.xlsx"
    
    map_data = process_file(file_path)
    
    write_to_excel(map_data, output_file)
    
    print(f"Data written to {output_file}")
