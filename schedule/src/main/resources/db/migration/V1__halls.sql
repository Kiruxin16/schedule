CREATE TABLE halls(
                id bigserial PRIMARY KEY,
                trigger VARCHAR(255) UNIQUE,
                name VARCHAR(255),
                address VARCHAR(255),
                description VARCHAR(255)
);

INSERT INTO halls(trigger,name,address,description) VALUES
        ('fitness1','Фитнес площадка','Ленина 140 п.10','Зал используемый для групповых занятий фитнесом'),
        ('gym1','Тренажерный зал','Ленина 140 п.23','Зал оснащенный тренажерами и железом'),
        ('dojo1','Зал единоборств','Мокрушина 11 гл. вх','Зал для проведения занятий по контактным дисциплинам'),
        ('dance1','Танцеваальная студия','Ленина 140 п.11','В зале проходят занятия по танцевальным направлеиям')
;