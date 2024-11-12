document.addEventListener('DOMContentLoaded', () => {
    const contactForm = document.getElementById('contactForm');
    const submitButton = contactForm.querySelector('button[type="submit"]');

    contactForm.addEventListener('submit', async (event) => {
        event.preventDefault();
        await sendContactForm();
    });

    async function sendContactForm() {
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const phoneNumber = document.getElementById('phoneNumber').value;
        const message = document.getElementById('message').value;

        disableSubmitButton(submitButton);

        const payload = {
            name: name,
            email: email,
            phoneNumber: phoneNumber ? phoneNumber : null,
            message: message
        };

        try {
            const response = await fetch('https://dobrypiasek.pl/email/send-email', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8',
                    'Accept': 'application/json'
                },
                body: JSON.stringify(payload)
            });

            if (response.ok) {
                document.getElementById('contactForm').style.display = 'none';
                const successMessage = document.querySelector('.successMessage');
                successMessage.classList.add('show');
            }
            else {
                const errorMessage = await response.text();
                alert('Błąd podczas wysyłania emaila: ' + errorMessage);
            }
        } catch (error) {
            alert('Wystąpił błąd: ' + error.message);
        } finally {
            enableSubmitButton(submitButton);
        }
    }

    function disableSubmitButton(button) {
        button.disabled = true;
        button.innerText = 'Wysyłanie...';
        const spinner = button.querySelector('.spinner-border');
        if (spinner) {
            spinner.style.display = 'inline-block';
        }
    }

    function enableSubmitButton(button) {
        button.disabled = false;
        button.innerText = 'Wyślij';
        const spinner = button.querySelector('.spinner-border');
        if (spinner) {
            spinner.style.display = 'none';
        }}
});