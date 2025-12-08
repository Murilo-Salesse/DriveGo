CREATE TABLE vehicle_photos (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    vehicle_id UUID NOT NULL REFERENCES vehicles(id) ON DELETE CASCADE,
    url VARCHAR NOT NULL,
    uploaded_at TIMESTAMP DEFAULT NOW()
);