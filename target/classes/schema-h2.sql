-- Water Logging and Drainage Map Database Schema for H2

-- Users table
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    role VARCHAR(20) DEFAULT 'CITIZEN' CHECK (role IN ('CITIZEN', 'ADMIN')),
    enabled BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Flood reports table
CREATE TABLE IF NOT EXISTS flood_reports (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    latitude DECIMAL(10,8) NOT NULL,
    longitude DECIMAL(11,8) NOT NULL,
    severity VARCHAR(20) NOT NULL CHECK (severity IN ('LOW', 'MEDIUM', 'HIGH', 'SEVERE')),
    description TEXT,
    image_url VARCHAR(500),
    location VARCHAR(255),
    status VARCHAR(20) DEFAULT 'PENDING' CHECK (status IN ('PENDING', 'VERIFIED', 'REJECTED', 'RESOLVED')),
    reported_by BIGINT NOT NULL,
    verified_by BIGINT,
    verified_at TIMESTAMP,
    resolved_at TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (reported_by) REFERENCES users(id),
    FOREIGN KEY (verified_by) REFERENCES users(id)
);

-- Indexes for better performance
CREATE INDEX IF NOT EXISTS idx_flood_reports_status ON flood_reports(status);
CREATE INDEX IF NOT EXISTS idx_flood_reports_severity ON flood_reports(severity);
CREATE INDEX IF NOT EXISTS idx_flood_reports_location ON flood_reports(latitude, longitude);
CREATE INDEX IF NOT EXISTS idx_flood_reports_created_at ON flood_reports(created_at);
CREATE INDEX IF NOT EXISTS idx_flood_reports_reported_by ON flood_reports(reported_by);

-- Insert default admin user (password: admin123)
INSERT INTO users (username, email, password, full_name, role) 
VALUES ('admin', 'admin@floodwatch.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'System Administrator', 'ADMIN');

-- Insert default regular user (password: user123)
INSERT INTO users (username, email, password, full_name, role) 
VALUES ('user', 'user@floodwatch.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 'Regular User', 'CITIZEN');

-- Insert test admin user (password: admin)
INSERT INTO users (username, email, password, full_name, role) 
VALUES ('testadmin', 'testadmin@floodwatch.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDi', 'Test Administrator', 'ADMIN');

-- Insert test regular user (password: user)
INSERT INTO users (username, email, password, full_name, role) 
VALUES ('testuser', 'testuser@floodwatch.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDi', 'Test User', 'CITIZEN');
