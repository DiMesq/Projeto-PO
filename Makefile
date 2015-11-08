OUTDIR=class/
SRCDIR=source/
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

.PHONY: clean

clean:
	rm -rf ${OUTDIR}
