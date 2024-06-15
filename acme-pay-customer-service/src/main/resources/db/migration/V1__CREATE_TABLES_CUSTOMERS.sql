create table  if not exists customers(
	id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    document VARCHAR(50) NOT NULL,
	close BOOLEAN,
	created_at TIMESTAMP NOT NULL,
	updated_at TIMESTAMP
);