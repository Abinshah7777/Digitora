document.addEventListener('DOMContentLoaded', () => {
    
    const portfolioGrid = document.getElementById('portfolio-grid');

    fetch('/api/portfolio')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(portfolioItems => {
            portfolioGrid.innerHTML = '';

            if (portfolioItems.length === 0) {
                portfolioGrid.innerHTML = '<p>No portfolio items to display yet.</p>';
                return;
            }

            portfolioItems.forEach(item => {
                const card = document.createElement('div');
                card.className = 'portfolio-card';

                // Note: The 'category' object is nested inside the 'item' object
                const categoryName = item.category ? item.category.name : 'Uncategorized';

                card.innerHTML = `
                    <img src="${item.imageUrl}" alt="${item.title}">
                    <div class="portfolio-card-content">
                        <span class="portfolio-category-tag">${categoryName}</span>
                        <h3>${item.title}</h3>
                        <p>${item.description}</p>
                        <a href="${item.projectLink}" target="_blank" class="portfolio-link">View Project</a>
                    </div>
                `;

                portfolioGrid.appendChild(card);
            });
        })
        .catch(error => {
            console.error('Error fetching portfolio items:', error);
            portfolioGrid.innerHTML = '<p>Could not load portfolio. Please try again later.</p>';
        });
});