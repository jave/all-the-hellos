# i was going to use make, but maybe ill just use maven
# see https://openjdk.java.net/projects/jigsaw/quick-start

clean:
	rm -rf mods mlib hello

mkdirs:
	mkdir -p mods/jv.jpms
	mkdir -p mlib

compile: mkdirs
	javac  -d mods/jv.jpms $(shell find src -name '*.java')

jar: compile
	jar --create \
	--file mlib/jvjpms-hello-world.jar \
	--main-class jv.jpms.HelloJpms \
	-C mods/jv.jpms .
run-unpackaged:
	java --module-path mods -m jv.jpms/jv.jpms.HelloJpms

run: jar
	java \
        -p mlib \
	--module jv.jpms

jlink: jar
	jlink --no-header-files --no-man-pages --compress=2 --strip-debug \
	--launcher hellolaunch=jv.jpms \
	--module-path /usr/lib/jvm/java-11-openjdk-11.0.1.13-10.fc28.x86_64/jmods/:mlib --add-modules jv.jpms --output hello
	du -hc hello

run-hello:
	 hello/bin/hellolaunch 
