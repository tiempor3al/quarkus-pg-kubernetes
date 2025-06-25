-- Insert sample Pokemon data

-- Insert Pokemon types
INSERT INTO pokemon_types (name, description) VALUES
    ('Normal', 'Normal-type Pokemon with standard attacks'),
    ('Fire', 'Fire-type Pokemon with heat-based attacks'),
    ('Water', 'Water-type Pokemon with aquatic abilities'),
    ('Electric', 'Electric-type Pokemon with lightning powers'),
    ('Grass', 'Grass-type Pokemon with plant-based abilities'),
    ('Ice', 'Ice-type Pokemon with freezing abilities'),
    ('Fighting', 'Fighting-type Pokemon with martial arts skills'),
    ('Poison', 'Poison-type Pokemon with toxic abilities'),
    ('Ground', 'Ground-type Pokemon with earth-based powers'),
    ('Flying', 'Flying-type Pokemon that can soar through the air'),
    ('Psychic', 'Psychic-type Pokemon with mental powers'),
    ('Bug', 'Bug-type Pokemon resembling insects'),
    ('Rock', 'Rock-type Pokemon with stone-based defenses'),
    ('Ghost', 'Ghost-type Pokemon with supernatural abilities'),
    ('Dragon', 'Dragon-type Pokemon with mythical powers'),
    ('Dark', 'Dark-type Pokemon with shadow-based abilities'),
    ('Steel', 'Steel-type Pokemon with metallic defenses'),
    ('Fairy', 'Fairy-type Pokemon with magical abilities');

-- Insert Pokemon
INSERT INTO pokemon (name, type_id, height, weight, hp, attack, defense, special_attack, special_defense, speed, description) VALUES
    ('Pikachu', 4, 0.4, 6.0, 35, 55, 40, 50, 50, 90, 'An Electric-type Pokemon that stores electricity in its cheeks'),
    ('Charizard', 2, 1.7, 90.5, 78, 84, 78, 109, 85, 100, 'A Fire/Flying-type Pokemon that breathes fire'),
    ('Bulbasaur', 5, 0.7, 6.9, 45, 49, 49, 65, 65, 45, 'A Grass/Poison-type Pokemon with a plant bulb on its back'),
    ('Squirtle', 3, 0.5, 9.0, 44, 48, 65, 50, 64, 43, 'A Water-type Pokemon with a shell'),
    ('Jigglypuff', 1, 0.5, 5.5, 115, 45, 20, 45, 25, 20, 'A Normal/Fairy-type Pokemon known for its singing'),
    ('Mewtwo', 11, 2.0, 122.0, 106, 110, 90, 154, 90, 130, 'A Psychic-type legendary Pokemon created by genetic manipulation'),
    ('Gyarados', 3, 6.5, 235.0, 95, 125, 79, 60, 100, 81, 'A Water/Flying-type Pokemon known for its fierce temperament'),
    ('Snorlax', 1, 2.1, 460.0, 160, 110, 65, 65, 110, 30, 'A Normal-type Pokemon that loves to eat and sleep'),
    ('Eevee', 1, 0.3, 6.5, 55, 55, 50, 45, 65, 55, 'A Normal-type Pokemon with unstable genetic makeup'),
    ('Dragonite', 15, 2.2, 210.0, 91, 134, 95, 100, 100, 80, 'A Dragon/Flying-type Pokemon that can fly around the world');

-- Insert Trainers
INSERT INTO trainers (name, hometown, region, badges) VALUES
    ('Ash Ketchum', 'Pallet Town', 'Kanto', 8),
    ('Misty', 'Cerulean City', 'Kanto', 8),
    ('Brock', 'Pewter City', 'Kanto', 8),
    ('Gary Oak', 'Pallet Town', 'Kanto', 10),
    ('Lance', 'Blackthorn City', 'Johto', 16);

-- Insert Trainer-Pokemon relationships
INSERT INTO trainer_pokemon (trainer_id, pokemon_id, nickname, level) VALUES
    (1, 1, 'Pika', 50),  -- Ash's Pikachu
    (1, 2, 'Char', 36),  -- Ash's Charizard
    (1, 3, 'Bulby', 32), -- Ash's Bulbasaur
    (1, 4, 'Squirt', 31), -- Ash's Squirtle
    (2, 7, 'Gyara', 52),  -- Misty's Gyarados
    (3, 8, 'Snor', 46),   -- Brock's Snorlax
    (4, 2, 'Blaze', 55),  -- Gary's Charizard
    (4, 9, 'Eve', 48),    -- Gary's Eevee
    (5, 10, 'Drake', 75), -- Lance's Dragonite
    (5, 6, 'Psy', 80);    -- Lance's Mewtwo