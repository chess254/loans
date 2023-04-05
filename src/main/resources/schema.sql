
DROP TABLE IF EXISTS transactions CASCADE;
DROP TABLE IF EXISTS accounts CASCADE;
CREATE TABLE accounts (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          balance DECIMAL(19, 4) NOT NULL CHECK (balance > 0)
);

INSERT INTO accounts (balance) VALUES (1000.00);
INSERT INTO accounts (balance) VALUES (500.00);
INSERT INTO accounts (balance) VALUES (2000.00);
INSERT INTO accounts (balance) VALUES (300.00);
INSERT INTO accounts (balance) VALUES (1500.00);



CREATE TABLE transactions (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              source_account_id BIGINT NOT NULL,
                              destination_account_id BIGINT NOT NULL,
                              amount DECIMAL(19, 4) NOT NULL,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE transactions ADD CONSTRAINT fk_transactions_source_account FOREIGN KEY (source_account_id) REFERENCES accounts (id) ON DELETE RESTRICT;
ALTER TABLE transactions ADD CONSTRAINT fk_transactions_destination_account FOREIGN KEY (destination_account_id) REFERENCES accounts (id) ON DELETE RESTRICT;
