INSERT INTO dao.artist (name, country)
VALUES ('RAMMSTEIN', 'Germany'),
       ('AC/DC', 'Australia'),
       ('Scorpions', 'Germany'),
       ('Modern Talking', 'Germany'),
       ('ABBA', 'Sweden'),
       ('The Beatles', 'England'),
       ('Bon Jovi', 'USA'),
       ('The Rolling Stones', 'England'),
       ('Queen', 'England'),
       ('Nirvana', 'USA'),
       ('Bob Marley', 'Jamaica');

INSERT INTO dao.song (title, album, recorded, length)
VALUES ('Thunderstruck','The Razors Edge',1990,'04:52'),
       ('Deutschland','Unnamed',2019,'06:05'),
       ('Mamma mia','ABBA',1975,'03:35'),
       ('Du Hast','Sehnsucht',1997,'03:55'),
       ('Wind Of Change','Crazy World',1990,'05:10'),
       ('Mutter','Mutter',2000,'04:28'),
       ('You''re My Heart, You''re My Soul','The First Album',1984,'05:32'),
       ('Let It Be','Let It Be',1969,'04:03'),
       ('It’s My Life','Crash',2000,'03:45'),
       ('Sympathy for the Devil','Beggars Banquet',1968,'06:28'),
       ('Bohemian Rhapsody','A Night at the Opera',1975,'05:58'),
       ('Something in the Way','Nevermind',1991,'03:52'),
       ('No woman, no cry','Natty Dread', 1974, '03:42'),
       ('Amerika','Reise, Reise',2004, '03:46');

INSERT INTO dao.artist_song_link (artist_id, song_id)
VALUES (1, 2),
       (2, 1),
       (5, 3),
       (1, 4),
       (3, 5),
       (1, 6),
       (4, 7),
       (6, 8),
       (7, 9),
       (8, 10),
       (9, 11),
       (10, 12),
       (11, 13),
       (1, 14);


