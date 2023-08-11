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

        ('СИЛОВОЙ ТРЕНИНГ','Соколова Алена', '2023-08-07', '09:30:00','90', 1,''),
        ('ЙОГА_ЛАТЕС',  'Пономарева Вика', '2023-08-07', '11:00:00','90', 1,''),
        ('BREAK_DANCE',  'Ефимов Василий', '2023-08-07', '16:00:00', '90',1,''),
        ('BREAK_DANCE',  'Ефимов Василий', '2023-08-07', '17:30:00','90', 1,''),
        ('ЗДОРОВАЯ СПИНА','Алексеева Катя', '2023-08-07', '19:00:00','90', 3,''),
        ('КИКБОКСИНГ','Соколова Алена', '2023-08-07', '19:00:00','90', 1,''),
        ('СТРЕТЧИНГ', 'Иванова Анастасия', '2023-08-07', '19:00:00','90', 2,''),
        ('ФУНКЦИОН. ПИЛАТЕС', 'Белоусова Наталья','2023-08-07', '19:00:00','90', 3,''),
        ('ЛФК ФИТНЕСС', 'Масликова Елена', '2023-08-07', '19:00:00','90', 4, '(детский)'),
        ('FT ПЕТЛИ TRX', 'Соколов Михаил', '2023-08-07', '20:30:00','90', 1,''),
        ('БАЙЛОТЕРАПИЯ', 'Матушкина Мария', '2023-08-07', '20:30:00', '90', 2, ''),
        ('КАРДИОСТРИП', 'Пономарева Вика', '2023-08-07', '20:30:00','90',3,''),
        ('ТРАЙБЛ', 'Марина Нечаева', '2023-08-07', '22:00:00','90', 1,''),

        ('ПИЛАТЕС','Белоусова Наталья', '2023-08-08', '09:30:00','90', 1,''),
        ('BREAK_DANCE',  'Полетаев Павел', '2023-08-08', '17:30:00','90', 1,'(прод)'),
        ('ТАЙ-БО',  'Васильева Кристина', '2023-08-08', '17:30:00','30', 3,''),
        ('АДАПТИВНАЯ ФИЗКУЛЬТУРА', 'Ельчанин Юрий', '2023-08-08', '17:30:00','90', 4,'(детский)'),
        ('КАЛЛАНЕТИКА', 'Синаевская Галина', '2023-08-08', '19:00:00','90', 1,''),
        ('КРОССФИТ', 'Васильева Кристина', '2023-08-08', '19:00:00','90', 2, ''),
        ('ИНТЕРВАЛЬНЫЙ ТРЕНИНГ', 'Корчуганова Соня', '2023-08-08', '19:00:00','90', 3,''),
        ('СИЛОВОЙ ТРЕНИНГ', 'Соколова Алена', '2023-08-08', '20:30:00','90', 1,''),
        ('ЗДОРОВАЯ СПИНА', 'Корчуганова Соня', '2023-08-08', '20:30:00','90', 2,''),
        ('ЙОГА', 'Ежикова Елена','2023-08-08', '20:30:00','90', 3,''),

        ('СИЛОВОЙ ТРЕНИНГ', 'Соколова Алена', '2023-08-09', '09:30:00', '90',1,''),
        ('АКТИВ_БОДИ' , 'Пономарева Вика', '2023-08-09', '11:00:00', '90', 1, ''),
        ('BREAK_DANCE' , 'Ефимов Василий', '2023-08-09', '16:00:00', '90', 1, ''),
        ('BREAK_DANCE' , 'Ефимов Василий', '2023-08-09', '17:30:00', '90', 1, ''),
        ('BREAK_DANCE' , 'Полетаев Павел', '2023-08-09', '19:00:00', '90', 3, '(начинающие)'),
        ('КИКБОКСИНГ' , 'Соколова Алена', '2023-08-09', '19:00:00', '90', 1, ''),
        ('БАЙЛОТЕРАПИЯ' , 'Матушкина Мария', '2023-08-09', '19:00:00', '90', 2, ''),
        ('СТРЕТЧИНГ' , 'Иванова Анастасия', '2023-08-09', '19:00:00', '90', 3, ''),
        ('ЛФК ФИТНЕСС', 'Масликова Елена', '2023-08-09', '19:00:00', '90', 4, '(детский)'),
        ('FT ПЕТЛИ TRX' , 'Соколов Михаил', '2023-08-09', '20:30:00', '90', 1, ''),
        ('СУПЕР ЯГОДИЦЫ' , 'Вяткина Мария', '2023-08-09', '20:30:00', '90', 2, ''),
        ('ЦИГУН', 'Иванова Настя', '2023-08-09', '20:30:00', '90', 3, ''),
        ('ТРАЙБЛ' , 'Марина Нечаева', '2023-08-09', '22:00:00', '90', 1, ''),

        ('ПИЛАТЕС' , 'Белоусова Наталья', '2023-08-10', '11:00:00', '90', 1, ''),
        ('BREAK_DANCE', 'Полетаев Павел', '2023-08-10', '17:30:00', '90', 1, '(прод)'),
        ('ТАЙ-БО', 'Васильева Кристина', '2023-08-10', '17:30:00', '30', 3, ''),
        ('КАЛЛАНЕТИКА' , 'Синаевская Галина', '2023-08-10', '19:00:00', '90', 1, ''),
        ('КРОССФИТ', 'Васильева Кристина', '2023-08-10', '19:00:00', '90', 2, ''),
        ('ИНТЕРВАЛЬНЫЙ ТРЕНИНГ' , 'Корчуганова Соня', '2023-08-10', '19:00:00', '90', 3, ''),
        ('СТЕП-АЭРОБИКА' , 'Корпачева Вероника', '2023-08-10', '19:00:00', '90', 4, ''),
        ('СИЛОВОЙ ТРЕНИНГ' , 'Соколова Алена', '2023-08-10', '20:30:00', '90', 1, ''),
        ('КРОССФИТ' , 'Корчуганова Соня', '2023-08-10', '20:30:00', '90', 2, ''),
        ('ЙОГА' , 'Ежикова Елена', '2023-08-10', '20:30:00', '90', 3, ''),
        ('СТЕП-АЭРОБИКА' , 'Карпачева Вероника', '2023-08-10', '20:30:00', '90', 4, ''),

        ('СИЛОВОЙ ТРЕНИНГ' , 'Соколова Алена', '2023-08-11', '9:30:00', '90', 1, ''),
        ('ЙОГА_ЛАТЕС' , 'Пономарева Вика', '2023-08-11', '11:00:00', '90', 1, ''),
        ('BREAK_DANCE' , 'Ефимов Василий', '2023-08-11', '16:00:00', '90', 1, ''),
        ('BREAK_DANCE' , 'Ефимов Василий', '2023-08-11', '17:30:00', '90', 1, ''),
        ('FT ПЕТЛИ TRX' , 'Соколов Михаил', '2023-08-11', '19:00:00', '90', 1, ''),
        ('BREAK_DANCE', 'Полетаев Павел', '2023-08-11', '19:00:00', '90', 3, '(начинающие)'),
        ('ЗДОРОВАЯ СПИНА', 'Корчуганова Соня', '2023-08-11', '17:30:00', '90', 4, ''),
        ('КИКБОКСИНГ' , 'Соколова Алена', '2023-08-11', '19:00:00', '90', 1, ''),
        ('БАЙЛОТЕРАПИЯ' , 'Матушкина Мария', '2023-08-11', '19:00:00', '90', 2, ''),
        ('СТРЕТЧИНГ' , 'Иванова Анастасия', '2023-08-11', '20:30:00', '90', 3, ''),
        ('СУПЕР ЯГОДИЦЫ' , 'Вяткина Мария', '2023-08-11', '20:30:00', '90', 1, ''),
        ('ЦИГУН', 'Иванова Настя', '2023-08-11', '20:30:00', '90', 2, ''),

        ('ПИЛАТЕС' , 'Белоусова Наталья', '2023-08-12', '11:00:00', '90', 1, ''),
        ('ФИТНЕС ЙОГА', 'Пономарева Вика', '2023-08-12', '12:30:00', '90', 1, ''),
        ('СТРЕТЧИНГ','', '2023-08-12', '20:30:00', '90', 1, ''),
        ('КИКБОКСИНГ','', '2023-08-12', '20:30:00', '90', 3, '(детская группа)'),

        ('ВОСТОЧНЫЕ ТАНЦЫ', 'Синаевская Галя', '2023-08-13', '11:00:00', '90', 1, '(взрослые)'),
        ('КАЛЛАНЕТИКА' , 'Синаевская Галина', '2023-08-13', '12:30:00', '90', 1, ''),
        ('FT ПЕТЛИ TRX' , 'Соколов Михаил', '2023-08-13', '16:00:00', '90', 1, ''),
        ('КИКБОКСИНГ' , 'Соколова Алена', '2023-08-13', '17:30:00', '90', 1, ''),
        ('ТРАЙБЛ' , 'Марина Нечаева', '2023-08-13', '19:00:00', '90', 2, ''),
        ('СТЕП-АЭРОБИКА' , 'Корпачева Вероника', '2023-08-13', '19:00:00', '90', 3, '')

;