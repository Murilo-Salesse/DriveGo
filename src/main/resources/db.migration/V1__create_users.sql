CREATE TYPE user_role AS ENUM ('ADMIN', 'OPERATOR', 'CLIENT', 'INSTRUCTOR');
CREATE TYPE vehicle_status AS ENUM ('AVAILABLE', 'RENTED', 'MAINTENANCE', 'RESERVED');
CREATE TYPE reservation_status AS ENUM ('PENDING', 'CONFIRMED', 'CANCELLED', 'COMPLETED');
CREATE TYPE payment_status AS ENUM ('PENDING', 'PAID', 'FAILED');

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email VARCHAR UNIQUE NOT NULL,
    password_hash VARCHAR NOT NULL,
    full_name VARCHAR,
    role user_role NOT NULL DEFAULT 'CLIENT',
    phone VARCHAR,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);