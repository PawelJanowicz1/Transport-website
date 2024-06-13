function submitContactForm(event){
event.preventDefault();
const form = document.getElementById("contactForm")
const formData = new FormData(form);

let name =  formData.get('name');
let email = formData.get('email');
let phoneNumber = formData.get('phoneNumber');
}