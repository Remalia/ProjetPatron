#!/bin/bash

# Makefile can't refuse to execute these commands.
.PHONY: all run clean mrproper

# Color
RED='\033[0;31m'
GREEN='\033[0;32m'
BLUE='\033[0;34m'
NC='\033[0m'
CYAN='\033[0;36m'
MAGENTA='\033[0;35m'
YELLOW='\033[0;33m'

# when user write make
.DEFAULT_GOAL := help

all: mrproper init compile run ## Clean bin and run the code

compile: ## Compile the code 
	@javac -d bin Jeu.java src/controller/*.java src/controller/Graphics/Bouton/*.java src/controller/Graphics/Bouton/actions/*.java src/controller/Graphics/Bouton/formes/*.java src/controller/Graphics/Bouton/menus/*.java src/controller/Graphics/Box/*.java src/controller/State/*.java src/model/*.java src/model/Action/*.java src/model/Action/Commandes/*.java src/model/Formes/*.java src/vue/*.java src/vue/Formes/*.java src/vue/Layout/*.java src/vue/Menu/*.java 

run: ## Execute the compiled code : bin/ProjetPatron/Jeu.class 
	@java -cp .bin.ProjetPatron.Jeu

jar: ## Create the jar file
	@jar cvfm bin/ProjetPatron.jar src/META-INF/MANIFEST.MF -C bin/ .

help: ## Affiche la liste des commandes
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-15s\033[0m %s\n", $$1, $$2}'

clean:	## Vide les fichiers .pdf et les .png test
	@rm -rf bin/*.class

mrproper: clean  ## Vide les fichiers .o et le dossier testVisu
	@rm -rf bin

init: ## Create the directory testVisu
	@mkdir -p bin