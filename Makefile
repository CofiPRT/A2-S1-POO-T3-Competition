JFLAGS = -g
JC = javac
JVM = java

COMANDA = ""
IN1 = ""
IN2 = ""
OUT = ""

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = comps/Competition.java \
		comps/MainClass.java \
		enums/Gender.java \
		enums/TeamType.java \
		factories/CompetitionBuilder.java \
		factories/PlayerBuilder.java \
		factories/TeamBuilder.java \
		teams/BasketballTeam.java \
		teams/FootballTeam.java \
		teams/HandballTeam.java \
		teams/Player.java \
		teams/Team.java \
		visitorstrategy/ScoreCalculator.java \
		visitorstrategy/TeamVisitor.java \
		visitorstrategy/formulas/BasketballFormula.java \
		visitorstrategy/formulas/FootballFemaleFormula.java \
		visitorstrategy/formulas/FootballMaleFormula.java \
		visitorstrategy/formulas/HandballFemaleFormula.java \
		visitorstrategy/formulas/HandballMaleFormula.java \
		visitorstrategy/formulas/ScoreFormula.java
		
MAIN = comps/MainClass

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN) $(COMANDA) $(IN1) $(IN2) $(OUT)
	
clean:
	$(RM) *.class