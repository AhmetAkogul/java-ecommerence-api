import requests

create_response = requests.post(
    "http://localhost:8080/products",
    json={
        "name": "Mouse",
        "price": 750
    }
)

product = create_response.json()
print("Eklenen ürün:", product)

product_id = product["id"]

update_response = requests.put(
    f"http://localhost:8080/products/{product_id}",
    json={
        "name": "Gaming Mouse",
        "price": 1200
    }
)

print("Güncellenen ürün:", update_response.json())