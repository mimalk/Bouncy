Kirjeldus
===========

Mängu nimi on **Bouncy**. Mäng põhineb mängul DX-Ball (http://dx-ball.ru/), kus tuleb lammutada põrkava kuuliga klotse. Kuuli saab põrgatada põrkelauaga. 
Kui kuul kukub põrkelauast mööda, siis mängija kaotab elu. Kui kõik klotsid saavad lammutatud, pääseb mängija järgmisesse levelisse, kui kõik elud saavad otsa, peab mängija mängu uuesti alustama esimesest levelist.

Tudengite nimed ja uni-id-d
---------------
Maria Letta   (malett)
Mirjam Mälksoo   (mimalk)


Funktsionaalsus
---------------

- mängija saab valida põrkelaua algpositsiooni, kust kuuli lendu lasta
- mängija saab põrkelauda horisontaalselt liigutada, et langevat kuuli põrgatada
- mängija saab kuuli trajektoori suunata
- kuuli põrke tõusunurk oleneb kuuli langemisnurgast ja põrkelaua asendist
- tavalised klotsid lagunevad esimesel kokkupuutel kuuliga
- tugevad klotsid lagunevad kahel kokkupuutel kuuliga
- vilkuvad klotsid lagunevad esimesel kokkupuutel kuuliga, hävitades ka iseendaga kokkupuutes olevad mistahes liiki teised klotsid
- osad klotsid (mis ei eristu kuidagi teistest klotsidest) langetavad kuuliga kokkupuutudes mängija jaoks kasulikke või kahjulikke 'booste', mille mängija peab põrkelauaga kinni püüdma. Boost kestab niikaua kuni mängija püüab kinni uue boosti või kui boosti kinnipüüdmise ajast on möödas rohkem kui 10 sekundit.
	Boostideks on:
        - põrkelaua pikenemine (kasulik)
        - põrkelaua lühenemine (kahjulik)
        - kuuli liikumise kiirenemine (pigem kahjulik)
        - kuuli liikumise aeglustumine (pigem kasulik)
        - kuuli omaduste muutus:
        - pall läbib klotse, läbitud klotsid lagunevad (kasulik)
        - pall ei purusta klotse (kahjulik)
        - ühe elu juurde saamine (kasulik)
        - kuul suureneb (kasulik)
        - kuul kahaneb (kahjulik)
        - kuul kolmekordistub
        - kuul viiekordistub
        - mänguvälja taust hakkab vilkuma, selleks, et mängijat segada (kahjulik)
        - klotsid muutuvad nähtamatuks(kahjulik)
        - põrkelaua omaduste muutus:
        - muutub kleepuvaks(kuul ei põrka automaatselt)
        - tulistab kiiri, mis lõhuvad klotse
- mängijal on ühe leveli kohta 3 elu
- mängija kaotab elu, kui kuul kukub põrkelauast mööda
- elu kaotades jätkub mäng pooleliolevast kohast, kui mängijal on veel alles vähemalt 1 elu
- levelitel on erinev klotside paigutus ja arv
- levelitel on erinev temaatika (olenevalt mängija poolt valitud maailmast)
- mäng lõppeb, kui mängijal saavad elud otsa
- mängija kogub klotside lammutamise ja boostide kinnipüüdmisega (+/-) punkte (tavalised klotsid annavad vähem + punkte, erilised klotsid rohkem + punkte)
- kasulikud boostid annavad + punkte ja kahjulikud - punkte	
- mida rohkem punkte mängu jooksul kogutakse, seda parem
- mängija peab esimese mängu alguses sisestama kasutajanime (kasutajanime järgnevates mängudes sisestama ei pea)
- mängija high score salvestatakse mängu lõppedes
- mängul mängib taustaks muusika
- **Ekstra: mängu saab mängida nii desktopil kui ka androidil**

Ekraanivaated
-------------

**Esileht**

Kuvatakse nupud "Uus mäng", "Seaded", "Juhis". Igaüks viib erinevasse vaatesse - vt järgmisi vaateid. Esilehel kuvatakse ka parim skoor koos mängija nimega. 

**Juhis**

Kuvatakse mängujuhis, kus selgitatakse mängijale mängu reegleid ja erinevate boost’ide toimeid. Ekraanil on nupp "Tagasi", mis viib esilehele.

**Seaded**

Mängija saab valida temaatilise maailma levelitele (temaatikaga muutub levelite visuaalne kujundus).
Mängija saab valida, kas soovib mängu taustamuusikat kuulata või mitte.
Mängija saab muuta oma kasutajanime, mille ta sisestas esimese mängu alguses.

Nupp "Tagasi" viib esilehele.

**Mäng**

Mängu põhivaade on selline, et mänguvälja ülaosas on klotsid ja alaosas on põrkelaud kuuliga. Vasakul nurgas on näha punktiskoor ja elude arv. Üleval keskel on näha leveli number. Igal maailmal on erinev temaatika. Temaatika muudab: mänguvälja taustapilti, klotside värvi, kuuli ja põrkelaua kujundust. (Temaatikat saab valida seadetest)

Mängija põrgatab palli ja purustab klotse. Tugevad klotsid, mis vajavad täielikuks purunemiseks kahte lööki, mõranevad esmalt peale esimest kokkupuudet kuuliga. 

Plaan
--------

- 5. nädal: UI mockup
- 6. nädal: mänguvälja funktsionaalsus (on mänguvälja, kuuli, põrkelaua ja klotside objektid)
- 7. nädal: punktiskoori arvutus, liikumise funktsionaalsus (kui kiiresti saab liikuda kuul, kuuli põrkamise tõusunurga määramine)
- 8. nädal: boostide lisamine
- 9. nädal: JavaFX/Android UI esileht, seaded
- 10. nädal: JavaFX/Android UI mängu vaade, maailmate temaatikad
- 11. nädal: Mängu UI ja loogika sidumine
- 12. nädal: boonus/efektid/edetabel/bugfix

Punktisoov
----------

8-10 punkti
