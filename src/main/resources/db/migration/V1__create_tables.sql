CREATE TABLE accounts (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          balance DECIMAL(19, 4) NOT NULL
);


CREATE TABLE transactions (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              source_account_id BIGINT NOT NULL,
                              destination_account_id BIGINT NOT NULL,
                              amount DECIMAL(19, 4) NOT NULL,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE transactions ADD CONSTRAINT fk_transactions_source_account FOREIGN KEY (source_account_id) REFERENCES accounts (id) ON DELETE RESTRICT;
ALTER TABLE transactions ADD CONSTRAINT fk_transactions_destination_account FOREIGN KEY (destination_account_id) REFERENCES accounts (id) ON DELETE RESTRICT;
