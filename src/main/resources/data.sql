-- 1. USERS
INSERT INTO users (id, first_name, last_name, birthdate, email) VALUES
                                                                    (1, 'Marty', 'McFly', '1969-12-13', 'marty.mcfly@hillvalley.com'),
                                                                    (2, 'Emmett', 'Brown', '1914-04-04', 'doc.brown@hillvalley.com'),
                                                                    (3, 'Lorraine', 'Baines', '1940-11-11', 'lorraine.mcfly@hillvalley.com'),
                                                                    (4, 'Biff', 'Tannen', '1940-01-01', 'biff.tannen@hillvalley.com');

-- 2. STATISTICS
INSERT INTO statistics (id, user_id, total_trainings, total_distance, total_calories_burned) VALUES
                                                                                                 (1, 1, 15, 150.5, 12000),
                                                                                                 (2, 2, 5, 20.0, 3000),
                                                                                                 (3, 3, 10, 45.0, 4500),
                                                                                                 (4, 4, 20, 100.0, 18000);

-- 3. HEALTH_METRICS (Używamy hearth_rate przez literówkę w Twojej encji/bazie)
INSERT INTO health_metrics (id, user_id, date, weight, height, hearth_rate) VALUES
                                                                                (1, 1, '2026-04-13', 72.5, 175, 65),
                                                                                (2, 2, '2026-04-13', 75.0, 185, 75),
                                                                                (3, 3, '2026-04-13', 60.0, 168, 68),
                                                                                (4, 4, '2026-04-13', 95.0, 190, 85);

-- 4. TRAININGS (Używamy cyfr dla activity_type, bo baza ma tam TINYINT)
INSERT INTO trainings (id, user_id, start_time, end_time, activity_type, distance, average_speed) VALUES
                                                                                                      (1, 1, '2026-04-13 08:00:00', '2026-04-13 09:00:00', 0, 10.0, 10.0),
                                                                                                      (2, 1, '2026-04-13 08:00:00', '2026-04-13 09:30:00', 1, 15.0, 10.0),
                                                                                                      (3, 2, '2026-04-13 10:00:00', '2026-04-13 10:45:00', 2, 3.5, 4.6),
                                                                                                      (4, 2, '2026-04-13 18:00:00', '2026-04-13 19:00:00', 0, 20.0, 20.0),
                                                                                                      (5, 3, '2026-04-13 17:00:00', '2026-04-13 18:00:00', 2, 0.0, 0.0),
                                                                                                      (6, 3, '2026-04-13 07:00:00', '2026-04-13 08:00:00', 0, 2.0, 2.0),
                                                                                                      (7, 4, '2026-04-13 15:00:00', '2026-04-13 16:30:00', 0, 0.0, 0.0),
                                                                                                      (8, 4, '2026-04-13 15:00:00', '2026-04-13 16:00:00', 1, 0.0, 0.0),
                                                                                                      (9, 1, '2026-04-13 09:00:00', '2026-04-13 10:00:00', 0, 8.0, 8.0);