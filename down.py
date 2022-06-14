import requests
from pymysql import connect, cursors

conn = connect(
    host="localhost",
    user="green",
    password="green1234",
    db="greendb",
    charset="utf8"
)
cursors = conn.cursor()

response = requests.get(
    "http://openapi.seoul.go.kr:8088/6b79486353776f643638734850736e/json/RealtimeCityAir/1/50/")

jsonData = None 

data = None  

if response.status_code == 200:
    jsonData = response.json()

    data = jsonData.get("RealtimeCityAir").get("row")
    sql = "INSERT INTO weather (MSRDT, MSRRGN_NM, MSRSTE_NM, PM10, PM25, O3, NO2, CO, SO2, IDEX_NM, IDEX_MVL, ARPLT_MAIN) VALUES (%(MSRDT)s, %(MSRRGN_NM)s, %(MSRSTE_NM)s, %(PM10)s, %(PM25)s, %(O3)s, %(NO2)s, %(CO)s, %(SO2)s, %(IDEX_NM)s, %(IDEX_MVL)s, %(ARPLT_MAIN)s)"
    cursors.executemany(sql, data)
    conn.commit()
    conn.close()
