-- =============================================
--  Seed Data for Digital Agency Database
-- =============================================


-- Insert initial Categories for portfolio items.
INSERT INTO category (name) VALUES
('Web Development'),   -- ID will be 1
('Mobile Apps'),       -- ID will be 2
('UI/UX Design');      -- ID will be 3


-- Insert initial Services offered by the agency.
INSERT INTO service (title, description, icon_url) VALUES
('Website Design & Development', 'We build beautiful, functional, and responsive websites tailored to your business needs.', 'assets/icons/icon-web.svg'),
('SEO & Digital Marketing', 'Improve your online visibility and attract more customers with our proven search engine optimization strategies.', 'assets/icons/icon-seo.svg'),
('Cloud Infrastructure Solutions', 'Leverage the power of the cloud for scalable, reliable, and secure application infrastructure.', 'assets/icons/icon-cloud.svg'),
('Mobile Application Development', 'Engage your users with intuitive and powerful native mobile apps for iOS and Android.', 'assets/icons/icon-mobile.svg');


-- Insert initial Portfolio Items to showcase (with live image URLs from Unsplash).
INSERT INTO portfolio_item (title, description, image_url, project_link, category_id) VALUES
('Global E-commerce Platform', 'A full-featured online store for an international retail client, built with a scalable microservices architecture.', 'https://images.unsplash.com/photo-1517694712202-14dd9538aa97', 'https://example.com/project1', 1),
('FitLife Fitness Tracker App', 'A cross-platform mobile application to help users track their workouts, nutrition, and fitness goals.', 'https://images.unsplash.com/photo-1544367567-0f2fcb009e0b', 'https://example.com/project2', 2),
('Innovate Corp Rebranding', 'A complete UI/UX and brand identity overhaul for a major B2B technology company, focusing on a clean and modern user experience.', 'https://images.unsplash.com/photo-1581291518857-4e27b48ff24e', 'https://example.com/project3', 3),
('Quantum Analytics Dashboard', 'A complex data visualization dashboard for a financial tech firm, providing real-time insights from multiple data sources.', 'https://images.unsplash.com/photo-1551288049-bebda4e38f71', 'https://example.com/project4', 1);