import requests


response = requests.post(
    "http://localhost:8080/products/1/decrease-stock",
    params={"quantity": 3}
)

print(response.status_code)
print(response.json())