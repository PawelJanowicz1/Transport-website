document.addEventListener('DOMContentLoaded', () => {
    const contactForm = document.getElementById('contactForm');
    const submitButton = contactForm.querySelector('button[type="submit"]');

    contactForm.addEventListener('submit', async (event) => {
        event.preventDefault();
        if (validateForm()) {
            await sendContactForm();
        }
    });

    function validateForm() {
        let isValid = true;

        const nameInput = document.getElementById('name');
        const phoneNumberInput = document.getElementById('phoneNumber');
        const emailInput = document.getElementById('email');
        const messageInput = document.getElementById('message');

        const namePattern = /^[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+$/;
        if (!nameInput.value || nameInput.value.length > 12 || !namePattern.test(nameInput.value)) {
            isValid = false;
            alert('Proszę wprowadzić poprawne imię (maksymalnie 12 liter, bez cyfr i znaków specjalnych).');
        }

        const phonePattern = /^(?:\+48\s?\d{3}\s?\d{3}\s?\d{3}|\+48\d{9}|\d{9}|\d{3}\s?\d{3}\s?\d{3})$/;
        if (!phoneNumberInput.value || !phonePattern.test(phoneNumberInput.value)) {
            isValid = false;
            alert('Proszę wprowadzić poprawny numer telefonu.');
        }

        if (!emailInput.value || emailInput.value.length > 25 || !validateEmail(emailInput.value)) {
            isValid = false;
            alert('Proszę wprowadzić poprawny adres email (maksymalnie 25 znaków).');
        }

        const messagePattern = /^[\w\s.,;:'"\-ąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+$/;
        if (!messageInput.value || messageInput.value.length > 500 || !messagePattern.test(messageInput.value)) {
            isValid = false;
            alert('Proszę wprowadzić poprawną wiadomość (maksymalnie 500 znaków).');
        }

        return isValid;
    }

    function validateEmail(email) {
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailPattern.test(email);
    }

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
        }
    }
});