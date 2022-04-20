FROM python
RUN pip install paho-mqtt influxdb
COPY app.py /app/app.py
CMD ["python", "-u", "/app/app.py"]