function loadResource() {
    let request = new XMLHttpRequest();
    request.open('GET', '/resource/getAll', false);

    request.onload = function (){
        let data = JSON.parse(this.responseText);
        let output = '';
        for (const i in data){
            output += '<tr><td>'+ data[i].SNo + '</td><td>' + data[i].nameOfProfessor +'</td><td>' + data[i].resource +'</td><td><a href="#">' + data[i].date + '</a></td></tr>'

        }
        document.getElementById('resourceList').innerHTML = output;
    }

    request.send();

}

loadResource();

//
//<tr>
//                                            <td>1</td>
//                                            <td>Course Book</td>
//                                            <td>24/06/21</td>
//                                            <td><a href="#">Course Book</a></td>
//                                        </tr>