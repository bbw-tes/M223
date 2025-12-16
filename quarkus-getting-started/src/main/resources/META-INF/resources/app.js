let token = localStorage.getItem('token');
if (!token) {
    window.location.href = 'login.html'; // Umleitung wenn nicht eingeloggt
}

async function fetchTasks() {
    const response = await fetch('/tasks', {
        headers: { 'Authorization': 'Bearer ' + token }
    });
    const tasks = await response.json();
    const list = document.getElementById('task-list');
    list.innerHTML = '';
    tasks.forEach(t => {
        const li = document.createElement('li');
        li.textContent = t.title + ' - ' + t.description;
        list.appendChild(li);
    });
}

document.getElementById('add-task').addEventListener('click', async () => {
    const title = document.getElementById('title').value;
    const description = document.getElementById('description').value;

    await fetch('/tasks', {
        method: 'POST',
        headers: { 
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + token
        },
        body: JSON.stringify({ title, description })
    });

    fetchTasks();
});

fetchTasks(); // initial laden
