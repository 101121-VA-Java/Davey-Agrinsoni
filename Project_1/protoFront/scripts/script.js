function logout() {
  sessionStorage.clear();
}

function redirect() {
  let token = sessionStorage.getItem("token");
  let authToken = sessionStorage.getItem("token");
  if (authToken.split(":")[1] === "3" && token != null) {
    window.location.href = "/views/Edash.html";
  } else if (token != null) {
    window.location.href = "/views/Mdash.html";
  } else {
    window.location.href = "home.html";
  }
}

function clearAll() {
  while (tableBody.firstChild) {
    tableBody.removeChild(tableBody.firstChild);
  }
}

function getAllPending() {
  let xhr = new XMLHttpRequest();
  xhr.open("GET", `http://localhost:8080/reimbursements/status/1`);

  xhr.setRequestHeader("Authorization", sessionStorage.token);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
      let reims = xhr.response;
      reims = JSON.parse(reims);
      printPending(reims);
    } else if (xhr.readyState === 4) {
      document.getElementById("error-div").innerHTML = "Unable to find Reimbursements.";
    }
  };
  xhr.send();
}

function printPending(reims) {
  reims.forEach((row) => {
    const tr = document.createElement("tr");
    const td1 = document.createElement("td");
    const td2 = document.createElement("td");
    const td3 = document.createElement("td");
    const td4 = document.createElement("td");
    const td5 = document.createElement("td");
    const td6 = document.createElement("td");
    const td7 = document.createElement("td");

    td1.textContent = row.reimbId;
    tr.appendChild(td1);
    td2.textContent = row.amount;
    tr.appendChild(td2);
    td3.textContent = timeFix(row.timeSubmitted);
    tr.appendChild(td3);
    td4.textContent = row.description;
    tr.appendChild(td4);
    td5.textContent = row.reimbAuthor.username;
    tr.appendChild(td5);
    td6.textContent = row.statusId.status;
    tr.appendChild(td6);
    td7.textContent = row.typeId.type;
    tr.appendChild(td7);
    $('<td><input type="checkbox"/></td>').appendTo(tr);
    tableBody.appendChild(tr);
  });
}

function timeFix(time) {
  if (time != null) {
    var d = new Date(time);
    var formattedDate =
      d.getMonth() + 1 + "/" + d.getDate() + "/" + d.getFullYear();
    var hours = d.getHours() < 10 ? "0" + d.getHours() : d.getHours();
    var minutes = d.getMinutes() < 10 ? "0" + d.getMinutes() : d.getMinutes();
    var formattedTime = hours + ":" + minutes;
    formattedDate = formattedDate + " " + formattedTime;
  }
  return formattedDate;
}

function GetSelected() {
  //Reference the Table.
  var grid = document.getElementById("choiceTable");

  //Reference the CheckBoxes in Table.
  var checkBoxes = grid.getElementsByTagName("INPUT");
  let array = [];

  //Loop through the CheckBoxes.
  for (var i = 0; i < checkBoxes.length; i++) {
    if (checkBoxes[i].checked) {
      var row = checkBoxes[i].parentNode.parentNode;
      array.push(row.cells[0].innerHTML);
    }
  }
  return array;
}

function approveAllSelectedReimsById() {
  let array = GetSelected();
  array.forEach(function (x) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", `http://localhost:8080/reimbursements/${x}`);
    xhr.setRequestHeader("Authorization", sessionStorage.token);
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
        let reims = xhr.response;
        reims = JSON.parse(reims);
        acceptSelectedReims(reims);
      } else if (xhr.readyState === 4) {
        document.getElementById("error-div").innerHTML = "Unable to find User Reimbursements.";
      }
    };
    xhr.send();
  });

}

function acceptSelectedReims(reims) {
  document.getElementById("error-div").innerHTML = "";
  let xhr1 = new XMLHttpRequest();
  reims.statusId.statusId = 2;
  xhr1.onreadystatechange = function () {
    if (xhr1.readyState === 4 && xhr1.status >= 200 && xhr1.status < 300) {
      document.getElementById("error-div").innerHTML = "Update successful.";
      location.reload();
    } else {
      document.getElementById("error-div").innerHTML = "Update failed.";
    }
  };
  xhr1.open("PUT", `http://localhost:8080/reimbursements/${reims.reimbId}`);
  xhr1.setRequestHeader("Authorization", sessionStorage.token);
  xhr1.send(JSON.stringify(reims));
}

function denyAllSelectedReimsById() {
  let array = GetSelected();
  array.forEach(function (x) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", `http://localhost:8080/reimbursements/${x}`);
    xhr.setRequestHeader("Authorization", sessionStorage.token);
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
        let reims = xhr.response;
        reims = JSON.parse(reims);

        denySelectedReims(reims);
      } else if (xhr.readyState === 4) {
        document.getElementById("error-div").innerHTML = "Unable to find User Reimbursements.";
      }
    };
    xhr.send();
  });

}

function denySelectedReims(reims) {
  document.getElementById("error-div").innerHTML = "";
  let xhr1 = new XMLHttpRequest();
  reims.statusId.statusId = 3;
  xhr1.onreadystatechange = function () {
    if (xhr1.readyState === 4 && xhr1.status >= 200 && xhr1.status < 300) {
      document.getElementById("error-div").innerHTML = "Update successful.";
      location.reload();
    } else {
      document.getElementById("error-div").innerHTML = "Update failed.";
    }
  };
  xhr1.open("PUT", `http://localhost:8080/reimbursements/${reims.reimbId}`);
  xhr1.setRequestHeader("Authorization", sessionStorage.token);
  xhr1.send(JSON.stringify(reims));
}

function getAllAReims() {
  let xhr = new XMLHttpRequest();
  xhr.open("GET", `http://localhost:8080/reimbursements/status/2`);

  xhr.setRequestHeader("Authorization", sessionStorage.token);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
      let reims = xhr.response;
      reims = JSON.parse(reims);
      printReims(reims);
    } else if (xhr.readyState === 4) {
      // provide user with feedback of failure to login
      document.getElementById("error-div").innerHTML = "Unable to find Reimbursements.";
    }
  };
  xhr.send();
}

function getAllDReims() {
  let xhr = new XMLHttpRequest();
  xhr.open("GET", `http://localhost:8080/reimbursements/status/3`);

  xhr.setRequestHeader("Authorization", sessionStorage.token);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
      let reims = xhr.response;
      reims = JSON.parse(reims);
      printReims(reims);
    } else if (xhr.readyState === 4) {
      // provide user with feedback of failure to login
      document.getElementById("error-div").innerHTML = "Unable to find Reimbursements.";
    }
  };
  xhr.send();
}

function printReims(reims) {
  reims.forEach((row) => {
    const tr = document.createElement("tr");
    const td1 = document.createElement("td");
    const td2 = document.createElement("td");
    const td3 = document.createElement("td");
    const td4 = document.createElement("td");
    const td5 = document.createElement("td");
    const td6 = document.createElement("td");
    const td7 = document.createElement("td");
    const td8 = document.createElement("td");
    const td9 = document.createElement("td");

    td1.textContent = row.reimbId;
    tr.appendChild(td1);
    td2.textContent = row.amount;
    tr.appendChild(td2);
    td3.textContent = timeFix(row.timeSubmitted);
    tr.appendChild(td3);
    td4.textContent = timeFix(row.timeResolved);
    tr.appendChild(td4);
    td5.textContent = row.description;
    tr.appendChild(td5);
    td6.textContent = row.reimbAuthor.username;
    tr.appendChild(td6);
    td7.textContent = row.reimbResolver.username;
    tr.appendChild(td7);
    td8.textContent = row.statusId.status;
    tr.appendChild(td8);
    td9.textContent = row.typeId.type;
    tr.appendChild(td9);
    tableBody.appendChild(tr);
  });
}

function getAllUsers() {
  let xhr = new XMLHttpRequest();
  xhr.open("GET", `http://localhost:8080/users`);
  xhr.setRequestHeader("Authorization", sessionStorage.token);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
      let users = xhr.response;
      users = JSON.parse(users);
      printUsers(users);
    } else if (xhr.readyState === 4) {
      // provide user with feedback of failure to login
      document.getElementById("error-div").innerHTML =
        "Unable to find User Profile.";
    }
  };
  xhr.send();
}

function printUsers(users) {
  while (tableBody.firstChild) {
    tableBody.removeChild(tableBody.firstChild);
  }
  users.forEach((row) => {
    const tr = document.createElement("tr");
    // tr.textContent = row.id;
    const td1 = document.createElement("td");
    const td2 = document.createElement("td");
    const td3 = document.createElement("td");
    const td4 = document.createElement("td");
    const td5 = document.createElement("td");
    td1.textContent = row.userId;
    tr.appendChild(td1);
    td2.textContent = row.firstName + " " + row.lastName;
    tr.appendChild(td2);
    td3.textContent = row.username;
    tr.appendChild(td3);
    td4.textContent = row.email;
    tr.appendChild(td4);
    td5.textContent = row.role.role;
    tr.appendChild(td5);
    tableBody.appendChild(tr);
  });
}

function getReimbById() {
  let empId = document.getElementById("empId").value;

  let xhr = new XMLHttpRequest();
  xhr.open("GET", `http://localhost:8080/reimbursements/author/${empId}`);
  xhr.setRequestHeader("Authorization", sessionStorage.token);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
      let reimbs = xhr.response;
      reimbs = JSON.parse(reimbs);
      printReims(reimbs);
    } else if (xhr.readyState === 4) {
      document.getElementById("error-div").innerHTML = "Unable to find User Profile.";
    }
  };
  xhr.send();
}

function newClaim() {
  document.getElementById("error-div").innerHTML = "";

  let amount = document.getElementById("reimAmount").value;
  let description = document.getElementById("descrip").value;
  let radio = document.getElementsByName("mergeType");
  let typeId = 0;
  for(let i = 0; i < radio.length; i++) {
    if(radio[i].checked){
      typeId = radio[i].value;
      }
    }


  let newReim = { amount, description, typeId};
  let xhr = new XMLHttpRequest();

  xhr.open("POST", "http://localhost:8080/reimbursements");

  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
      document.getElementById("error-div").innerHTML =
        "You have succesfully posted a claim please wait for approval!";
    } else if (xhr.readyState === 4) {
      document.getElementById("error-div").innerHTML = "Unable to make a new claim.";
    }
  };
  let requestBody = JSON.stringify(newReim);
  xhr.setRequestHeader("Authorization", sessionStorage.token);
  xhr.send(requestBody);
}

function getAllRequestsByStatusAndAuthorP() {
  let xhr = new XMLHttpRequest();
  xhr.open("GET", `http://localhost:8080/reimbursements/status/1?author_id=${sessionStorage.token.split(":")[0]}`);

  xhr.setRequestHeader("Authorization", sessionStorage.token);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
      let reims = xhr.response;
      reims = JSON.parse(reims);
      printReims(reims);
    } else if (xhr.readyState === 4) {
      document.getElementById("error-div").innerHTML ="Unable to find Reimbursements.";
    }
  };
  xhr.send();
}

function getAllRequestsByStatusAndAuthorA() {
  let xhr = new XMLHttpRequest();
  xhr.open("GET", `http://localhost:8080/reimbursements/status/2?author_id=${sessionStorage.token.split(":")[0]}`);

  xhr.setRequestHeader("Authorization", sessionStorage.token);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
      let reims = xhr.response;
      reims = JSON.parse(reims);
      printReims(reims);
    } else if (xhr.readyState === 4) {
      document.getElementById("error-div").innerHTML ="Unable to find Reimbursements.";
    }
  };
  xhr.send();
}

function getAllRequestsByStatusAndAuthorD() {
  let xhr = new XMLHttpRequest();
  xhr.open("GET", `http://localhost:8080/reimbursements/status/3?author_id=${sessionStorage.token.split(":")[0]}`);

  xhr.setRequestHeader("Authorization", sessionStorage.token);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
      let reims = xhr.response;
      reims = JSON.parse(reims);
      printReims(reims);
    } else if (xhr.readyState === 4) {
      document.getElementById("error-div").innerHTML ="Unable to find Reimbursements.";
    }
  };
  xhr.send();
}
function getUserProfile() {
  document.getElementById("error-div").innerHTML = "";
  let xhr = new XMLHttpRequest();
  xhr.open(
    "GET", `http://localhost:8080/users/${sessionStorage.token.split(":")[0]}`
  );
  xhr.setRequestHeader("Authorization", sessionStorage.token);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
      let user = xhr.response;
      user = JSON.parse(user);
      document.getElementById("name").innerHTML = user.firstName + " " + user.lastName;
      document.getElementById("username").innerHTML = "Username: "+ user.username;
      document.getElementById("email").innerHTML = "Email: " + user.email;
      document.getElementById("role").innerHTML = "Role: "+ user.role.role;
    } else if (xhr.readyState === 4) {
      document.getElementById("error-div").innerHTML = "Unable to find User Profile.";
    }
  };
  xhr.send();
}

function updateUserProfile() {
  document.getElementById("error-div").innerHTML = "";
  let xhr = new XMLHttpRequest();
  let firstName = document.getElementById("firstName").value;
  let lastName = document.getElementById("lastName").value;
  let username = document.getElementById("username").value;
  let password = document.getElementById("password").value;
  let email = document.getElementById("email").value;

  let updatedEmployee = {
    username,
    password,
    firstName,
    lastName,
    email
  };
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
      document.getElementById("error-div").innerHTML = "Update successfull.";
      window.location.href = "/views/EProfile.html";
    } else {
      document.getElementById("error-div").innerHTML = "Update failed.";
    }
  };
  xhr.open(
    "PUT",`http://localhost:8080/users/${sessionStorage.token.split(":")[0]}`);
  xhr.setRequestHeader("Authorization", sessionStorage.token);
  xhr.send(JSON.stringify(updatedEmployee));
}
