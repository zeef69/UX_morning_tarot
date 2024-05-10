package hu.frzee.uxmorningtarot.views.helpers

import hu.frzee.uxmorningtarot.R

enum class TarotCardValue() {
    Card0_Bolond{
        override fun getName() = "A Bolond"
        override fun getNameEnglish() = "The Fool"
        override fun getImage() = R.mipmap.card_00
        override fun getKeywords() = "kezdet, szabad lélek, tapasztalatok keresése, új kezdet, utazás, kaland, szabadság, ártatlanság, kockázatvállalás, felelőtlenség, eredetiség, ösztön, bolondság, elindulni az úton, könnyedséggel venni az életet, nemtörődömség, gyermekiség, álruhás személy, bizalom az életben"
        override fun getMeaning() = "A Bolond fiatal és sebezhető. Még nem élte át az élet hullámvölgyeit, így nincs tudatában az élet kihívásainak, valamint a benne rejlő lehetőségeknek. Amikor a Bolond szóba kerül egy Tarot-olvasásban, arra ösztönöznek, hogy vegye fel a nyitott, készséges energiáját, és aggodalom nélkül ölelje fel mindazt, ami előtte áll."
        override fun getMeaningEnglish()= "The Fool is young and vulnerable. He has not yet experienced the ups and downs of life, leaving him unaware of the magnitude of life's challenges, as well as the potential he holds. When The Fool comes up in a Tarot reading, you are encouraged to take on his open, willing energy and embrace all that lies ahead of you without worry."
    },
    Card1_Magus{
        override fun getName() = "A Mágus"
        override fun getNameEnglish() = "The Magician"
        override fun getImage() = R.mipmap.card_01
        override fun getKeywords() = "megnyilvánulás, öntudatos személy, tehetséges önérvényesítés, kompetencia, képesség az alkotásra, tudatosság, összpontosított energia, karizma, spirituális erő, problémamegoldás, elhatározás, kreatív impulzusok, megnyerő, vonzó, (tudatos) cselekvés, manifesztáció, akaraterő, kockázatvállalás, mágia, inspirált cselekvés"
        override fun getMeaning() = "A Mágus kártya emlékeztet arra, hogy egyedi vagy, és sok ajándékod van. Ezek a készségek kitűnnek a tömegből, és segíthetnek új projektek megkezdésében vagy a csapások leküzdésében. Amikor a Varázsló előkerül a Tarot olvasmányban, ez arra emlékeztet, hogy már mindent megvan, amire szüksége van ahhoz, hogy előrehaladjon és elérje, amit elhatározott."
        override fun getMeaningEnglish()= "The Magician card is a reminder that you are unique and have many gifts. These skills set you apart from the crowd and can help you begin new projects or overcome adversity. When The Magician comes up in your Tarot reading, it's a reminder that you already hold everything you need to move forward and accomplish what you've set out to do."
    },
    Card2_Fopapno{
        override fun getName() = "A Főpapnő"
        override fun getNameEnglish() = "The High Priestess"
        override fun getImage() = R.mipmap.card_02
        override fun getKeywords() = "intuíció, isteni nőiesség, fizikai képességek, tudatalatti, rejtély, rejtett titkok, szakralitás, csend, titokzatosság, belső érzékelés, művészi tehetség, rejtett tehetség, mélység, misztikum, bölcsesség, a tudás őrzője, titkok tudója, befelé figyelés"
        override fun getMeaning() = "Az egész Tarot pakli legintuitívabb, legösszefüggőbb kártyája, a Főpapnő a tudatosság kártyája. Ez a kártya arra ösztönöz, hogy hallgass a belső hangodra, és kövesd az ösztöneidet. Az elméd sokkal többet tud, mint gondolnád. Amikor ez a kártya megjelenik a Tarot-olvasásban, ne keresd a válaszokat a külvilágban. Forduljon befelé a keresett útmutatásért."
        override fun getMeaningEnglish()= "The most intuitive, connected card in the whole Tarot deck, The High Priestess is a card of awareness. This card urges you to listen to your inner voice and follow your instincts. Your mind knows far more than you think. When this card arises in your Tarot reading, stop looking for answers in the outside world. Turn within for the guidance you seek."
    },
    Card3_Csaszarno{
        override fun getName() = "A Császárnő"
        override fun getNameEnglish() = "The Empress"
        override fun getImage() = R.mipmap.card_03
        override fun getKeywords() = "szépség, bőség, potenciál, gondoskodás, nőiség, alkotás, fényűzés, termékenység, Természet, Anyai minőség, Földanya, érzelmi + természeti + anyagi erők forrása, megújulás, gondozás, alkotó törekvés, kivirágzás, anyagi javak, boldog családi élet, anyáskodás"
        override fun getMeaning() = "A Császárnő a legnőiesebb kártya a Tarotban, és nagymértékben bátorítja az együttérzést, a szépséget és a szeretetet. Mélyen kötődik az anyatermészethez, és befolyása erőteljes, ha felszívod a körülötted lévő természeti világ energiáját."
        override fun getMeaningEnglish()= "The Empress is the most feminine card in the Tarot, and greatly encourages compassion, beauty, and love. She is deeply connected to Mother Nature, and her influence is powerful when you absorb the energy of the natural world around you."
    },
    Card4_Csaszar{
        override fun getName() = "A Császár"
        override fun getNameEnglish() = "The Emperor"
        override fun getImage() = R.mipmap.card_04
        override fun getKeywords() = "erő, hatalom, tapasztalat, struktúra, szabályok, határ húzás, előkészítő munka, szakértelem, zsarnok, irányítás, vezetői képesség, magas pozíció, stabil kormányzás, világi vagyon, önfegyelem, tekintély, törvénytisztelet, önuralom, hatalomvágy, kontroll, biztonság, érzelemmentesség kockázata"
        override fun getMeaning() = "A császár a vezetés és a hatalom kártyája. Ő egy tekintélyes erő, aki sok tapasztalaton ment keresztül e státusz elérése érdekében. Ő képviseli a struktúrát és a szilárdságot, és emlékeztet arra, hogy te is hatalmas hatalmad van a saját életed felett, és arról, hogy mi történik vele."
        override fun getMeaningEnglish()= "The Emperor is a card of leadership and power. He is an authoritative force who has been through many experiences to achieve this status. He represents structure and solidity, and reminds you that you, too, hold immense amounts of power over your own life, and what happens to it."
    },
    Card5_Fopap{
        override fun getName() = "A Főpap"
        override fun getNameEnglish() = "The Hierophant"
        override fun getImage() = R.mipmap.card_05
        override fun getKeywords() = "hagyomány, vallás, tanulás, konvenció, spirituális keresés, hit, spirituális bölcsesség, társadalmi elismerés, a világ magasabb szintű megismerésének vágya, barátság, elkötelezettség, (isteni) támogatás, tudományos vagy oktatói elhivatottság, hatalom és egyensúly, jóság"
        override fun getMeaning() = "A Hierophant olyan, mint egy mennyei hírnök. Tapasztalt a spiritualitásban és az útmutatásban, és az ő feladata, hogy ezeket a leckéket elhozza nekünk itt, a való világban. Amikor a Hierofánt szóba kerül a Tarot-olvasmányodban, arra buzdítunk, hogy kövesd a szabályokat, és találj lelki perspektívát a jelenlegi helyzetedre."
        override fun getMeaningEnglish()= "The Hierophant is like a messenger from the heavens. He is experienced in spirituality and guidance, and his job is to bring these lessons down to us here in the real world. When The Hierophant comes up in your Tarot reading, you're encouraged to follow the rules, and to find a spiritual perspective on your current situation."
    },
    Card6_Szereto{
        override fun getName() = "A Szeretők"
        override fun getNameEnglish() = "The Lovers"
        override fun getImage() = R.mipmap.card_06
        override fun getKeywords() = "választás, döntés, vágy, szerelem, kettősség, kapcsolatok, kérdések, a döntés megpróbáltatása, döntési helyzet, ösztönös megérzésen alapuló választás, harmónia, barátság, bizonytalanság, ellentétek és azok kiegyenlítődése, kapcsolódás"
        override fun getMeaning() = "A szerelmesek kártya az életed szoros kapcsolatait jelképezi. Ha ez előkerül a Tarot olvasatban, akkor szerelmi életed extra figyelmet igényel. Ez azonban ugyanúgy kártya az Ön értékeiről és döntéseiről. Előfordulhat, hogy a szerelmesek előkerülnek, amikor válaszút előtt állsz. Mérlegelje választásának összes lehetséges következményét."
        override fun getMeaningEnglish()= "The Lovers card represents the close relationships in your life. If it comes up in your Tarot reading, your love life is in need of extra attention. However, this is just as much a card about your values and decisions. You may find The Lovers come up when you are at a crossroads. Consider all the possible consequences of your choices."
    },
    Card7_Szeker{
        override fun getName() = "A Szekér"
        override fun getNameEnglish() = "The Chariot"
        override fun getImage() = R.mipmap.card_07
        override fun getKeywords() = "céltudatos cselekvés, haladás, dinamika, akaraterő, utazás, önuralom, ambíció, irányítás, erő, adrenalin, küzdelem és győzelem, hírek érkezése, megszerzett eredmény vagy presztízs, szenvedélyek, belső vívódás, ellentétes motivációk lehetősége"
        override fun getMeaning() = "A Chariot kártya természetes lendületedhez és elszántságodhoz kapcsolódik, és jelezheti a közelgő győzelmet. Ez a kártya arra emlékeztet, hogy a legnagyobb sikereidet nem a korlátozott gondolkodáson keresztül éred el – ha az elméd tudását a szíved és szellemed tudásával kombinálod, megállíthatatlan erő vagy."
        override fun getMeaningEnglish()= "The Chariot card is connected to your natural drive and determination, and can indicate an upcoming victory. This card reminds you that your greatest successes won't come through limited thinking -- when you combine the knowledge of your mind with that of your heart and spirit, you are an unstoppable force."
    },
    Card8_Ero{
        override fun getName() = "Erő"
        override fun getNameEnglish() = "Strength"
        override fun getImage() = R.mipmap.card_08
        override fun getKeywords() = "belső erő, magabiztosság, megzabolázás, türelem, lágy erő, kitartás, bizalom, bátorság, együttérzés, a szellem győzelme az anyag felett, önmérséklet, ego és annak megzabolázása, a jellem ereje, szenvedélyek kordában tartása, lelki erő, rugalmasság, higgadtság"
        override fun getMeaning() = "Az Erő kártya a bátorságot, a szíved szilárdságát és azt a képességedet jelképezi, hogy ellenállsz bárminek, amit az élet felad. Ha ez a kártya megjelenik a Tarot-olvasás során, akkor eszébe jut, hogy elég erős vagy ahhoz, hogy kezelni tudd, bármivel is szembesülj, és még nagyobb erővel lépsz ki belőle, mint korábban."
        override fun getMeaningEnglish()= "The Strength card represents courage, the fortitude of your heart, and your ability to withstand anything life hands you. If this card arises in your Tarot reading, you are reminded that you're strong enough to handle whatever you are facing and will come out of it with even more power than you had before."
    },
    Card9_Remete{
        override fun getName() = "A Remete"
        override fun getNameEnglish() = "The Hermit"
        override fun getImage() = R.mipmap.card_09
        override fun getKeywords() = "befelé tekintés, önvizsgálat, magány, elzárkózás, bölcsesség, belső útmutatás, visszavonulás, meditáció, megvilágosodás, belső hang, szellemi utazás, tanulás, visszafogottság, ismeretlen vagy ismeretlen út, késleltetett eredmény, elszigetelődés"
        override fun getMeaning() = "A Remete egyedül vágyik. Tudja, hogy az élet történéseit csak úgy lehet feldolgozni, ha visszavonul a világ zajától, és megteremti a magány csendes terét. Amikor a Remete felbukkan az olvasatban, a válaszok belülről érkeznek. Maradj csendben, és hallgass..."
        override fun getMeaningEnglish()= "The Hermit yearns to be alone. He knows that the only way to process what is happening in life is to withdraw from the noise of the world and create a quiet space of solitude. When The Hermit comes up in your reading, the answers you need will come from within. Be very still, and listen..."
    },
    Card10_Szerencsekerek{
        override fun getName() = "Szerencsekerék"
        override fun getNameEnglish() = "Wheel of Fortune"
        override fun getImage() = R.mipmap.card_10
        override fun getKeywords() = "változás, lehetőség, szerencse, körforgás, végzet, karma, ciklus, sors, ok és okozat közötti összefüggés, a múlt tetteinek eredménye, tapasztalatból eredő tudás vagy bölcsesség, áttörés, a szerencse forgandó"
        override fun getMeaning() = "A Szerencsekerék folyamatosan forog – néha te leszel a csúcson, néha pedig az alján. Ez a Tarot kártya emlékeztet arra, hogy semmi sem állandó, és legyen jó vagy rossz, ápolni kell azokat a leckéket, amelyeket ez a pillanat hoz neked."
        override fun getMeaningEnglish()= "The Wheel of Fortune is constantly revolving -- sometimes you will be at the top, and sometimes you will be at the bottom. This Tarot card reminds you that nothing is permanent, and, good or bad, you must cherish the lessons that this moment is bringing you."
    },
    Card11_Igazsag{
        override fun getName() = "Igazság"
        override fun getNameEnglish() = "Justice"
        override fun getImage() = R.mipmap.card_11
        override fun getKeywords() = "igazság, őszinteség, egyensúly, következmények, egyenlőség, mérlegelés, igazságosság, méltányosság, becsületesség, tisztesség, kiegyensúlyozottság, felelősség, jogi és oktatási ügyek, az igazság érvényesítése, bírálat, peres ügy, nézeteltérés, egyetemes törvények, hideg fejjel hozott döntés"
        override fun getMeaning() = "Az igazságosság határozott, de igazságos emlékeztetője arra, hogy minden cselekedetnek következménye van. Bármit is nyújt az élet ebben a pillanatban, az olyan döntésekből fakad, amelyeket Ön és mások a múltban hoztak, természetes ok-okozatot tükrözve. Amikor ez a kártya megjelenik a Tarot-olvasás során, győződjön meg arról, hogy tisztességesen jár el minden interakciójában másokkal.\n"
        override fun getMeaningEnglish()= "Justice is your firm-but-fair reminder that there is a consequence for every action. Whatever life is handing you at this moment comes from decisions you and others have made in the past, reflecting natural cause-and-effect. When this card comes up in your Tarot reading, make sure you are acting fairly in all your interactions with others."
    },
    Card12_Akasztott{
        override fun getName() = "Az Akasztott Ember"
        override fun getNameEnglish() = "The Hanged Man"
        override fun getImage() = R.mipmap.card_12
        override fun getKeywords() = "szorult helyzet, korlátozottság, önelemzés, feláldozás, reflexió, perspektíva váltás, stagnálás, szünet, feszengés, elfogadás, önként meghozott áldozat, holtpont, valami feláldozása, előrelátás, parkoló pálya, spirituális döntés, okkult erő (vagy annak megszerzése), önfeláldozás, nyugalom, új nézőpont"
        override fun getMeaning() = "Az Akasztott Ember azt mondja, hogy néha kis áldozatokra van szükség a nagyobb összkép érdekében. Amikor az akasztott ember felbukkan az olvasásban, valószínűleg szeretne lépni, de nem tudja, hol kezdje. Ha könnyít a szorításon azon, ami már nem működik az Ön számára, vagy elszakad a helyzet kimenetelétől, segíthet elengedni magát."
        override fun getMeaningEnglish()= "The Hanged Man tells you that sometimes small sacrifices are required to benefit the bigger picture. When The Hanged Man arises in your reading, you likely want to make a move but don't know where to begin. Lightening your grip on what's no longer working for you, or detaching from the outcome of your situation, can help you release yourself."
    },
    Card13_Halal{
        override fun getName() = "Halál"
        override fun getNameEnglish() = "Death"
        override fun getImage() = R.mipmap.card_13
        override fun getKeywords() = "transzformáció, mélyreható átalakulás, vég, a lezárás elfogadása, ciklus, átmenet, befejezés, a régi vége és az új kezdete, újjászületés, új tudatosság, az alapoktól való újrakezdés, fájdalmas helyzet, gyász,  elengedés, valami hátrahagyása"
        override fun getMeaning() = "Az egyik leginkább félreértett Tarot kártya, a Halál nem a fizikai halálról szól. A Halálkártya ciklusokról beszél, és arra emlékeztet, hogy mindennek el kell múlnia. Ha ragaszkodsz a múlt helyzeteihez, az akadályoz téged abban, hogy új, jobb dolgokat engedj be az életedbe. Minden befejezésben rejlik egy esély az új kezdetre."
        override fun getMeaningEnglish()= "One of the most misunderstood Tarot cards, Death is not a card about physical death. The Death card speaks of cycles and is a reminder that all things must pass. Hanging on to situations from the past will hinder you from allowing new, better things to enter your life. In every ending lies a chance for a new beginning."
    },
    Card14_Mertekletesseg{
        override fun getName() = "Mértékletesség"
        override fun getNameEnglish() = "Temperance"
        override fun getImage() = R.mipmap.card_14
        override fun getKeywords() = "higgadtság, mértéktartás, józanság, önmérséklet, kiegyezés, lelki vezető, isteni áldás, gyógyulás, egyensúly, emberség, inspiráció, harmóniára törekvés, nyugalmi állapot, regeneráció, béke"
        override fun getMeaning() = "A mértékletesség kártya a mértékletesség mestere. Békére és türelemre buzdít, és emlékeztet arra, hogy haladj az életed áramlásával, ahelyett, hogy erőltetni próbálnád annak ütemét vagy irányát. Amikor a mértékletesség megjelenik a Tarot-olvasásban, az egy üzenet, hogy vedd a dolgokat úgy, ahogy jönnek, és maradj elég rugalmas ahhoz, hogy a változásokkal együtt változtass."
        override fun getMeaningEnglish()= "The Temperance card is a master of moderation. She encourages peace and patience, and reminds you to go with the flow of your life instead of trying to force its pace or direction. When Temperance turns up in your Tarot reading, it is a message to take things as they come, and remain flexible enough to change with the changes."
    },
    Card15_Ordog{
        override fun getName() = "Az Ördög"
        override fun getNameEnglish() = "The Devil"
        override fun getImage() = R.mipmap.card_15
        override fun getKeywords() = "árnyékén, önmagunk uralására szólít fel, anyagi szinten a teremtő erő, félelmek, fogság, tisztességtelenség, energia, humor, érzékiség, vágy, függőség, csábítás, korlátozás, túlzott engedékenység, önkontroll szükséges, materializmus, anyagiasság, pénz vagy pénzfüggőség,"
        override fun getMeaning() = "Az Ördög kártya a visszafogottság és a tehetetlenség témáit hordozza. Amikor ez felmerül a Tarot-olvasás során, valószínűleg úgy érzi, elakadt. Az Ördög meggyőzött arról, hogy nincs más választásod, de ez nem állhat távolabb az igazságtól. A saját szabadságod kulcsai nálad vannak, de rajtad múlik, hogy kinyitod-e a zárat."
        override fun getMeaningEnglish()= "The Devil card carries themes of restraint and powerlessness. When it comes up in your Tarot reading, you are likely feeling stuck. The Devil has convinced you that you have no options, but this couldn't be further from the truth. You hold the keys to your own freedom, but it's up to you to open the lock."
    },
    Card16_Torony{
        override fun getName() = "A Torony"
        override fun getNameEnglish() = "The Tower"
        override fun getImage() = R.mipmap.card_16
        override fun getKeywords() = "káosz, pusztulás, hirtelen változás, rombolás, zűrzavar, kétségbeesés, váratlan sokk, katasztrófa, összetört illúzió, megvilágosodás, isteni szikra, összeomlás, bukás, lerombolt ambíciók, szakítás, krízis, kinyilatkoztatás, kényszerű változás, váratlan és felvillanyzó szituáció"
        override fun getMeaning() = "A torony a pusztulást jelképezi. Gyakran előjön, amikor az életedben minden összeomlik, és nincs módod megállítani. Ennek a kártyának az üzenete, hogy hagyd leesni. Életed leggyengébb részeit le kell bontani, hogy valami erőset és szilárdat építs a helyükre."
        override fun getMeaningEnglish()= "The Tower represents destruction. It often comes up when everything in your life feels like its crumbling, and you have no way of stopping it. The message of this card is to just let it fall. The weakest parts of your life must be torn down in order to build something strong and sturdy in their place."
    },
    Card17_Csillag{
        override fun getName() = "A Csillag"
        override fun getNameEnglish() = "The Star"
        override fun getImage() = R.mipmap.card_17
        override fun getKeywords() = "remény, áldás, hit, megújulás, jövő, vezérelv, lehetőség, spirituális vezetettség, újjászületés, emberszeretet, optimizmus, égi áldás, viszonzott érzelmek, egészség, gyógyulás, önbecsülés kérdéseit felveti, vezércsillag, spiritualitás, vágyálmok, eszmék, idealizmus"
        override fun getMeaning() = "A Csillag a remény és a gyógyulás megtestesítője. Nyugtató hatású, amely a megújulást, az optimizmust és az inspirációt közvetíti. Amikor a Csillag megjelenik a Tarot olvasmányban, emlékeztet arra, hogy az univerzum az Ön javára dolgozik, és arra biztat, hogy higgyen abban, hová visznek."
        override fun getMeaningEnglish()= "The Star is the embodiment of hope and healing. She is a calming influence that brings messages of renewal, optimism, and inspiration. When The Star comes up in your Tarot reading, she reminds you that the universe is working in your favor, and encourages you to have faith in where you are being taken."
    },
    Card18_Hold{
        override fun getName() = "A Hold"
        override fun getNameEnglish() = "The Moon"
        override fun getImage() = R.mipmap.card_18
        override fun getKeywords() = "tudatalatti, intuíció, illúzió, ismeretlen, megtévesztés, fantázia, álmodozás, szorongás, belső világunk, belső minták általi vezéreltség, képzelőerő, kreativitás, bizonytalanság, ingadozás, csalódás, érzelmek"
        override fun getMeaning() = "A Holdkártya rejtett gondolatokat, érzéseket, kétségeket és félelmeket jelképez. Amikor a Hold feljön a tarot olvasatban, akkor megengedheti, hogy félelmei felülmúlják a jövőbe vetett hitét. Ne tévesszen meg – nem hisz el mindent, amit lát, hall vagy gondol. Ha felszínre tudod vonni érzéseidet, és meg tudod oldani őket, megszabadulhatsz az aggodalomtól."
        override fun getMeaningEnglish()= "The Moon card represents hidden thoughts, feelings, doubts and fears. When The Moon arises in your Tarot reading, you may be allowing your fears to override your faith in the future. Don't be deceived - you can't believe everything that you see, hear, or think. If you can draw your feelings to the surface and address them, you can rid yourself of worry."
    },
    Card19_Nap{
        override fun getName() = "A Nap"
        override fun getNameEnglish() = "The Sun"
        override fun getImage() = R.mipmap.card_19
        override fun getKeywords() = "tudatosság, ragyogás, öröm, életélvezet, győzelem, ünnep, boldogság, siker, gyermeki öröm és felszabadultság, önmagunk megmutatása, ego, önkifejezés, önmegvalósítás, jó egészség, kedvező alkalom, anyagi gyarapodás, önbizalom kérdése merül fel, pozitív energia, melegség, fiatalos energia"
        override fun getMeaning() = "A Nap egy erőteljesen felemelő kártya, amely boldogságot, örömöt, vitalitást és optimizmust jelképez. Amikor feljön a Nap a Tarot olvasmányodban, az pozitív jele annak, hogy a dolgok jól működnek számodra, és hogy jó irányba haladsz. Emelje fel a fejét, és ismerje fel a jó helyzeteket és embereket, amelyek most és mindig körülvesznek."
        override fun getMeaningEnglish()= "The Sun is a powerfully uplifting card, representing happiness, joy, vitality, and optimism. When The Sun comes up in your Tarot reading, it is an positive sign that things are working well for you and that you're moving in the right direction. Lift your head and realize all the good situations and people that are surrounding you now and always."
    },
    Card20_Vegitelet{
        override fun getName() = "Végítélet"
        override fun getNameEnglish() = "Judgement"
        override fun getImage() = R.mipmap.card_20
        override fun getKeywords() = "újjászületés, elfogadás, feloldozás, cél, ébredés, feltámadás, karma, áttörés, becsületes élet, belső elhivatottság, az élet célja, múltbéli erőfeszítések, visszatekintés, fogadalmak és az alóluk való felszabadulás, megújulás, új korszak, ítélet"
        override fun getMeaning() = "Az ítélet egy kártya, ahol a múltad és a jövőd találkozik. Arra kérnek, hogy vizsgálja felül eddigi döntéseit és tetteit, hogy megbizonyosodjon arról, hogy azok összhangban vannak azzal, hová szeretne eljutni. Az Ítéletkártya emlékeztet arra, hogy a jövőd nincs kőbe vésve, és soha nem késő jobbra változtatni."
        override fun getMeaningEnglish()= "Judgement is a card where your past and your future come together. You are being called on to review your decisions and your actions until now, to ensure they are in-line with where you ultimately want to go. The Judgement card reminds you that your future is not set in stone, and that it's never too late to make a change for the better."
    },
    Card21_Vilag{
        override fun getName() = "A Világ"
        override fun getNameEnglish() = "The World"
        override fun getImage() = R.mipmap.card_21
        override fun getKeywords() = "beteljesedés, bölcsesség, befejezés, eredmény, siker, egy ciklus vége, pozitív végkifejlet, nagy utazás, megtanult lecke, személyes fejlődés, jutalom, integrálódás, teljessé válás, révbe érés, beteljesülés"
        override fun getMeaning() = "A Major Arcana utolsó kártyájaként a világ a befejezést és a beteljesülést jelenti. Amikor ez felmerül a Tarot-olvasásban, pontosan ott vagy, ahol lennie kell. Jobban megérted, hogy ki vagy mindazok után, amin keresztülmentél, és készen állsz az utazásod következő szakaszára."
        override fun getMeaningEnglish()= "As the last card of the Major Arcana, The World represents completion and fulfillment. When it arises in your Tarot Reading, you are exactly where you're meant to be. You have a greater understanding of who you are after all you've been through, and you're ready for the next phase of your journey."
    };

    abstract fun getImage(): Int
    abstract fun getName(): String
    abstract fun getNameEnglish(): String
    abstract fun getKeywords(): String
    abstract fun getMeaning(): String
    abstract fun getMeaningEnglish(): String
}