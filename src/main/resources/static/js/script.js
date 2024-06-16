document.addEventListener('DOMContentLoaded', () => {
    const contactForm = document.getElementById('contactForm');
    contactForm.addEventListener('submit', (event) => {
        event.preventDefault();
        sendContactForm();
    });
});

function validateForm(name, email, phoneNumber, message) {
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const phonePattern = /^\d{9}$/;

    if (!name.trim()) {
        alert('Pole "Imię" nie może być puste.');
        return false;
    }
    if (!emailPattern.test(email)) {
        alert('Pole "Email" musi zawierać poprawny adres email.');
        return false;
    }
    if (phoneNumber && !phonePattern.test(phoneNumber)) {
        alert('Pole "Numer telefonu" musi zawierać 9 cyfr.');
        return false;
    }
    if (!message.trim()) {
        alert('Pole "Wiadomość" nie może być puste.');
        return false;
    }
    return true;
}

async function sendContactForm() {
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const phoneNumber = document.getElementById('phoneNumber').value;
    const message = document.getElementById('message').value;

    if (!validateForm(name, email, phoneNumber, message)) {
        return;
    }

    try {
        const response = await fetch(`http://localhost:8064/email/send-email?name=${encodeURIComponent(name)}&email=${encodeURIComponent(email)}&phoneNumber=${encodeURIComponent(phoneNumber)}&message=${encodeURIComponent(message)}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            }
        });

        if (response.ok) {
            document.getElementById('contactFormContainer').style.display = 'none';
            document.getElementById('successMessage').style.display = 'block';
        } else {
            const errorMessage = await response.text();
            alert('Błąd podczas wysyłania emaila: ' + errorMessage);
        }
    } catch (error) {
        alert('Wystąpił błąd: ' + error.message);
    }
}