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

order = order_response.json()
print("Sipariş:", order)

cancel_response = requests.patch(
    f"http://localhost:8080/orders/{order['id']}/cancel"
)

print("İptal edilen sipariş:", cancel_response.json())

updated_product = requests.get(
    f"http://localhost:8080/products/{product['id']}"
)

print("Güncel ürün:", updated_product.json())