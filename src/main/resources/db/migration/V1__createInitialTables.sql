CREATE TABLE players (
    player_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    gamer_tag TEXT,
    first_name TEXT,
    last_name TEXT,
    player_image BLOB NULL
);

CREATE TABLE games(
    game_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    game_name TEXT,
    game_category TEXT,
    game_image BLOB NULL
);

CREATE TABLE yearScore (
    year INT NOT NULL,
    is_Champion BOOLEAN NOT NULL DEFAULT FALSE,
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



CREATE TABLE gameCategory(
    game_category_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    category_name TEXT
);

-- Insert 
INSERT INTO gameCategory(category_name) VALUES('Arcade');
INSERT INTO gameCategory(category_name) VALUES('FPS');
INSERT INTO gameCategory(category_name) VALUES('Platformer');
INSERT INTO gameCategory(category_name) VALUES('Fighting');
INSERT INTO gameCategory(category_name) VALUES('Racing');
INSERT INTO gameCategory(category_name) VALUES('Sport');
INSERT INTO gameCategory(category_name) VALUES('Survival');
INSERT INTO gameCategory(category_name) VALUES('Stealth');
INSERT INTO gameCategory(category_name) VALUES('Mini Game');
