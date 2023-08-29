-- Data to table group
INSERT INTO "group" (name) VALUES
('H1'),
('H2'),
('H3'),
('H4');


-- Data to table group H1
INSERT INTO student (last_name, first_name, student_number, group_id) VALUES
('Smith1', 'John1', 'STD22010', 1),
('Johnson1', 'Emily1', 'STD22011', 1),
('Brown1', 'Olivia1', 'STD22012', 1),
('Smith2', 'John2', 'STD22013', 1),
('Johnson2', 'Emily2', 'STD22014', 1),
('Brown2', 'Olivia2', 'STD22015', 1),
('Smith3', 'John3', 'STD22016', 1),
('Johnson3', 'Emily3', 'STD22017', 1),
('Brown3', 'Olivia3', 'STD22018', 1),
('Smith4', 'John4', 'STD22019', 1),
('Johnson4', 'Emily4', 'STD22020', 1),
('Brown4', 'Olivia4', 'STD22021', 1),
('Smith5', 'John5', 'STD22022', 1),
('Johnson5', 'Emily5', 'STD22023', 1),
('Brown5', 'Olivia5', 'STD22024', 1);

-- Data to table group H2
INSERT INTO student (last_name, first_name, student_number, group_id) VALUES
('Lee1', 'Michael1', 'STD22025', 2),
('Patel1', 'Priya1', 'STD22026', 2),
('Davis1', 'Daniel1', 'STD22027', 2),
('Lee2', 'Michael2', 'STD22028', 2),
('Patel2', 'Priya2', 'STD22029', 2),
('Davis2', 'Daniel2', 'STD22030', 2),
('Lee3', 'Michael3', 'STD22031', 2),
('Patel3', 'Priya3', 'STD22032', 2),
('Davis3', 'Daniel3', 'STD22033', 2),
('Lee4', 'Michael4', 'STD22034', 2),
('Patel4', 'Priya4', 'STD22035', 2),
('Davis4', 'Daniel4', 'STD22036', 2),
('Lee5', 'Michael5', 'STD22037', 2),
('Patel5', 'Priya5', 'STD22038', 2),
('Davis5', 'Daniel5', 'STD22039', 2);


-- Data to table group H3
INSERT INTO student (last_name, first_name, student_number, group_id) VALUES
('Wang1', 'Lisa1', 'STD22040', 3),
('Kim1', 'David1', 'STD22041', 3),
('Wang2', 'Lisa2', 'STD22042', 3),
('Kim2', 'David2', 'STD22043', 3),
('Wang3', 'Lisa3', 'STD22044', 3),
('Kim3', 'David3', 'STD22045', 3),
('Wang4', 'Lisa4', 'STD22046', 3),
('Kim4', 'David4', 'STD22047', 3),
('Wang5', 'Lisa5', 'STD22048', 3),
('Kim5', 'David5', 'STD22049', 3),
('Wang6', 'Lisa6', 'STD22050', 3),
('Kim6', 'David6', 'STD22051', 3),
('Wang7', 'Lisa7', 'STD22052', 3),
('Kim7', 'David7', 'STD22053', 3),
('Wang8', 'Lisa8', 'STD22054', 3);

-- Data to table group H4
INSERT INTO student (last_name, first_name, student_number, group_id) VALUES
('Garcia1', 'Sofia1', 'STD22055', 4),
('Martinez1', 'Carlos1', 'STD22056', 4),
('Garcia2', 'Sofia2', 'STD22057', 4),
('Martinez2', 'Carlos2', 'STD22058', 4),
('Garcia3', 'Sofia3', 'STD22059', 4),
('Martinez3', 'Carlos3', 'STD22060', 4),
('Garcia4', 'Sofia4', 'STD22061', 4),
('Martinez4', 'Carlos4', 'STD22062', 4),
('Garcia5', 'Sofia5', 'STD22063', 4),
('Martinez5', 'Carlos5', 'STD22064', 4),
('Garcia6', 'Sofia6', 'STD22065', 4),
('Martinez6', 'Carlos6', 'STD22066', 4),
('Garcia7', 'Sofia7', 'STD22067', 4),
('Martinez7', 'Carlos7', 'STD22068', 4),
('Garcia8', 'Sofia8', 'STD22069', 4);

-- -- Data to table  "subject"
INSERT INTO subject (subject_code, coef_subject) VALUES
('PROG1', 3),
('PROG2', 4),
('WEB1', 3),
('WEB2', 4),
('DONNEE1', 3),
('LV1', 2),
('SYS1', 4),
('SYS2', 4),
('IA1', 3),
('THEORIE1', 2);

-- Dummy inserts in the "note" table for students in group H1
-- Scores are randomly generated between 0 and 20
INSERT INTO note (subject_id, student_id, note) VALUES
(1, 1, RANDOM() * 20),
(2, 1, RANDOM() * 20),
(3, 1, RANDOM() * 20),
(4, 1, RANDOM() * 20),
(5, 1, RANDOM() * 20),
(6, 1, RANDOM() * 20),
(7, 1, RANDOM() * 20),
(8, 1, RANDOM() * 20),
(9, 1, RANDOM() * 20),
(10, 1, RANDOM() * 20),
(1, 2, RANDOM() * 20),
(2, 2, RANDOM() * 20),
(3, 2, RANDOM() * 20),
(4, 2, RANDOM() * 20),
(5, 2, RANDOM() * 20),
(6, 2, RANDOM() * 20),
(7, 2, RANDOM() * 20),
(8, 2, RANDOM() * 20),
(9, 2, RANDOM() * 20),
(10, 2, RANDOM() * 20),
(1, 9, RANDOM() * 20),
(2, 9, RANDOM() * 20),
(3, 9, RANDOM() * 20),
(4, 9, RANDOM() * 20),
(5, 9, RANDOM() * 20),
(6, 9, RANDOM() * 20),
(7, 9, RANDOM() * 20),
(8, 9, RANDOM() * 20),
(9, 9, RANDOM() * 20),
(10, 9, RANDOM() * 20);

-- Dummy inserts in the "note" table for students in group H2
-- Scores are randomly generated between 0 and 20
INSERT INTO note (subject_id, student_id, note) VALUES
(1, 3, RANDOM() * 20),
(2, 3, RANDOM() * 20),
(3, 3, RANDOM() * 20),
(4, 3, RANDOM() * 20),
(5, 3, RANDOM() * 20),
(6, 3, RANDOM() * 20),
(7, 3, RANDOM() * 20),
(8, 3, RANDOM() * 20),
(9, 3, RANDOM() * 20),
(10, 3, RANDOM() * 20),
(1, 4, RANDOM() * 20),
(2, 4, RANDOM() * 20),
(3, 4, RANDOM() * 20),
(4, 4, RANDOM() * 20),
(5, 4, RANDOM() * 20),
(6, 4, RANDOM() * 20),
(7, 4, RANDOM() * 20),
(8, 4, RANDOM() * 20),
(9, 4, RANDOM() * 20),
(10, 4, RANDOM() * 20),
(1, 10, RANDOM() * 20),
(2, 10, RANDOM() * 20),
(3, 10, RANDOM() * 20),
(4, 10, RANDOM() * 20),
(5, 10, RANDOM() * 20),
(6, 10, RANDOM() * 20),
(7, 10, RANDOM() * 20),
(8, 10, RANDOM() * 20),
(9, 10, RANDOM() * 20),
(10, 10, RANDOM() * 20);

-- Dummy inserts in the "note" table for students in group H3
-- Scores are randomly generated between 0 and 20
INSERT INTO note (subject_id, student_id, note) VALUES
(1, 5, RANDOM() * 20),
(2, 5, RANDOM() * 20),
(3, 5, RANDOM() * 20),
(4, 5, RANDOM() * 20),
(5, 5, RANDOM() * 20),
(6, 5, RANDOM() * 20),
(7, 5, RANDOM() * 20),
(8, 5, RANDOM() * 20),
(9, 5, RANDOM() * 20),
(10, 5, RANDOM() * 20),
(1, 6, RANDOM() * 20),
(2, 6, RANDOM() * 20),
(3, 6, RANDOM() * 20),
(4, 6, RANDOM() * 20),
(5, 6, RANDOM() * 20),
(6, 6, RANDOM() * 20),
(7, 6, RANDOM() * 20),
(8, 6, RANDOM() * 20),
(9, 6, RANDOM() * 20),
(10, 6, RANDOM() * 20);

-- Dummy inserts in the "note" table for students in group H4
-- Scores are randomly generated between 0 and 20
INSERT INTO note (subject_id, student_id, note) VALUES
(1, 7, RANDOM() * 20),
(2, 7, RANDOM() * 20),
(3, 7, RANDOM() * 20),
(4, 7, RANDOM() * 20),
(5, 7, RANDOM() * 20),
(6, 7, RANDOM() * 20),
(7, 7, RANDOM() * 20),
(8, 7, RANDOM() * 20),
(9, 7, RANDOM() * 20),
(10, 7, RANDOM() * 20),
(1, 8, RANDOM() * 20),
(2, 8, RANDOM() * 20),
(3, 8, RANDOM() * 20),
(4, 8, RANDOM() * 20),
(5, 8, RANDOM() * 20),
(6, 8, RANDOM() * 20),
(7, 8, RANDOM() * 20),
(8, 8, RANDOM() * 20),
(9, 8, RANDOM() * 20),
(10, 8, RANDOM() * 20);
