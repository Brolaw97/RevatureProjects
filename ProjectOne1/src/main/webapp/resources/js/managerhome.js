

let xhtml = new XMLHttpRequest();

window.onload = function () {
    getAllReimbursements();

    document.getElementById("updateFoodButton").addEventListener('click', updateReimbursement);
    document.getElementById("pendingStatus").addEventListener('click', viewByPending);
    document.getElementById("approvedStatus").addEventListener('click', viewByApproved);
    document.getElementById("deniedStatus").addEventListener('click', viewByDenied);
    document.getElementById("allStatus").addEventListener('click', getAllReimbursements);

}


function getAllReimbursements() {

    xhtml.onreadystatechange = function () {

        if (xhtml.readyState == 4 && xhtml.status == 200) {

            let reimb = JSON.parse(xhtml.responseText);

            showAllReimbDOM(reimb);
        }
    }

    xhtml.open('GET', 'http://localhost:9001/ProjectOne1/forwarding/allreimbursements');
    xhtml.send();

}
function viewByPending() {

    xhtml.onreadystatechange = function () {

        if (xhtml.readyState == 4 && xhtml.status == 200) {

            let reimb = JSON.parse(xhtml.responseText);

            showAllReimbDOM(reimb);
        }
    }

    xhtml.open('GET', 'http://localhost:9001/ProjectOne1/forwarding/viewstatuspending');
    xhtml.send();

}
function viewByApproved() {

    xhtml.onreadystatechange = function () {

        if (xhtml.readyState == 4 && xhtml.status == 200) {

            let reimb = JSON.parse(xhtml.responseText);

            showAllReimbDOM(reimb);
        }
    }

    xhtml.open('GET', 'http://localhost:9001/ProjectOne1/forwarding/viewstatusapproved');
    xhtml.send();

}
function viewByDenied() {

    xhtml.onreadystatechange = function () {

        if (xhtml.readyState == 4 && xhtml.status == 200) {

            let reimb = JSON.parse(xhtml.responseText);

            showAllReimbDOM(reimb);
        }
    }

    xhtml.open('GET', 'http://localhost:9001/ProjectOne1/forwarding/viewstatusdenied');
    xhtml.send();

}

function updateReimbursement() {
    let updateValues = {
        reimbId: document.getElementById('updateId').value,
        statusId: document.getElementById('updateStatus').value
    };

    xhtml.onreadystatechange = function () {

        if (xhtml.readyState == 4 && xhtml.status == 200) {
            getAllReimbursements();
        }
    }
    xhtml.open('POST', `http://localhost:9001/ProjectOne1/forwarding/updatereimbursement`);
    xhtml.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    xhtml.send(JSON.stringify(updateValues));

}


function showAllReimbDOM(reimb) {

    let ourReturn = document.getElementById("reimbTableBody");
    ourReturn.innerText = "";
    for (let i = 0; i < reimb.length; i++) {
        ////////////CREATE ELEMENTS DYNAMICALLY////////////////

        //step 1: creaitng our new elements
        let newTR = document.createElement("tr");
        let newTH = document.createElement("th");

        let newTD1 = document.createElement("td");
        let newTD2 = document.createElement("td");
        let newTD3 = document.createElement("td");
        let newTD4 = document.createElement("td");
        let newTD5 = document.createElement("td");
        let newTD6 = document.createElement("td");
        let newTD7 = document.createElement("td");

        //step 2: populate our creations
        newTH.setAttribute("scope", "row");
        let myTextH = document.createTextNode(reimb[i].reimbId);
        let myTextD1 = document.createTextNode(reimb[i].amount);
        let myTextD2 = document.createTextNode(reimb[i].submitDate);
        let myTextD3 = document.createTextNode(reimb[i].resolveDate);
        let myTextD4 = document.createTextNode(reimb[i].authorId);
        let myTextD5 = document.createTextNode(reimb[i].resolverId);
        let myTextD6 = document.createTextNode(reimb[i].statusId);
        let myTextD7 = document.createTextNode(reimb[i].typeId);

        //all appending
        newTH.appendChild(myTextH);
        newTD1.appendChild(myTextD1);
        newTD2.appendChild(myTextD2);
        newTD3.appendChild(myTextD3);
        newTD4.appendChild(myTextD4);
        newTD5.appendChild(myTextD5);
        newTD6.appendChild(myTextD6);
        newTD7.appendChild(myTextD7);

        newTR.appendChild(newTH);
        newTR.appendChild(newTD1);
        newTR.appendChild(newTD2);
        newTR.appendChild(newTD3);
        newTR.appendChild(newTD4);
        newTR.appendChild(newTD5);
        newTR.appendChild(newTD6);
        newTR.appendChild(newTD7);

        let newSelection = document.querySelector("#reimbTableBody");
        newSelection.appendChild(newTR);
    }
}









