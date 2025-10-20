-- =============================================
--  Seed Data for Digital Agency Database
-- =============================================

-- Delete existing data to prevent duplicates on restart
-- (Only run this if you want a fresh start each time)
-- DELETE FROM portfolio_item;
-- DELETE FROM service;
-- DELETE FROM category;

-- Insert initial Categories for portfolio items (with duplicate prevention)
INSERT IGNORE INTO category (id, name) VALUES
(1, 'Web Development'),
(2, 'Mobile Apps'),
(3, 'UI/UX Design');

-- Insert initial Services offered by the agency (with duplicate prevention)
INSERT IGNORE INTO service (id, title, description, icon_url) VALUES
(1, 'Website Design & Development', 'We build beautiful, functional, and responsive websites tailored to your business needs.', 'assets/icons/icon-web.svg'),
(2, 'SEO & Digital Marketing', 'Improve your online visibility and attract more customers with our proven search engine optimization strategies.', 'assets/icons/icon-seo.svg'),
(3, 'Cloud Infrastructure Solutions', 'Leverage the power of the cloud for scalable, reliable, and secure application infrastructure.', 'assets/icons/icon-cloud.svg'),
(4, 'Mobile Application Development', 'Engage your users with intuitive and powerful native mobile apps for iOS and Android.', 'assets/icons/icon-mobile.svg');

-- Insert initial Portfolio Items to showcase (with duplicate prevention)
INSERT IGNORE INTO portfolio_item (id, title, description, image_url, project_link, category_id) VALUES
(1, 'Global E-commerce Platform', 'A full-featured online store for an international retail client, built with a scalable microservices architecture.', 'https://images.unsplash.com/photo-1517694712202-14dd9538aa97', '/project/ecommerce', 1),
(2, 'FitLife Fitness Tracker App', 'A cross-platform mobile application to help users track their workouts, nutrition, and fitness goals.', 'https://images.unsplash.com/photo-1544367567-0f2fcb009e0b', '/project/fitlife', 2),
(3, 'Innovate Corp Rebranding', 'A complete UI/UX and brand identity overhaul for a major B2B technology company, focusing on a clean and modern user experience.', 'https://images.unsplash.com/photo-1581291518857-4e27b48ff24e', '/project/innovate', 3),
(4, 'Quantum Analytics Dashboard', 'A complex data visualization dashboard for a financial tech firm, providing real-time insights from multiple data sources.', 'https://images.unsplash.com/photo-1551288049-bebda4e38f71', '/project/quantum', 1);

-- Insert roles (with duplicate prevention)
INSERT IGNORE INTO roles (id, name) VALUES 
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');