

document.addEventListener('DOMContentLoaded', () => {
    const contactForm = document.getElementById('contact-form');
    const formStatus = document.getElementById('form-status');

    contactForm.addEventListener('submit', (event) => {
        // Prevent the default form submission (which causes a page reload)
        event.preventDefault();

        // Show a "sending" message
        formStatus.textContent = 'Sending...';
        formStatus.className = ''; // Reset classes

        // Create a FormData object from the form
        const formData = new FormData(contactForm);
        // Convert FormData to a plain JavaScript object
        const formObject = Object.fromEntries(formData.entries());

        // Send the data to the backend API using a POST request, with the full URL
        fetch('/api/contact', {            // <-- correct endpoint, no stray comma
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formObject),
        })
        .then(response => {
            if (!response.ok) {
                // If the server responds with an error status, throw an error
                throw new Error('Server responded with an error.');
            }
            return response.json();
        })
        .then(data => {
            // Handle success
            formStatus.textContent = 'Thank you! Your message has been sent successfully.';
            formStatus.className = 'success';
            contactForm.reset(); // Clear the form fields
        })
        .catch(error => {
            // Handle failure
            console.error('Error submitting form:', error);
            formStatus.textContent = 'Sorry, there was an error sending your message. Please try again.';
            formStatus.className = 'error';
        });
    });
});