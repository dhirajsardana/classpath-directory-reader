This utility reads directory ( which contains multi sub directory) from classpath and 
create similar tree structure on given path.
This is useful when u need classptah resources(big bundle) during runtime.

To quickly verifies , please build the jar and execute by any of option:
1) By default it will be in target directory :
java -jar target/reading-from-jar-poc-1.0-SNAPSHOT.jar 
2)Providing path :
 java -jar target/reading-from-jar-poc-1.0-SNAPSHOT.jar <PathWhereYouWantDirToBeCopied>

You will see that 'resDir' and all its sub-directories will be copied to 'target' directory.
Note : You can execute this jar from anywhere, because resources are bundled inside jar