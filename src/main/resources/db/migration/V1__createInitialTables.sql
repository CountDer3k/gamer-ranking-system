CREATE TABLE players (
    player_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    gamer_tag TEXT UNIQUE,
    first_name TEXT,
    last_name TEXT,
    player_image BLOB NULL
);

CREATE TABLE games(
    game_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    game_name TEXT UNIQUE,
    game_category TEXT,
    game_image BLOB NULL
);

CREATE TABLE game_category(
    game_category_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    category_name TEXT
);

-- The years the game was included in competitions
CREATE TABLE game_played_years(
    id INT AUTO_INCREMENT PRIMARY KEY,
    game_id INT,
    year INT,
    -- This next variable is if there was more than one competition that year, default should be 0
    competition_number INT DEFAULT 0,
    FOREIGN KEY (game_id) REFERENCES games(game_id)
);

CREATE TABLE yearScore (
    year INT NOT NULL,
    is_champion BOOLEAN NOT NULL DEFAULT FALSE,
    ranking_position INT NOT NULL,
    player_id INT NOT NULL,
    FOREIGN KEY (player_id) REFERENCES players(player_id),
    PRIMARY KEY (year, player_id)
);

-- 
CREATE TABLE game_year_score (
    year INT NOT NULL,
    game_id INT NOT NULL,
    player_id INT NOT NULL,
    -- Player Score is the score the player recieved.
    player_score INT,
    -- Player Ranking will be the position the player achieved in this game. List should be organized by this & not the score (this will allow games will lowest scores to still work)
    player_ranking INT,
    FOREIGN KEY (game_id) REFERENCES games(game_id),
    PRIMARY KEY (year, game_id, player_id)
);

ALTER TABLE gameYearScore
    ADD CONSTRAINT fk_gameYearScore_yearScore_year_player_id FOREIGN KEY (year, player_id) REFERENCES yearScore(year, player_id);




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
