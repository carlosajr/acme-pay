create table if not exists documents(
	id serial PRIMARY KEY,
    document VARCHAR(20) NOT NULL,
    status VARCHAR(50) NOT NULL,
	created_at TIMESTAMP NOT NULL,
	updated_at TIMESTAMP
);