DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `value` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into car(value,type) values('配货','long');
insert into car(value,type) values('4.2米','long');
insert into car(value,type) values('4.8米','long');
insert into car(value,type) values('5.8米','long');
insert into car(value,type) values('6.8米','long');
insert into car(value,type) values('7.2米','long');
insert into car(value,type) values('7.8米','long');
insert into car(value,type) values('8.2米','long');
insert into car(value,type) values('8.7米','long');
insert into car(value,type) values('9.6米','long');
insert into car(value,type) values('12.5米','long');
insert into car(value,type) values('13米','long');
insert into car(value,type) values('16.5米','long');
insert into car(value,type) values('17.5米','long');

insert into car(value,type) values('车型不限','type');
insert into car(value,type) values('厢车','type');
insert into car(value,type) values('平板','type');
insert into car(value,type) values('高栏','type');
insert into car(value,type) values('高低板','type');
insert into car(value,type) values('面包','type');
insert into car(value,type) values('特种车','type');
insert into car(value,type) values('保温车','type');
insert into car(value,type) values('冷藏车','type');
insert into car(value,type) values('危险品车','type');
insert into car(value,type) values('其他','type');
