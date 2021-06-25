function loadAssignments() {
    let request = new XMLHttpRequest();
    request.open('GET', '/getAll', false);

    request.onload = function () {
        console.log("STATUS");
        console.log(this.status);
        let data = JSON.parse(this.responseText);
        let output = '';
        let listof = document.getElementById('assignmentList');
        for (const i in data) {

            console.log(data[i]);

            let sub = 'Not Submitted';
            let ttype = "table-danger";
            if (data[i].status === true)  {
                sub = 'Submitted';
                ttype = "table-success"
            }

            let row = document.createElement("tr");

            let sno = document.createElement("td");
            let snodata = document.createTextNode(data[i].sno);
            sno.appendChild(snodata);
            row.appendChild(sno);

            sno = document.createElement("td");
            snodata = document.createTextNode(data[i].title);
            sno.appendChild(snodata);
            row.appendChild(sno);

            sno = document.createElement("td");
            snodata = document.createTextNode(data[i].date);
            sno.appendChild(snodata);
            row.appendChild(sno);

            sno = document.createElement("td");
            snodata = document.createTextNode(data[i].dueDate);
            sno.appendChild(snodata);
            row.appendChild(sno);

            sno = document.createElement("td");
            snodata = document.createTextNode(sub);
            sno.classList.add(ttype);
            sno.appendChild(snodata);
            row.appendChild(sno);

            sno = document.createElement("td");
            sno.style.cssText = "text-align: center;height: 30px;";

            snodata = document.createElement("button");
            snodata.classList.add("btn");
            snodata.classList.add("btn-primary");
            snodata.classList.add("text-end");
            snodata.type = "button";
            snodata.style.cssText = "background: var(--bs-table-bg);border-color: var(--bs-table-bg);color: var(--bs-table-bg);padding: 0px;";

            let frame = document.createElement("i");
            frame.classList.add("fa");
            frame.classList.add("fa-upload");
            frame.style.cssText = "height: -7px;width: 21.9px;background: var(--bs-table-bg);text-align: center;color: var(--bs-table-striped-color);";

            snodata.appendChild(frame);
            sno.appendChild(snodata);
            row.appendChild(sno);
            listof.appendChild(row);
        }
    }

    request.send();
}

loadAssignments();