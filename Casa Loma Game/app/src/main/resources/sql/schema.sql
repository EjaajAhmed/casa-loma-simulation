-- schema.sql
-- Creates database structure for Casa Loma Game NPCs

CREATE TABLE IF NOT EXISTS NPCs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    loi DOUBLE NOT NULL CHECK (loi >= 0 AND loi <= 1),
    randomJobs TEXT,
    randomLines TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
