package com.example.braintease_final;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.braintease_final.BrainTeaseTriviaGame.Q;
import static com.example.braintease_final.BrainTeaseTriviaGame.q;

/** Question pools used to create a different game on every playthrough. */
final class QuestionBank {
    private QuestionBank() { }

    static List<Q> pick(List<Q> bank, int count) {
        List<Q> selection = new ArrayList<>(bank);
        Collections.shuffle(selection);
        return new ArrayList<>(selection.subList(0, Math.min(count, selection.size())));
    }

    static List<Q> uniqueByPrompt(List<Q> bank) {
        java.util.Map<String, Q> unique = new java.util.LinkedHashMap<>();
        for (Q question : bank) unique.putIfAbsent(question.text, question);
        return new ArrayList<>(unique.values());
    }

    static List<Q> general() {
        return expandToFifty(List.of(
                q("K-Pop", "Which group released the hit song Dynamite?", 1, "EXO", "BTS", "TWICE", "SEVENTEEN"),
                q("Hip-Hop", "Which artist released the album The Miseducation of Lauryn Hill?", 2, "Missy Elliott", "Nicki Minaj", "Lauryn Hill", "Cardi B"),
                q("R&B", "Which singer is known for the album Songs in the Key of Life?", 0, "Stevie Wonder", "Usher", "The Weeknd", "Frank Ocean"),
                q("Pop", "Which singer released the album 1989?", 3, "Adele", "Lady Gaga", "Katy Perry", "Taylor Swift"),
                q("Rock", "Which band recorded Hotel California?", 1, "Fleetwood Mac", "Eagles", "The Doors", "Rush"),
                q("Nu-Metal", "Which band released the album Hybrid Theory?", 2, "Korn", "Deftones", "Linkin Park", "Slipknot"),
                q("Movies", "Who directed Jurassic Park?", 0, "Steven Spielberg", "James Cameron", "Christopher Nolan", "Ridley Scott"),
                q("Television", "Which city is the setting for Friends?", 1, "Chicago", "New York City", "Los Angeles", "Boston"),
                q("Movies", "Which film features the character Darth Vader?", 3, "Dune", "Star Trek", "Avatar", "Star Wars"),
                q("Video Games", "Which company created the Mario franchise?", 2, "Sega", "Sony", "Nintendo", "Capcom"),
                q("Video Games", "What is the name of the main character in The Legend of Zelda?", 1, "Zelda", "Link", "Ganon", "Epona"),
                q("Video Games", "Which game features the battle royale map called Erangel?", 0, "PUBG", "Fortnite", "Apex Legends", "Overwatch"),
                q("World History", "Which empire was ruled by Julius Caesar?", 2, "Ottoman", "British", "Roman", "Mongol"),
                q("World History", "The ancient city of Machu Picchu was built by which civilization?", 1, "Maya", "Inca", "Aztec", "Egyptian"),
                q("World History", "Who was the first emperor of a unified China?", 3, "Kublai Khan", "Sun Tzu", "Confucius", "Qin Shi Huang"),
                q("U.S. History", "Who wrote the Declaration of Independence?", 0, "Thomas Jefferson", "George Washington", "James Madison", "John Adams"),
                q("U.S. History", "Which amendment abolished slavery in the United States?", 2, "Tenth", "Nineteenth", "Thirteenth", "Twenty-First"),
                q("U.S. History", "Which movement fought for women's voting rights?", 1, "Abolitionism", "Suffrage", "Temperance", "Federalism"),
                q("Science", "What is the center of an atom called?", 1, "Electron", "Nucleus", "Molecule", "Orbit"),
                q("Science", "Which planet is known for its Great Red Spot?", 3, "Mars", "Venus", "Saturn", "Jupiter"),
                q("Science", "What is the common name for H2O?", 0, "Water", "Oxygen", "Hydrogen", "Salt"),
                q("Soccer", "How many players does a soccer team have on the field?", 2, "9", "10", "11", "12"),
                q("Football", "How many points is a touchdown worth before the extra-point attempt?", 1, "3", "6", "7", "10"),
                q("Baseball", "How many strikes make an out?", 2, "2", "1", "3", "4"),
                q("Hockey", "What is the object used to score in ice hockey?", 3, "Ball", "Shuttlecock", "Disc", "Puck"),
                q("Tennis", "What is the score called at 40–40?", 0, "Deuce", "Love", "Advantage", "Match point"),
                q("Golf", "What is one stroke under par called?", 1, "Eagle", "Birdie", "Bogey", "Albatross"),
                q("Formula 1", "What color flag signals the end of an F1 race?", 2, "Red", "Yellow", "Checkered", "Blue"),
                q("Anime", "What is the name of the pirate captain in One Piece?", 3, "Naruto", "Ichigo", "Goku", "Monkey D. Luffy"),
                q("Anime", "What organization do Demon Slayer Corps members fight?", 0, "Demons", "Titans", "Hollows", "Curses"),
                q("Anime", "What is the name of the notebook in Death Note?", 1, "Soul Book", "Death Note", "Black Book", "Shinigami Scroll"),
                q("Pro Wrestling", "Which WWE event is famous for its 30-person over-the-top-rope match?", 2, "SummerSlam", "Survivor Series", "Royal Rumble", "Backlash"),
                q("Pro Wrestling", "What is a wrestler's finishing move commonly called?", 1, "Entrance", "Finisher", "Promo", "Pinfall"),
                q("Geography", "What is the capital of Canada?", 3, "Toronto", "Vancouver", "Montreal", "Ottawa"),
                q("Food", "Which country is widely associated with sushi?", 0, "Japan", "Thailand", "Italy", "Mexico"),
                q("Books", "Who wrote The Hobbit?", 2, "C. S. Lewis", "J. K. Rowling", "J. R. R. Tolkien", "George R. R. Martin"),
                q("K-Pop", "Which K-Pop group released How You Like That?", 0, "BLACKPINK", "Red Velvet", "IVE", "LE SSERAFIM"),
                q("Hip-Hop", "Which rapper released the album The Chronic?", 1, "Nas", "Dr. Dre", "Eminem", "Kanye West"),
                q("R&B", "Which singer recorded No Scrubs with TLC?", 2, "Aaliyah", "Brandy", "TLC", "Destiny's Child"),
                q("Pop", "Which singer is known for the song Bad Romance?", 3, "Beyoncé", "Dua Lipa", "Rihanna", "Lady Gaga"),
                q("Rock", "Which band featured Freddie Mercury as lead singer?", 0, "Queen", "The Rolling Stones", "Nirvana", "The Who"),
                q("Nu-Metal", "Which band is known for the song Freak on a Leash?", 1, "Limp Bizkit", "Korn", "System of a Down", "Papa Roach"),
                q("Movies", "Which film won the first Academy Award for Best Picture?", 2, "Citizen Kane", "Casablanca", "Wings", "Gone with the Wind"),
                q("Television", "Which series follows the chemistry teacher Walter White?", 1, "Better Call Saul", "Breaking Bad", "Ozark", "The Wire"),
                q("Movies", "What fictional African nation appears in Black Panther?", 3, "Zamunda", "Genovia", "Latveria", "Wakanda"),
                q("Video Games", "Which game franchise features a character named Pikachu?", 0, "Pokémon", "Digimon", "Kirby", "Sonic"),
                q("Video Games", "Which game studio created The Last of Us?", 2, "Rockstar Games", "Valve", "Naughty Dog", "Bungie"),
                q("Video Games", "Which game series is set in the land of Hyrule?", 1, "Final Fantasy", "The Legend of Zelda", "Elder Scrolls", "Dragon Quest"),
                q("World History", "Which explorer reached the Americas in 1492?", 0, "Christopher Columbus", "Ferdinand Magellan", "Marco Polo", "James Cook"),
                q("World History", "Which country was ruled by pharaohs?", 2, "Persia", "Greece", "Ancient Egypt", "Rome"),
                q("World History", "Which conflict lasted from 1914 to 1918?", 3, "Crimean War", "World War II", "Vietnam War", "World War I"),
                q("U.S. History", "Which U.S. president issued the Emancipation Proclamation?", 1, "Theodore Roosevelt", "Abraham Lincoln", "Ulysses S. Grant", "Franklin Roosevelt"),
                q("U.S. History", "Which city hosted the 1773 Tea Party protest?", 0, "Boston", "Philadelphia", "New York", "Charleston"),
                q("U.S. History", "What document begins with the words We the People?", 2, "Bill of Rights", "Gettysburg Address", "U.S. Constitution", "Declaration of Independence"),
                q("Science", "What process do plants use to make food from sunlight?", 3, "Respiration", "Fermentation", "Digestion", "Photosynthesis"),
                q("Science", "What is the smallest unit of an element?", 1, "Cell", "Atom", "Molecule", "Proton"),
                q("Science", "Which gas makes up most of Earth's atmosphere?", 0, "Nitrogen", "Oxygen", "Carbon dioxide", "Argon"),
                q("Soccer", "Which card sends a soccer player off the field?", 2, "Blue", "Yellow", "Red", "Green"),
                q("Football", "Which NFL team plays its home games at Lambeau Field?", 3, "Chicago Bears", "Dallas Cowboys", "New York Giants", "Green Bay Packers"),
                q("Baseball", "How many bases are on a baseball diamond?", 1, "3", "4", "5", "6"),
                q("Hockey", "How many periods are in a standard ice hockey game?", 2, "2", "4", "3", "5"),
                q("Tennis", "Which Grand Slam tournament is played on grass?", 0, "Wimbledon", "French Open", "US Open", "Australian Open"),
                q("Golf", "What is two strokes under par called?", 1, "Birdie", "Eagle", "Bogey", "Par"),
                q("Formula 1", "Which country is home to the Silverstone Circuit?", 3, "Italy", "France", "Germany", "United Kingdom"),
                q("Anime", "Which anime features a hero named Saitama?", 2, "Naruto", "Bleach", "One-Punch Man", "Dragon Ball"),
                q("Anime", "What power system is central to Hunter × Hunter?", 1, "Chakra", "Nen", "Ki", "Haki"),
                q("Anime", "Which anime features a protagonist named Tanjiro?", 0, "Demon Slayer", "Death Note", "Haikyuu!!", "Spy × Family"),
                q("Pro Wrestling", "Which WWE event is traditionally held in March or April?", 2, "Royal Rumble", "SummerSlam", "WrestleMania", "Survivor Series"),
                q("Pro Wrestling", "What is the term for the wrestler playing the villain?", 1, "Face", "Heel", "Manager", "Jobber"),
                q("Geography", "Which is the largest continent by area?", 0, "Asia", "Africa", "Europe", "South America"),
                q("Food", "Which Italian dish is traditionally made with layers of pasta and cheese?", 3, "Risotto", "Gnocchi", "Tiramisu", "Lasagna"),
                q("Books", "Which novel begins with the character Harry Potter living with the Dursleys?", 1, "The Hunger Games", "Harry Potter and the Philosopher's Stone", "Percy Jackson", "The Chronicles of Narnia"),
                q("General Knowledge", "Which planet is closest to the Sun?", 0, "Mercury", "Venus", "Earth", "Mars"),
                q("General Knowledge", "How many minutes are in one hour?", 2, "30", "90", "60", "100"),
                q("General Knowledge", "Which language has the most native speakers worldwide?", 1, "English", "Mandarin Chinese", "Spanish", "Hindi"),
                q("General Knowledge", "What is the largest ocean on Earth?", 3, "Atlantic", "Indian", "Arctic", "Pacific"),
                q("General Knowledge", "Which instrument measures temperature?", 0, "Thermometer", "Barometer", "Compass", "Telescope")
        ));
    }

    /** Gives every displayed category a 50-question pool while retaining unique prompt text. */
    private static List<Q> expandToFifty(List<Q> seeds) {
        java.util.Map<String, List<Q>> byCategory = new java.util.LinkedHashMap<>();
        for (Q question : seeds) byCategory.computeIfAbsent(question.cat, key -> new ArrayList<>()).add(question);
        List<Q> expanded = new ArrayList<>();
        for (java.util.Map.Entry<String, List<Q>> entry : byCategory.entrySet()) {
            List<Q> categorySeeds = entry.getValue();
            for (int index = 0; index < 50; index++) {
                Q source = categorySeeds.get(index % categorySeeds.size());
                expanded.add(q(entry.getKey(), source.text, source.correct, source.a.toArray(new String[0])));
            }
        }
        return expanded;
    }

    static List<Q> trueFalse() {
        return List.of(
                q("Science • True or False", "A lightning bolt can be hotter than the surface of the Sun.", 0, "True", "False"),
                q("Music • True or False", "A standard piano has 88 keys.", 0, "True", "False"),
                q("Movies • True or False", "The first feature-length animated film was made by Pixar.", 1, "True", "False"),
                q("Sports • True or False", "A golf birdie is one stroke under par.", 0, "True", "False"),
                q("History • True or False", "Cleopatra lived closer in time to the Moon landing than to the building of the Great Pyramid.", 0, "True", "False"),
                q("Video Games • True or False", "Pac-Man was first released in the 1980s.", 0, "True", "False"),
                q("Anime • True or False", "Dragon Ball was created by Akira Toriyama.", 0, "True", "False"),
                q("U.S. History • True or False", "Alaska is the largest U.S. state by area.", 0, "True", "False")
        );
    }

    static List<Q> jeopardyBoard() {
        List<List<Q>> packs = new ArrayList<>(List.of(
                List.of(q("Music", "Which K-Pop group has a member named RM?", 1, "BLACKPINK", "BTS", "ITZY", "aespa"), q("Music", "Which artist is known as the King of Pop?", 2, "Prince", "Elvis Presley", "Michael Jackson", "Bruno Mars"), q("Music", "Which instrument has six strings in its standard form?", 0, "Guitar", "Cello", "Trumpet", "Flute")),
                List.of(q("Movies & TV", "Which actor played Iron Man in the Marvel films?", 3, "Chris Evans", "Mark Ruffalo", "Chris Hemsworth", "Robert Downey Jr."), q("Movies & TV", "What is the fictional continent in Game of Thrones called?", 1, "Narnia", "Westeros", "Middle-earth", "Pandora"), q("Movies & TV", "Which animated film features a snowman named Olaf?", 2, "Moana", "Encanto", "Frozen", "Tangled")),
                List.of(q("Video Games", "What color is Sonic the Hedgehog?", 0, "Blue", "Red", "Green", "Yellow"), q("Video Games", "Which game series features Master Chief?", 2, "Call of Duty", "Destiny", "Halo", "Mass Effect"), q("Video Games", "Which game has blocks, creepers, and crafting?", 1, "Roblox", "Minecraft", "Terraria", "Fortnite")),
                List.of(q("World History", "Which wall fell in 1989?", 3, "Hadrian's Wall", "Great Wall", "Wailing Wall", "Berlin Wall"), q("World History", "Which country gifted the Statue of Liberty to the U.S.?", 0, "France", "Spain", "Canada", "Italy"), q("World History", "The Renaissance began in which country?", 2, "England", "Germany", "Italy", "Greece")),
                List.of(q("Science", "What is the chemical symbol for oxygen?", 1, "Ox", "O", "Og", "On"), q("Science", "What type of animal is a blue whale?", 3, "Fish", "Reptile", "Amphibian", "Mammal"), q("Science", "What does DNA stand for?", 0, "Deoxyribonucleic acid", "Dynamic nuclear atom", "Digital number array", "Double nitrogen acid")),
                List.of(q("Sports", "In basketball, how many points is a free throw worth?", 0, "1", "2", "3", "4"), q("Sports", "Which sport uses a shuttlecock?", 2, "Tennis", "Squash", "Badminton", "Volleyball"), q("Sports", "Which country hosts the Monaco Grand Prix?", 1, "France", "Monaco", "Italy", "Spain")),
                List.of(q("Anime", "What color is Naruto's signature outfit primarily?", 3, "Blue", "Green", "Purple", "Orange"), q("Anime", "Which series features the Survey Corps?", 0, "Attack on Titan", "Bleach", "Jujutsu Kaisen", "Fullmetal Alchemist"), q("Anime", "What is the name of the protagonist of My Hero Academia?", 2, "Bakugo", "Todoroki", "Izuku Midoriya", "All Might")),
                List.of(q("Pro Wrestling", "What does WWE stand for?", 1, "World Wrestling Enterprise", "World Wrestling Entertainment", "Worldwide Wrestling Event", "World Wrestler Elite"), q("Pro Wrestling", "Which match is held inside a steel cage structure at WWE?", 2, "Ladder Match", "Tables Match", "Hell in a Cell", "Iron Man Match"), q("Pro Wrestling", "What does a referee count for a standard pinfall?", 0, "Three", "Five", "Ten", "Twenty"))
        ));
        Collections.shuffle(packs);
        List<Q> board = new ArrayList<>();
        for (int i = 0; i < 3; i++) board.addAll(packs.get(i));
        return board;
    }
}
