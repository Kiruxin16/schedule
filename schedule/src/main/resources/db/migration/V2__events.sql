CREATE TABLE club_events(
                id bigserial PRIMARY KEY,
                discipline VARCHAR(255),
                coach_name VARCHAR(255),
                event_date DATE,
                start_time TIME,
                duration VARCHAR(255),
                hall_id bigint REFERENCES halls(id),
                comments VARCHAR(255),
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO club_events(discipline,coach_name,event_date,start_time,duration,hall_id,comments) VALUES
        ('Фитнес','Ершов Сергей Петрович','2023-08-02','19:00:00','90',1,''),
        ('Фитнес','Ершов Сергей Петрович','2023-08-04','19:00:00','90',1,''),
        ('Фитнес','Ершов Сергей Петрович','2023-08-06','19:30:00','90',1,''),
        ('Бачата','Епифанцева Екатерина Андреевна','2023-08-03','16:00:00','90',4,'Запись парами'),
        ('Бачата','Епифанцева Екатерина Андреевна','2023-08-05','16:00:00','90',4,'Запись парами'),
        ('Бачата','Епифанцева Екатерина Андреевна','2023-08-07','16:00:00','90',4,'Запись парами'),
        ('Кикбоксинг','Манойлов Андрей Владимирович','2023-08-10','12:30:00','90',3,'')
;