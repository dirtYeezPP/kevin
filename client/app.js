// Fetch the JSON from your Ktor API
fetch('http://localhost:8080/tasks')
    .then(response => response.json())
    .then(tasks => {
        const container = document.getElementById('task-container');
        container.innerHTML = ''; // Clear the loading text

        // Loop through the tasks and create HTML for each
        tasks.forEach(task => {
            const taskDiv = document.createElement('div');
            taskDiv.className = 'task-card';
            taskDiv.innerHTML = `
                        <h3>${task.name} (Priority: ${task.priority})</h3>
                        <p>${task.description}</p>
                        <p>${task.time}</p>
                        
                    `;
            container.appendChild(taskDiv);
        });
    })
    .catch(error => {
        console.error("Error fetching data:", error);
        document.getElementById('task-container').innerText = "Failed to connect to the server.";
    });



document.getElementById('task-form').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevents the page from refreshing

    // Build the data object
    const newTask = {
        name: document.getElementById('task-name').value,
        description: document.getElementById('task-desc').value,
        priority: document.getElementById('task-priority').value,
        time: document.getElementById('task-time').value
    };

    // Send the data to Kotlin
    fetch('http://localhost:8080/tasks', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newTask)
    })
        .then(response => {
            if (response.ok) {
                console.log("Task successfully sent to server!");
                // You can optionally call your fetch() function here to refresh the UI list
            }
        })
        .catch(error => console.error("Error saving task:", error));
});

