
create user 'koreagrandsale'@'%' identified by '#koreagrandsale!@';

create database kgs;

grant all privileges on kgs.* to 'koreagrandsale'@'%' identified by '#koreagrandsale!@';
grant all privileges on kgs.* to 'koreagrandsale'@'localhost' identified by '#koreagrandsale!@';

flush privileges;
