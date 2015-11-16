OUTDIR=class/
SRCDIR=source/
JARS=${SRCDIR}po-uilib.jar:${SRCDIR}edt-support.jar
DOCDIR=doc/
MAIN_FILE_NAME=edt/textui/Editor

CLASSP=${OUTDIR}:${JARS}

all: directories compile

compile:
	cp source/po-uilib.jar ${OUTDIR}
	cp source/edt-support.jar ${OUTDIR}
	javac -d ${OUTDIR} -cp ${CLASSP} -sourcepath ${SRCDIR} `find ${SRCDIR} -name "*.java"`

run:
	java -cp ${CLASSP} $(MAIN_FILE_NAME)

swing:
	java -cp ${CLASSP} -Dui=swing $(MAIN_FILE_NAME)

directories: ${OUTDIR}

${OUTDIR}:
	mkdir $@

documentation:
	mkdir -p doc/
	javadoc -d ${DOCDIR} -cp ${OUTDIR} -sourcepath ${SRCDIR} `find ${SRCDIR}edt -name "*.java"`

tests: all
	cp tests/* -r class/
	cd class/; \
	./runtests.sh; \
	rm -r runtests.sh tests

.PHONY: clean

clean:
	rm -rf ${OUTDIR} ${DOCDIR}
