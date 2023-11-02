# Taak Databases

## Schema  

[![Klassendiagram](https://mermaid.ink/img/pako:eNqNVMGOmzAU_BXLxyobBUiyAVU9NLvdS7eqmlxaIVVeeKRWjY1ss20a5d_7bEjA7GEXDuDx4Dczz-ZEC1UCzWghmDF3nB00q3NZcg2F5UqSj_tc-jnywGogp1wSvD4reSDkgMhPXnbQzmqOoOVWQIA0gtlK6ToAS3gGAY3SHXov25ocQGqYsEyheeOEXOoWTNwxC-Qbfs4MuPfREjvLbGtIh3BpiVWWia1qOJhcni9WHlsDyA7M1B6b2pFoMQCcgkGPK_HMDbdKm6-gvwPrDVVCMUtAWs1kAZ8AxnCppF_DCUVNF1V75BrWxT6WZgf8Ks9PBPl7ZGJiiGu0xiSy0cz-2ECgaCs4WghzKjw2zYlAzbgIoQaX-KP0Cy3Y6CeltHXNa8Nt4fZACTrEXvSAVFwb-8XD155uMU8lwHkIBBcD_mpzaybbCrNoNWgH92H4nZ_TxXz-Lqfk_c3Nh2HUbaVcjsvnNBp4Ucd78LXGLQ5YizexorDma7y-fcR5cDed0Ro0NqrEA-8zyqn9BViSZvhaMv07p-gZeay1aneUBc0qJgzMaNuU2Lv-B3FFGyZ_KIVjq9tuSLMT_UuzdDnfrDZptF4mcXSbJOmMHmm2TOerON7Eq3idRHEaLc8z-s9_v5jfxus0SeP1Il2la2TMKJTuXD32_yf3uMi49zO9ivN_PbuP6w?type=png)](https://mermaid.live/edit#pako:eNqNVMGOmzAU_BXLxyobBUiyAVU9NLvdS7eqmlxaIVVeeKRWjY1ss20a5d_7bEjA7GEXDuDx4Dczz-ZEC1UCzWghmDF3nB00q3NZcg2F5UqSj_tc-jnywGogp1wSvD4reSDkgMhPXnbQzmqOoOVWQIA0gtlK6ToAS3gGAY3SHXov25ocQGqYsEyheeOEXOoWTNwxC-Qbfs4MuPfREjvLbGtIh3BpiVWWia1qOJhcni9WHlsDyA7M1B6b2pFoMQCcgkGPK_HMDbdKm6-gvwPrDVVCMUtAWs1kAZ8AxnCppF_DCUVNF1V75BrWxT6WZgf8Ks9PBPl7ZGJiiGu0xiSy0cz-2ECgaCs4WghzKjw2zYlAzbgIoQaX-KP0Cy3Y6CeltHXNa8Nt4fZACTrEXvSAVFwb-8XD155uMU8lwHkIBBcD_mpzaybbCrNoNWgH92H4nZ_TxXz-Lqfk_c3Nh2HUbaVcjsvnNBp4Ucd78LXGLQ5YizexorDma7y-fcR5cDed0Ro0NqrEA-8zyqn9BViSZvhaMv07p-gZeay1aneUBc0qJgzMaNuU2Lv-B3FFGyZ_KIVjq9tuSLMT_UuzdDnfrDZptF4mcXSbJOmMHmm2TOerON7Eq3idRHEaLc8z-s9_v5jfxus0SeP1Il2la2TMKJTuXD32_yf3uMi49zO9ivN_PbuP6w)


## Beschrijving van schema
### Enititeiten
Om de database voor het Video Game History Foundation uit te werken, maken we gebruik van 5 entiteiten. De eerste entiteit is een game, deze bevat een unieke id, een titel, het platform waarop het spel gespeeld kan worden, de maker, het genre, de beschrijving van het spel, de uitgeefdatum, het totale aantal kopieën van de game en tot slot de status van het spel (uitgeleend, in een museum, verkocht). We gaan er vanuit dat elke game op een locatie ligt in een museum als opslagplaats, dus is het museum de volgende entiteit die gekoppeld is aan de game. Het museum bevat ook een unieke id, een naam, locatie, aantal bezoekers per jaar, kost van toegang voor bezoekers en eventuele donaties. Wanneer we willen weten wat er met een game gebeurd is, vallen we terug op de transactie entiteit, deze bevat het unieke transactie id, de id van de game waarover het gaat, de id van het museum waar de transactie gebeurd is, de datum en het transactie type (aankoop, huur, donatie). Elke transactie gebeurt door een klant en dat is onze volgende entiteit, deze bevat de gegevens van de klant, dus client id, email, wachtwoord, geboortedatum, gender, voor- en achternaam. De bedoeling van transaction is om eerder bepaalde aspecten te scheiden/af te zonderen van de client zelf. Op deze manier zorgen we ervoor dat we een client vooral gegevens zoals email,password, id enzovoort heeft wat vooral gebruikt wordt voor een persoon terwijl we het handelen zelf laten aan een transaction entiteit. Zo kunnen we aan de hand van de transactie meteen zien waar, wanneer en door wie een game verplaatst is. Tot slot hebben we de consoleType entiteit, deze bevat de id, naam en fabrikant als variabelen. Deze entiteit is om de games te klassificeren voor welke game console ze zijn.

### Relaties tussen entiteiten
Er is een veel-op-veel relatie tussen game en museum. Een game(of games) kan zich in meerdere musea bevinden aangezien er ook copies van een game mogelijk zijn. Tegelijk kan een museum meer dan één game bevatten wat dus uiteindelijk een veel-op-veel relatie oplevert. Dit is een representatie van een real-world museum of library die bezocht kan worden om spellen te bekijken. Op onze klassendiagram wordt dit getoond als 0..* - 0..* om aan te geven dat een een game zich in geen of meerdere musea kan bevinden en anderszijds dat een museum geen maar normaliter meerdere games bevat.


Tussen de entiteiten consoleType en game is er een veel-op-veel relatie aanwezig. Een consoleType of platform bevat minstens een game die geschikt is voor dat specifieke consoleType en een game kan zich op meerdere platformen bevinden. De property platform in game is dus eigenlijk een verwijzing naar de consoleType entiteit die een name heeft wat dus de console zelf is. Indien men een bepaalde game wil uitlenen van een museum kan men dus ook controleren of een game wel degelijk geschikt is voor het gewenste consoleType/platform. Op onze klassendiagram geven we dit aan met 1..* - 1..* aangezien elk game wordt ontworpen om op zijn minst op een platform te werken en omgekeerd wordt een platform/consoleType gemaakt met de bedoeling dat het minstens één maar liefst meer games ondersteunt.

Daarnaast bevat elk transactie een game, terwijl niet elk game een onderdeel moet zijn van een transactie wat de relatie tussen game en transactie verklaart. Bij het uitvoeren van een transactie wordt er altijd een game meegegeven aangezien we daarmee iets willen doen, bijvoorbeeld wanneer we willen wat er gebeurd is met een game.

Tussen museum en transaction is er ook een 1-op-veel relatie. De transaction entiteit zorgt ervoor dat een client of persoon interactie kan hebben met een museum. Een museum kan meerdere transacties hebben maar een bepaalde transactie heeft slechts betrekking tot één van de musea. Als je bijvoorbeeld Minecraft wil ophalen van Museum X, is dat een specifieke transactie gelinkt aan Museum X. Andersom kan een museum meerdere transacties behandelen wat ons uiteindelijk een 1-op-veel relatie oplevert. 

Client-transaction is dan een 1-op-veel relatie. Interactie met een museum gebeurt aan de hand van een transactie waarvoor we dus het transaction entiteit gebruiken. Elk transactie die plaatsvindt is specifiek aan een client terwijl een client meerdere transacties kan uitvoeren. Hier stelt een client een persoon voor die bijvoorbeeld een game wil checken of het beschikbaar is in een museum. We achten een relatie tussen client-transactie nodig omdat een transactie zelf ook wat aspecten bevat die niet helemaal bij een client zouden passen, waarbij we bij een client eerder focussen op "account" gedeelte van een persoon. Het uitvoeren van een handeling zelf is dus het transition entiteit.
