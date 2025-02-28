var emailLista = [];

function kuldes() {
    var email = document.querySelector(".email").value;
    var ertekeles = document.querySelector(".ertekeles").value;
    var nev= document.querySelector(".nev").value;

    var tbody = document.querySelector("tbody");

    emailLista.push(email);
    tbody.innerHTML += `<tr>
                        <th scope="row">${emailLista.length}</th>
                        <td>${nev}</td>
                        <td>${email}</td>
                        <td>${ertekeles}}</td>
                      </tr>`;
    emailListaKiir();
}

function emailListaKiir() {
    if(!nevVizsgal()) return;
    if(!emailVizsgal()) return;
    if(!ertekelVizsgal()) return;
    var lista = document.querySelector(".emailLista");
    lista.innerHTML = "";
    for (let i = 0; i < emailLista.length; i++) {
        lista.innerHTML += "<li>" + emailLista[i] + "</li>";
    }
}

function emailVizsgal(vizsgalandoEmail){
    var vizsgalandoEmail = document.querySelector(".email").value.trim();
    const szamok = "0123456789";

    if(vizsgalandoEmail == ""){
        alert("Ez a mező nem állhat üresen!")
        return false;
    }

    for (let i = 0; i < szamok.length; i++) {
        if(vizsgalandoEmail.includes(szamok[i])){
            alert("Az e-mail nem tartalmazhat számokat!")
            return false;
        }
    }
    alert("Sikeres E-mail cím bevitel!");
    return true;
}

function uzenetVizsgal(vizsgalandoNev){
    var vizsgalandoNev = document.querySelector(".nev").value.trim();
    const szamok = "0123456789";    

    if(vizsgalandoNev == ""){
        alert("Ez a mező nem állhat üresen!");
        return false;
     }

     for (let i = 0; i < szamok.length; i++) {
            if(vizsgalandoNev.includes(szamok[i])){
                alert("A név nem tartalmazhat számokat!");
                return false;
            }
     }

     for (let i = 0; i < vizsgalandoNev.length; i++) {
        if(vizsgalandoNev.length < 3){
            alert("A név hossza nem lehet 3 karakternél kevesebb!");
            return false;
        }
     }
     alert("Sikeres Név bevitel!");
     return true;
}

function ertekelVizsgal(ertekelendo) {
    var ertekelendo = document.querySelector(".ertekeles").value;

    for (let i = 0; i < ertekelendo.length; i++) { 
    if(ertekelendo.length == 0){
        alert("Nincs értékleve!");
        return false;
    } else if (ertekelendo.length == 1){
        ertekelendo[0].replace(i, "*");
        return false;
    } else if (ertekelendo.length == 2) {
        ertekelendo.replaceAll(i,"*");
        return false;
    } else if (ertekelendo.length == 3){
        ertekelendo.replaceAll(i,"*");
        return false;
    } else if (ertekelendo.length == 4){
        ertekelendo.replaceAll(i,"*");
        return false;
    }else if (ertekelendo.length == 5){
        ertekelendo.replaceAll(i,"*");
        return false;
    }
}
alert("Sikeres értékelés!");
return true;
}