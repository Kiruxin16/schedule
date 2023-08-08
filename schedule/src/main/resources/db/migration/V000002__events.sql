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
--        ('Фитнес','Ершов Сергей Петрович','2023-08-02','19:00:00','90',1,''),
--        ('Фитнес','Ершов Сергей Петрович','2023-08-04','19:00:00','90',1,''),
--        ('Фитнес','Ершов Сергей Петрович','2023-08-06','19:30:00','90',1,''),
--        ('Бачата','Епифанцева Екатерина Андреевна','2023-08-03','16:00:00','90',4,'Запись парами'),
--        ('Бачата','Епифанцева Екатерина Андреевна','2023-08-05','16:00:00','90',4,'Запись парами'),
--        ('Бачата','Епифанцева Екатерина Андреевна','2023-08-07','16:00:00','90',4,'Запись парами'),
--        ('Кикбоксинг','Манойлов Андрей Владимирович','2023-08-10','12:30:00','90',3,'')




        ('СИЛОВОЙ ТРЕНИНГ','Соколова Алена', '2023-07-31', '09:30:00','90', 1,''),
        ('ЙОГА_ЛАТЕС',  'Пономарева Вика', '2023-07-31', '11:00:00','90', 1,''),
        ('BREAK_DANCE',  'Ефимов Василий', '2023-07-31', '16:00:00', '90',1,''),
        ('BREAK_DANCE',  'Ефимов Василий', '2023-07-31', '17:30:00','90', 1,''),
        ('ЗДОРОВАЯ СПИНА','Алексеева Катя', '2023-07-31', '19:00:00','90', 3,''),
        ('СИЛОВОЙ тренинг + кардио','Соколова Алена', '2023-07-31', '19:00:00','90', 1,''),
        ('СТРЕТЧИНГ', 'Иванова Анастасия', '2023-07-31', '19:00:00','90', 2,''),
        ('ФУНКЦИОН. ПИЛАТЕС', 'Белоусова Наталья','2023-07-31', '19:00:00','90', 3,''),
        ('ЛФК ФИТНЕСС', 'Масликова Елена', '2023-07-31', '19:00:00','90', 4, '(детский)'),
        ('FT ПЕТЛИ TRX', 'Соколов Михаил', '2023-07-31', '20:30:00','90', 1,''),
        ('СИЛОВАЯ СО ШТАНГОЙ', 'Матушкина Мария', '2023-07-31', '20:30:00', '90', 2, ''),
        ('БАЧАТА', 'Пономарева Вика', '2023-07-31', '20:30:00','90',3,''),
        ('ТРАЙБЛ', 'Марина Нечаева', '2023-07-31', '22:00:00','90', 1,''),

        ('ПИЛАТЕС POLESTAR','Белоусова Наталья', '2023-08-01', '09:30:00','90', 1,''),
        ('HIP - HOP',  'Полетаев Павел', '2023-08-01', '17:30:00','90', 1,'(прод)'),
        ('ЭКСПРЕСС-ТРЕНИНГ',  'Васильева Кристина', '2023-08-01', '17:30:00','30', 3,''),
        ('АДАПТИВНАЯ ФИЗКУЛЬТУРА', 'Ельчанин Юрий', '2023-08-01', '17:30:00','90', 4,'(детский)'),
        ('КАЛЛАНЕТИКА', 'Синаевская Галина', '2023-08-01', '19:00:00','90', 1,''),
        ('DANCE FITNESS', 'Васильева Кристина', '2023-08-01', '19:00:00','90', 2, '(ЗУМБА)'),
        ('ИНТЕРВАЛЬНЫЙ ТРЕНИНГ', 'Корчуганова Соня', '2023-08-01', '19:00:00','90', 3,''),
        ('СИЛОВОЙ ТРЕНИНГ', 'Соколова Алена', '2023-08-01', '20:30:00','90', 1,''),
        ('ЗДОРОВАЯ СПИНА', 'Корчуганова Соня', '2023-08-01', '20:30:00','90', 2,''),
        ('ЙОГА', 'Ежикова Елена','2023-08-01', '20:30:00','90', 3,''),

        ('СИЛОВОЙ ТРЕНИНГ', 'Соколова Алена', '2023-08-02', '09:30:00', '90',1,''),
        ('АКТИВ_БОДИ' , 'Пономарева Вика', '2023-08-02', '11:00:00', '90', 1, ''),
        ('BREAK_DANCE' , 'Ефимов Василий', '2023-08-02', '16:00:00', '90', 1, ''),
        ('BREAK_DANCE' , 'Ефимов Василий', '2023-08-02', '17:30:00', '90', 1, ''),
        ('HIP - HOP' , 'Полетаев Павел', '2023-08-02', '19:00:00', '90', 3, '(начинающие)'),
        ('СИЛОВОЙ тренинг + кардио' , 'Соколова Алена', '2023-08-02', '19:00:00', '90', 1, ''),
        ('СИЛОВАЯ СО ШТАНГОЙ' , 'Матушкина Мария', '2023-08-02', '19:00:00', '90', 2, ''),
        ('СТРЕТЧИНГ' , 'Иванова Анастасия', '2023-08-02', '19:00:00', '90', 3, ''),
        ('ЛФК ФИТНЕСС', 'Масликова Елена', '2023-08-02', '19:00:00', '90', 4, '(детский)'),
        ('FT ПЕТЛИ TRX' , 'Соколов Михаил', '2023-08-02', '20:30:00', '90', 1, ''),
        ('СУПЕР ЯГОДИЦЫ' , 'Вяткина Мария', '2023-08-02', '20:30:00', '90', 2, ''),
        ('ГАМАКИ', 'Иванова Настя', '2023-08-02', '20:30:00', '90', 3, ''),
        ('ТРАЙБЛ' , 'Марина Нечаева', '2023-08-02', '22:00:00', '90', 1, ''),

        ('ПИЛАТЕС POLESTAR' , 'Белоусова Наталья', '2023-08-03', '11:00:00', '90', 1, ''),
        ('HIP - HOP', 'Полетаев Павел', '2023-08-03', '17:30:00', '90', 1, '(прод)'),
        ('ЭКСПРЕСС-ТРЕНИНГ', 'Васильева Кристина', '2023-08-03', '17:30:00', '30', 3, ''),
        ('АДАПТИВНАЯ ФИЗКУЛЬТУРА', 'Ельчанин Юрий', '2023-08-03', '16:00:00', '90', 4, '(детский)'),
        ('КАЛЛАНЕТИКА' , 'Синаевская Галина', '2023-08-03', '19:00:00', '90', 1, ''),
        ('DANCE FITNESS', 'Васильева Кристина', '2023-08-03', '19:00:00', '90', 2, '(ЗУМБА)'),
        ('ИНТЕРВАЛЬНЫЙ ТРЕНИНГ' , 'Корчуганова Соня', '2023-08-03', '19:00:00', '90', 3, ''),
        ('СТЕП-АЭРОБИКА' , 'Корпачева Вероника', '2023-08-03', '19:00:00', '90', 4, ''),
        ('СИЛОВОЙ ТРЕНИНГ' , 'Соколова Алена', '2023-08-03', '20:30:00', '90', 1, ''),
        ('HOT POWER' , 'Корчуганова Соня', '2023-08-03', '20:30:00', '90', 2, ''),
        ('ЙОГА' , 'Ежикова Елена', '2023-08-03', '20:30:00', '90', 3, ''),
        ('СТЕП-АЭРОБИКА' , 'Карпачева Вероника', '2023-08-03', '20:30:00', '90', 4, ''),

        ('СИЛОВОЙ ТРЕНИНГ' , 'Соколова Алена', '2023-08-04', '9:30:00', '90', 1, ''),
        ('ЙОГА_ЛАТЕС' , 'Пономарева Вика', '2023-08-04', '11:00:00', '90', 1, ''),
        ('BREAK_DANCE' , 'Ефимов Василий', '2023-08-04', '16:00:00', '90', 1, ''),
        ('BREAK_DANCE' , 'Ефимов Василий', '2023-08-04', '17:30:00', '90', 1, ''),
        ('FT ПЕТЛИ TRX' , 'Соколов Михаил', '2023-08-04', '19:00:00', '90', 1, ''),
        ('HIP - HOP', 'Полетаев Павел', '2023-08-04', '19:00:00', '90', 3, '(начинающие)'),
        ('ЗДОРОВАЯ СПИНА', 'Корчуганова Соня', '2023-08-04', '17:30:00', '90', 4, ''),
        ('СИЛОВОЙ тренинг + кардио' , 'Соколова Алена', '2023-08-04', '19:00:00', '90', 1, ''),
        ('СИЛОВАЯ СО ШТАНГОЙ' , 'Матушкина Мария', '2023-08-04', '19:00:00', '90', 2, ''),
        ('СТРЕТЧИНГ' , 'Иванова Анастасия', '2023-08-04', '20:30:00', '90', 3, ''),
        ('СУПЕР ЯГОДИЦЫ' , 'Вяткина Мария', '2023-08-04', '20:30:00', '90', 1, ''),
        ('ГАМАКИ', 'Иванова Настя', '2023-08-04', '20:30:00', '90', 2, ''),

        ('ПИЛАТЕС POLESTAR' , 'Белоусова Наталья', '2023-08-05', '11:00:00', '90', 1, ''),
        ('АДАПТИВНАЯ ФИЗКУЛЬТУРА', 'Ельчанин Юрий', '2023-08-05', '11:00:00', '90', 4, '(детский)'),
        ('ФИТНЕС ЙОГА', 'Пономарева Вика', '2023-08-05', '12:30:00', '90', 1, ''),
        ('ФИТНЕСС ЗАЛ','', '2023-08-05', '20:30:00', '90', 1, ''),
        ('ЗЕЛЕНЫЙ ЗАЛ','', '2023-08-05', '20:30:00', '90', 3, ''),

        ('ВОСТОЧНЫЕ ТАНЦЫ', 'Синаевская Галя', '2023-08-06', '11:00:00', '90', 1, '(взрослые)'),
        ('КАЛЛАНЕТИКА' , 'Синаевская Галина', '2023-08-06', '12:30:00', '90', 1, ''),
        ('FT ПЕТЛИ TRX' , 'Соколов Михаил', '2023-08-06', '16:00:00', '90', 1, ''),
        ('СИЛОВОЙ тренинг + кардио' , 'Соколова Алена', '2023-08-06', '17:30:00', '90', 1, ''),
        ('ТРАЙБЛ' , 'Марина Нечаева', '2023-08-06', '19:00:00', '90', 2, ''),
        ('СТЕП-АЭРОБИКА' , 'Корпачева Вероника', '2023-08-06', '19:00:00', '90', 3, '')

;