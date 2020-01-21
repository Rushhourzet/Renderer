JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java

CLASSES = \
        Camera.java \
        Line.java \
        Main.java \
        MathR.java \
		Point2D.java \
		Point3D.java \
		Renderer.java \
		Shape.java \
		Face.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
        $(RM) *.class