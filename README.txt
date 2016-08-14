Задание
    Для всех предыдущих ДЗ создать ant build.xml,
    с помощью которого можно будет скомпилировать,
    протестировать и собрать executable .jar





<project name = "CompareCollectionsEfficiency" basedir = "."> // obligatory.
    //"." - локальная папка относительно билд файла

    //Указание переменных и обозначени пути
    <property name="src" location="src"/>
    <property name="build" location="build"/>
    <property name="dist" location="dist"/> // в папку dist будет положен финальный jar файл

    <target name="init"> //Инициализация. Создание папок
        <mkdir dir="${build}"/>
        <mkdir dir="${dist}"/>
    </target>


    <target name="compile" depends="init">
        <javac srcdir="${src}" destdir="${build}" source="1.8" target="1.8"/>
        // srcdir="${src}" - место нахождения кода (откуда брать код)
        // destdir="${build}" - куда класть скомпилированные .class файлы
        // source="1.8" - версия нашей JVM
        // target="1.8" - версия для какой JVM будем компилилровать
    </target>

    <target name="dist" depends="compile">
        <jar destfile="${dist}/executable.jar"> // куда -> папка dist, название -> executable.jar
            <fileset dir="build"/>

            <manifest>
                <attribute name="Main-Class" value="Module1/CollectionImplementation/Main"/>
                // с помощью атрибута манифеста указываем путь main класс и путь к нему
            </manifest>

        </jar>
    </target>

    <target name="clean">
        <delete dir="${dist}"/>
        <delete dir="${build}"/>
    </target>

</project>



commands:

ant init -  инициализация (создание папок). Не обязательна.
            Можно сразу вызвать compile, в ней есть зависимость от init.
ant compile - компилируем код. Перед compile вызывается init.

ant clean - чистим папки
ant clean dist - создаем jar файл
java -jar dist/{filename}.jar - запускаем jar dile

Можно делать так
ant clean compile dist
