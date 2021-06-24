//GET THE STUDENT THAT IS CURRENTLY LOGGED IN
/*
getLoggedIn not able to send the output to loadMessages
Need to figure out why request is not finished yet
 */
function getLoggedInStudent(){
    return new Promise( function (resolve, reject) {
        var xrh = new XMLHttpRequest();
        xrh.open('GET', '/student/getAllStudents', true);
        xrh.onload = function () {
            let output= '';
            if (this.status === 200) {
                const members = JSON.parse(this.responseText);
                for (let i = members.length - 1; i >= 0; i--) {
                    if (members[i].loggedIn === true) {
                        output = members[i].fullName;
                        break;
                    }
                }
            }
            resolve(output);
        }
        xrh.timeout = 250;
        xrh.send();
    });
}

//SHOW THE MESSAGE
function loadMessages() {
    getLoggedInStudent().then(nameOfSender => {
        var xrh = new XMLHttpRequest();
        xrh.open('GET', '/discussions/getAll', true);
        xrh.onload = function () {
            if (this.status === 200) {
                const members = JSON.parse(this.responseText);

                let output = '';
                for(let i = members.length - 1; i >= 0; i--) {
                    output +=
                        '<div class="row" onload="scrollDown()">\n' +
                        '<div class="col">\n' +
                        '<ul class="list-group" id="list-discussion">\n' +
                        /*'<li class="list-group-item" style="margin: 5px 5px 0px 5px;">\n' +
                        '<div class="d-flex media">\n' +
                        '<div></div>\n' +
                        '<div class="media-body">\n' +
                        '<div class="d-flex media" style="overflow:visible;">\n' +
                        '<div></div>\n' +
                        '<div style="overflow:visible;" class="media-body">\n' +
                        '<div class="row" style="width: 787px;">\n' +
                        '<div class="col-10" style="width: 650px;">\n' +
                        '<h5></h5><label class="form-label">Priyasha</label>\n' +
                        '<p style="width: 500px;">I agree<br>\n' +
                        '<small class="text-muted">' + members[i].date + ' at ' +  members[i].time + '</small></p>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</li>\n' +*/
                        '<li class="list-group-item" style="margin: 0px 5px;border-style: solid;" id="the-messages"><a><label class="form-label">' + nameOfSender + '</label>\n' +
                        '<div class="d-flex media">\n' +
                        '<div></div>\n' +
                        '<div class="media-body">\n' +
                        '<div class="d-flex media" style="overflow:visible;">\n' +
                        '<div></div>\n' +
                        '<div style="overflow:visible;" class="media-body">\n' +
                        '<div class="row">\n' +
                        '<div class="col-md-12">\n' +
                        '<p>' + members[i].input + '<br>\n' +
                        '<small class="text-muted">' + members[i].date + ' at ' +  members[i].time + '</small></p>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</a></li>\n' +
                        '</ul>\n' +
                        '</div>\n' +
                        '</div>'
                }


                document.getElementById('message-to-send').innerHTML = output;
            }
        }
        xrh.send();
    });
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
    document.getElementById('send-message').value='';
    console.log(params);
    xrh.send(params);
    loadMessages();
}

/*
$(function(){
    $('.mybox').scrollTop($(document).height());
  });
*/


/*$(mybox).load(scrollDown);*/
//TRYING TO TARGET THE SCROLLER TO BOTTOM
 scrollDown = function() {
     document.div.scrollTop = document.div.scrollHeight;

     /*
$(function(){
    $('.mybox').scrollTop($(document).height());
  });
*/


     /*$(mybox).load(scrollDown);*/
 }


 //SEARCH FILTER

/*function searchList() {
    let input, filter, ul, li, a, i, txtValue;
    input = document.getElementById("search-field");
    console.log(input);
    filter = input.value.toUpperCase();
    ul = document.getElementById("list-discussion");
    li = ul.getElementsByTagName("the-messages");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}*/
