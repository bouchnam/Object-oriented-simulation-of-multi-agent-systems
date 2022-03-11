# Ensimag 2A POO - TP 2015/16
# ============================
#
# Ce Makefile permet de compiler le test de l'ihm en ligne de commande.
# Alternative (recommandee?): utiliser un IDE (eclipse, netbeans, ...)
# Le but est d'illustrer les notions de "classpath", a vous de l'adapter
# a votre projet.
#
# Organisation:
#  1) Les sources (*.java) se trouvent dans le repertoire src
#     Les classes d'un package toto sont dans src/toto
#     Les classes du package par defaut sont dans src
#
#  2) Les bytecodes (*.class) se trouvent dans le repertoire bin
#     La hierarchie des sources (par package) est conservee.
#     Pour un package (ici gui.jar), il est aussi dans bin.
#
# Compilation:
#  Options de javac:
#   -d : repertoire dans lequel sont places les .class compiles
#   -classpath : repertoire dans lequel sont cherches les .class deja compiles
#   -sourcepath : repertoire dans lequel sont cherches les .java (dependances)

all: testGUI

testGUI:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestGUI.java src/TestConwaySimulator.java src/TestBallsSimulator.java src/TestConwayImmSimulator.java src/TestBalls.java src/TestSchelling.java src/TestBoidsSimulator.java src/TestBoidsSimulatorGroup.java


exeGUI:
	java -classpath bin:bin/gui.jar TestGUI
exeBalls:
	java -classpath bin:bin/gui.jar TestBalls
exeSimBalls:
	java -classpath bin:bin/gui.jar TestBallsSimulator
exeConway:
	java -classpath bin:bin/gui.jar TestConwaySimulator
exeConwayImm:
	java -classpath bin:bin/gui.jar TestConwayImmSimulator
exeScheli:
	java -classpath bin:bin/gui.jar TestSchelling
exeBoids:
	java -classpath bin:bin/gui.jar TestBoidsSimulator
exeBoidsGroup:
	java -classpath bin:bin/gui.jar TestBoidsSimulatorGroup

clean:
	rm -rf bin/*.class
