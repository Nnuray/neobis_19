CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    amount INT NOT NULL
                );
CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE orders(
    id INT PRIMARY KEY AUTO_INCREMENT,
    status VARCHAR(50) NOT NULL ,
    product_id INT REFERENCES product(id),
    user_id INT REFERENCES users(id),
    create_at TIMESTAMP
);