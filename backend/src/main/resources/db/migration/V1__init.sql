-- Flyway runs these in version order: V1, V2, V3...
-- This first migration establishes a minimal schema.

CREATE TABLE projects (
  id            BIGSERIAL PRIMARY KEY,
  slug          TEXT NOT NULL UNIQUE,
  title         TEXT NOT NULL,
  summary       TEXT NOT NULL,
  created_at    TIMESTAMPTZ NOT NULL DEFAULT now(),
  updated_at    TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX ix_projects_created_at ON projects (created_at DESC);
