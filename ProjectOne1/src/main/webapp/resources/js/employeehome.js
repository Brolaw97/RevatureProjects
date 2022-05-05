let xhtml = new XMLHttpRequest();

window.onload = function () {
    getAllReimbursements();

    document.getElementById("updateFoodButton").addEventListener('click', createReimbursement);
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

    xhtml.open('GET', 'http://localhost:9001/ProjectOne1/forwarding/viewreimbursements');
    xhtml.send();

}
function viewByPending() {

    xhtml.onreadystatechange = function () {

        if (xhtml.readyState == 4 && xhtml.status == 200) {

            let reimb = JSON.parse(xhtml.responseText);

            showAllReimbDOM(reimb);
        }
    }

    xhtml.open('GET', 'http://localhost:9001/ProjectOne1/forwarding/viewemployeepending');
    xhtml.send();

}
function viewByApproved() {

    xhtml.onreadystatechange = function () {

        if (xhtml.readyState == 4 && xhtml.status == 200) {

            let reimb = JSON.parse(xhtml.responseText);

            showAllReimbDOM(reimb);
        }
    }

    xhtml.open('GET', 'http://localhost:9001/ProjectOne1/forwarding/viewemployeeapproved');
    xhtml.send();

}
function viewByDenied() {

    xhtml.onreadystatechange = function () {

        if (xhtml.readyState == 4 && xhtml.status == 200) {

            let reimb = JSON.parse(xhtml.responseText);

            showAllReimbDOM(reimb);
        }
    }

    xhtml.open('GET', 'http://localhost:9001/ProjectOne1/forwarding/viewemployeedenied');
    xhtml.send();

}
function createReimbursement() {
    var x = document.getElementById("amount").value;
    int_part = Math.trunc(x);
    float_part = Number((x - int_part).toFixed(2));
    let amount = int_part + float_part;

    let reimbValues = {
        amount: amount,
        typeId: document.getElementById("typeId").value
    }

    xhtml.onreadystatechange = function () {

        if (xhtml.readyState == 4 && xhtml.status == 200) {

            getAllReimbursements();
        }
    }

    xhtml.open('POST', 'http://localhost:9001/ProjectOne1/forwarding/createreimbursement');
    xhtml.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    xhtml.send(JSON.stringify(reimbValues));
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