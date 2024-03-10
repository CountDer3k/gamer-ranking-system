CREATE TABLE players (
	player_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	gamer_tag TEXT,
	first_name TEXT,
	last_name TEXT,

);

CREATE TABLE games(
	game_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	gameName TEXT,
	gameCategory TEXT,
);

-- Table for keeping track of a player's score for each year.
CREATE TABLE yearScore (
    year INT NOT NULL,
	isChampion BOOLEAN NOT NULL DEFAULT FALSE,
    score INT NOT NULL,
    player_id INT NOT NULL,
    FOREIGN KEY (player_id) REFERENCES players(id),
    PRIMARY KEY (year, player_id)
);

-- Table for keeping track of the player's score or ranking for each game per year.
CREATE TABLE gameYearScore (
    year INT NOT NULL,
    game_id INT NOT NULL,
    player_id INT NOT NULL,
	player_score: INT,
	player_ranking: INT,
    FOREIGN KEY (year, player_id) REFERENCES yearScore(year, player_id),
    FOREIGN KEY (game_id) REFERENCES games(game_id),
    PRIMARY KEY (year, game_id, player_id)
);
