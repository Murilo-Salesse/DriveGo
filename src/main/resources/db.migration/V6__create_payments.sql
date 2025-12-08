CREATE TABLE payments (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    reservation_id UUID NOT NULL REFERENCES reservations(id) ON DELETE CASCADE,
    amount NUMERIC NOT NULL,
    method VARCHAR,
    status payment_status NOT NULL DEFAULT 'PENDING',
    provider_reference VARCHAR,
    created_at TIMESTAMP DEFAULT NOW()
);