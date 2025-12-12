CREATE TABLE payments (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    reservation_id UUID NOT NULL REFERENCES reservations(id) ON DELETE CASCADE,
    amount NUMERIC(10,2) NOT NULL,
    method VARCHAR NOT NULL,
    status payment_status NOT NULL DEFAULT 'PENDING',
    provider_reference VARCHAR NOT NULL,
    created_at TIMESTAMP DEFAULT NOW()
);