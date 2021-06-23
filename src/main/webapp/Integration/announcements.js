function loadAllAnnouncments() {
    xrh = new XMLHttpRequest();
    xrh.open('GET', '/announcement/getAll', false);
    xrh.onload = function () {
        console.log("Status:");
        console.log(this.status);
        if (this.status === 200) {
            const data = JSON.parse(this.responseText);
            let output = '';
            for (const i in data) {
                output += '<li class="list-group-item"><div class="d-flex media"><div class="media-body"> <div class="d-flex media" style="overflow:visible;"><div></div><div style="overflow:visible;" class="media-body"><div class="row" style="width: 797px;"><div class="col-10"><h5></h5><p>';
                output += data[i].announcement;
                output += '<br><small class="text-muted">';
                output += data[i].date;
                output += ' at ' + data[i].time.substring(0, 5);
                output += '</small></p></div></div></div></div></div></div></li>';
            }
            document.getElementById('announcementsList').innerHTML = output;
        }
    }
    xrh.send();
}

loadAllAnnouncments();


// {/* <li class="list-group-item">
//     <div class="d-flex media">
//         <div class="media-body">
//             <div class="d-flex media" style="overflow:visible;">
//                 <div></div>
//                 <div style="overflow:visible;" class="media-body">
//                     <div class="row" style="width: 797px;">
//                         <div class="col-10">
//                             <h5></h5>
//                             <p>Assignment-7 added for submission (due on
//                                 28/06/21)<br>
//                                 <small class="text-muted">21/01/21 at 9:00am
//                                 </small>
//                             </p>
//                         </div>
//                     </div>
//                 </div>
//             </div>
//         </div>
//     </div>
// </li> */}