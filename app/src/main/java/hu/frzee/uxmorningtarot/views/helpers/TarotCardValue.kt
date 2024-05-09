package hu.frzee.uxmorningtarot.views.helpers

import hu.frzee.uxmorningtarot.R

enum class TarotCardValue() {
    Card0_Bolond{
        override fun getName() = "A Bolond"
        override fun getImage() = R.mipmap.card_00
        override fun getKeywords() = "kezdet, szabad lélek, tapasztalatok keresése, új kezdet, utazás, kaland, szabadság, ártatlanság, kockázatvállalás, felelőtlenség, eredetiség, ösztön, bolondság, elindulni az úton, könnyedséggel venni az életet, nemtörődömség, gyermekiség, álruhás személy, bizalom az életben"
        override fun getMeaning() = ""
    },
    Card1_Magus{
        override fun getName() = "A Mágus"
        override fun getImage() = R.mipmap.card_01
        override fun getKeywords() = "megnyilvánulás, öntudatos személy, tehetséges önérvényesítés, kompetencia, képesség az alkotásra, tudatosság, összpontosított energia, karizma, spirituális erő, problémamegoldás, elhatározás, kreatív impulzusok, megnyerő, vonzó, (tudatos) cselekvés, manifesztáció, akaraterő, kockázatvállalás, mágia, inspirált cselekvés"
        override fun getMeaning() = "Alkalmazkodj a változó körülményekhez, bűvészkedj az ötleteiddel, és találd meg, melyik a célhoz vezető legrövidebb út. Légy rugalmas! Talán egy barátodnak vagy a társadnak kell segítened abban, hogy a saját életében megfelelő döntést hozzon. Meggyőzően érvelsz, így képes vagy irányítani és másoknak ötleteket adni. A mágus a cselekvés és a megvalósítás kártyája. A közeljövőben bizonyítanod kell, hogy képes vagy gondolataidat megfelelő formában szavakba önteni, és ezzel el tudod érni a kívánt eredményt."
    },
    Card2_Fopapno{
        override fun getName() = "A Főpapnő"
        override fun getImage() = R.mipmap.card_02
        override fun getKeywords() = "intuíció, isteni nőiesség, fizikai képességek, tudatalatti, rejtély, rejtett titkok, szakralitás, csend, titokzatosság, belső érzékelés, művészi tehetség, rejtett tehetség, mélység, misztikum, bölcsesség, a tudás őrzője, titkok tudója, befelé figyelés"
        override fun getMeaning() = ""
    },
    Card3_Csaszarno{
        override fun getName() = "A Császárnő"
        override fun getImage() = R.mipmap.card_03
        override fun getKeywords() = "szépség, bőség, potenciál, gondoskodás, nőiség, alkotás, fényűzés, termékenység, Természet, Anyai minőség, Földanya, érzelmi + természeti + anyagi erők forrása, megújulás, gondozás, alkotó törekvés, kivirágzás, anyagi javak, boldog családi élet, anyáskodás"
        override fun getMeaning() = ""
    },
    Card4_Csaszar{
        override fun getName() = "A Császár"
        override fun getImage() = R.mipmap.card_04
        override fun getKeywords() = "erő, hatalom, tapasztalat, struktúra, szabályok, határ húzás, előkészítő munka, szakértelem, zsarnok, irányítás, vezetői képesség, magas pozíció, stabil kormányzás, világi vagyon, önfegyelem, tekintély, törvénytisztelet, önuralom, hatalomvágy, kontroll, biztonság, érzelemmentesség kockázata"
        override fun getMeaning() = ""
    },
    Card5_Fopap{
        override fun getName() = "A Főpap"
        override fun getImage() = R.mipmap.card_05
        override fun getKeywords() = "hagyomány, vallás, tanulás, konvenció, spirituális keresés, hit, spirituális bölcsesség, társadalmi elismerés, a világ magasabb szintű megismerésének vágya, barátság, elkötelezettség, (isteni) támogatás, tudományos vagy oktatói elhivatottság, hatalom és egyensúly, jóság"
        override fun getMeaning() = ""
    },
    Card6_Szereto{
        override fun getName() = "A Szerető"
        override fun getImage() = R.mipmap.card_06
        override fun getKeywords() = "választás, döntés, vágy, szerelem, kettősség, kapcsolatok, kérdések, a döntés megpróbáltatása, döntési helyzet, ösztönös megérzésen alapuló választás, harmónia, barátság, bizonytalanság, ellentétek és azok kiegyenlítődése, kapcsolódás"
        override fun getMeaning() = ""
    },
    Card7_Szeker{
        override fun getName() = "A Szekér"
        override fun getImage() = R.mipmap.card_07
        override fun getKeywords() = "céltudatos cselekvés, haladás, dinamika, akaraterő, utazás, önuralom, ambíció, irányítás, erő, adrenalin, küzdelem és győzelem, hírek érkezése, megszerzett eredmény vagy presztízs, szenvedélyek, belső vívódás, ellentétes motivációk lehetősége"
        override fun getMeaning() = ""
    },
    Card8_Ero{
        override fun getName() = "Az Erő"
        override fun getImage() = R.mipmap.card_08
        override fun getKeywords() = "belső erő, magabiztosság, megzabolázás, türelem, lágy erő, kitartás, bizalom, bátorság, együttérzés, a szellem győzelme az anyag felett, önmérséklet, ego és annak megzabolázása, a jellem ereje, szenvedélyek kordában tartása, lelki erő, rugalmasság, higgadtság"
        override fun getMeaning() = ""
    },
    Card9_Remete{
        override fun getName() = "A Remete"
        override fun getImage() = R.mipmap.card_09
        override fun getKeywords() = "befelé tekintés, önvizsgálat, magány, elzárkózás, bölcsesség, belső útmutatás, visszavonulás, meditáció, megvilágosodás, belső hang, szellemi utazás, tanulás, visszafogottság, ismeretlen vagy ismeretlen út, késleltetett eredmény, elszigetelődés"
        override fun getMeaning() = ""
    },
    Card10_Szerencsekerek{
        override fun getName() = "A Szerencsekerék"
        override fun getImage() = R.mipmap.card_10
        override fun getKeywords() = "változás, lehetőség, szerencse, körforgás, végzet, karma, ciklus, sors, ok és okozat közötti összefüggés, a múlt tetteinek eredménye, tapasztalatból eredő tudás vagy bölcsesség, áttörés, a szerencse forgandó"
        override fun getMeaning() = ""
    },
    Card11_Igazsag{
        override fun getName() = "Az Igazság"
        override fun getImage() = R.mipmap.card_11
        override fun getKeywords() = "igazság, őszinteség, egyensúly, következmények, egyenlőség, mérlegelés, igazságosság, méltányosság, becsületesség, tisztesség, kiegyensúlyozottság, felelősség, jogi és oktatási ügyek, az igazság érvényesítése, bírálat, peres ügy, nézeteltérés, egyetemes törvények, hideg fejjel hozott döntés"
        override fun getMeaning() = ""
    },
    Card12_Akasztott{
        override fun getName() = "Az Akasztott Ember"
        override fun getImage() = R.mipmap.card_12
        override fun getKeywords() = "szorult helyzet, korlátozottság, önelemzés, feláldozás, reflexió, perspektíva váltás, stagnálás, szünet, feszengés, elfogadás, önként meghozott áldozat, holtpont, valami feláldozása, előrelátás, parkoló pálya, spirituális döntés, okkult erő (vagy annak megszerzése), önfeláldozás, nyugalom, új nézőpont"
        override fun getMeaning() = ""
    },
    Card13_Halal{
        override fun getName() = "A Halál"
        override fun getImage() = R.mipmap.card_13
        override fun getKeywords() = "transzformáció, mélyreható átalakulás, vég, a lezárás elfogadása, ciklus, átmenet, befejezés, a régi vége és az új kezdete, újjászületés, új tudatosság, az alapoktól való újrakezdés, fájdalmas helyzet, gyász,  elengedés, valami hátrahagyása"
        override fun getMeaning() = ""
    },
    Card14_Mertekletesseg{
        override fun getName() = "A Mértékletesség"
        override fun getImage() = R.mipmap.card_14
        override fun getKeywords() = "higgadtság, mértéktartás, józanság, önmérséklet, kiegyezés, lelki vezető, isteni áldás, gyógyulás, egyensúly, emberség, inspiráció, harmóniára törekvés, nyugalmi állapot, regeneráció, béke"
        override fun getMeaning() = ""
    },
    Card15_Ordog{
        override fun getName() = "Az Ördög"
        override fun getImage() = R.mipmap.card_15
        override fun getKeywords() = "árnyékén, önmagunk uralására szólít fel, anyagi szinten a teremtő erő, félelmek, fogság, tisztességtelenség, energia, humor, érzékiség, vágy, függőség, csábítás, korlátozás, túlzott engedékenység, önkontroll szükséges, materializmus, anyagiasság, pénz vagy pénzfüggőség,"
        override fun getMeaning() = ""
    },
    Card16_Torony{
        override fun getName() = "A Torony"
        override fun getImage() = R.mipmap.card_16
        override fun getKeywords() = "káosz, pusztulás, hirtelen változás, rombolás, zűrzavar, kétségbeesés, váratlan sokk, katasztrófa, összetört illúzió, megvilágosodás, isteni szikra, összeomlás, bukás, lerombolt ambíciók, szakítás, krízis, kinyilatkoztatás, kényszerű változás, váratlan és felvillanyzó szituáció"
        override fun getMeaning() = ""
    },
    Card17_Csillag{
        override fun getName() = "A Csillag"
        override fun getImage() = R.mipmap.card_17
        override fun getKeywords() = "remény, áldás, hit, megújulás, jövő, vezérelv, lehetőség, spirituális vezetettség, újjászületés, emberszeretet, optimizmus, égi áldás, viszonzott érzelmek, egészség, gyógyulás, önbecsülés kérdéseit felveti, vezércsillag, spiritualitás, vágyálmok, eszmék, idealizmus"
        override fun getMeaning() = ""
    },
    Card18_Hold{
        override fun getName() = "A Hold"
        override fun getImage() = R.mipmap.card_18
        override fun getKeywords() = "tudatalatti, intuíció, illúzió, ismeretlen, megtévesztés, fantázia, álmodozás, szorongás, belső világunk, belső minták általi vezéreltség, képzelőerő, kreativitás, bizonytalanság, ingadozás, csalódás, érzelmek"
        override fun getMeaning() = ""
    },
    Card19_Nap{
        override fun getName() = "A Nap"
        override fun getImage() = R.mipmap.card_19
        override fun getKeywords() = "tudatosság, ragyogás, öröm, életélvezet, győzelem, ünnep, boldogság, siker, gyermeki öröm és felszabadultság, önmagunk megmutatása, ego, önkifejezés, önmegvalósítás, jó egészség, kedvező alkalom, anyagi gyarapodás, önbizalom kérdése merül fel, pozitív energia, melegség, fiatalos energia"
        override fun getMeaning() = ""
    },
    Card20_Vegitelet{
        override fun getName() = "A Végítélet"
        override fun getImage() = R.mipmap.card_20
        override fun getKeywords() = "újjászületés, elfogadás, feloldozás, cél, ébredés, feltámadás, karma, áttörés, becsületes élet, belső elhivatottság, az élet célja, múltbéli erőfeszítések, visszatekintés, fogadalmak és az alóluk való felszabadulás, megújulás, új korszak, ítélet"
        override fun getMeaning() = ""
    },
    Card21_Vilag{
        override fun getName() = "A Világ"
        override fun getImage() = R.mipmap.card_21
        override fun getKeywords() = "beteljesedés, bölcsesség, befejezés, eredmény, siker, egy ciklus vége, pozitív végkifejlet, nagy utazás, megtanult lecke, személyes fejlődés, jutalom, integrálódás, teljessé válás, révbe érés, beteljesülés"
        override fun getMeaning() = ""
    };

    abstract fun getImage(): Int
    abstract fun getName(): String
    abstract fun getKeywords(): String
    abstract fun getMeaning(): String
}