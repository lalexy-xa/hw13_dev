INSERT INTO client
(name)
VALUES
('Mic'),
('Maks'),
('Mirra'),
('Nic'),
('Mic'),
('MaksG'),
('MirraG'),
('NicG'),
('Nic'),
('Nina');

INSERT INTO planet
(id, name)
VALUES
('MARS','MicP'),
('SUN1','MaksP'),
('JUPITER','MirraP'),
('DARK','NicP'),
('STAR','NinaP');

INSERT INTO Ticket
(created_at, client_id, from_planet_id, to_planet_id)
VALUES
('2020-01-02','1','MARS','STAR'),
('2021-03-10','3','DARK','MARS'),
('2022-02-09','5','STAR','DARK'),
('2023-10-20','7','SUN1','MARS'),
('2022-03-01','9','DARK','JUPITER'),
('2020-12-01','2','JUPITER','DARK'),
('2019-09-25','4','JUPITER','STAR'),
('2022-11-11','6','MARS','STAR'),
('2023-07-07','8','SUN1','STAR'),
('2023-02-11','10','STAR','JUPITER');