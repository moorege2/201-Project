use('songsDB');

db.getCollection('songs').insertMany([
  // Pop
  {
    title: 'Billie Jean',
    artist: 'Michael Jackson',
    genre: 'Pop',
    mood: 'Energetic',
    dateReleased: '1983-01-02',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/5/55/Michael_Jackson_-_Thriller.png'
  },

  {
    title: 'Bohemian Rhapsody',
    artist: 'Queen',
    genre: 'Pop',
    mood: 'Energetic',
    dateReleased: '1975-10-31',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/9/9f/Bohemian_Rhapsody.png'
  },

  {
    title: 'Dancing Queen',
    artist: 'ABBA',
    genre: 'Pop',
    mood: 'Happy',
    dateReleased: '1976-08-27',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/a/a3/ABBA_-_The_Album.jpg'
  },

  {
    title: 'I Will Always Love You',
    artist: 'Whitney Houston',
    genre: 'Pop',
    mood: 'Sad',
    dateReleased: '1992-11-03',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/4/47/Whitney_Houston_-_The_Bodyguard_Soundtrack.jpg'
  },

  {
    title: 'Shape of You',
    artist: 'Ed Sheeran',
    genre: 'Pop',
    mood: 'Happy',
    dateReleased: '2017-01-06',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/b/b8/Ed_Sheeran_-_Shape_of_You_%28Official_Single_Cover%29.png'
  },

  // Country
  {
    title: 'Chicken Fried',
    artist: 'Zac Brown Band',
    genre: 'Country',
    mood: 'Happy',
    dateReleased: '2008-07-08',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/3/3c/Zac_Brown_Band_-_The_Foundation.jpg'

  },

  {
    title: 'Jolene',
    artist: 'Dolly Parton',
    genre: 'Country',
    mood: 'Sad',
    dateReleased: '1973-10-15',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/5/50/Jolene_album.jpg'

  },

  {
    title: 'Take Me Home, Country Roads',
    artist: 'John Denver',
    genre: 'Country',
    mood: 'Calm',
    dateReleased: '1971-04-12',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/1/17/TakeMeHomeCountryRoads.jpg'

  },

  {
    title: 'Before He Cheats',
    artist: 'Carrie Underwood',
    genre: 'Country',
    mood: 'Energetic',
    dateReleased: '2005-10-26',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/2/2e/Carrie_Underwood_-_Some_Hearts.jpg'
  },

  {
    title: 'Bless the Broken Road',
    artist: 'Rascal Flatts',
    genre: 'Country',
    mood: 'Calm',
    dateReleased: '2004-08-17',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/5/52/Rascal_Flatts_-_Feels_Like_Today.jpg'
  },

  // Rock
  {
    title: 'Back in Black',
    artist: 'AC/DC',
    genre: 'Rock',
    mood: 'Energetic',
    dateReleased: '1980-07-25',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/ACDC_Back_in_Black.jpg/220px-ACDC_Back_in_Black.jpg'
  },

  {
    title: 'Welcome to the Jungle',
    artist: 'Guns N Roses',
    genre: 'Rock',
    mood: 'Energetic',
    dateReleased: '1987-09-28',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/6/60/GunsnRosesAppetiteforDestructionalbumcover.jpg'

  },

  {
    title: 'Smells Like Team Spirit',
    artist: 'Nirvana',
    genre: 'Rock',
    mood: 'Energetic',
    dateReleased: '1991-09-10',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/b/b7/NirvanaNevermindalbumcover.jpg'

  },

  {
    title: 'Stairway to Heaven',
    artist: 'Led Zeppelin',
    genre: 'Rock',
    mood: 'Calm',
    dateReleased: '1971-11-08',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/2/26/Led_Zeppelin_-_Led_Zeppelin_IV.jpg'

  },

  {
    title: 'Tom Sawyer',
    artist: 'Rush',
    genre: 'Rock',
    mood: 'Energetic',
    dateReleased: '1981-02-09',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/9/9a/Rush_Moving_Pictures.jpg'

  },

  // Rap
  {
    title: 'Not Like Us',
    artist: 'Kendrick Lamar',
    genre: 'Rap',
    mood: 'Energetic',
    dateReleased: '2024-05-04',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/3/30/Kendrick_Lamar_-_Not_Like_Us.png'
  },

  {
    title: 'Lose Yourself',
    artist: 'Eminem',
    genre: 'Rap',
    mood: 'Energetic',
    dateReleased: '2002-10-28',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/7/77/Eminemloseyourself.jpg'

  },

  {
    title: 'Stan',
    artist: 'Eminem',
    genre: 'Rap',
    mood: 'Sad',
    dateReleased: '2000-11-13',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/3/35/Eminem_-_The_Marshall_Mathers_LP_CD_cover.jpg'

  },

  {
    title: 'C.R.E.A.M',
    artist: 'Wu-Tang Clan',
    genre: 'Rap',
    mood: 'Calm',
    dateReleased: '1993-03-09',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/5/53/Wu-Tang_Clan_Enter_the_Wu-Tang.jpg'
  },

  {
    title: 'In Da Club',
    artist: '50 Cent',
    genre: 'Rap',
    mood: 'Happy',
    dateReleased: '2003-01-07',
    imageUrl: 'https://upload.wikimedia.org/wikipedia/en/b/b8/50cent-getrichordietryin.jpg'
  },


]);

console.log('Songs inserted!');