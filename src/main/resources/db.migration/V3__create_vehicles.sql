CREATE TABLE vehicles (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    license_plate VARCHAR UNIQUE NOT NULL,
    vin VARCHAR UNIQUE,
    brand VARCHAR NOT NULL,
    model VARCHAR NOT NULL,
    year SMALLINT NOT NULL,
    category_id UUID REFERENCES categories(id) ON DELETE SET NULL,
    status vehicle_status NOT NULL DEFAULT 'AVAILABLE',
    mileage BIGINT,
    daily_price NUMERIC(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);
