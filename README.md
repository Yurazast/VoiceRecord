![](https://imageog.flaticon.com/icons/png/512/26/26312.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF)
# VoiceRecord
VoiceRecord is a simple program that allows to do certain actions with music tracks on disc, and also supports undo/redo.
## Installation
Some files need to be modified depending on the operation system and home directory.
Also all the necessary libraries need to be downloaded.
> ## Files
> [Copyright](src/copyright/Copyright.java)
> [CopyrightTest](src/UNITTEST/copyrightTest/CopyrightTest.java)
> [Executor](src/executor/Executor.java)
> [Logger](src/log/Logger.java)
> ## Libraries
> [javax.mail](https://github.com/javaee/javamail/releases/download/JAVAMAIL-1_6_2/javax.mail.jar)
> [JUnit4](https://repo1.maven.org/maven2/junit/junit/4.12/junit-4.12.jar)
> [Hamcrest](https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar)
## Usage
It will take some simple steps to run the program.

At first, compile Main.java:
```bash
cd IdeaProjects/VoiceRecord/src/
javac -verbose Main.java
```
Then, run Main with/without parameters:
```bash
java Main @parameters
```
> #### @parameters
> yes YES y Y agree AGREE accept ACCEPT skip SKIP

If there is no parameter or entered parameter is incorrect, copyright will be shown.
## License
[MIT](https://choosealicense.com/licenses/mit/)