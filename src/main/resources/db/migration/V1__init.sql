CREATE TABLE products (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          sku VARCHAR(64) UNIQUE NOT NULL,
                          name VARCHAR(255) NOT NULL,
                          unit VARCHAR(32) NOT NULL,
                          min_stock INT DEFAULT 0,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE warehouse_locations (
                                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                     code VARCHAR(64) UNIQUE NOT NULL,
                                     name VARCHAR(255) NOT NULL
);

CREATE TABLE inventory (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           product_id BIGINT NOT NULL,
                           location_id BIGINT NOT NULL,
                           quantity INT NOT NULL DEFAULT 0,
                           UNIQUE KEY uk_inv (product_id, location_id),
                           CONSTRAINT fk_inv_prod FOREIGN KEY (product_id) REFERENCES products(id),
                           CONSTRAINT fk_inv_loc FOREIGN KEY (location_id) REFERENCES warehouse_locations(id)
);

CREATE TABLE stock_movements (
                                 id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                 product_id BIGINT NOT NULL,
                                 from_location_id BIGINT NULL,
                                 to_location_id BIGINT NULL,
                                 type ENUM('IN','OUT','TRANSFER') NOT NULL,
                                 quantity INT NOT NULL,
                                 note VARCHAR(500),
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 CONSTRAINT fk_sm_prod FOREIGN KEY (product_id) REFERENCES products(id),
                                 CONSTRAINT fk_sm_from FOREIGN KEY (from_location_id) REFERENCES warehouse_locations(id),
                                 CONSTRAINT fk_sm_to FOREIGN KEY (to_location_id) REFERENCES warehouse_locations(id)
);
