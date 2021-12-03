// retrieving token from session storage if it exists
let token = sessionStorage.getItem("token");

document.getElementById("submitButton").addEventListener("click", login);

let apiUrl = "http://localhost:8080";

function login(){
    // resetting error div
    document.getElementById("error-div").innerHTML = "";
    
    //retrieving user credentials
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let xhr = new XMLHttpRequest();
    
    xhr.open("POST", `${apiUrl}/auth`);

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            let authToken = xhr.getResponseHeader("Authorization");

            /*
             storing authtoken in the session storage to be retrieved in different views
                - an item of key "token" and value authToken (Authorization token passed back from Javalin) is stored in the sessionStorage
             */
            sessionStorage.setItem("token", authToken);

            // navigate to a different view (ie: homepage)
            redirect();

        } else if (xhr.readyState === 4){
            // provide user with feedback of failure to login
            document.getElementById("error-div").innerHTML = "Unable to login.";
        }
    } 

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    let requestBody = `username=${username}&password=${password}`;

    xhr.send(requestBody);
}

function redirect() {
    let token = sessionStorage.getItem("token");
      let authToken = sessionStorage.getItem("token");
      if (authToken.split(":")[1] === "3" && token!= null) {
        window.location.href = "/views/Ehome.html";
      } else if(token !=null) {
        window.location.href = "/views/Mhome.html";
      }else {
        window.location.href = "home.html";
      }
    }

function register(){

    document.getElementById("error-div").innerHTML = "";

    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let email = document.getElementById("email").value;

    let newEmployee = { username, password, firstName, lastName,  email };
    let xhr = new XMLHttpRequest();

    xhr.open("POST", `http://localhost:8080/users`);
    // xhr.open("POST", `http://localhost:8080/users/${sessionStorage.token.split(":")[0]}`);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
        let authToken = xhr.getResponseHeader("Authorization");

        sessionStorage.setItem("token", authToken);

        let x = sessionStorage.token;
        window.location.href = "Ehome.html";
        console.log("You are in as an employee!!!");
        } else if (xhr.readyState === 4) {
        document.getElementById("error-div").innerHTML = "Unable to register.";
        }
    };
    let requestBody = JSON.stringify(newEmployee);

    xhr.send(requestBody);
}