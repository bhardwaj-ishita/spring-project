//GET THE STUDENT THAT IS CURRENTLY LOGGED IN
function getLoggedInStudent() {
    var xrh = new XMLHttpRequest();
    xrh.open('GET', '/student/find/true', false);
    xrh.onload = function () {
        let output= '';
        if(this.status == 200) {
            const members = JSON.parse(this.responseText);
            for(const i in members) {
                if(members[i].isLoggedIn === true) {
                    output = members[i].fullName;
                }
            }
        }
        return output;
    }
    xrh.send();
}


//SHOW THE MESSAGE
function loadMessages() {
    var xrh = new XMLHttpRequest();
    xrh.open('GET', '/discussions/getAll', false);
    xrh.onload = function () {
        if (this.status == 200) {
            const members = JSON.parse(this.responseText);

            let output = '';
            for(const i in members) {
                output +=
                    '<div class="row">\n' +
'                                <div class="col">\n' +
'                                    <ul class="list-group">\n' +
'                                        <li class="list-group-item" style="margin: 5px 5px 0px 5px;">\n' +
'                                            <div class="d-flex media">\n' +
'                                                <div></div>\n' +
'                                                <div class="media-body" class="">\n' +
'                                                    <div class="d-flex media" style="overflow:visible;">\n' +
'                                                        <div></div>\n' +
'                                                        <div style="overflow:visible;" class="media-body">\n' +
'                                                            <div class="row" style="width: 787px;">\n' +
'                                                                <div class="col-10" style="width: 650px;">\n' +
'                                                                    <h5></h5>\n' +
'                                                                    <label class="form-label" id="name-of-sender">' + 'name' + '</label>\n' +
'                                                                    <p style="width: 500px;" id="message-to-send">' + members[i].input + '<br>\n' +
'                                                                        <small class="text-muted">' + members[i].date + ' at ' +  members[i].time + '</small></p>\n' +
'                                                                </div>\n' +
'                                                            </div>\n' +
'                                                        </div>\n' +
'                                                    </div>\n' +
'                                                </div>\n' +
'                                            </div>\n' +
'                                        </li>' +
'                                     </ul>\n' +
'                                </div>\n' +
'                            </div>'
            }

            document.getElementById('message-to-send').innerHTML = output;
        }
    }
    xrh.send();
}


//POSTING NEW MESSAGES TO DB
document.getElementById('sendInput').addEventListener('click', addNewMessage);
function addNewMessage() {
    let input = document.getElementById('send-message').value;
    let xrh = new XMLHttpRequest();
    xrh.open('POST', '/discussions/addMessage', false);
    xrh.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    let params = JSON.stringify({
        "input": input
    });
    console.log(params);
    xrh.send(params);
    loadMessages();
}