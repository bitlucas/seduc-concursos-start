#!/bin/bash

## Funcao com comandos especificos para o site/sistema
config_site() {
  # Configuracoes padrao para sites/sistemas desenvolvidos em drupal
  if [ -e ${SITE_HOME}/${PROJETO} ]; then
    cd ${DIR_WORK}/${PROJETO}_tmp/sites/default
    rm -rf *
    cp -rp ${SITE_HOME}/${PROJETO}/sites/default/* .
  fi
}

