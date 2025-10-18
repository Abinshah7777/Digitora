// This function runs when the page is fully loaded
document.addEventListener('DOMContentLoaded', () => {
    
    // Find the container where we will display the services
    const servicesGrid = document.getElementById('services-grid');

    // Fetch the service data from our backend API
    fetch('/api/services')
        .then(response => {
            // Check if the request was successful
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Convert the response to JSON
        })
        .then(services => {
            // Clear the "Loading..." message
            servicesGrid.innerHTML = ''; 

            // If there are no services, display a message
            if (services.length === 0) {
                servicesGrid.innerHTML = '<p>No services available at the moment.</p>';
                return;
            }

            // Loop through each service and create an HTML card for it
            services.forEach(service => {
                const card = document.createElement('div');
                card.className = 'service-card';
                
                card.innerHTML = `
                    <h3>${service.title}</h3>
                    <p>${service.description}</p>
                `;
                
                servicesGrid.appendChild(card);
            });
        })
        .catch(error => {
            // If there's an error (e.g., backend is down), display an error message
            console.error('Error fetching services:', error);
            servicesGrid.innerHTML = '<p>Could not load services. Please try again later.</p>';
        });
});