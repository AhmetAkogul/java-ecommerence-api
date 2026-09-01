import requests


product_response = requests.post(
    "http://localhost:8080/products",
    json={
        "name": "Gaming Monitor",
        "price": 12000,
        "stock": 4,
        "category": "ELECTRONICS"
    }
)

product = product_response.json()
print("Ürün:", product)


order_response = requests.post(
    "http://localhost:8080/orders",
    json={
        "productId": product["id"],
        "quantity": 2
    }
)

print("Sipariş:", order_response.status_code)
print(order_response.json())


updated_product = requests.get(
    f"http://localhost:8080/products/{product['id']}"
)

print("Güncel ürün:", updated_product.json())


orders_response = requests.get("http://localhost:8080/orders")

print("Siparişler:", orders_response.json())