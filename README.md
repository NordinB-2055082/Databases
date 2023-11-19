# Taak Databases
## Auteurs
Abdullah Yalvac,
Luca Briers,
Nordin Ben-Al-Lal

## Schema  

[![Klassendiagram](https://mermaid.ink/img/pako:eNqFVMtu2zAQ_BWCx8IxJFlObCHooc7j0hRF40sKAQUrrR2iEimQVFrX8L93SckWKSepdTA1HO3Ozi65p4UsgWa0qJjWN5xtFatzUXIFheFSkE_rXLg9cs9qIPtcEPx9lmJLyBaRH7zsoEejOIKGmwo8UiGFlhWsd80ZtYQXqGQDKkC3IBSMeLpQvLFyOvyGGSAKKmAa7LpDuTCEbWFlxfINL9jwwaaSzJBG8QK5h1wcS3poNbR1WFTtsLFWgaUGQCX9BDb3C9fcSKW_gnoCpvzMIIxiooA7AB8upXAxNAlUrZGrWWe_L80M-Ele53HFMcOAcW26DduglWw4hPxRic5OL_hg6a1Ad7wd20UvDjbG8K4EF8yrYeUkhc6OZPZGEqgZr0KowRC_pfL1kZ9cmedB2pGK41KOJui8WWTDlTZfHHw4SRwmM9D5zsSeBa6ZaDfoTatGGlipQOs7qb5Bw7iF3hpdz7T7rl07X03fwl3YweDkvdbTNwfGJXRHOadxTsn1xcVHXEbT6Qd8OyroKHY17IXM7ujkwncRIwbUeAiaC3-qx8Sz7O-RYy_7_3j9GBLrsX3ohNagcOBKvPKczTk1z4D6aIbLkqlfOUWLkMdaIx93oqDZhlUaJrRtSmxYf0We0IaJ71Liu1Ft90qzPf1Ds0U8jWdX83i2TC-X0WIRT-iOZrPpPLlKovliniZJNIuWhwn9676Pp1GCzzKdxZfpIpmn6YRCaW-Uh_6Gtn9HGbdup1dx-AfVCeaK?type=png)](https://mermaid.live/edit#pako:eNqFVMtu2zAQ_BWCx8IxJFlObCHooc7j0hRF40sKAQUrrR2iEimQVFrX8L93SckWKSepdTA1HO3Ozi65p4UsgWa0qJjWN5xtFatzUXIFheFSkE_rXLg9cs9qIPtcEPx9lmJLyBaRH7zsoEejOIKGmwo8UiGFlhWsd80ZtYQXqGQDKkC3IBSMeLpQvLFyOvyGGSAKKmAa7LpDuTCEbWFlxfINL9jwwaaSzJBG8QK5h1wcS3poNbR1WFTtsLFWgaUGQCX9BDb3C9fcSKW_gnoCpvzMIIxiooA7AB8upXAxNAlUrZGrWWe_L80M-Ele53HFMcOAcW26DduglWw4hPxRic5OL_hg6a1Ad7wd20UvDjbG8K4EF8yrYeUkhc6OZPZGEqgZr0KowRC_pfL1kZ9cmedB2pGK41KOJui8WWTDlTZfHHw4SRwmM9D5zsSeBa6ZaDfoTatGGlipQOs7qb5Bw7iF3hpdz7T7rl07X03fwl3YweDkvdbTNwfGJXRHOadxTsn1xcVHXEbT6Qd8OyroKHY17IXM7ujkwncRIwbUeAiaC3-qx8Sz7O-RYy_7_3j9GBLrsX3ohNagcOBKvPKczTk1z4D6aIbLkqlfOUWLkMdaIx93oqDZhlUaJrRtSmxYf0We0IaJ71Liu1Ft90qzPf1Ds0U8jWdX83i2TC-X0WIRT-iOZrPpPLlKovliniZJNIuWhwn9676Pp1GCzzKdxZfpIpmn6YRCaW-Uh_6Gtn9HGbdup1dx-AfVCeaK)
## Beschrijving van schema
### Enititeiten
Om de database voor het Video Game History Foundation uit te werken, maken we gebruik van 6 entiteiten. De eerste entiteit is een game, deze bevat een unieke id, een titel, de id van het platform waarop het spel gespeeld kan worden, de maker, het genre, de beschrijving van het spel, de uitgeefdatum, leeftijdscategorie en de prijs. Daarnaast hebben we de gameCopy entiteit, dit kan je zien als de inventaris van games. Hierin kunnen meerdere copies van eenzelfde game steken met elk een unieke id, deze bevat dus ook de game_id en een eventuele museum_id als eer nog geen transactie gebeurd is. We gaan er vanuit dat elke gameCopy op een locatie ligt in een museum als opslagplaats, dus is het museum de volgende entiteit die gekoppeld is aan de game. Het museum bevat ook een unieke id, een naam, locatie, aantal bezoekers per jaar, kost van toegang voor bezoekers en eventuele donaties. Wanneer een gameCopy niet meer op de originele site ligt willen we weten wat ermee gebeurd is, daarvoor vallen we terug op de transactie entiteit, deze bevat het unieke transactie id, een lijst van de id van de gameCopy's waarover het gaat, de id van het museum waar de transactie gebeurd is, de datum en het transactie type (aankoop, huur, donatie), de id van de destination dus ofwel is het handel tussen een client en een museum ofwel wisselen de games van museum. We zullen dus een bepaalde structuur van id moeten volgen om gemakkelijk onderscheid te kunnen maken tussen een museum en een echte klant. Transacties gebeuren door een klant en dat is dus onze volgende entiteit, deze bevat de gegevens van de klant, dus client id, email, wachtwoord, geboortedatum, gender, voor- en achternaam. De bedoeling van transaction is om snel terug te vinden wat er met een gameCopy al allemaal gebeurd is en om een buffer te hebben voor de handel zodat we de geschiedenis van gebeurtenissen makkelijker kunnen bijhouden. Nu kunnen we aan de hand van de transactie entiteit meteen zien waar, wanneer en naar wie een game verplaatst is. Tot slot hebben we de consoleType entiteit, deze bevat de id, naam, uitgeefdatum en fabrikant als variabelen. Deze entiteit is om de games te klassificeren voor welke game console ze zijn. Dit vergemakkelijkt het opzoekwerk naar games van een bepaald platform of als we bijvoorbeeld willen weten welk platform het meeste succes heeft in verhuur.

### Relaties tussen entiteiten 
(Github laat de relaties niet zien op het schema, om deze te zien moet u op de figuur klikken en de Mermaid link volgen)
Tussen de Game en GameCopy entiteit is er een 1-op-veel relatie, 1 game kan meerdere gameCopy's bevatten, maar 1 gameCopy kan max 1 Game bevatten. (De oude nintendo DS kaarten met 300 games in 1 kaart laten we even buiten spel).

Er is een veel-op-veel relatie tussen gameCopy en museum. Er kunnen verschillende gameCopy's zich in meerdere musea bevinden aangezien. Tegelijk kan een museum meer dan één gameCopy bevatten wat dus uiteindelijk een veel-op-veel relatie oplevert. Dit is een representatie van een real-world museum of library die bezocht kan worden om spellen te bekijken. Op het klassendiagram wordt dit getoond als 0..* - 0..* om aan te geven dat een een gameCopy zich in geen of meerdere musea kan bevinden en anderszijds dat een museum geen maar normaliter meerdere gameCopy's bevat. Moest er in het museum een renovatie plaatsvinden of een museum wordt pas gebouwd dan ligt er geen enkele 0 gameCopy.

Tussen de entiteiten consoleType en Game is er een veel-op-veel relatie aanwezig. Een consoleType bevat minstens 1 Game die geschikt is voor dat specifieke consoleType en 1 Game kan zich op meerdere platformen bevinden. Indien men een bepaalde Game zoekt om te huren of te kopen van een museum, maar niet weet of die bijvoorbeeld voor de Nintendo DS bestaat, kan men dus ook controleren of de gekozen game bestaat voor de klant zijn console. Als die bestaat kunnen we ze snel opzoeken of deze nog beschikbaar is in de GameCopy entiteit. Op het klassendiagram geven we dit aan met 1..* - 1..* aangezien elke Game ontworpen wordt om op zijn minst op 1 platform te werken en omgekeerd wordt een platform/consoleType gemaakt met de bedoeling dat het minstens één maar liefst meer games ondersteunt.

Wanneer een gameCopy gekocht wordt, bevatten de entiteiten Transaction en GameCopy een veel-op-veel relatie, 1 transactie kunnen meerdere gameCopys bevatten. Maar een gameCopy kan meerdere transacties ondergaan. Eerst huurt klant A hem, daarna klant B, daarna klant C... Dus deze gameCopy zal in de Transaction tabel 3 rijen hebben. 
Tussen Museum en Transaction is er ook een 1-op-veel relatie. De transaction entiteit zorgt ervoor dat een client of persoon interactie kan hebben met een museum. Een museum kan meerdere transacties hebben maar een bepaalde transactie heeft slechts betrekking tot één van de musea. Als je bijvoorbeeld Minecraft wil ophalen van Museum X, is dat een specifieke transactie gelinkt aan Museum X. Andersom kan een museum meerdere transacties behandelen wat ons uiteindelijk een 1-op-veel relatie oplevert. 

Client-Transaction is dan een 1-op-veel relatie. Interactie met een museum gebeurt aan de hand van een transaction. Elke transaction die plaatsvindt is specifiek aan een client terwijl een client meerdere transacties kan uitvoeren. Hier stelt een client een persoon voor die bijvoorbeeld een game wil checken of het beschikbaar is in een museum OF een museum dat een gameCopy van een ander museum overneemt. We achten een relatie tussen client-transactie nodig omdat een transactie zelf ook wat aspecten bevat die niet helemaal bij een client zouden passen, waarbij we bij een client eerder focussen op "account" gedeelte van een persoon.

MAAR niet elke transactie hoeft een gameCopy te bevatten, wanneer een client een museum bezoekt en een donatie achterlaat, is hier geen enkele GameCopy bij betrokken. Daarom is de variabele transactionType heel handig om zo onderscheid te maken tussen het soort van transaction. We gaan om het overzichtelijk te houden een entry + eventuele donatie EN het meenemen van games als aparte transactie zien.  

Tot slot hebben we de relatie tussen Museum en Transaction wat een 1 - 1..* relatie is, een museum kan meerdere transacties maken, maar een transactie kan maar met 1 museum gebeuren aangezien we zeggen dat wanneer er gewisseld wordt van museum A naar museum B, museum B een client is in onze transactie met een bepaalde client_id die herkenbaar is. Elke transactie heeft wel minstens 1 museum nodig.


