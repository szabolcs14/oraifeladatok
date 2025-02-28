var emailLista = [];

function kuldes() {

    alert("Sikeres értékelés!");
    var ertekelendo = document.querySelector(".ertekeles").value;
    for (let i = 0; i < ertekelendo.length; i++) {
        document.write("*");
    }
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

///<i class="bi bi-star-fill"></i>