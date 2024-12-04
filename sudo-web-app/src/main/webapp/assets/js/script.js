document.getElementById("registrationForm").addEventListener("submit", function (event) {
    const username = document.getElementById("username").value.trim();
    const email = document.getElementById("email").value.trim();
    const errorMessage = document.getElementById("errorMessage");

    if (!username || !email) {
        errorMessage.textContent = "All fields are required.";
        event.preventDefault();
    } else if (!validateEmail(email)) {
        errorMessage.textContent = "Please enter a valid email address.";
        event.preventDefault();
    } else {
        errorMessage.textContent = ""; // Clear error
    }
});

function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
}
