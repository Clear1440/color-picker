INSERT INTO app_themes(primary_color, secondary_color) VALUES
("green", "purple"),
("teal", "green"),
("brown", "tan"),
("tan", "brown");

INSERT INTO users(firstname, lastname, username, password) VALUES
("Eon", "John", "EJ@gmail.com", "SomeRandomPasswordForEon"),
("Aiden", "Martins", "AM@gmail.com", "SomeRandomPasswordForAiden");

INSERT INTO user_prefences(user_id, app_theme_id) VALUES
(1, 1),
(2, 2);