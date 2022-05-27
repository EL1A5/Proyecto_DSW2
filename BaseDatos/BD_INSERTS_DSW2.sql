		

use proyecto_dsw2;





insert into authority(authority) values ('ROLE_ADMIN');
insert into authority(authority) values ('ROLE_OPERADOR');
insert into authority(authority) values ('ROLE_NEGOCIO');

INSERT INTO personas(id_persona, apellidos, celular, dni,fecha_registro, nombre, telefono)
values (null, 'pariona', '973393286', '70073164','2021-05-14 20:26:00', 'Erick','056267735');

INSERT INTO personas(id_persona, apellidos, celular, dni,fecha_registro, nombre, telefono)
values (null, 'pariona', '936634054', '70073165','2021-05-14 20:26:00', 'Alex','056267735');

insert into users (enabled, password, username, id_persona, id_authority)
values (0b1, '$2a$04$oGQrvCwOMmOv2uYXVFnsWein.smvRgwyoSRw1QOBxfBYOGiP3ioEq', 'admin', 1,1);

insert into users (enabled, password, username, id_persona,id_authority)
values (0b1, '$2a$04$oGQrvCwOMmOv2uYXVFnsWein.smvRgwyoSRw1QOBxfBYOGiP3ioEq', 'counter', 2,2);

insert into authorities_users values (1, 1);
insert into authorities_users values (2, 2);


alter table users 
add constraint fk_user_pers foreign key (id_persona) references personas(id_persona);

alter table users
modify column id_persona int not null;


alter table authorities_users 
add constraint fk_auth_users_usuario foreign key (usuario_id) references users(id);

alter table authorities_users 
add constraint fk_auth_users_authority foreign key (authority_id) references authority(id);

alter table authorities_users
modify column usuario_id bigint not null;

alter table authorities_users
modify column authority_id bigint not null;

insert into aplicacion(descripcion) values ('IGC');
insert into aplicacion(descripcion) values ('CAPS');
insert into aplicacion(descripcion) values ('REMI');

SELECT * from tipo_solicitud;
insert into tipo_solicitud (descripcion) values ('Incidentes');
insert into tipo_solicitud (descripcion) values ('Ordenes');


select * from categoria;

insert into categoria (descripcion) values ('Acceso');
insert into categoria (descripcion) values ('Instalacion');
insert into categoria (descripcion) values ('Reportes');



select * from personas;
select * from users;
select * from authorities_users;







