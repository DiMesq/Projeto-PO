OUTDIR=class/
SRCDIR=source/
DOCDIR=doc/
MAIN_FILE_NAME=edt/textui/Editor

all: directories compile

compile:
	javac -d ${OUTDIR} -cp ${OUTDIR} -sourcepath ${SRCDIR} ${SRCDIR}$(MAIN_FILE_NAME:=.java)

run:
	java -cp ${OUTDIR} $(MAIN_FILE_NAME)

swing:
	java -cp ${OUTDIR} -Dui=swing $(MAIN_FILE_NAME)

directories: ${OUTDIR}

${OUTDIR}:
	mkdir $@

documentation:
	mkdir -p doc/
	javadoc -d ${DOCDIR} -cp ${OUTDIR} -sourcepath ${SRCDIR} `find ${SRCDIR}edt -name "*.java"`


.PHONY: clean

clean:
	rm -rf ${OUTDIR} ${DOCDIR}
