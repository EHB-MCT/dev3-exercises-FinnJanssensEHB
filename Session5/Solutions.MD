# First Batch

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

# Second Batch

How many orders were made by customer with nr 328?
```SQL
SELECT COUNT(orderNumber) FROM orders WHERE customerNumber like '328';
```
*3*

How many orders were made by customer Julie Young?
```SQL
SELECT COUNT(orderNumber)
FROM orders
LEFT JOIN customers
ON orders.customerNumber = customers.customerNumber
WHERE contactFirstName LIKE 'Julie' 
AND customers.contactLastName LIKE 'Young';
```
*3*

How many customers from the USA have a credit limit of 0?
```SQL
SELECT COUNT(*)
FROM customers
WHERE creditLimit LIKE '0.00' 
AND country LIKE 'USA';
```
*1*

Who makes the biggest payment on average?
```SQL
SELECT customers.*, AVG(payments.amount) AS averageAmount FROM customers
LEFT JOIN payments 
ON payments.customerNumber = customers.customerNumber
GROUP BY customerNumber
ORDER BY averageAmount DESC
```

*Collectable Mini Designs Co.*

*Thompson Valarie*

# Third Batch

How much did William Brown pay in 2004?

```SQL
SELECT customers.*,
SUM(payments.amount) AS paymentAmount,
payments.paymentDate AS paymentDate
FROM customers
LEFT JOIN payments 
ON payments.customerNumber = customers.customerNumber
WHERE contactLastName LIKE 'Brown'
AND contactFirstName LIKE 'William'
AND paymentDate LIKE '2004%'
```

*38281.51*

Get a list of customer names and the name of their representative. Only include customers with a representative.

```SQL
SELECT customerName,
employees.lastName,
employees.firstName
FROM customers
LEFT JOIN employees
ON customers.salesRepEmployeeNumber = employees.employeeNumber
WHERE salesRepEmployeeNumber IS NOT NULL
```

What office is customer The Sharp Gifts Warehouse tied to?

```SQL
SELECT customerName,
offices.city,
offices.addressLine1,
offices.addressLine2
FROM customers
LEFT JOIN employees
ON customers.salesRepEmployeeNumber = employees.employeeNumber
LEFT JOIN offices
ON offices.officeCode = employees.officeCode
WHERE customerName LIKE 'The Sharp Gifts Warehouse';
```
