CREATE TABLE nlc_cases (
    id BIGSERIAL PRIMARY KEY,
    case_id TEXT NOT NULL UNIQUE,
    case_description TEXT NOT NULL,
    case_date DATE NOT NULL,
    past_description TEXT NOT NULL,
    past_date DATE NOT NULL,
    label BOOLEAN
);
