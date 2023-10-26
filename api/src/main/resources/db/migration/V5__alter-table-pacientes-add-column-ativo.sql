alter table pacientes add collum ativo tinyint;
update pacientes set ativo = 1;
alter table pacientes modify ativo tinyint not null;