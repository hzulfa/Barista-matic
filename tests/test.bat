del Output*.txt
del diff*.txt
java -jar "..\out\artifacts\Barista_matic_jar\Barista-matic.jar" < SampleInput1.txt > Output1.txt
FC Output1.txt SampleOutput1.txt > diff1.txt
type diff1.txt
java -jar "..\out\artifacts\Barista_matic_jar\Barista-matic.jar" < SampleInput2.txt > Output2.txt
FC Output2.txt SampleOutput2.txt > diff2.txt
type diff2.txt
