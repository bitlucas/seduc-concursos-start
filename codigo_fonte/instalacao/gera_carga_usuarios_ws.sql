
select distinct on (u.id)
  format(
    'insert into controleacesso.ws_usuario (id, login, descricao, senha, ativo, id_orgao, id_usuario_manut, data_manut) values (%s, %L, %L, %L, %s, %s, %s, current_timestamp);',
    u.id, u.login, u.descricao, u.senha, u.ativo, u.id_orgao, &P_ID_USUARIO_MANUT
  )
from 
  controleacesso.aplicacao a
  join controleacesso.ws_perfil p on p.id_aplicacao = a.id
    join controleacesso.ws_usuario_ws_perfil up on up.id_perfil = p.id
      join controleacesso.ws_usuario u on u.id = up.id_usuario
where
  a.contexto = '\&P_CONTEXTO';

select 
  format(
    'insert into controleacesso.ws_usuario_ws_perfil (id_usuario, id_perfil ) values (%s, %s);',
    up.id_usuario, up.id_perfil
  )
from 
  controleacesso.aplicacao a
  join controleacesso.ws_perfil p on p.id_aplicacao = a.id
    join controleacesso.ws_usuario_ws_perfil up on up.id_perfil = p.id
where
  a.contexto = '\&P_CONTEXTO';
