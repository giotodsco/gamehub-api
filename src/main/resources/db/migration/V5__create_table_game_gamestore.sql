CREATE TABLE game_gamestore (
     game_id INTEGER,
     gamestore_id INTEGER,
     CONSTRAINT fk_game_gamestore_game FOREIGN KEY (game_id) REFERENCES game(id),
     CONSTRAINT fk_game_gamestore_gamestore FOREIGN KEY (gamestore_id) REFERENCES gamestore(id)
);