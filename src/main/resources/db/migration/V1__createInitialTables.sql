CREATE TABLE players (
    player_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    gamer_tag TEXT,
    first_name TEXT,
    last_name TEXT
);

CREATE TABLE games(
    game_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    gameName TEXT,
    gameCategory TEXT
);

CREATE TABLE yearScore (
    year INT NOT NULL,
    isChampion BOOLEAN NOT NULL DEFAULT FALSE,
    score INT NOT NULL,
    player_id INT NOT NULL,
    FOREIGN KEY (player_id) REFERENCES players(player_id),
    PRIMARY KEY (year, player_id)
);

CREATE TABLE gameYearScore (
    year INT NOT NULL,
    game_id INT NOT NULL,
    player_id INT NOT NULL,
    player_score INT,
    player_ranking INT,
    FOREIGN KEY (game_id) REFERENCES games(game_id),
    PRIMARY KEY (year, game_id, player_id)
);

ALTER TABLE gameYearScore
    ADD CONSTRAINT fk_gameYearScore_yearScore_year_player_id FOREIGN KEY (year, player_id) REFERENCES yearScore(year, player_id);
