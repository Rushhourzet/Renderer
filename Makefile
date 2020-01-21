JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
    Main.java \
    MathR.java \
	Point2D.java \
	Point3D.java \
	Renderer.java \
	Panel.java \
	Vector3.java \
	Vector2.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class