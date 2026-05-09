<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Simple Login</title>
    <style>
        body { font-family: sans-serif; display: flex; justify-content: center; padding-top: 50px; }
        .login-container { border: 1px solid #ccc; padding: 20px; border-radius: 8px; width: 300px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input { width: 100%; padding: 8px; box-sizing: border-box; }
        button { width: 100%; padding: 10px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background-color: #0056b3; }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Login</h2>
    <form id="loginForm">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Submit</button>
    </form>
    <p id="message"></p>
</div>

<script>
    // Grab the form element
    const loginForm = document.getElementById('loginForm');
    const message = document.getElementById('message');

    // Add event listener for form submission
    loginForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Stop the page from refreshing

        // Extract values from the inputs
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        // Basic validation logic
        if (username === "admins" && password === "1010101") {
            message.style.color = "green";
            message.textContent = "Login successful!";
            console.log("Logged in as:", username);
        } else {
            message.style.color = "red";
            message.textContent = "Invalid username or password.";
        }
    });
</script>

</body>
</html>
