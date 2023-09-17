DROP TABLE IF EXISTS products;
CREATE TABLE products(
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    store VARCHAR(20) NOT NULL,
    brand VARCHAR(20) NOT NULL, 
    category VARCHAR(20) NOT NULL,
    price DOUBLE NOT NULL,
    item_description VARCHAR(5000) NOT NULL
);