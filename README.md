### OOP Stanislav Ch. Rehor 
### štvrtok 9:00

# Pracovná verzia programu

V pracovnej verzii sa mi úspešne podarilo využiť 
[trojvrstvové dedenie](/src/main/java/com/stanrehor/oop/model/items/miscellaneous/QuestItems.java),
[polymorfizmus](https://github.com/OOP-FIIT/oop-2022-stv-9-a-povazanova-schrehor/blob/85da0c1d26124705b17b2af66ef83356179acf7d/src/main/java/com/stanrehor/oop/model/characters/Character.java#L36),
[agregácia](https://github.com/OOP-FIIT/oop-2022-stv-9-a-povazanova-schrehor/blob/85da0c1d26124705b17b2af66ef83356179acf7d/src/main/java/com/stanrehor/oop/controller/AuctionController.java#L19) a 
oddelenie aplikačnej logiky od používateľského rozhrania použiťím MVC.

Program dokáže úspešne vytvoriť nového hráča a vygenerovať mu inventár. Prihlasovanie a práca s heslami, ako aj zlé vstupy napr. prázdne meno hráča, ešte nie sú ošetrené.
Samotná aukcia ešte nie je plnohodnotne implementovaná, mám totiž menší problém dostať prvky z inventára do TableView štruktúry, ktorú som si vybral ako spôsob ukazovania 
položiek a inventára.

V projekte sa mi ešte podarilo využiť návrhový vzor [Factory](/src/main/java/com/stanrehor/oop/model/characters/CharacterFactory.java)


