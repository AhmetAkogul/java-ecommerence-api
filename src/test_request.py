import requests

response = requests.post(
    "http://localhost:8080/products",
    json={
  "id": 991,
  "name": "Mouse",
  "price": 750,
  "stock": 10
}
)

print(response.json())