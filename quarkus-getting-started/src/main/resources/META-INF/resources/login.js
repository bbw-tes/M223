document.getElementById('login').addEventListener('click', async () => {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const response = await fetch('/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
    });

    if (response.ok) {
        const data = await response.json();
        localStorage.setItem('token', data.token); // JWT speichern
        window.location.href = 'index.html'; // Weiterleitung zur Todo-Seite
    } else {
        alert('Login fehlgeschlagen');
    }
});
