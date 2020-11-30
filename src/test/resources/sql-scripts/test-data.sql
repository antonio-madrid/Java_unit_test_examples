CREATE TABLE IF NOT EXISTS movies (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
minutes INT NOT NULL,
genre VARCHAR(50) NOT NULL,
director VARCHAR(50) NOT NULL
);

INSERT INTO movies (name, minutes, genre, director)  VALUES
    ('Dark Knight', 152, 'ACTION', 'Christopher Nolan'),
    ('Memento', 113, 'THRILLER', 'Christopher Nolan'),
    ('Matrix', 136, 'ACTION', 'Lana Wachowski, Lilly Wachowski'),
    ('Super 8', 112, 'THRILLER', 'J.J. Abrams'),
    ('Superman', 184, 'ACTION', 'Richard Donner');
