rmiregistry &
java -classpath ./ -Djava.rmi.server.codebase=file:./ jrmi.Server
java  -classpath ./ jrmi.Client
killall -9 rmiregistry
