What is the product with this number: S24_3856?

```SQL
SELECT * FROM products WHERE productCode LIKE 'S24_3856';
```
*1956 Porsche 356A Coupe*

What is the average product price?
```SQL
SELECT AVG(buyPrice) FROM products;
```
*54.395182*

How many products have “Ford” in the name?
```SQL
SELECT COUNT(productName) FROM products WHERE productName LIKE '%Ford%';
```
*15*

What is the most expensive product?
```SQL
SELECT productName, buyPrice FROM products ORDER BY buyPrice DESC;
```
*1962 LanciaA Delta 16V*

How many ships are in the products?
```SQL
SELECT COUNT(productName) FROM products WHERE productLine LIKE 'Ships';
```
*9*
