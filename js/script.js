function kuldes(){
    var jelszo = document.querySelector(".jelszo").value;

    const szamok = "0123456789";
    const karakterek = "#&*!%";
    const nagyBetuk = "AÁBCDEÉFGHIÍJKLMNOÓÖŐPQRSTUÚÜŰVWXYZ";

    if (jelszo == ""){
            alert("Nincs megadva jelszó! a jelszó gyenge"); 
     } else {
        if (jelszo.length < 8) {
            alert("A jelszó túl rövid ! A jelszó kevésbé-gyenge");
        } else if (jelszo.includes(szamok[i])) {
            alert("A jelszó erőssége közepes");
        } else if (jelszo.includes(karakterek[i])) {
            alert("A jelszó erőssége normál");
        }
    }

}