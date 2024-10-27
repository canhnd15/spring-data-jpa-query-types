CREATE TABLE IF NOT EXISTS tbl_address (
                         id BIGSERIAL PRIMARY KEY,
                         street VARCHAR(255) NOT NULL,
                         city VARCHAR(100) NOT NULL,
                         state VARCHAR(100) NOT NULL,
                         country VARCHAR(100) NOT NULL,
                         zip_code VARCHAR(20) NOT NULL
);

COMMENT ON COLUMN tbl_address.id IS 'Unique identifier for the address';
COMMENT ON COLUMN tbl_address.street IS 'Street name and number';
COMMENT ON COLUMN tbl_address.city IS 'City name';
COMMENT ON COLUMN tbl_address.state IS 'State name';
COMMENT ON COLUMN tbl_address.country IS 'Country name';
COMMENT ON COLUMN tbl_address.zip_code IS 'Postal/ZIP code';

CREATE TABLE IF NOT EXISTS tbl_user (
                        id BIGSERIAL PRIMARY KEY,
                        first_name VARCHAR(100) NOT NULL,
                        last_name VARCHAR(100) NOT NULL,
                        email VARCHAR(255) NOT NULL UNIQUE,
                        status VARCHAR(20) NOT NULL,
                        address_id BIGINT,
                        FOREIGN KEY (address_id) REFERENCES tbl_address(id) ON DELETE CASCADE
);

COMMENT ON COLUMN tbl_user.id IS 'Unique identifier for the user';
COMMENT ON COLUMN tbl_user.first_name IS 'User first name';
COMMENT ON COLUMN tbl_user.last_name IS 'User last name';
COMMENT ON COLUMN tbl_user.email IS 'User email address';
COMMENT ON COLUMN tbl_user.status IS 'User account status (e.g., ACTIVE, INACTIVE)';
COMMENT ON COLUMN tbl_user.address_id IS 'Foreign key referencing the address table';