import requests
from time import sleep
import json
import subprocess


url = "https://api.github.com/repos/devantler/software-engineering-f22/actions/workflows/22437731/runs?per_page=1"
payload={}
headers = {
'Accept': 'application/vnd.github.v3+json',
'Authorization': 'Basic aG91bnN2YWQ6Z2hwX1BDekZQaWtVdGdNUlpvUE16NlVBM1ZtSzkzcVY3azJRSVFjeQ=='
}

lastRun = 0
while(True):
    response = requests.request("GET", url, headers=headers, data=payload)
    print("Got Respone")
    jsonObject = json.loads(response.text)
    if int(jsonObject['total_count']) > lastRun and jsonObject['workflow_runs'][0]['conclusion'] == 'success':
        print("Success")
        lastRun = jsonObject['total_count']
        conclusion = jsonObject['workflow_runs'][0]['conclusion']
        print("Running script")
        subprocess.run(["sh","./reload.sh"])
    sleep(10)
