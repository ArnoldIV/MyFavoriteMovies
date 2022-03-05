package com.arnold.myfavoritemovies.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Genre.class, Movie.class}, version = 1)
public abstract class MoviesDataBase extends RoomDatabase {

    public static MoviesDataBase instance;

    public abstract GenreDao getGenreDao();

    public abstract MovieDao getMovieDao();

    public static synchronized MoviesDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MoviesDataBase.class,
                    "moviesDB").fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new InitialDataAsyncTask(instance).execute();
        }
    };

    private static class InitialDataAsyncTask extends AsyncTask<Void, Void, Void> {
        private GenreDao genreDao;
        private MovieDao movieDao;

        public InitialDataAsyncTask(MoviesDataBase dataBase) {
            genreDao = dataBase.getGenreDao();
            movieDao = dataBase.getMovieDao();

        }

        //all genre
        @Override
        protected Void doInBackground(Void... voids) {

            //creating a genre
            Genre actionGenre = new Genre();
            actionGenre.setGenreName("Action");

            Genre comedyGenre = new Genre();
            comedyGenre.setGenreName("Comedy");

            Genre westernGenre = new Genre();
            westernGenre.setGenreName("Western");

            Genre detectiveGenre = new Genre();
            detectiveGenre.setGenreName("Detective");

            Genre fantasyGenre = new Genre();
            fantasyGenre.setGenreName("Fantasy");

            Genre horrorGenre = new Genre();
            horrorGenre.setGenreName("Horror");

            Genre thrillerGenre = new Genre();
            thrillerGenre.setGenreName("Thriller");

            Genre noirGenre = new Genre();
            noirGenre.setGenreName("Noir");

            Genre crimeGenre = new Genre();
            crimeGenre.setGenreName("Crime");

            Genre cartoonGenre = new Genre();
            cartoonGenre.setGenreName("Cartoon");

            Genre adventureGenre = new Genre();
            adventureGenre.setGenreName("Adventure");

            Genre romanceGenre = new Genre();
            romanceGenre.setGenreName("Romance");

            Genre dramaGenre = new Genre();
            dramaGenre.setGenreName("Drama");

            //inserting of genres in genreDAO
            genreDao.insert(actionGenre); //1
            genreDao.insert(comedyGenre); //2
            genreDao.insert(westernGenre); //3
            genreDao.insert(detectiveGenre); //4
            genreDao.insert(fantasyGenre); //5
            genreDao.insert(horrorGenre); //6
            genreDao.insert(thrillerGenre); //7
            genreDao.insert(noirGenre); //8
            genreDao.insert(crimeGenre); //9
            genreDao.insert(cartoonGenre); //10
            genreDao.insert(adventureGenre); //11
            genreDao.insert(romanceGenre); //12
            genreDao.insert(dramaGenre); //13

            //creating a movies
            Movie movie12 = new Movie();
            movie12.setMovieName("007:No time to die");
            movie12.setMovieDescription("007 agent James Bond deserves a break from the super agent's operational service. Unfortunately, his calm was cut short - an old CIA friend, Felix Leiter, came to Jamaica to ask Bond for a favor. We need to rescue a kidnapped scientist - sounds pretty simple for a super agent, but everything turned out to be much more complicated...");
            movie12.setGenreId(1);

            Movie movie13 = new Movie();
            movie13.setMovieName("Suicide Squad: Mission Blast");
            movie13.setMovieDescription("Welcome to Hell or Belle Reve, the prisons with the highest death rate in the US. The place where the most dangerous villains of the world are kept. The criminals will do anything to get out, even joining the super-secret task force X-Squad!");
            movie13.setGenreId(1);

            Movie movie14 = new Movie();
            movie14.setMovieName("Shang-Chi and the Legend of the Ten Rings");
            movie14.setMovieDescription("The past, which seemed to be left behind, confronts Shang-Chi again when he is drawn into the network of a mystical organization called the Ten Rings.");
            movie14.setGenreId(1);

            Movie movie15 = new Movie();
            movie15.setMovieName("Justice League Zack Snyder");
            movie15.setMovieDescription("Director's cut of the 2017 Justice League movie. Inspired by Superman's self-sacrifice, Bruce Wayne regains faith in humanity. He enlists the help of a new ally, Diana Prince, to take on an even more powerful foe. Batman and Wonder Woman recruit a team of superhumans to fight the awakened threat.");
            movie15.setGenreId(1);

            Movie movie16 = new Movie();
            movie16.setMovieName("The Matrix Resurrections");
            movie16.setMovieDescription("In the film, we return to a world with two realities. One is everyday life, the other exists outside of everyday life. Is reality a physical or mental construct?");
            movie16.setGenreId(1);

            Movie movie1 = new Movie();
            movie1.setMovieName("Bad Boys for Life");
            movie1.setMovieDescription("The Bad Boys Mike Lowrey and Marcus Burnett are back together for one last ride in the highly anticipated Bad Boys for Life.");
            movie1.setGenreId(2);

            Movie movie2 = new Movie();
            movie2.setMovieName("Parasite");
            movie2.setMovieDescription("All unemployed, Ki-taek and his family take peculiar interest in the wealthy and glamorous Parks, as they ingratiate themselves into their lives and get entangled in an unexpected incident.");
            movie2.setGenreId(2);

            Movie movie3 = new Movie();
            movie3.setMovieName("Once Upon a Time... in Hollywood");
            movie3.setMovieDescription("A faded television actor and his stunt double strive to achieve fame and success in the film industry during the final years of Hollywood's Golden Age in 1969 Los Angeles.");
            movie3.setGenreId(2);

            Movie movie11 = new Movie();
            movie11.setMovieName("Ghostbusters: Descendants");
            movie11.setMovieDescription("After being evicted, a single mother, along with two children, is forced to go to the town of Summerville, to a farm inherited by her father, whom the woman never knew. On the territory of the old house, children discover an unusual car that once belonged to ghost hunters. This team became so legendary that over the years people began to perceive them as mythical heroes.");
            movie11.setGenreId(2);

            Movie movie10 = new Movie();
            movie10.setMovieName("The hitman`s bodyguardian");
            movie10.setMovieDescription("A world-class killer throughout his extensive career has not made a single puncture, his reputation is impeccable. The hero has already earned himself a comfortable old age, so he decides to retire and make peace with the authorities, having handed over a couple of influential customers. The underworld has stirred up, now everyone dreams of getting the corpse of a traitor. The former hitman now needs a bodyguard himself.");
            movie10.setGenreId(2);

            Movie movie17 = new Movie();
            movie17.setMovieName("1883");
            movie17.setMovieDescription("The story of the glorious ancestors of the Duttton family, who set off on a journey west across the Great Plains to the last stronghold of wild America. The story of the development of the Wild West will be shown through the eyes of a family fleeing poverty, who hopes to find a better future in America's promised land - Montana.");
            movie17.setGenreId(3);

            Movie movie18 = new Movie();
            movie18.setMovieName("The Kid");
            movie18.setMovieDescription("Teenage boy Billy contacts the Wild West's master criminal, Billy the Kid, to get revenge on his uncle for his father's death and save his sister. Caught in a bitter showdown between a mobster and his enemy Sheriff Pat Garrett, little Billy struggles to choose the right side.");
            movie18.setGenreId(3);

            Movie movie19 = new Movie();
            movie19.setMovieName("Les frères Sisters");
            movie19.setMovieDescription("Meet the Sisters brothers: Eli and Charlie. They make a living by killing people. Such as the assassins of the 50s of the nineteenth century in Oregon. Those days in the United States were marked by a gold rush and constant killings left and right.");
            movie19.setGenreId(3);

            Movie movie20 = new Movie();
            movie20.setMovieName("Godless");
            movie20.setMovieDescription("The action takes place in 1884. A sinister bandit, Frank Griffin, terrorizes the Wild West in search of his adopted son and ex-partner, Roy Hood, who suddenly had a guilty conscience and left Frank with the loot from the last raid. The search leads Frank to the quiet town of La Belle, which, by strange circumstances, is inhabited only by women.");
            movie20.setGenreId(3);

            Movie movie21 = new Movie();
            movie21.setMovieName("The Magnificent Seven");
            movie21.setMovieDescription("A group of brave warriors defends the small village of Rose Creek, which is terrorized by the bloody gang of Bartolomeu Boge. Each of them has their own history and their own unique fighting style behind them - some are good with fists, and some are sharp with words and cunning. Together they will fight back against the worst bandits of the Wild West.");
            movie21.setGenreId(3);

            Movie movie22 = new Movie();
            movie22.setMovieName("Old");
            movie22.setMovieDescription("The family travels to a remote tropical island to relax and have a great time together. Subsequently, they realize that in a few hours of being there, they have aged for decades. Now their whole life is just a matter of time...");
            movie22.setGenreId(4);

            Movie movie23 = new Movie();
            movie23.setMovieName("You Should Have Left");
            movie23.setMovieDescription("A famous screenwriter travels to a secluded home nestled among the Alps with his family to write a sequel to his popular film. But very soon he is forced to regret his decision.");
            movie23.setGenreId(4);

            Movie movie24 = new Movie();
            movie24.setMovieName("The Empty Man");
            movie24.setMovieDescription("In search of a missing girl, a former police officer is on the trail of a secret group, whose members are obsessed with the idea of summoning some kind of supernatural entity into our world.");
            movie24.setGenreId(4);

            Movie movie25 = new Movie();
            movie25.setMovieName("When the Street Lights Go On");
            movie25.setMovieDescription("A quiet town is at the center of a police investigation when one of the main characters of the story discovers the bodies of a local schoolgirl and teacher in the forest.");
            movie25.setGenreId(4);

            Movie movie26 = new Movie();
            movie26.setMovieName("Pokémon: Detective Pikachu");
            movie26.setMovieDescription("Have you dreamed of having your own Pokémon? What about a world-class detective named Pikachu? In a world where humans and Pokémon exist in harmony, this is possible. Twenty-one-year-old Tim and Pikachu met under very strange circumstances - the father of a guy who was one of the best detectives in the world disappeared during mysterious events.");
            movie26.setGenreId(4);

            Movie movie27 = new Movie();
            movie27.setMovieName("Gretel & Hansel");
            movie27.setMovieDescription("Many, many years ago, in a distant, almost fairy-tale land, a teenage girl, along with her little brother, went into a dark forest in the hope of finding food and at least some kind of work that could feed them later. Their names are Hansel and Gretel.");
            movie27.setGenreId(5);

            Movie movie28 = new Movie();
            movie28.setMovieName("Nine Days");
            movie28.setMovieDescription("The hermit lives in a house located outside the boundaries of ordinary reality. There he communicates with various candidates - the personifications of human souls. One of these candidates will be awarded the right to be born.");
            movie28.setGenreId(5);

            Movie movie29 = new Movie();
            movie29.setMovieName("Mortal");
            movie29.setMovieDescription("For the Scandinavians, you can only cheer: regardless of the influx of globalization, the stench could save the power of tradition and culture. That way, Scandinavian culture has become the light of the bathhouses. Aje, who among us does not feel about the majestic and warlike Varangians-vikings, about the runes and Scandinavian legends, about the gods Odina and Torah ...");
            movie29.setGenreId(5);

            Movie movie30 = new Movie();
            movie30.setMovieName("Valhalla");
            movie30.setMovieDescription("Ask any of the Scandinavians what \"Ragnarok\" is, and they will give you an exhaustive answer without a second's hesitation. But if in a nutshell - this is the end of the world, when the great gods of Asgard will fight in mortal combat with the ancient giants from Jotenheim. Everyone knows what will happen then, because it is destined by fate.");
            movie30.setGenreId(5);

            Movie movie31 = new Movie();
            movie31.setMovieName("Fantastic Beasts: The Crimes of Grindelwald");
            movie31.setMovieDescription("Continuation of adventures in magical poterrians. Newt Scamander, along with MACUSA (United States Magical Congress), managed to chain the incredibly dangerous dark wizard Gelert Grindelwald. Despite all the precautions, the magician still managed to escape.");
            movie31.setGenreId(5);

            Movie movie32 = new Movie();
            movie32.setMovieName("Escape Room: Tournament of Champions");
            movie32.setMovieDescription("Six strangers, each of whom became the sole winner of one of the last death quests, are once again locked in a trap. However, this time they face even more cruel and ruthless tasks. To survive, the participants will have to solve this merciless and ingenious puzzle.");
            movie32.setGenreId(6);

            Movie movie33 = new Movie();
            movie33.setMovieName("Candyman");
            movie33.setMovieDescription("There is a legend about the mysterious Candyman - a ghost from a parallel world. But one has only to stand in front of the mirror and pronounce his name five times in a row, the darkness will cross the border. A spooky sequel revives a terrifying urban legend and brings it to the present day!");
            movie33.setGenreId(6);

            Movie movie34 = new Movie();
            movie34.setMovieName("The Black Phone");
            movie34.setMovieDescription("After a horrific kidnapping, a 13-year-old finds himself locked in a soundproof basement with a broken black phone. Suddenly, the guy receives a call from the previous victims of the killer, who are trying to save him at all costs...");
            movie34.setGenreId(6);

            Movie movie35 = new Movie();
            movie35.setMovieName("Hypnotic");
            movie35.setMovieDescription("A young woman obsessed with self-improvement seeks the help of a well-known hypnotherapist. But experiments with the disclosure of inner potential and the search for answers to all questions will not lead to anything good...");
            movie35.setGenreId(6);

            Movie movie36 = new Movie();
            movie36.setMovieName("Paranormal Activity: Next of Kin");
            movie36.setMovieDescription("The plot revolves around a young documentary filmmaker who travels to a small town in the middle of nowhere in search of her mother. Seemingly strange residents are involved in a terrible secret.");
            movie36.setGenreId(6);

            Movie movie37 = new Movie();
            movie37.setMovieName("Wrong Turn");
            movie37.setMovieDescription("A group of friends come to Harpers Ferry to hike the Appalachian Trail. In these parts, they encounter a community of people who lived in the mountains even before the Civil War. And who really don't like strangers.");
            movie37.setGenreId(7);

            Movie movie38 = new Movie();
            movie38.setMovieName("The Ice Road");
            movie38.setMovieDescription("Thin ice. Truck weight - 33 tons. It is possible to drive on the frozen surface of the water only at a certain speed, because stopping or accelerating means certain death. But this is precisely the task facing the convoy of trucks led by an experienced driver Mike. Only they can save people from the death trap. However, neither the ice nor the massive snowstorm can compare to the threat that lies ahead...");
            movie38.setGenreId(7);

            Movie movie39 = new Movie();
            movie39.setMovieName("Warning");
            movie39.setMovieDescription("In the near future technology, people were practically spared the need for physical contact one with one. Everything changes, if the interplanetary storm disturbs the electronics of the whole world, it goes out of tune.");
            movie39.setGenreId(7);

            Movie movie40 = new Movie();
            movie40.setMovieName("13 Minutes");
            movie40.setMovieDescription("The biggest tornado in history threatens to devastate a small town, leaving residents with only 13 minutes to find shelter, find loved ones and fight for their lives.");
            movie40.setGenreId(7);

            Movie movie41 = new Movie();
            movie41.setMovieName("Greenland");
            movie41.setMovieDescription("The wreckage of a giant comet is rushing towards Earth and threatens to destroy the planet. The end of the world seems inevitable. The only safe place is a bunker in faraway Greenland. John, his wife and son embark on a dangerous journey. On their way to salvation - not only the devastating debris of the comet, but also the panic of people, distraught with horror. During a global catastrophe, human laws no longer apply, and everyone is for himself...");
            movie41.setGenreId(7);

            Movie movie42 = new Movie();
            movie42.setMovieName("The Hunt");
            movie42.setMovieDescription("Twelve people who did not know each other turned out to be incomprehensibly connected and with gag in their mouths. How they got here and why, they don't know. Having somehow freed themselves from the fetters, they were able to find the package - the box is full of various weapons. And from that moment on, a real hell began - someone arranged a hunt for these people. It has long been rumored that the rich kidnap some loners to have fun hunting them.");
            movie42.setGenreId(8);

            Movie movie43 = new Movie();
            movie43.setMovieName("The Rental");
            movie43.setMovieDescription("Have you rented through Airbnb? Have you looked at the beautiful pictures on the site and imagined the perfect vacation? Two young couples decided to break away on the ocean and rented a luxury villa. They didn't know that there were cameras in every room and they were being watched closely. Their little secrets, and with them the secret of the whole house, will come true, but this is only the beginning of the game. Who is not hiding...");
            movie43.setGenreId(8);

            Movie movie44 = new Movie();
            movie44.setMovieName("I'm Thinking of Ending Things");
            movie44.setMovieDescription("Jake travels to a remote farm to introduce his girlfriend to his parents. The irony is that she wanted to break up with Jake and is now in a difficult position. Upon arrival, it turns out that something strange is going on in the house of Jake's parents, and the potential relatives themselves are behaving very suspiciously.");
            movie44.setGenreId(8);

            Movie movie45 = new Movie();
            movie45.setMovieName("Triggered");
            movie45.setMovieDescription("After a party at a forest campsite, nine former high school friends wake up wearing explosive vests and a timer counting down the minutes until they die.");
            movie45.setGenreId(8);

            Movie movie46 = new Movie();
            movie46.setMovieName("Countdown");
            movie46.setMovieDescription("There are many more features hidden in our phones today than even a few years ago. Once, with the help of it, they only called, but now you can track your movement, physical fitness, or just play on it. There are even apps that can tell you the exact time of your death.");
            movie46.setGenreId(8);

            Movie movie47 = new Movie();
            movie47.setMovieName("The Birthday Cake");
            movie47.setMovieDescription("On the 10th anniversary of his father's death, Giovanni reluctantly agrees to bring the cake to the house of his uncle, a mob boss, for the celebration. In just two hours, Gio's life will change forever.");
            movie47.setGenreId(9);

            Movie movie48 = new Movie();
            movie48.setMovieName("The Guilty");
            movie48.setMovieDescription("An emergency dispatcher takes a call from a kidnapped woman who is in grave danger. The man immediately traces the phone and sends a patrol car to the scene, but the police find no one there. He makes a new attempt to contact the woman, but a male threatening voice is already on the phone and demands not to interfere...");
            movie48.setGenreId(9);

            Movie movie49 = new Movie();
            movie49.setMovieName("Honest Thief");
            movie49.setMovieDescription("Tom Carter is an experienced robber. But, having met love, he decides to quit crime and surrender to the FBI in exchange for a lenient sentence. And Carter is insanely unlucky: he runs into corrupt agents. And now he must fight back to clear his name and save his beloved.");
            movie49.setGenreId(9);

            Movie movie50 = new Movie();
            movie50.setMovieName("Vanguard");
            movie50.setMovieDescription("The world of business is not as clean as it might seem at first glance. If someone is among the tops at the international level, he or she cannot be absolutely calm or calm about his life and the lives of his family members. So in the UK, Chinese businessman Tang Huating, along with his daughter Mi Ya, was kidnapped by the world-famous organization of mercenary killers \"Arctic Wolves\".");
            movie50.setGenreId(9);

            Movie movie51 = new Movie();
            movie51.setMovieName("Capone");
            movie51.setMovieDescription("Returning from prison, Al Capone continues to be the subject of close attention of the FBI. Indeed, during the arrest, a large amount of money was not found - the result of all the criminal activities of the famous mafia. Bugs are placed throughout the house, every member of the large Capone family is under suspicion. Will the special services be able to get information from the gangster losing his memory, where and under what circumstances he hid the money? Or is his illness a well-thought-out game?");
            movie51.setGenreId(9);

            Movie movie52 = new Movie();
            movie52.setMovieName("The Addams Family 2");
            movie52.setMovieDescription("The legendary Addams family returns in the sequel to this hellish animated adventure! Even more intrigue, scares and strange jokes for every taste!");
            movie52.setGenreId(10);

            Movie movie53 = new Movie();
            movie53.setMovieName("Tom and Jerry");
            movie53.setMovieDescription("When Jerry moves into New York's most expensive hotel on the eve of the \"wedding of the century,\" the wedding planner is forced to hire Tom to get rid of the mouse. And a war between the two threatens to destroy her career, her wedding, and possibly the hotel itself. But an even bigger problem soon appears: a diabolically ambitious colleague is plotting against the three of them.");
            movie53.setGenreId(10);

            Movie movie54 = new Movie();
            movie54.setMovieName("Sing 2");
            movie54.setMovieDescription("Continuation of the cult animated hit from Illumination on the big screens! A new musical adventure awaits Buster and his friends on the koala. More big hits and inflammatory performances that will blow everyone away. Sing along with them soon to the cinema!");
            movie54.setGenreId(10);

            Movie movie55 = new Movie();
            movie55.setMovieName("Scooby-Doo! The Sword and the Scoob");
            movie55.setMovieDescription("An evil sorceress takes the gang to the era of knights, sorcerers and fire-breathing dragons.");
            movie55.setGenreId(10);

            Movie movie56 = new Movie();
            movie56.setMovieName("Three heroes and a horse on the throne");
            movie56.setMovieDescription("As usual, the caretaker of the princely library, the horse Julius, got into trouble. And at the same time he made the Prince happy - they accidentally exchanged bodies, of course, not without the help of an old friend - Baba Yaga and a little witchcraft. Now Julius sits in the palace and landscapes Kiev, and the Prince plows the field.");
            movie56.setGenreId(10);

            Movie movie57 = new Movie();
            movie57.setMovieName("The King's Man");
            movie57.setMovieDescription("On the street of admirers of brave agents from 11 Saville Road, a holiday - Matthew Vaughn offers to plunge into the history of the creation of the Kingsman agency, which began back in 1902 in South Africa.");
            movie57.setGenreId(11);

            Movie movie58 = new Movie();
            movie58.setMovieName("Loki");
            movie58.setMovieDescription("Loki enters the mysterious organization Temporal Change Management after he steals the Tesseract and travels through time, changing history.");
            movie58.setGenreId(11);

            Movie movie59 = new Movie();
            movie59.setMovieName("The Book of Boba Fett");
            movie59.setMovieDescription("Boba Fett, along with partner Fennec Shand, is trying to gain authority in the underworld by seizing the territory that once belonged to Jabba the Hutt.");
            movie59.setGenreId(11);

            Movie movie60 = new Movie();
            movie60.setMovieName("Sonic the Hedgehog");
            movie60.setMovieDescription("One distant and unlike Earth planet is in danger. To save her, the incredibly fast, funny and truly crazy hedgehog Sonic teleported to our home, namely the USA. The power surge after the energetic hedgehog landed with us led to a loss of power throughout the Northwest coast of the country, which did not pass by the attention of the Pentagon.");
            movie60.setGenreId(11);

            Movie movie61 = new Movie();
            movie61.setMovieName("Inglorious serfs");
            movie61.setMovieDescription("The rules of the samurai are simple: fight with two swords, train for half a day and not run into trouble for the sake of feelings. But how can you accomplish at least one when your name is Taras Shevchenko, your girlfriend is being tortured by a bastard, and your mentor is beating you to train your iron will? You will have to become a samurai in 2 days: shoot \"in Macedonian style\", run fast and finally stop staring at geishas.");
            movie61.setGenreId(11);

            Movie movie62 = new Movie();
            movie62.setMovieName("Palm Springs");
            movie62.setMovieDescription("After meeting at a wedding in Palm Springs, Miles and Sarah suddenly find themselves in a time loop. Every day they are forced to listen to the same wedding toasts and songs ... But there are also advantages: \"Groundhog Day\" gives you the opportunity to live an infinite number of lives and, therefore, realize your wildest ideas and dreams. Get ready, it's going to be hot!");
            movie62.setGenreId(12);

            Movie movie63 = new Movie();
            movie63.setMovieName("The Aftermath");
            movie63.setMovieDescription("After World War II, a British colonel and his wife are intended to live in Hamburg during post-war reconstruction, but tensions arise with the German who previously owned the house.");
            movie63.setGenreId(12);

            Movie movie4 = new Movie();
            movie4.setMovieName("You");
            movie4.setMovieDescription("A dangerously charming, intensely obsessive young man goes to extreme measures to insert himself into the lives of those he is transfixed by.");
            movie4.setGenreId(12);

            Movie movie5 = new Movie();
            movie5.setMovieName("Little Women");
            movie5.setMovieDescription("Jo March reflects back and forth on her life, telling the beloved story of the March sisters - four young women each determined to live life on their own terms.");
            movie5.setGenreId(12);

            Movie movie6 = new Movie();
            movie6.setMovieName("Vikings");
            movie6.setMovieDescription("Vikings transports us to the brutal and mysterious world of Ragnar Lothbrok, a Viking warrior and farmer who yearns to explore - and raid - the distant shores across the ocean.");
            movie6.setGenreId(12);

            Movie movie64 = new Movie();
            movie64.setMovieName("The Mauritanian");
            movie64.setMovieDescription("The true story of a Guantanamo Bay prisoner who spent 14 years behind bars. In the center of the plot is the Mauritanian Mohammed Ould Slahi. The US authorities suspect him of recruiting terrorists during the September 11 attacks. Without formal charges and the possibility of defense in court, Slakhi is sent to prison.");
            movie64.setGenreId(13);

            Movie movie65 = new Movie();
            movie65.setMovieName("The Green Knight");
            movie65.setMovieDescription("A new take on the classic Arthurian legend of Sir Gawain and his journey through temptations of body and spirit, ghosts and intrigue to fight the giant emerald stranger - the Green Knight. Gawain will have to define his own character and prove his worth in the eyes of his family and kingdom in the face of an indescribable threat.");
            movie65.setGenreId(13);

            Movie movie7 = new Movie();
            movie7.setMovieName("1917");
            movie7.setMovieDescription("Two young British soldiers during the First World War are given an impossible mission: deliver a message deep in enemy territory that will stop 1,600 men, and one of the soldiers' brothers, from walking straight into a deadly trap.");
            movie7.setGenreId(13);

            Movie movie8 = new Movie();
            movie8.setMovieName("The Witcher");
            movie8.setMovieDescription("Geralt of Rivia, a solitary monster hunter, struggles to find his place in a world where people often prove more wicked than beasts.");
            movie8.setGenreId(13);

            Movie movie9 = new Movie();
            movie9.setMovieName("The Outsider");
            movie9.setMovieDescription("Investigators are confounded over an unspeakable crime that's been committed.");
            movie9.setGenreId(13);

            //inserting movies in movieDAO
            movieDao.insert(movie1);
            movieDao.insert(movie2);
            movieDao.insert(movie3);
            movieDao.insert(movie4);
            movieDao.insert(movie5);
            movieDao.insert(movie6);
            movieDao.insert(movie7);
            movieDao.insert(movie8);
            movieDao.insert(movie9);
            movieDao.insert(movie10);
            movieDao.insert(movie11);
            movieDao.insert(movie12);
            movieDao.insert(movie13);
            movieDao.insert(movie14);
            movieDao.insert(movie15);
            movieDao.insert(movie16);
            movieDao.insert(movie17);
            movieDao.insert(movie18);
            movieDao.insert(movie17);
            movieDao.insert(movie18);
            movieDao.insert(movie19);
            movieDao.insert(movie20);
            movieDao.insert(movie21);
            movieDao.insert(movie22);
            movieDao.insert(movie23);
            movieDao.insert(movie24);
            movieDao.insert(movie25);
            movieDao.insert(movie26);
            movieDao.insert(movie27);
            movieDao.insert(movie28);
            movieDao.insert(movie29);
            movieDao.insert(movie30);
            movieDao.insert(movie31);
            movieDao.insert(movie32);
            movieDao.insert(movie33);
            movieDao.insert(movie34);
            movieDao.insert(movie35);
            movieDao.insert(movie36);
            movieDao.insert(movie37);
            movieDao.insert(movie38);
            movieDao.insert(movie39);
            movieDao.insert(movie40);
            movieDao.insert(movie41);
            movieDao.insert(movie42);
            movieDao.insert(movie43);
            movieDao.insert(movie44);
            movieDao.insert(movie45);
            movieDao.insert(movie46);
            movieDao.insert(movie47);
            movieDao.insert(movie48);
            movieDao.insert(movie49);
            movieDao.insert(movie50);
            movieDao.insert(movie51);
            movieDao.insert(movie52);
            movieDao.insert(movie53);
            movieDao.insert(movie54);
            movieDao.insert(movie55);
            movieDao.insert(movie56);
            movieDao.insert(movie57);
            movieDao.insert(movie58);
            movieDao.insert(movie59);
            movieDao.insert(movie60);
            movieDao.insert(movie61);
            movieDao.insert(movie62);
            movieDao.insert(movie63);
            movieDao.insert(movie64);
            movieDao.insert(movie65);

            return null;
        }
    }
}
