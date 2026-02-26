use('songsDB');

db.getCollection('songs').insertMany([
  // Pop
  {
    title: 'Billie Jean',
    artist: 'Michael Jackson',
    genre: 'Pop',
    mood: 'Energetic',
    dateReleased: '1983-01-02',
    imageBase64: ''
  },

  {
    title: 'Bohemian Rhapsody',
    artist: 'Queen',
    genre: 'Pop',
    mood: 'Energetic',
    dateReleased: '1975-10-31',
    imageBase64: ''
  },

  {
    title: 'Dancing Queen',
    artist: 'ABBA',
    genre: 'Pop',
    mood: 'Happy',
    dateReleased: '1976-08-27',
    imageBase64: ''
  },

  {
    title: 'I Will Always Love You',
    artist: 'Whitney Houston',
    genre: 'Pop',
    mood: 'Sad',
    dateReleased: '1992-11-03',
    imageBase64: ''
  },

  {
    title: 'Shape of You',
    artist: 'Ed Sheeran',
    genre: 'Pop',
    mood: 'Happy',
    dateReleased: '2017-01-06',
    imageBase64: ''
  },

  // Country
  {
    title: 'Chicken Fried',
    artist: 'Zac Brown Band',
    genre: 'Country',
    mood: 'Happy',
    dateReleased: '2008-07-08',
    imageBase64: ''
  },

  {
    title: 'Jolene',
    artist: 'Dolly Parton',
    genre: 'Country',
    mood: 'Sad',
    dateReleased: '1973-10-15',
    imageBase64: ''
  },

  {
    title: 'Take Me Home, Country Roads',
    artist: 'John Denver',
    genre: 'Country',
    mood: 'Calm',
    dateReleased: '1971-04-12',
    imageBase64: ''
  },

  {
    title: 'Before He Cheats',
    artist: 'Carrie Underwood',
    genre: 'Country',
    mood: 'Energetic',
    dateReleased: '2005-10-26',
    imageBase64: ''
  },

  {
    title: 'Bless the Broken Road',
    artist: 'Rascal Flatts',
    genre: 'Country',
    mood: 'Calm',
    dateReleased: '2004-08-17',
    imageBase64: ''
  },

  // Rock
  {
    title: 'Back in Black',
    artist: 'AC/DC',
    genre: 'Rock',
    mood: 'Energetic',
    dateReleased: '1980-07-25',
    imageBase64: ''
  },

  {
    title: 'Welcome to the Jungle',
    artist: 'Guns N Roses',
    genre: 'Rock',
    mood: 'Energetic',
    dateReleased: '1987-09-28',
    imageBase64: ''
  },

  {
    title: 'Smells Like Team Spirit',
    artist: 'Nirvana',
    genre: 'Rock',
    mood: 'Energetic',
    dateReleased: '1991-09-10',
    imageBase64: ''
  },

  {
    title: 'Stairway to Heaven',
    artist: 'Led Zeppelin',
    genre: 'Rock',
    mood: 'Calm',
    dateReleased: '1971-11-08',
    imageBase64: ''
  },

  {
    title: 'Tom Sawyer',
    artist: 'Rush',
    genre: 'Rock',
    mood: 'Energetic',
    dateReleased: '1981-02-09',
    imageBase64: ''
  },

  // Rap
  {
    title: 'Not Like Us',
    artist: 'Kendrick Lamar',
    genre: 'Rap',
    mood: 'Energetic',
    dateReleased: '2024-05-04',
    imageBase64: ''
  },

  {
    title: 'Lose Yourself',
    artist: 'Eminem',
    genre: 'Rap',
    mood: 'Energetic',
    dateReleased: '2002-10-28',
    imageBase64: ''
  },

  {
    title: 'Stan',
    artist: 'Eminem',
    genre: 'Rap',
    mood: 'Sad',
    dateReleased: '2000-11-13',
    imageBase64: ''
  },

  {
    title: 'C.R.E.A.M',
    artist: 'Wu-Tang Clan',
    genre: 'Rap',
    mood: 'Calm',
    dateReleased: '1993-03-09',
    imageBase64: ''
  },

  {
    title: 'In Da Club',
    artist: '50 Cent',
    genre: 'Rap',
    mood: 'Happy',
    dateReleased: '2003-01-07',
    imageBase64: ''
  },


]);

console.log('Songs inserted!');