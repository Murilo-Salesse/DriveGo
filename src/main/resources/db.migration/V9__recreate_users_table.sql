-- Remove estrutura antiga
DROP TABLE IF EXISTS users CASCADE;
DROP TYPE IF EXISTS user_role;
DROP TYPE IF EXISTS user_status;

-- Enum de roles
CREATE TYPE user_role AS ENUM ('ADMIN', 'OPERATOR', 'CLIENT', 'INSTRUCTOR');

-- Status do usuário
CREATE TYPE user_status AS ENUM ('PENDING', 'ACTIVE', 'BLOCKED');

CREATE TABLE users (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

   email VARCHAR NOT NULL UNIQUE,
   password_hash VARCHAR,

   google_id VARCHAR UNIQUE,

   full_name VARCHAR NOT NULL,
   phone VARCHAR,

   role user_role NOT NULL DEFAULT 'CLIENT',
   status user_status NOT NULL DEFAULT 'PENDING',

   verification_code VARCHAR,
   verification_expires_at TIMESTAMP,

   last_login_at TIMESTAMP,

   created_at TIMESTAMP DEFAULT NOW(),
   updated_at TIMESTAMP DEFAULT NOW()
);