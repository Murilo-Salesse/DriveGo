CREATE TABLE payments (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  reservation_id UUID NOT NULL REFERENCES reservations(id) ON DELETE CASCADE,

  amount NUMERIC(10,2) NOT NULL,

  method VARCHAR(50) NOT NULL, -- CARD, PIX, BOLETO, etc
  provider VARCHAR(30) NOT NULL, -- STRIPE, MERCADO_PAGO

  status payment_status NOT NULL DEFAULT 'PENDING',

  provider_reference VARCHAR(255) NOT NULL, -- payment_intent_id
  created_at TIMESTAMP DEFAULT NOW()
);